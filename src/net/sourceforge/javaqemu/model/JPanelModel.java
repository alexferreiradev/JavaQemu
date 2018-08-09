package net.sourceforge.javaqemu.model;

public class JPanelModel {

    private String emulation;
    private String[] execQemu;

    public JPanelModel() {
        this.execQemu = new String[7];
        this.execQemu[0] = "";
        this.execQemu[1] = "";
        this.execQemu[2] = "";
        this.execQemu[3] = "";
        this.execQemu[4] = "";
        this.execQemu[5] = "";
        this.execQemu[6] = "";
    }

    public String getEmulation() {
        return emulation;
    }

    public void setEmulation(String[] basis) {
        for (int i = 0; i < this.execQemu.length
                && i < basis.length; i++) {
            if (!basis[i].isEmpty()) {
                this.execQemu[i] = basis[i];
            } else if (i >= 2) {
                this.execQemu[i] = "";
            }
        }
        StringBuilder result = new StringBuilder(execQemu[0]);
        for (int i = 1; i < execQemu.length; i++) {
            if (!execQemu[i].isEmpty()) {
                result.append(" ").append(execQemu[i]);
            }
        }
        this.emulation = result.toString();
    }

    public void setExecQemu(String basis, int position) {
        this.execQemu[position] = basis;
    }

    public String getExecQemu(int position) {
        return this.execQemu[position];
    }

    public String[] getExecQemu() {
        return execQemu.clone();
    }
}
