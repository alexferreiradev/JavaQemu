package net.sourceforge.javaqemu.model;

import javax.swing.JComboBox;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class CPUModel extends OptionsControl {

    private String cpuidFlags;
    private String cpuModel;

    public CPUModel(EmulationControl myemulation) {
        super(myemulation);
        cpuModel = "";
        cpuidFlags = "";
    }

    public void buildIt() {
        if (!cpuModel.isEmpty()) {
            super.setOption(cpuModel + cpuidFlags,
                    OptionsEnumModel.CPUOPTION.getValor());
        } else {
            super.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.CPUOPTION.getValor()]);
        }
    }

    public void buildCPUIDFlags(String[] mycpuidflagsoptions) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < mycpuidflagsoptions.length; i++) {
            if (!mycpuidflagsoptions[i].isEmpty()) {
                result.append(",+").append(mycpuidflagsoptions[i]);
            }
        }
        cpuidFlags = result.toString();
    }

    public void buildCPUModel(JComboBox<String> cpuModel) {
        if (cpuModel.getSelectedItem().toString().indexOf(":") != -1) {
            this.cpuModel = cpuModel
                    .getSelectedItem()
                    .toString()
                    .substring(
                            cpuModel.getSelectedItem().toString().indexOf(":") + 2);
        } else {
            this.cpuModel = "";
        }
    }

    public String getCpuidFlags() {
        return cpuidFlags;
    }

    public String getCpuModel() {
        return cpuModel;
    }
}
