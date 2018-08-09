package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class USBBrailleModel extends OptionsControl {

    private FileControl myfile;

    public USBBrailleModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;

        if (this.myfile.getMymodel().getUsbBrailleOption() != null) {
            if (this.myfile.getMymodel().getUsbBrailleOption().equals("true")) {
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBBRAILLEOPTION.getValor()]);
            }
        }
    }

    public void setOption(String option) {
        if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBBRAILLEOPTION.getValor()])) {
            super.setOption("braille",
                    OptionsEnumModel.USBBRAILLEOPTION.getValor());
            this.myfile.getMymodel()
                    .setUsbBrailleOption("true");
        }
    }

    public void unsetOption(String option) {
        super.unsetOption(option, OptionsEnumModel.USBBRAILLEOPTION.getValor());
        this.myfile.getMymodel().setUsbBrailleOption("false");
    }
}
