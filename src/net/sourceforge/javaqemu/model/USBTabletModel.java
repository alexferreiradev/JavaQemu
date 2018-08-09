package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class USBTabletModel extends OptionsControl {

    private FileControl myfile;

    public USBTabletModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;

        if (myfile.getMymodel().getUsbTabletOption() != null) {
            if (myfile.getMymodel().getUsbTabletOption().equals("true")) {
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBTABLETOPTION.getValor()]);
            }
        }
    }

    public void setOption(String option) {
        if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBTABLETOPTION.getValor()])) {
            super.setOption("tablet",
                    OptionsEnumModel.USBTABLETOPTION.getValor());
            this.myfile.getMymodel()
                    .setUsbTabletOption("true");
        }
    }

    public void unsetOption(String option) {
        super.unsetOption(option, OptionsEnumModel.USBTABLETOPTION.getValor());
        this.myfile.getMymodel().setUsbTabletOption("false");
    }
}
