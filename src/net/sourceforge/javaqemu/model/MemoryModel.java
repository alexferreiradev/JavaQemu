package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class MemoryModel extends OptionsControl {

    private FileControl myfile;

    public MemoryModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;

        if (this.myfile.getMymodel().getMemPathOption() != null) {
            if (!this.myfile.getMymodel().getMemPathOption().isEmpty()) {
                this.buildIt(this.myfile.getMymodel().getMemPathOption());
            }
        }

        if (this.myfile.getMymodel().getMemPreallocOption() != null) {
            if (!this.myfile.getMymodel().getMemPreallocOption().isEmpty()) {
                if (this.myfile.getMymodel().getMemPreallocOption().equals("true")) {
                    this.buildIt();
                }
            }
        }
    }

    public void buildIt(String path) {
        if (!path.isEmpty()) {
            path = UsabilityModel.fixPath(path);
            this.setOption(path);
            this.myfile.getMymodel().setMemPathOption(path);
        } else {
            this.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MEMORYPATHOPTION.getValor()]);
        }
    }

    public void buildIt() {
        this.setOption("");
        this.myfile.getMymodel().setMemPreallocOption("true");
    }

    private void setOption(String option) {
        if (!option.isEmpty()) {
            super.setOption(option,
                    OptionsEnumModel.MEMORYPATHOPTION.getValor());
        } else {
            super.setOption(option, OptionsEnumModel.MEMPREALLOC.getValor());
        }
    }

    public void unsetOption(String option) {
        super.unsetOption(option);
        if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MEMORYPATHOPTION.getValor()])) {
            this.myfile.getMymodel().setMemPathOption("");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MEMPREALLOC.getValor()])) {
            this.myfile.getMymodel().setMemPreallocOption("");
        }
    }
}
