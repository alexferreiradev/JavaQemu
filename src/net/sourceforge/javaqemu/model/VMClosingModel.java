package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.view.View;

public class VMClosingModel {

    private View view;
    private EmulationControl myemulation;

    public VMClosingModel(View view, EmulationControl myemulation) {
        this.view = view;
        this.myemulation = myemulation;
    }

    public boolean starts(Boolean removeAll) {

        if (removeAll) {
            while (this.view.getSizeOfJTabbedPane() > 0) {
                this.myemulation.removeAllProcesses();
                this.myemulation.closeAllEmulation();
                this.view.removeAllJPanels();
            }
        } else if (this.view.getSizeOfJTabbedPane() > 1) {
            this.myemulation.removesAProcess(this.view.getActivePanel());
            this.myemulation.close_emulation(this.view.getActivePanel());
            this.view.removeCreationNewJPanel();
        }

        return true;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setMyemulation(EmulationControl myemulation) {
        this.myemulation = myemulation;
    }
}
