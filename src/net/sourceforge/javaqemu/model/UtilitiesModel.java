package net.sourceforge.javaqemu.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

import net.sourceforge.javaqemu.view.UtilitiesView;

public class UtilitiesModel {

    private Process myprocess;
    private Scanner outputScanner;
    private UtilitiesView myview;
    private String outputs;
    private String qemuPathDir;

    public UtilitiesModel(Process myprocess, UtilitiesView myview, String qemuPathDir) {
        this.myprocess = myprocess;
        this.myview = myview;
        this.qemuPathDir = qemuPathDir;
    }

    public boolean inheritIO_Output_QemuImg() {
        outputScanner = new Scanner(this.myprocess.getInputStream(), "UTF-8");
        if (outputScanner.hasNextLine()) {
            String result = outputScanner.nextLine();
            this.myview.showMessage("The version of the qemu-img executable file is:\n" + result);
            return true;
        }
        return false;
    }

    public boolean inheritIO_Output_Qemu() {
        boolean returnValue = false;
        outputScanner = new Scanner(this.myprocess.getInputStream(), "UTF-8");
        StringBuilder results = new StringBuilder("");
        this.outputs = "";
        while (outputScanner.hasNextLine()) {
            returnValue = true;
            String result = outputScanner.nextLine();
            if (results.toString().isEmpty()) {
                results.append(result);
            } else {
                results.append("\n").append(result);
            }
        }
        this.outputs = results.toString();
        if (returnValue) {
            this.myview.showMessage("The version of the qemu executable file is:\n" + this.outputs);
        }
        return returnValue;
    }

    public boolean isRunning() {
        try {
            myprocess.exitValue();
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public boolean readsFile() throws IOException {
        File stdout = new File(qemuPathDir
                + UsabilityModel.getFileSeparator()
                + "stdout.txt");
        if (stdout.exists()) {
            if (stdout.canRead()) {
                InputStreamReader fileReader = null;
                boolean response = false;
                try {
                    StringBuilder sb = new StringBuilder(qemuPathDir.length()
                            + UsabilityModel.getFileSeparator().length()
                            + "stdout.txt".length());
                    sb.append(qemuPathDir)
                            .append(UsabilityModel.getFileSeparator())
                            .append("stdout.txt");

                    fileReader = new InputStreamReader(new FileInputStream(
                            sb.toString()), Charset.forName("UTF-8"));
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    BufferedReader br = new BufferedReader(fileReader);
                    String result;
                    try {
                        result = br.readLine();
                        if (result != null) {
                            StringBuilder results = new StringBuilder(result);
                            String line = br.readLine();
                            while (line != null) {
                                results.append("\n").append(line);
                                line = br.readLine();
                            }
                            result = results.toString();
                            this.myview.showMessage("The version of the qemu executable file is:\n" + result);
                            response = true;
                        }
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } finally {
                        br.close();
                        fileReader.close();
                    }
                }

                return response;
            }
        }
        return false;
    }

    public void setMyprocess(Process myprocess) {
        this.myprocess = myprocess;
    }

    public void setQemuPathDir(String qemuPathDir) {
        this.qemuPathDir = qemuPathDir;
    }
}
