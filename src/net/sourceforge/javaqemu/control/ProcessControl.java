package net.sourceforge.javaqemu.control;

import net.sourceforge.javaqemu.model.ProcessModel;
import net.sourceforge.javaqemu.view.EmulationView;

public class ProcessControl {

    private ProcessModel myModel;
    private EmulationView myView;

    public ProcessControl(Process myProcess, String machineName, EmulationView myView, String qemuPathDir) {
        this.myView = myView;
        this.myModel = new ProcessModel(myProcess, machineName, qemuPathDir, myView);
    }

    public ProcessModel getMyModel() {
        return this.myModel;
    }

    public String getMachineName() {
        return this.myModel.getMachineName();
    }

    public EmulationView getMyView() {
        return myView;
    }

    public void run() throws InterruptedException {
        this.myModel.runMaster();
    }
}
