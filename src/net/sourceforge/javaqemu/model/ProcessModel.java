package net.sourceforge.javaqemu.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

import javax.swing.JLabel;

import net.sourceforge.javaqemu.view.EmulationView;
import net.sourceforge.javaqemu.view.ProcessMessageView;

public class ProcessModel implements Runnable {

    private Process myprocess;
    private Scanner outputScanner;
    private Scanner errorScanner;
    private String machineName;
    private JLabel outputs;
    private JLabel errors;

    private String qemuPathDir;
    private AliveFileModel files[];
    private Thread threads[];
    private Thread mainThread;

    private ProcessMessageView messageView[];

    public ProcessModel(Process myprocess, String machineName,
            String qemuPathDir, EmulationView myView) {
        this.myprocess = myprocess;
        this.machineName = machineName;
        this.setOutputs(new JLabel());
        this.setErrors(new JLabel());
        this.qemuPathDir = qemuPathDir;
        files = new AliveFileModel[2];
        threads = new Thread[4];
        messageView = new ProcessMessageView[4];
        messageView[AliveFilesEnumModel.STDERR.getValor()] = new ProcessMessageView(AliveFilesEnumModel.STDERR.getValor(), myView);
        messageView[AliveFilesEnumModel.STDOUT.getValor()] = new ProcessMessageView(AliveFilesEnumModel.STDOUT.getValor(), myView);
        messageView[AliveFilesEnumModel.ERR.getValor()] = new ProcessMessageView(AliveFilesEnumModel.ERR.getValor(), myView);
        messageView[AliveFilesEnumModel.OUT.getValor()] = new ProcessMessageView(AliveFilesEnumModel.OUT.getValor(), myView);
        outputs.addPropertyChangeListener(
                messageView[AliveFilesEnumModel.OUT.getValor()]);
        errors.addPropertyChangeListener(
                messageView[AliveFilesEnumModel.ERR.getValor()]);
    }

