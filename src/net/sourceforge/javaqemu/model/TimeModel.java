package net.sourceforge.javaqemu.model;

import java.util.Locale;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class TimeModel extends OptionsControl {

    private FileControl myfile;

    public TimeModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;

        if (myfile.getMymodel().getRtcOption() != null) {
            String base = "";
            String date = "";
            String clock = "";
            String driftfix = "";
            String options[] = myfile.getMymodel().getRtcOption().split(",");
            for (String option : options) {
                if (option.startsWith("base=")) {
                    if (option.endsWith("utc")) {
                        base = "UTC - Universal Time Coordinated";
                    } else if (option.endsWith("localtime")) {
                        base = "Local Time";
                    } else {
                        base = "date";
                        date = option.substring(option.indexOf("=") + 1);
                    }
                } else if (option.startsWith("clock=")) {
                    if (option.endsWith("host")) {
                        clock = "Host";
                    } else if (option.endsWith("vm")) {
                        clock = "Virtual Machine";
                    }
                } else if (option.startsWith("driftfix=")) {
                    if (option.endsWith("none")) {
                        driftfix = "none";
                    } else if (option.endsWith("slew")) {
                        driftfix = "slew";
                    }
                }
                this.buildIt(base, date, clock, driftfix);
            }
        }
    }

    public void buildIt(String base, String date, String clock, String driftfix) {
        StringBuilder result = new StringBuilder("");
        result.append(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.RTCOPTION.getValor()]);
        if (base != null) {
            if (!base.isEmpty()) {
                if (base.equals("UTC - Universal Time Coordinated")) {
                    result.append("base=utc");
                } else if (base.equals("Local Time")) {
                    result.append("base=localtime");
                } else if (date != null) {
                    if (!date.isEmpty()) {
                        result.append("base=").append(date);
                    }
                }
            }
        }
        if (clock != null) {
            if (!clock.isEmpty()) {
                if (!result.toString().equals(
                        VMConfigurationModel.getTagsOptions()[OptionsEnumModel.RTCOPTION.getValor()])) {
                    result.append(",");
                }
                if (clock.equals("Host")) {
                    result.append("clock=host");
                } else if (clock.equals("Virtual Machine")) {
                    result.append("clock=vm");
                }
            }
        }
        if (driftfix != null) {
            if (!driftfix.isEmpty()) {
                if (!result.toString().equals(
                        VMConfigurationModel.getTagsOptions()[OptionsEnumModel.RTCOPTION.getValor()])) {
                    result.append(",");
                }
                result.append("driftfix=").append(driftfix.toLowerCase(Locale.ENGLISH));
            }
        }
        if (!result.toString().equals(
                VMConfigurationModel.getTagsOptions()[OptionsEnumModel.RTCOPTION.getValor()])) {
            myfile.getMymodel().setRtcOption(
                    result.toString().substring(
                            result.toString().indexOf(" ") + 1));
            this.setOption(result.toString().substring(
                    result.toString().indexOf(" ") + 1));
        } else {
            this.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.RTCOPTION.getValor()]);
        }
    }

    public void setOption(String option) {
        super.setOption(option, OptionsEnumModel.RTCOPTION.getValor());
    }

    public void unsetOption(String option) {
        super.unsetOption(option);
        this.myfile.getMymodel().setRtcOption("");
    }
}
