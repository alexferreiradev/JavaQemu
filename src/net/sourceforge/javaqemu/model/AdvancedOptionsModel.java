package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class AdvancedOptionsModel extends OptionsControl {

    private FileControl myfile;
    private String name;

    public AdvancedOptionsModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;
        if (this.myfile.getMymodel().getNoacpiOption() != null) {
            if (this.myfile.getMymodel().getNoacpiOption().equals("true")) {
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOACPIOPTION.getValor()]);
            }
        }
        if (this.myfile.getMymodel().getWin2khackOption() != null) {
            if (this.myfile.getMymodel().getWin2khackOption().equals("true")) {
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.WIN2KHACKOPTION.getValor()]);
            }
        }
        if (this.myfile.getMymodel().getNameOption() != null) {
            if (!this.myfile.getMymodel().getNameOption().isEmpty()) {
                this.name = this.myfile.getMymodel().getNameOption();
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NAMEOPTION.getValor()]);
            }
        }
        if (this.myfile.getMymodel().getSnapshotOption() != null) {
            if (this.myfile.getMymodel().getSnapshotOption().equals("true")) {
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SNAPSHOTOPTION.getValor()]);
            }
        }
        if (this.myfile.getMymodel().getNoFdBootchkOption() != null) {
            if (this.myfile.getMymodel().getNoFdBootchkOption().equals("true")) {
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOFDBOOTCHKOPTION.getValor()]);
            }
        }
        if (this.myfile.getMymodel().getNoHpetOption() != null) {
            if (this.myfile.getMymodel().getNoHpetOption().equals("true")) {
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOHPETOPTION.getValor()]);
            }
        }
    }

    public void setOption(String option) {
        if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.WIN2KHACKOPTION.getValor()])) {
            super.setOption("", OptionsEnumModel.WIN2KHACKOPTION.getValor());
            this.myfile.getMymodel().setWin2khackOption("true");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOACPIOPTION.getValor()])) {
            super.setOption("", OptionsEnumModel.NOACPIOPTION.getValor());
            this.myfile.getMymodel().setNoacpiOption("true");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NAMEOPTION.getValor()])) {
            super.setOption(name, OptionsEnumModel.NAMEOPTION.getValor());
            this.myfile.getMymodel().setNameOption(name);
            this.myfile.getMymodel().setMachineName(name);
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SNAPSHOTOPTION.getValor()])) {
            super.setOption("", OptionsEnumModel.SNAPSHOTOPTION.getValor());
            this.myfile.getMymodel().setSnapshotOption("true");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOFDBOOTCHKOPTION.getValor()])) {
            super.setOption("", OptionsEnumModel.NOFDBOOTCHKOPTION.getValor());
            this.myfile.getMymodel().setNoFdBootchkOption("true");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOHPETOPTION.getValor()])) {
            super.setOption("", OptionsEnumModel.NOHPETOPTION.getValor());
            this.myfile.getMymodel().setNoHpetOption("true");
        }
    }

    public void unsetOption(String option) {
        super.unsetOption(option);
        if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.WIN2KHACKOPTION.getValor()])) {
            this.myfile.getMymodel().setWin2khackOption("false");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOACPIOPTION.getValor()])) {
            this.myfile.getMymodel().setNoacpiOption("false");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NAMEOPTION.getValor()])) {
            this.myfile.getMymodel().setNameOption("");
            this.myfile.getMymodel().setMachineName("");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SNAPSHOTOPTION.getValor()])) {
            this.myfile.getMymodel().setSnapshotOption("false");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOFDBOOTCHKOPTION.getValor()])) {
            this.myfile.getMymodel().setNoFdBootchkOption("false");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOHPETOPTION.getValor()])) {
            this.myfile.getMymodel().setNoHpetOption("false");
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
