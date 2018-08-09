package net.sourceforge.javaqemu.model;

public class PhysicalDriveModel {

    private String option;

    public PhysicalDriveModel() {
        option = "";
    }

    public void setOption(String option) {
        if (!option.isEmpty()) {
            this.option = "\\" + "\\" + "." + "\\" + "PhysicalDrive" + option;
        } else {
            this.unsetOption();
        }
    }

    public void unsetOption() {
        option = "";
    }

    public String getOption() {
        return option;
    }
}
