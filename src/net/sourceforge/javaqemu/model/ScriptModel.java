package net.sourceforge.javaqemu.model;

import java.util.Scanner;

import net.sourceforge.javaqemu.view.EmulationView;

public class ScriptModel extends Thread {

    private Process myprocess;
    private Scanner outputScanner;
    private String outputs;
    private EmulationView myview;

    public ScriptModel(Process myprocess, EmulationView myview) {
        this.myprocess = myprocess;
        this.outputs = "";
        this.myview = myview;
    }

    public void run() {
        inheritIO_Output();
    }

    private void inheritIO_Output() {
        outputScanner = new Scanner(this.myprocess.getInputStream(), "UTF-8");
        StringBuilder results = new StringBuilder("");
        while (outputScanner.hasNextLine()) {
            String result = outputScanner.nextLine();
            this.myview.showMessage("The emulation process output of this script is:\n" + result);
            if (results.toString().isEmpty()) {
                results.append(result);
            } else {
                results.append("\n").append(result);
            }
        }
        this.outputs = results.toString();
    }

    public String getOutputs() {
        return outputs;
    }
}
