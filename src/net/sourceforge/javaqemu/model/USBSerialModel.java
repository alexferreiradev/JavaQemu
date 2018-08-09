package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class USBSerialModel extends OptionsControl {

    private FileControl myfile;

    private String option;

    private String vendorid;

    private String productid;

    private String dev;

    public USBSerialModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;

        if (myfile.getMymodel().getUsbSerialOption() != null) {
            if (!myfile.getMymodel().getUsbSerialOption().isEmpty()) {
                this.option = myfile.getMymodel().getUsbSerialOption();
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBSERIALOPTION.getValor()]);
            }
        }
    }

    public void setOption(String option) {
        if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBSERIALOPTION.getValor()])) {
            super.setOption("serial:" + this.option,
                    OptionsEnumModel.USBSERIALOPTION.getValor());
            this.myfile.getMymodel()
                    .setUsbSerialOption(this.option);
        }
    }

    public void unsetOption(String option) {
        super.unsetOption(option, OptionsEnumModel.USBSERIALOPTION.getValor());
        this.myfile.getMymodel().setUsbSerialOption("");
    }

    public void setVendorid(String vendorid) {
        this.vendorid = vendorid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public void setDev(String dev) {
        this.dev = dev;
    }

    public void setOption() {
        StringBuilder result = new StringBuilder("");
        if (!vendorid.isEmpty()) {
            result.append("vendorid=").append(vendorid);
            if (!productid.isEmpty()) {
                result.append(",productid=").append(productid);
            }
            if (!dev.isEmpty()) {
                result.append(":").append(dev);
            }
        } else if (!productid.isEmpty()) {
            result.append("productid=").append(productid);
            if (!dev.isEmpty()) {
                result.append(":").append(dev);
            }
        } else {
            result.append(dev);
        }
        option = result.toString();
    }
}
