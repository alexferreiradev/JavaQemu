package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class USBKeyboardModel extends OptionsControl {

    private FileControl myfile;

    public USBKeyboardModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;

        if (myfile.getMymodel().getUsbKeyboardOption() != null) {
            if (myfile.getMymodel().getUsbKeyboardOption().equals("true")) {
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBKEYBOARDOPTION.getValor()]);
            }
        }
    }

    public void setOption(String option) {
        if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBKEYBOARDOPTION.getValor()])) {
            super.setOption("keyboard",
                    OptionsEnumModel.USBKEYBOARDOPTION.getValor());
            this.myfile.getMymodel()
                    .setUsbKeyboardOption("true");
        }
    }

    public void unsetOption(String option) {
        super.unsetOption(option, OptionsEnumModel.USBKEYBOARDOPTION.getValor());
        this.myfile.getMymodel().setUsbKeyboardOption("false");
    }
}
