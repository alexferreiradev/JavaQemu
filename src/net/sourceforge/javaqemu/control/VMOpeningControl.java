package net.sourceforge.javaqemu.control;

import net.sourceforge.javaqemu.model.VMOpeningModel;
import net.sourceforge.javaqemu.view.VMOpeningView;
import net.sourceforge.javaqemu.view.View;

public class VMOpeningControl {

    private VMOpeningModel mymodel;
    private VMOpeningView myview;

    public VMOpeningControl(View view, EmulationControl myemulation, FileControl myfile) {
        this.mymodel = new VMOpeningModel(myemulation, myfile);
        this.myview = new VMOpeningView(view, this.mymodel.getMyfile().getMymodel().getMachineName());
    }

    public boolean starts(FileControl myfile) {
        this.mymodel.starts();
        this.myview.setChosenMachineName(myfile.getMymodel().getMachineName());
        this.myview.starts(this.mymodel.getDiskImagePath(),
                myfile.getMymodel().getSecondHardDiskOption(),
                myfile.getMymodel().getThirdHardDiskOption(),
                myfile.getMymodel().getFourthHardDiskOption(),
                myfile.getMymodel().getRamSize());
        return true;
    }

    public void setView(View view) {
        this.myview.setView(view);
    }

    public void setMyemulation(EmulationControl myemulation) {
        this.mymodel.setMyemulation(myemulation);
    }

    public void setMyfile(FileControl myfile) {
        this.mymodel.setMyfile(myfile);
    }
}
