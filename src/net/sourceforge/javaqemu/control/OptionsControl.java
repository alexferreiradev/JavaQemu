package net.sourceforge.javaqemu.control;

import net.sourceforge.javaqemu.model.OptionsModel;

public class OptionsControl {

    private OptionsModel mymodel;

    public OptionsControl(EmulationControl myemulation) {
        this.mymodel = new OptionsModel(myemulation);
    }

    public String getOption() {
        return this.mymodel.getOption();
    }

    public void setOption(String option, int position) {
        this.mymodel.setOption(option, position);
    }

    public void unsetOption(String option) {
        this.mymodel.unsetOption(option);
    }

    public void unsetOption(String option, int position) {
        this.mymodel.unsetOption(option, position);
    }
}
