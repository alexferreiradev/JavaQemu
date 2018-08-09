package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class KernelBootModel extends OptionsControl {

    private FileControl myfile;

    public KernelBootModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;

        if (this.myfile.getMymodel().getKernelBootOption() != null) {
            if (!this.myfile.getMymodel().getKernelBootOption().isEmpty()) {
                this.setOption(this.myfile.getMymodel().getKernelBootOption());
            }
        }
    }

    public void setOption(String option) {
        this.myfile.getMymodel()
                .setKernelBootOption(option);
        option = UsabilityModel.fixPath(option);
        super.setOption(option,
                OptionsEnumModel.KERNELBOOTOPTION.getValor());
    }

    public void unsetOption(String option) {
        super.unsetOption(option);
        this.myfile.getMymodel().setKernelBootOption("");
    }
}
