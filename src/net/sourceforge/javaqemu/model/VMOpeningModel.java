package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;

public class VMOpeningModel {

    private EmulationControl myemulation;
    private FileControl myfile;

    public VMOpeningModel(EmulationControl myemulation, FileControl myfile) {

        this.myemulation = myemulation;
        this.myfile = myfile;
    }

    public boolean starts() {
        if (this.myfile.getMymodel().getFirstHardDiskOption() != null) {
            this.myemulation.define_first_hard_disk_option(this.myfile.getMymodel()
                    .getFirstHardDiskOption());
        }
        if (this.myfile.getMymodel().getSecondHardDiskOption() != null) {
            this.myemulation.define_second_hard_disk_option(this.myfile
                    .getMymodel().getSecondHardDiskOption());
        }
        if (this.myfile.getMymodel().getThirdHardDiskOption() != null) {
            this.myemulation.define_third_hard_disk_option(this.myfile
                    .getMymodel().getThirdHardDiskOption());
        }
        if (this.myfile.getMymodel().getFourthHardDiskOption() != null) {
            this.myemulation.define_fourth_hard_disk_option(this.myfile
                    .getMymodel().getFourthHardDiskOption());
        }
        if (this.myfile.getMymodel().getRamSize() != null) {
            this.myemulation.change_options(
                    OptionsEnumModel.RAMSIZE.getValor(), "-m "
                    + this.myfile.getMymodel().getRamSize());
        } else {
            this.myemulation.change_options(
                    OptionsEnumModel.RAMSIZE.getValor(), "-m 128");
        }
        this.myemulation.appends_options();
        return true;
    }

    public void setMyemulation(EmulationControl myemulation) {
        this.myemulation = myemulation;
    }

    public void setMyfile(FileControl myfile) {
        this.myfile = myfile;
    }

    public FileControl getMyfile() {
        return myfile;
    }

    public String getDiskImagePath() {
        return this.myfile.getMymodel().getFirstHardDiskOption();
    }
}
