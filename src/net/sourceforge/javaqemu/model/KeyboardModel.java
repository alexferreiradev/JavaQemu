package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class KeyboardModel extends OptionsControl {

    private FileControl myfile;

    public KeyboardModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;
        if (this.myfile.getMymodel().getKeyboardLayoutLanguage() != null) {
            this.setOption(this.myfile.getMymodel().getKeyboardLayoutLanguage());
        }
    }

    public void setOption(String option) {
        super.setOption(option, OptionsEnumModel.KEYBOARDOPTION.getValor());
        this.myfile.getMymodel().setKeyboardLayoutLanguage(option);
    }

    public void unsetOption(String option) {
        super.unsetOption(option);
        this.myfile.getMymodel().setKeyboardLayoutLanguage("");
    }
}
