package net.sourceforge.javaqemu.control;

import net.sourceforge.javaqemu.model.RAMModel;

public class RAMControl {

    private RAMModel mymodel;

    public RAMControl(EmulationControl myemulation,
            FileControl myfile) {
        this.mymodel = new RAMModel(myemulation, myfile);
    }

    public void setOption(String option) {
        this.mymodel.setOption(option);
    }

    public String getOption() {
        return this.mymodel.getOption();
    }
}
