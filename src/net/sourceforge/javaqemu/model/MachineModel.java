package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class MachineModel extends OptionsControl {

    private static String additionalKVMString = "-enable-kvm";
    private Boolean enabledKVM;
    private Boolean disabledKVM1, disabledKVM2, disabledKVM3;

    public MachineModel(EmulationControl myemulation) {
        super(myemulation);
    }

    public String buildAccel(String accel1, String accel2, String accel3) {
        StringBuilder result = new StringBuilder("");
        enabledKVM = false;
        if (!accel1.isEmpty()) {
            result.append(accel1);
            if (accel1.equals("kvm")) {
                enabledKVM = true;
                disabledKVM1 = false;
            } else {
                disabledKVM1 = true;
            }
        } else {
            disabledKVM1 = true;
        }

        if (!accel2.isEmpty()) {
            if (accel2.equals("kvm")) {
                enabledKVM = true;
                disabledKVM2 = false;
            } else {
                disabledKVM2 = true;
            }
            if (result.toString().isEmpty()) {
                result.append(accel2);
            } else {
                result.append(":").append(accel2);
            }
        } else {
            disabledKVM2 = true;
        }

        if (!accel3.isEmpty()) {
            if (accel3.equals("kvm")) {
                enabledKVM = true;
                disabledKVM3 = false;
            } else {
                disabledKVM3 = true;
            }
            if (result.toString().isEmpty()) {
                result.append(accel3);
            } else {
                result.append(":").append(accel3);
            }
        } else {
            disabledKVM3 = true;
        }

        return result.toString();
    }

    public void buildIt(String type, String accel, String kernel_irpchip,
            double kvm_shadow_mem, String dump_guest_core, String mem_merge) {
        StringBuilder result = new StringBuilder("");
        if (!type.isEmpty()) {
            result.append(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MACHINEOPTION.getValor()]).append("type=").append(type);
        } else {
            result.append(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MACHINEOPTION.getValor()]);
        }
        if (!accel.isEmpty()) {
            if (!result.toString().equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MACHINEOPTION.getValor()])) {
                result.append(",");
            }
            result.append("accel=").append(accel);
        }
        if (!kernel_irpchip.isEmpty()) {
            if (!result.toString().equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MACHINEOPTION.getValor()])) {
                result.append(",");
            }
            result.append("kernel_irqchip=").append(kernel_irpchip);
        }
        if (kvm_shadow_mem > 0) {
            if (!result.toString().equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MACHINEOPTION.getValor()])) {
                result.append(",");
            }
            result.append("kvm_shadow_mem=").append(kvm_shadow_mem);
        }
        if (!dump_guest_core.isEmpty()) {
            if (!result.toString().equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MACHINEOPTION.getValor()])) {
                result.append(",");
            }
            result.append("dump-guest-core=").append(dump_guest_core);
        }
        if (!mem_merge.isEmpty()) {
            if (!result.toString().equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MACHINEOPTION.getValor()])) {
                result.append(",");
            }
            result.append("mem-merge=").append(mem_merge);
        }

        if (this.enabledKVM != null && this.disabledKVM1 != null
                && this.disabledKVM2 != null && this.disabledKVM3 != null) {
            if (this.enabledKVM
                    && (!this.disabledKVM1 || !this.disabledKVM2 || !this.disabledKVM3)) {
                result.append(" ").append(additionalKVMString);
            }
        }

        if (!result.toString().equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MACHINEOPTION.getValor()])) {
            super.setOption(result.toString().substring(result.toString().indexOf(" ") + 1),
                    OptionsEnumModel.MACHINEOPTION.getValor());
        } else {
            this.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MACHINEOPTION.getValor()]);
        }
    }
}