    @Override
    public void run() {
        threads[0] = new Thread() {
            @Override
            public void run() {
                inheritIO_Output();
            }
        };

        threads[1] = new Thread() {
            @Override
            public void run() {
                inheritIO_Error();
            }
        };

        threads[2] = new Thread() {
            @Override
            public void run() {
                while (isRunning(myprocess)) {
                    try {
                        if (files[AliveFilesEnumModel.STDERR.getValor()] != null) {
                            files[AliveFilesEnumModel.STDERR.getValor()].checks();
                        } else {
                            File stderr = new File(qemuPathDir
                                    + UsabilityModel.getFileSeparator() + "stderr.txt");
                            if (stderr.exists()) {
                                if (stderr.canRead()) {
                                    try {
                                        if (!isEmpty(stderr)) {
                                            files[AliveFilesEnumModel.STDERR.getValor()] = new AliveErrorFileModel(qemuPathDir,
                                                    AliveFilesEnumModel.STDERR.getValor(), "");
                                            files[AliveFilesEnumModel.STDERR.getValor()].getMessages()
                                                    .addPropertyChangeListener(messageView[AliveFilesEnumModel.STDERR.getValor()]);
                                            System.out.println("Monitorando stderr...");
                                        }
                                    } catch (IOException e) {
                                        files[AliveFilesEnumModel.STDERR.getValor()] = null;
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        files[AliveFilesEnumModel.STDERR.getValor()] = null;
                    }
                }
            }
        };

        threads[3] = new Thread() {
            @Override
            public void run() {
                while (isRunning(myprocess)) {
                    try {
                        if (files[AliveFilesEnumModel.STDOUT.getValor()] != null) {
                            files[AliveFilesEnumModel.STDOUT.getValor()].checks();
                        } else {
                            File stdout = new File(qemuPathDir
                                    + UsabilityModel.getFileSeparator() + "stdout.txt");
                            if (stdout.exists()) {
                                if (stdout.canRead()) {
                                    try {
                                        if (!isEmpty(stdout)) {
                                            files[AliveFilesEnumModel.STDOUT.getValor()] = new AliveOutputFileModel(qemuPathDir,
                                                    AliveFilesEnumModel.STDOUT.getValor(), "");
                                            files[AliveFilesEnumModel.STDOUT.getValor()].getMessages()
                                                    .addPropertyChangeListener(messageView[AliveFilesEnumModel.STDOUT.getValor()]);
                                            System.out.println("Monitorando stdout...");
                                        }
                                    } catch (IOException e) {
                                        files[AliveFilesEnumModel.STDOUT.getValor()] = null;
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        files[AliveFilesEnumModel.STDOUT.getValor()] = null;
                    }
                }
            }
        };

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

    private void inheritIO_Output() {
        outputScanner = new Scanner(this.myprocess.getInputStream(), "UTF-8");
        StringBuilder results = new StringBuilder("");
        while (outputScanner.hasNextLine()) {
            String result = outputScanner.nextLine();
            if (results.toString().isEmpty()) {
                results.append(result);
            } else {
                results.append("\n").append(result);
            }
        }

        if (!results.toString().isEmpty()) {

            if (this.getOutputs().getText().isEmpty()) {
                this.getOutputs().setText(results.toString());
            } else {
                StringBuilder sb = new StringBuilder(this.getOutputs().getText());
                sb.append("\n").append(results.toString());
                this.getOutputs().setText(sb.toString());
            }
        }
    }

    private void inheritIO_Error() {
        errorScanner = new Scanner(this.myprocess.getErrorStream(), "UTF-8");
        StringBuilder results = new StringBuilder("");
        while (errorScanner.hasNextLine()) {
            String result = errorScanner.nextLine();
            if (results.toString().isEmpty()) {
                results.append(result);
            } else {
                results.append("\n").append(result);
            }
        }

        if (!results.toString().isEmpty()) {
            if (this.getErrors().getText().isEmpty()) {
                this.getErrors().setText(results.toString());
            } else {
                StringBuilder sb = new StringBuilder(this.getErrors().getText());
                sb.append("\n").append(results.toString());
                this.getErrors().setText(sb.toString());
            }
        }
    }

    public JLabel getOutputs() {
        return outputs;
    }

    public void setOutputs(JLabel outputs) {
        this.outputs = outputs;
    }

    public JLabel getErrors() {
        return errors;
    }

    public void setErrors(JLabel errors) {
        this.errors = errors;
    }

    private boolean isRunning(Process process) {
        try {
            process.exitValue();
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public String getMachineName() {
        return machineName;
    }

    private boolean isEmpty(File file) throws IOException {
        /*
		 https://www.google.com.br/search?client=ubuntu&channel=fs&q=java.io.File&ie=utf-8&oe=utf-8&gfe_rd=cr&ei=7vCCVL-ZE8Ki8wfVpYFw#channel=fs&q=File+is+empty+java
		 ->
		 http://stackoverflow.com/questions/10281370/see-if-file-is-empty
		 AND
		 http://stackoverflow.com/questions/7190618/most-efficient-way-to-check-if-a-file-is-empty-in-java-on-windows
		 .
         */
        if (file.exists()) {
            if (file.canRead()) {
                InputStreamReader fileReader = null;
                boolean response = false;
                try {
                    fileReader = new InputStreamReader(new FileInputStream(
                            file.getAbsolutePath()),
                            Charset.forName("UTF-8"));
                } catch (FileNotFoundException e) {
                    response = true;
                } finally {
                    if (!response) {
                        BufferedReader br = new BufferedReader(fileReader);
                        String result = null;
                        try {
                            result = br.readLine();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } finally {
                            br.close();
                            fileReader.close();
                        }
                        response = result == null;
                    }
                }
                return response;
            } else {
                return file.length() == 0;
            }
        } else {
            return true;
        }
    }

    public Thread getMainThread() {
        return mainThread;
    }

    public void runMaster() throws InterruptedException {
        mainThread = new Thread(this);
        mainThread.start();
    }
}
