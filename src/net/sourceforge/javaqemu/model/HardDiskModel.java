package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;

public class HardDiskModel {

    private String firstHardDiskOption;

    private String secondHardDiskOption;

    private String thirdHardDiskOption;

    private String fourthHardDiskOption;

    private EmulationControl myemulation;

    private FileControl myfile;

    public HardDiskModel(EmulationControl myemulation, FileControl myfile) {
        this.myemulation = myemulation;
        this.myfile = myfile;
        if (this.myfile.getMymodel().getFirstHardDiskOption() != null) {
            this.firstHardDiskOption = this.myfile.getMymodel().getFirstHardDiskOption();
        }
        if (this.myfile.getMymodel().getSecondHardDiskOption() != null) {
            this.secondHardDiskOption = this.myfile.getMymodel().getSecondHardDiskOption();
        }
        if (this.myfile.getMymodel().getThirdHardDiskOption() != null) {
            this.thirdHardDiskOption = this.myfile.getMymodel().getThirdHardDiskOption();
        }
        if (this.myfile.getMymodel().getFourthHardDiskOption() != null) {
            this.fourthHardDiskOption = this.myfile.getMymodel().getFourthHardDiskOption();
        }
    }

    public String getFirstHardDiskOption() {
        return firstHardDiskOption;
    }

    public String getSecondHardDiskOption() {
        return secondHardDiskOption;
    }

    public String getThirdHardDiskOption() {
        return thirdHardDiskOption;
    }

    public String getFourthHardDiskOption() {
        return fourthHardDiskOption;
    }

    public void setFirstHardDiskOption(String firstHardDiskOption) {
        this.firstHardDiskOption = firstHardDiskOption;
        this.myemulation.define_first_hard_disk_option(firstHardDiskOption);
        this.myfile.getMymodel().setFirstHardDiskOption(firstHardDiskOption);
        this.myemulation.setJPanel();
    }

    public void setSecondHardDiskOption(String secondHardDiskOption) {
        this.secondHardDiskOption = secondHardDiskOption;
        this.myemulation.define_second_hard_disk_option(secondHardDiskOption);
        this.myfile.getMymodel().setSecondHardDiskOption(secondHardDiskOption);
        this.myemulation.setJPanel();
    }

    public void setThirdHardDiskOption(String thirdHardDiskOption) {
        this.thirdHardDiskOption = thirdHardDiskOption;
        this.myemulation.define_third_hard_disk_option(thirdHardDiskOption);
        this.myfile.getMymodel().setThirdHardDiskOption(thirdHardDiskOption);
        this.myemulation.setJPanel();
    }

    public void setFourthHardDiskOption(String fourthHardDiskOption) {
        this.fourthHardDiskOption = fourthHardDiskOption;
        this.myemulation.define_fourth_hard_disk_option(fourthHardDiskOption);
        this.myfile.getMymodel().setFourthHardDiskOption(fourthHardDiskOption);
        this.myemulation.setJPanel();
    }

}
