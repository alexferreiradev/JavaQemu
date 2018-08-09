package net.sourceforge.javaqemu.model;

import java.util.Locale;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class FloppyModel extends OptionsControl {

    public FloppyModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        if (myfile.getMymodel().getFloppyDiskA() != null) {
            this.setFloppyDiskAOption(myfile.getMymodel().getFloppyDiskA(), "");
        }
    }

    public void setFloppyDiskAOption(String floppyDiskOption, String option) {
        if (option.equals("drive")) {
            if (checks_extension(floppyDiskOption).equals("/")) {
                super.setOption(floppyDiskOption,
                        OptionsEnumModel.FLOPPYDISKAOPTION.getValor());
            } else if (checks_extension(floppyDiskOption).equals("\\")) {
                if (floppyDiskOption.length() == 3) {
                    if (floppyDiskOption.charAt(1) == ':' && (floppyDiskOption.toLowerCase(Locale.ENGLISH).charAt(0) >= 'a' && floppyDiskOption.toLowerCase(Locale.ENGLISH).charAt(0) <= 'z')) {
                        super.setOption("\\" + "\\" + "." + "\\"
                                + floppyDiskOption.substring(0, 2)
                                .toLowerCase(Locale.ENGLISH), OptionsEnumModel.FLOPPYDISKAOPTION
                                .getValor());
                    }
                } else {
                    super.setOption(floppyDiskOption,
                            OptionsEnumModel.FLOPPYDISKAOPTION.getValor());
                }
            }
        } else if (option.equals("image")) {
            if (floppyDiskOption.endsWith(".img") || floppyDiskOption.endsWith(".iso")) {
                super.setOption(floppyDiskOption,
                        OptionsEnumModel.FLOPPYDISKAOPTION.getValor());
            } else {
                super.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.FLOPPYDISKAOPTION.getValor()]);
            }
        } else if (option.isEmpty()) {
            if (floppyDiskOption.endsWith(".img") || floppyDiskOption.endsWith(".iso")) {
                super.setOption(floppyDiskOption,
                        OptionsEnumModel.FLOPPYDISKAOPTION.getValor());
            } else if (checks_extension(floppyDiskOption).equals("/")) {
                super.setOption(floppyDiskOption,
                        OptionsEnumModel.FLOPPYDISKAOPTION.getValor());
            } else if (checks_extension(floppyDiskOption).equals("\\")) {
                if (floppyDiskOption.length() == 3) {
                    if (floppyDiskOption.charAt(1) == ':' && (floppyDiskOption.toLowerCase(Locale.ENGLISH).charAt(0) >= 'a' && floppyDiskOption.toLowerCase(Locale.ENGLISH).charAt(0) <= 'z')) {
                        super.setOption("\\" + "\\" + "." + "\\"
                                + floppyDiskOption.substring(0, 2)
                                .toLowerCase(Locale.ENGLISH),
                                OptionsEnumModel.FLOPPYDISKAOPTION.getValor());
                    }
                } else {
                    super.setOption(floppyDiskOption,
                            OptionsEnumModel.FLOPPYDISKAOPTION.getValor());
                }
            } else {
                super.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.FLOPPYDISKAOPTION.getValor()]);
            }
        }
    }

    public void setFloppyDiskBOption(String floppyDiskOption, String option) {
        if (option.equals("drive")) {
            if (checks_extension(floppyDiskOption).equals("/")) {
                super.setOption(floppyDiskOption,
                        OptionsEnumModel.FLOPPYDISKBOPTION.getValor());
            } else if (checks_extension(floppyDiskOption).equals("\\")) {
                if (floppyDiskOption.length() == 3) {
                    if (floppyDiskOption.charAt(1) == ':' && (floppyDiskOption.toLowerCase(Locale.ENGLISH).charAt(0) >= 'a' && floppyDiskOption.toLowerCase(Locale.ENGLISH).charAt(0) <= 'z')) {
                        super.setOption("\\" + "\\" + "." + "\\"
                                + floppyDiskOption.substring(0, 2)
                                .toLowerCase(Locale.ENGLISH), OptionsEnumModel.FLOPPYDISKBOPTION
                                .getValor());
                    }
                } else {
                    super.setOption(floppyDiskOption,
                            OptionsEnumModel.FLOPPYDISKBOPTION.getValor());
                }
            }
        } else if (option.equals("image")) {
            if (floppyDiskOption.endsWith(".img") || floppyDiskOption.endsWith(".iso")) {
                super.setOption(floppyDiskOption,
                        OptionsEnumModel.FLOPPYDISKBOPTION.getValor());
            } else {
                super.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.FLOPPYDISKBOPTION.getValor()]);
            }
        } else if (option.isEmpty()) {
            if (floppyDiskOption.endsWith(".img") || floppyDiskOption.endsWith(".iso")) {
                super.setOption(floppyDiskOption,
                        OptionsEnumModel.FLOPPYDISKBOPTION.getValor());
            } else if (checks_extension(floppyDiskOption).equals("/")) {
                super.setOption(floppyDiskOption,
                        OptionsEnumModel.FLOPPYDISKBOPTION.getValor());
            } else if (checks_extension(floppyDiskOption).equals("\\")) {
                if (floppyDiskOption.length() == 3) {
                    if (floppyDiskOption.charAt(1) == ':' && (floppyDiskOption.toLowerCase(Locale.ENGLISH).charAt(0) >= 'a' && floppyDiskOption.toLowerCase(Locale.ENGLISH).charAt(0) <= 'z')) {
                        super.setOption("\\" + "\\" + "." + "\\"
                                + floppyDiskOption.substring(0, 2)
                                .toLowerCase(Locale.ENGLISH),
                                OptionsEnumModel.FLOPPYDISKBOPTION.getValor());
                    }
                } else {
                    super.setOption(floppyDiskOption,
                            OptionsEnumModel.FLOPPYDISKBOPTION.getValor());
                }
            } else {
                super.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.FLOPPYDISKBOPTION.getValor()]);
            }
        }
    }

    public String checks_extension(String path) {
        String result = "";
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                result = "/";
                break;
            }
            if (path.charAt(i) == '\\') {
                result = "\\";
                break;
            }
        }
        return result;
    }
}
