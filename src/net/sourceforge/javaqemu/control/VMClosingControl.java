package net.sourceforge.javaqemu.control;

import net.sourceforge.javaqemu.model.VMClosingModel;
import net.sourceforge.javaqemu.view.View;

public class VMClosingControl {

    private VMClosingModel mymodel;

    public VMClosingControl(View view, EmulationControl myemulation) {
        this.mymodel = new VMClosingModel(view, myemulation);
    }

    public boolean starts(Boolean removeAll) {
        return this.mymodel.starts(removeAll);
    }

    public void setView(View view) {
        this.mymodel.setView(view);
    }

    public void setMyemulation(EmulationControl myemulation) {
        this.mymodel.setMyemulation(myemulation);
    }
}
