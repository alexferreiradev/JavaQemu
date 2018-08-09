package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class USBNetModel extends OptionsControl {

    private FileControl myfile;

    private String option;

    private String vlan;

    private String macaddr;

    private String name;

    private String addr;

    private String vectors;

    public USBNetModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;

        if (myfile.getMymodel().getUsbNetOption() != null) {
            if (!myfile.getMymodel().getUsbNetOption().isEmpty()) {
                this.option = myfile.getMymodel().getUsbNetOption();
                this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBNETOPTION.getValor()]);
            }
        }
    }

    public void setOption(String option) {
        if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBNETOPTION.getValor()])) {
            super.setOption("net:" + this.option,
                    OptionsEnumModel.USBNETOPTION.getValor());
            this.myfile.getMymodel()
                    .setUsbNetOption(this.option);
        }
    }

    public void unsetOption(String option) {
        super.unsetOption(option, OptionsEnumModel.USBNETOPTION.getValor());
        this.myfile.getMymodel().setUsbNetOption("");
    }

    public void setVlan(String vlan) {
        this.vlan = vlan;
    }

    public void setMacaddr(String macaddr) {
        this.macaddr = macaddr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setVectors(String vectors) {
        this.vectors = vectors;
    }

    public void setOption() {
        StringBuilder result = new StringBuilder("");
        if (!vlan.isEmpty()) {
            result.append("vlan=").append(vlan);
            if (!macaddr.isEmpty()) {
                result.append(",macaddr=").append(macaddr);
            }
            if (!name.isEmpty()) {
                result.append(",name=").append(name);
            }
            if (!addr.isEmpty()) {
                result.append(",addr=").append(addr);
            }
            if (!vectors.isEmpty()) {
                result.append(",vectors=").append(vectors);
            }
        } else if (!macaddr.isEmpty()) {
            result.append("macaddr=").append(macaddr);
            if (!name.isEmpty()) {
                result.append(",name=").append(name);
            }
            if (!addr.isEmpty()) {
                result.append(",addr=").append(addr);
            }
            if (!vectors.isEmpty()) {
                result.append(",vectors=").append(vectors);
            }
        } else if (!name.isEmpty()) {
            result.append("name=").append(name);
            if (!addr.isEmpty()) {
                result.append(",addr=").append(addr);
            }
            if (!vectors.isEmpty()) {
                result.append(",vectors=").append(vectors);
            }
        } else if (!addr.isEmpty()) {
            result.append("addr=").append(addr);
            if (!vectors.isEmpty()) {
                result.append(",vectors=").append(vectors);
            }
        } else if (!vectors.isEmpty()) {
            result.append("vectors=").append(vectors);
        }
        option = result.toString();
    }
}
