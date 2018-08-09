package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class CustomOptionsModel extends OptionsControl {

    private FileControl myfile;

    public CustomOptionsModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;

        if (this.myfile.getMymodel().getCustomOptions() != null) {
            this.setOption(this.myfile.getMymodel().getCustomOptions().replace("\n", " "));
        }
    }

    public void setOption(String option) {
        super.setOption(option,
                OptionsEnumModel.CUSTOMOPTIONS.getValor());
    }

    public void setFileOption(String option) {
        this.myfile.getMymodel().setCustomOptions(option);
    }
}
