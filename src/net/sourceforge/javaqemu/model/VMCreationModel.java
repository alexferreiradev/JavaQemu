package net.sourceforge.javaqemu.model;

import java.io.File;

public class VMCreationModel {

    private String chosenMachineName;

    private double diskImageSize;

    private String Qemu_imgPath;

    public String getChosenMachineName() {
        return chosenMachineName;
    }

    public void setChosenMachineName(String chosenMachineName) {
        this.chosenMachineName = chosenMachineName;
    }

    public double getDiskImageSize() {
        return diskImageSize;
    }

    public void setDiskImageSize(double diskImageSize) {
        this.diskImageSize = diskImageSize;
    }

    public String getQemu_imgPath() {
        return Qemu_imgPath;
    }

    public void setQemu_imgPath(String Qemu_imgPath) {
        this.Qemu_imgPath = Qemu_imgPath;
    }

    public boolean checks_if_is_a_valid_directory(String path) {
        File file = new File(path);

        if (!file.exists()) {
            return false;
        }

        if (file.isFile()) {
            return false;
        }

        return true;
    }

    public String checks_extension(String path) {
        String result = "";
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                result = "/";
                break;
            }
            if (path.charAt(i) == '\\') {
                result = "\\";
                break;
            }
        }
        return result;
    }
}
