package net.sourceforge.javaqemu.model;

import java.io.File;
import java.util.List;

public class DiskCreationModel {

    private Process myprocess;

    private String Qemu_imgPath;

    private String[] execQemu_img;

    private String sizeMB;

    private String fileName;

    private String default_virtual_machines_path;

    public Process getMyprocess() {
        return myprocess;
    }

    public void setMyprocess(Process myprocess) {
        this.myprocess = myprocess;
    }

    public DiskCreationModel(String sizeMB) {
        this.sizeMB = sizeMB;
        execQemu_img = new String[5];
        execQemu_img[1] = "create -f ";
        execQemu_img[2] = "";
        execQemu_img[4] = this.sizeMB;
    }

    public void setQemu_imgPath(String Qemu_imgPath) {
        this.Qemu_imgPath = Qemu_imgPath;
        this.execQemu_img[0] = this.Qemu_imgPath;
    }

    public void setFileName(String fileName, String extension) {
        if (default_virtual_machines_path != null) {
            Boolean containsSpace = false;
            StringBuilder sb = new StringBuilder();
            if (fileName.contains(" ")
                    || this.default_virtual_machines_path.contains(" ")) {
                containsSpace = true;
            }
            if (containsSpace) {
                sb.append("\"");
            }
            sb.append(this.default_virtual_machines_path)
                    .append(this.checks_extension(this.default_virtual_machines_path))
                    .append(fileName).append(extension);
            if (containsSpace) {
                sb.append("\"");
            }
            this.fileName = sb.toString();
            this.execQemu_img[3] = this.fileName;
            if (!extension.equals(".img")) {
                this.execQemu_img[1] = this.execQemu_img[1].substring(0, 10) + extension.substring(1);
            } else {
                this.execQemu_img[1] = this.execQemu_img[1].substring(0, 10) + "raw";
            }
        }
    }

    public String getFileName() {
        return fileName;
    }

    public String[] getExecQemu_img() {
        return execQemu_img.clone();
    }

    public void setDefault_virtual_machines_path(
            String default_virtual_machines_path) {
        this.default_virtual_machines_path = default_virtual_machines_path;
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

    public boolean createsAdditionalDirectory(String path) {
        File theDir = new File(path);

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            return theDir.mkdir();
        }
        return false;
    }

    public void setSizeMB(String sizeMB) {
        this.sizeMB = sizeMB;
        execQemu_img[4] = this.sizeMB;
    }

    public void setOption(String option) {
        execQemu_img[2] = "-o " + option;
    }

    public void setOptions(List<String> options) {
        StringBuilder sb = new StringBuilder("");
        for (String option : options) {
            if (!sb.toString().isEmpty()) {
                sb.append(" ");
            }
            sb.append("-o ").append(option);

        }
        execQemu_img[2] = sb.toString();
    }

    public void unsetOption() {
        execQemu_img[2] = "";
    }
}
