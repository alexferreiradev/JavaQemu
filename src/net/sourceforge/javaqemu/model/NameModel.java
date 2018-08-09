package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class NameModel extends OptionsControl {

    private FileControl myfile;

    public NameModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);

        this.myfile = myfile;

        if (this.myfile.getMymodel().getNameOption() != null) {
            this.setOption(this.myfile.getMymodel().getNameOption());
        }
    }

    public void setOption(String option) {
        super.setOption(option,
                OptionsEnumModel.NAMEOPTION.getValor());
        this.myfile.getMymodel()
                .setNameOption(option);
    }

    public void unsetOption(String option) {
        super.unsetOption(option);
        this.myfile.getMymodel().setNameOption("");
    }
}
