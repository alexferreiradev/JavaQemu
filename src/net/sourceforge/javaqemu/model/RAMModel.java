package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class RAMModel extends OptionsControl {

    private FileControl myfile;

    public RAMModel(EmulationControl myemulation,
            FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;
        if (this.myfile.getMymodel().getRamSize() == null) {
            this.setOption("128.000");
        } else {
            this.setOption(this.myfile.getMymodel().getRamSize());
        }
    }

    public void setOption(String option) {
        super.setOption(option, OptionsEnumModel.RAMSIZE.getValor());
        this.myfile.getMymodel().setRamSize(option);
    }
}
