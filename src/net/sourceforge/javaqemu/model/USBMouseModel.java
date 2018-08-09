package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class USBMouseModel extends OptionsControl {

    private FileControl myfile;

    public USBMouseModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;

        if (this.myfile.getMymodel().getUsbMouseOption() != null) {
            if (this.myfile.getMymodel().getUsbMouseOption().equals("true")) {
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBMOUSEOPTION.getValor()]);
            }
        }
    }

    public void setOption(String option) {
        if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBMOUSEOPTION.getValor()])) {
            super.setOption("mouse",
                    OptionsEnumModel.USBMOUSEOPTION.getValor());
            this.myfile.getMymodel()
                    .setUsbMouseOption("true");
        }
    }

    public void unsetOption(String option) {
        super.unsetOption(option, OptionsEnumModel.USBMOUSEOPTION.getValor());
        this.myfile.getMymodel().setUsbMouseOption("false");
    }
}
