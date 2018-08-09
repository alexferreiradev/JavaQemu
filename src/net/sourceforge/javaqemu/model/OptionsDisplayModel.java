package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class OptionsDisplayModel extends OptionsControl {

    private String displayTypeOption;

    private FileControl myfile;

    public OptionsDisplayModel(EmulationControl myemulation,
            FileControl myfile) {
        super(myemulation);
        displayTypeOption = "";
        this.myfile = myfile;
        if (this.myfile.getMymodel().getDisplayType() != null) {
            this.setDisplayTypeOption(this.myfile.getMymodel().getDisplayType());
        }
        if (this.myfile.getMymodel().getNographicOption() != null) {
            if (this.myfile.getMymodel().getNographicOption().equals("true")) {
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOGRAPHICOPTION.getValor()]);
            }
        }
        if (this.myfile.getMymodel().getVgaType() != null) {
            this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.VGAOPTION.getValor()] + this.myfile.getMymodel().getVgaType());
        }
        if (this.myfile.getMymodel().getFullscreenOption() != null) {
            if (this.myfile.getMymodel().getFullscreenOption().equals("true")) {
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.FULLSCREENOPTION.getValor()]);
            }
        }
        if (this.myfile.getMymodel().getNoFrameOption() != null) {
            if (this.myfile.getMymodel().getNoFrameOption().equals("true")) {
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOFRAMEOPTION.getValor()]);
            }
        }
    }

    public String getDisplayTypeOption() {
        return displayTypeOption;
    }

    public void setDisplayTypeOption(String displayTypeOption) {
        this.displayTypeOption = displayTypeOption;
        if (displayTypeOption.equals("sdl")) {
            this.myfile.getMymodel().setDisplayType("sdl");
        } else if (displayTypeOption.equals("curses")) {
            this.myfile.getMymodel().setDisplayType("curses");
        } else if (displayTypeOption.equals("none")) {
            this.myfile.getMymodel().setDisplayType("none");
        } else if (displayTypeOption.substring(0, 3).equals("vnc")) {
            this.myfile.getMymodel().setDisplayType(displayTypeOption);
        }
        super.setOption(displayTypeOption,
                OptionsEnumModel.DISPLAYOPTION.getValor());
    }

    public void setOption(String option) {
        if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOGRAPHICOPTION.getValor()])) {
            super.setOption("", OptionsEnumModel.NOGRAPHICOPTION.getValor());
            this.myfile.getMymodel().setNographicOption("true");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.FULLSCREENOPTION.getValor()])) {
            super.setOption("", OptionsEnumModel.FULLSCREENOPTION.getValor());
            this.myfile.getMymodel().setFullscreenOption("true");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOFRAMEOPTION.getValor()])) {
            super.setOption("", OptionsEnumModel.NOFRAMEOPTION.getValor());
            this.myfile.getMymodel().setNoFrameOption("true");
        } else if (option.indexOf(" ") != -1) {
            if (option.substring(0, option.indexOf(" ")).equals("-vga")) {
                super.setOption(option.substring(option.indexOf(" ") + 1),
                        OptionsEnumModel.VGAOPTION.getValor());
                this.myfile.getMymodel().setVgaType(
                        option.substring(option.indexOf(" ") + 1));
            }
        }
    }

    public void unsetOption(String option) {
        super.unsetOption(option);
        if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.DISPLAYOPTION.getValor()])
                && this.myfile.getMymodel().getDisplayType() != null) {
            this.myfile.getMymodel().setDisplayType("");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOGRAPHICOPTION.getValor()])) {
            this.myfile.getMymodel().setNographicOption("false");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.VGAOPTION.getValor()])) {
            this.myfile.getMymodel().setVgaType(null);
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.FULLSCREENOPTION.getValor()])) {
            this.myfile.getMymodel().setFullscreenOption("false");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOFRAMEOPTION.getValor()])) {
            this.myfile.getMymodel().setNoFrameOption("false");
        }
    }
}
