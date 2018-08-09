package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class USBWacomTabletModel extends OptionsControl {

    private FileControl myfile;

    public USBWacomTabletModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;

        if (myfile.getMymodel().getUsbWacomTabletOption() != null) {
            if (myfile.getMymodel().getUsbWacomTabletOption().equals("true")) {
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBWACOMTABLETOPTION.getValor()]);
            }
        }
    }

    public void setOption(String option) {
        if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBWACOMTABLETOPTION.getValor()])) {
            super.setOption("wacom-tablet",
                    OptionsEnumModel.USBWACOMTABLETOPTION.getValor());
            this.myfile.getMymodel()
                    .setUsbWacomTabletOption("true");
        }
    }

    public void unsetOption(String option) {
        super.unsetOption(option, OptionsEnumModel.USBWACOMTABLETOPTION.getValor());
        this.myfile.getMymodel().setUsbWacomTabletOption("false");
    }
}
