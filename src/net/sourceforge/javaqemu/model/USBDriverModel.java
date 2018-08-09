package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class USBDriverModel extends OptionsControl {

    private FileControl myfile;

    public USBDriverModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;

        if (myfile.getMymodel().getUsbDriverOption() != null) {
            if (myfile.getMymodel().getUsbDriverOption().equals("true")) {
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBDRIVEROPTION.getValor()]);
            }
        }
    }

    public void setOption(String option) {
        if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBDRIVEROPTION.getValor()])) {
            super.setOption("",
                    OptionsEnumModel.USBDRIVEROPTION.getValor());
            this.myfile.getMymodel()
                    .setUsbDriverOption("true");
        }
    }

    public void unsetOption(String option) {
        super.unsetOption(option);
        this.myfile.getMymodel().setUsbDriverOption("false");
    }
}
