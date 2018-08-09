package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class NetworkManagerModel extends OptionsControl {

    private FileControl myfile;

    public NetworkManagerModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;
    }

    public void setOption(String option) {
        super.setOption(option, OptionsEnumModel.NETWORKNIC1OPTION.getValor());
    }

    public void buildIt(String option) {
        myfile.getMymodel().setFirstNetworkNICOption(option);
    }
}
