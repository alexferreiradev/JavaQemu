package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.sourceforge.javaqemu.control.FileControl;

public class SMPView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridLayout gridLayout;

    private JLabel smpGeneralDescription;

    private JLabel temp[];

    private JLabel cpuNumbersDescription;

    private JComboBox<String> cpuNumbers;

    private JLabel coreNumbersDescription;

    private JComboBox<String> coreNumbers;

    private JLabel threadNumbersDescription;

    private JComboBox<String> threadNumbers;

    private JLabel socketNumbersDescription;

    private JComboBox<String> socketNumbers;

    private JLabel maxCpuNumbersDescription;

    private JComboBox<String> maxCpuNumbers;

    private JButton eraseButton;

    private JButton okButton;

    public SMPView(FileControl myfile) {
        super();

        windowContent = new JPanel();

        gridLayout = new GridLayout(7, 2);

        windowContent.setLayout(gridLayout);

        smpGeneralDescription = new JLabel("Choose the SMP system options:");

        windowContent.add(smpGeneralDescription);

        temp = new JLabel[1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new JLabel();
        }

        windowContent.add(temp[0]);

        cpuNumbersDescription = new JLabel("Choose the number of CPUs:");

        windowContent.add(cpuNumbersDescription);

        String[] smpOptions = {"", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
            "29", "30", "31", "32", "33", "34", "35", "36", "37", "38",
            "39", "40", "41", "42", "43", "44", "45", "46", "47", "48",
            "49", "50", "51", "52", "53", "54", "55", "56", "57", "58",
            "59", "60", "61", "62", "63", "64", "65", "66", "67", "68",
            "69", "70", "71", "72", "73", "74", "75", "76", "77", "78",
            "79", "80", "81", "82", "83", "84", "85", "86", "87", "88",
            "89", "90", "91", "92", "93", "94", "95", "96", "97", "98",
            "99", "100"};

        this.cpuNumbers = new JComboBox<String>(smpOptions);

        windowContent.add(cpuNumbers);

        this.coreNumbersDescription = new JLabel("Choose the number of cores:");

        windowContent.add(this.coreNumbersDescription);

        this.coreNumbers = new JComboBox<String>(smpOptions);

        windowContent.add(this.coreNumbers);

        this.threadNumbersDescription = new JLabel(
                "Choose the number of threads:");

        windowContent.add(this.threadNumbersDescription);

        this.threadNumbers = new JComboBox<String>(smpOptions);

        windowContent.add(this.threadNumbers);

        this.socketNumbersDescription = new JLabel(
                "Choose the number of sockets:");

        this.windowContent.add(this.socketNumbersDescription);

        this.socketNumbers = new JComboBox<String>(smpOptions);

        this.windowContent.add(this.socketNumbers);

        this.maxCpuNumbersDescription = new JLabel(
                "Choose the maximum number of CPUs:");

        this.windowContent.add(this.maxCpuNumbersDescription);

        this.maxCpuNumbers = new JComboBox<String>(smpOptions);

        this.windowContent.add(this.maxCpuNumbers);

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        windowContent.add(okButton);

        windowContent.add(eraseButton);

        this.setContentPane(windowContent);

        this.setTitle("JavaQemu - SMP System Choice");

        if (myfile.getMymodel().getSmpCpusNumber() != null) {
            this.getCpuNumbers().setSelectedItem(
                    myfile.getMymodel().getSmpCpusNumber());
        }

        if (myfile.getMymodel().getSmpCoresNumber() != null) {
            this.getCoreNumbers().setSelectedItem(
                    myfile.getMymodel().getSmpCoresNumber());
        }

        if (myfile.getMymodel().getSmpThreadsNumber() != null) {
            this.getThreadNumbers().setSelectedItem(
                    myfile.getMymodel().getSmpThreadsNumber());
        }

        if (myfile.getMymodel().getSmpSocketsNumber() != null) {
            this.getSocketNumbers().setSelectedItem(
                    myfile.getMymodel().getSmpSocketsNumber());
        }

        if (myfile.getMymodel().getSmpCpusMaxNumber() != null) {
            this.getMaxCpuNumbers().setSelectedItem(
                    myfile.getMymodel().getSmpCpusMaxNumber());
        }

        this.rechecks();

    }

    private void rechecks() {
        this.pack();
        this.repaint();
    }

    public void configureListener(ActionListener listener) {
        eraseButton.addActionListener(listener);
        okButton.addActionListener(listener);
    }

    public void configureStandardMode() {
        eraseButton.setActionCommand("eraseButton");
        okButton.setActionCommand("okButton");
    }

    public JComboBox<String> getCpuNumbers() {
        return cpuNumbers;
    }

    public JComboBox<String> getThreadNumbers() {
        return threadNumbers;
    }

    public JComboBox<String> getSocketNumbers() {
        return socketNumbers;
    }

    public JComboBox<String> getMaxCpuNumbers() {
        return maxCpuNumbers;
    }

    public JComboBox<String> getCoreNumbers() {
        return coreNumbers;
    }
}
