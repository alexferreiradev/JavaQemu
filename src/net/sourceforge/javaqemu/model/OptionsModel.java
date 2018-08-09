package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;

public class OptionsModel {

    private String option;
    private EmulationControl myemulation;

    public OptionsModel(EmulationControl myemulation) {
        this.myemulation = myemulation;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option, int position) {
        this.option = option;
        this.myemulation.change_options(position, VMConfigurationModel.getTagsOptions()[position] + option);
        this.myemulation.appends_options();
        this.myemulation.setJPanel();
    }

    public void unsetOption(String option) {
        this.myemulation.removes_options(option);
        this.myemulation.appends_options();
        this.myemulation.setJPanel();
    }

    public void unsetOption(String option, int position) {
        this.myemulation.removes_options(option, position);
        this.myemulation.appends_options();
        this.myemulation.setJPanel();
    }
}
