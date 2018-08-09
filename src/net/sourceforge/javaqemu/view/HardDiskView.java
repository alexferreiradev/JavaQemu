package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HardDiskView extends JFileChooserView {

    private static final long serialVersionUID = 1L;

    private JPanel jContentPane = null; // @jve:decl-index=0:visual-constraint="105,58"

    private GridLayout gridLayout;

    private JLabel firstHardDiskOption;

    private JTextField firstHardDiskOptionField;

    private JButton firstHardDiskImagePathButton;

    private JButton firstPhysicalHardDiskDriveButton;

    private JButton firstReadOnlyVirtualFATHardDiskPathButton;

    private JButton firstReadWriteVirtualFATHardDiskPathButton;

    private JButton firstLinuxPhysicalHardDiskDriveButton;

    private JLabel secondHardDiskOption;

    private JTextField secondHardDiskOptionField;

    private JButton secondHardDiskImagePathButton;

    private JButton secondPhysicalHardDiskDriveButton;

    private JButton secondReadOnlyVirtualFATHardDiskPathButton;

    private JButton secondReadWriteVirtualFATHardDiskPathButton;

    private JButton secondLinuxPhysicalHardDiskDriveButton;

    private JLabel thirdHardDiskOption;

    private JTextField thirdHardDiskOptionField;

    private JButton thirdHardDiskImagePathButton;

    private JButton thirdPhysicalHardDiskDriveButton;

    private JButton thirdReadOnlyVirtualFATHardDiskPathButton;

    private JButton thirdReadWriteVirtualFATHardDiskPathButton;

    private JButton thirdLinuxPhysicalHardDiskDriveButton;

    private JLabel fourthHardDiskOption;

    private JTextField fourthHardDiskOptionField;

    private JButton fourthHardDiskImagePathButton;

    private JButton fourthPhysicalHardDiskDriveButton;

    private JButton fourthReadOnlyVirtualFATHardDiskPathButton;

    private JButton fourthReadWriteVirtualFATHardDiskPathButton;

    private JButton fourthLinuxPhysicalHardDiskDriveButton;

    //private JLabel temp1, temp2;
    private JLabel temp[];

    private JButton okButton;

    private JButton eraseButton;

    public HardDiskView(String firstHardDiskOption, String secondHardDiskOption,
            String thirdHardDiskOption, String fourthHardDiskOption) {
        super(null);

        this.gridLayout = new GridLayout(17, 2);

        this.firstHardDiskOption = new JLabel("First Hard Disk Option:");

        this.firstHardDiskOptionField = new JTextField(firstHardDiskOption);

        this.firstHardDiskImagePathButton = new JButton(
                "Set First HD Image Path!");

        this.firstPhysicalHardDiskDriveButton = new JButton(
                "Set First Physical HD Drive (Windows)!");

        this.firstReadOnlyVirtualFATHardDiskPathButton = new JButton(
                "Set First READ-ONLY Virtual FAT HD Path!");

        this.firstReadWriteVirtualFATHardDiskPathButton = new JButton(
                "Set First READ-WRITE Virtual FAT HD Path!");

        this.firstLinuxPhysicalHardDiskDriveButton = new JButton(
                "Set First Physical HD Drive (Linux)!");

        this.temp = new JLabel[4];

        for (int i = 0; i < temp.length; i++) {
            this.temp[i] = new JLabel("");
        }

        this.initialize();
        this.setJpanel(jContentPane);

        jContentPane.add(this.firstHardDiskOption);
        jContentPane.add(this.firstHardDiskOptionField);
        jContentPane.add(this.firstHardDiskImagePathButton);
        jContentPane.add(this.firstPhysicalHardDiskDriveButton);
        jContentPane.add(this.firstLinuxPhysicalHardDiskDriveButton);
        jContentPane.add(this.firstReadOnlyVirtualFATHardDiskPathButton);
        jContentPane.add(this.firstReadWriteVirtualFATHardDiskPathButton);
        jContentPane.add(this.temp[0]);
        //jContentPane.add(this.temp[1]);

        this.secondHardDiskOption = new JLabel("Second Hard Disk Option:");

        this.secondHardDiskOptionField = new JTextField(secondHardDiskOption);

        this.secondHardDiskImagePathButton = new JButton(
                "Set Second HD Image Path!");

        this.secondPhysicalHardDiskDriveButton = new JButton(
                "Set Second Physical HD Drive (Windows)!");

        this.secondReadOnlyVirtualFATHardDiskPathButton = new JButton(
                "Set Second READ-ONLY Virtual FAT HD Path!");

        this.secondReadWriteVirtualFATHardDiskPathButton = new JButton(
                "Set Second READ-WRITE Virtual FAT HD Path!");

        this.secondLinuxPhysicalHardDiskDriveButton = new JButton(
                "Set Second Physical HD Drive (Linux)!");

        jContentPane.add(this.secondHardDiskOption);
        jContentPane.add(this.secondHardDiskOptionField);
        jContentPane.add(this.secondHardDiskImagePathButton);
        jContentPane.add(this.secondPhysicalHardDiskDriveButton);
        jContentPane.add(this.secondLinuxPhysicalHardDiskDriveButton);
        jContentPane.add(this.secondReadOnlyVirtualFATHardDiskPathButton);
        jContentPane.add(this.secondReadWriteVirtualFATHardDiskPathButton);
        jContentPane.add(this.temp[1]);
        //jContentPane.add(this.temp[2]);
        //jContentPane.add(this.temp[3]);

        this.thirdHardDiskOption = new JLabel("Third Hard Disk Option:");

        this.thirdHardDiskOptionField = new JTextField(thirdHardDiskOption);

        this.thirdHardDiskImagePathButton = new JButton(
                "Set Third HD Image Path!");

        this.thirdPhysicalHardDiskDriveButton = new JButton(
                "Set Third Physical HD Drive (Windows)!");

        this.thirdReadOnlyVirtualFATHardDiskPathButton = new JButton(
                "Set Third READ-ONLY Virtual FAT HD Path!");

        this.thirdReadWriteVirtualFATHardDiskPathButton = new JButton(
                "Set Third READ-WRITE Virtual FAT HD Path!");

        this.thirdLinuxPhysicalHardDiskDriveButton = new JButton(
                "Set Third Physical HD Drive (Linux)!");

        jContentPane.add(this.thirdHardDiskOption);
        jContentPane.add(thirdHardDiskOptionField);
        jContentPane.add(thirdHardDiskImagePathButton);
        jContentPane.add(this.thirdPhysicalHardDiskDriveButton);
        jContentPane.add(this.thirdLinuxPhysicalHardDiskDriveButton);
        jContentPane.add(this.thirdReadOnlyVirtualFATHardDiskPathButton);
        jContentPane.add(this.thirdReadWriteVirtualFATHardDiskPathButton);
        jContentPane.add(this.temp[2]);
        //jContentPane.add(this.temp[4]);
        //jContentPane.add(this.temp[5]);		

        this.fourthHardDiskOption = new JLabel("Fourth Hard Disk Option:");

        this.fourthHardDiskOptionField = new JTextField(fourthHardDiskOption);

        this.fourthHardDiskImagePathButton = new JButton(
                "Set Fourth HD Image Path!");

        this.fourthPhysicalHardDiskDriveButton = new JButton(
                "Set Fourth Physical HD Drive (Windows)!");

        this.fourthReadOnlyVirtualFATHardDiskPathButton = new JButton(
                "Set Fourth READ-ONLY Virtual FAT HD Path!");

        this.fourthReadWriteVirtualFATHardDiskPathButton = new JButton(
                "Set Fourth READ-WRITE Virtual FAT HD Path!");

        this.fourthLinuxPhysicalHardDiskDriveButton = new JButton(
                "Set Fourth Physical HD Drive (Linux)!");

        jContentPane.add(this.fourthHardDiskOption);
        jContentPane.add(this.fourthHardDiskOptionField);
        jContentPane.add(this.fourthHardDiskImagePathButton);
        jContentPane.add(this.fourthPhysicalHardDiskDriveButton);
        jContentPane.add(this.fourthLinuxPhysicalHardDiskDriveButton);
        jContentPane.add(this.fourthReadOnlyVirtualFATHardDiskPathButton);
        jContentPane.add(this.fourthReadWriteVirtualFATHardDiskPathButton);
        jContentPane.add(this.temp[3]);
        //jContentPane.add(this.temp[6]);		
        /*
		temp1 = new JLabel("");
		temp2 = new JLabel("");
         */
        this.okButton = new JButton("OK");
        this.eraseButton = new JButton("Erase");

        //jContentPane.add(this.temp1);
        //jContentPane.add(this.temp2);
        jContentPane.add(this.okButton);
        jContentPane.add(this.eraseButton);

        this.rechecks();
    }

    private void initialize() {
        this.setContentPane(getJContentPane());

        this.setTitle("JavaQemu - Hard Disk Configuration");

        this.jContentPane.setLayout(this.gridLayout);

        this.pack();
        this.repaint();
    }

    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            // jContentPane.add(getNum1Field(), null);
        }
        return jContentPane;
    }

    public void configureStandardMode() {
        this.firstHardDiskImagePathButton
                .setActionCommand("ChangeDiskImagePathButton");
        this.firstPhysicalHardDiskDriveButton
                .setActionCommand("SetFirstPhysicalHardDiskDriveButton");
        this.firstLinuxPhysicalHardDiskDriveButton
                .setActionCommand("SetFirstLinuxPhysicalHardDiskDriveButton");
        this.firstReadOnlyVirtualFATHardDiskPathButton
                .setActionCommand("SetFirstReadOnlyVirtualFATHardDiskPathButton");
        this.firstReadWriteVirtualFATHardDiskPathButton
                .setActionCommand("SetFirstReadWriteVirtualFATHardDiskPathButton");
        this.secondHardDiskImagePathButton
                .setActionCommand("ChangeSecondDiskImagePathButton");
        this.secondPhysicalHardDiskDriveButton
                .setActionCommand("SetSecondPhysicalHardDiskDriveButton");
        this.secondLinuxPhysicalHardDiskDriveButton
                .setActionCommand("SetSecondLinuxPhysicalHardDiskDriveButton");
        this.secondReadOnlyVirtualFATHardDiskPathButton
                .setActionCommand("SetSecondReadOnlyVirtualFATHardDiskPathButton");
        this.secondReadWriteVirtualFATHardDiskPathButton
                .setActionCommand("SetSecondReadWriteVirtualFATHardDiskPathButton");
        this.thirdHardDiskImagePathButton
                .setActionCommand("ChangeThirdDiskImagePathButton");
        this.thirdPhysicalHardDiskDriveButton
                .setActionCommand("SetThirdPhysicalHardDiskDriveButton");
        this.thirdLinuxPhysicalHardDiskDriveButton
                .setActionCommand("SetThirdLinuxPhysicalHardDiskDriveButton");
        this.thirdReadOnlyVirtualFATHardDiskPathButton
                .setActionCommand("SetThirdReadOnlyVirtualFATHardDiskPathButton");
        this.thirdReadWriteVirtualFATHardDiskPathButton
                .setActionCommand("SetThirdReadWriteVirtualFATHardDiskPathButton");
        this.fourthHardDiskImagePathButton
                .setActionCommand("ChangeFourthDiskImagePathButton");
        this.fourthPhysicalHardDiskDriveButton
                .setActionCommand("SetFourthPhysicalHardDiskDriveButton");
        this.fourthLinuxPhysicalHardDiskDriveButton
                .setActionCommand("SetFourthLinuxPhysicalHardDiskDriveButton");
        this.fourthReadOnlyVirtualFATHardDiskPathButton
                .setActionCommand("SetFourthReadOnlyVirtualFATHardDiskPathButton");
        this.fourthReadWriteVirtualFATHardDiskPathButton
                .setActionCommand("SetFourthReadWriteVirtualFATHardDiskPathButton");
        okButton.setActionCommand("okButtonHDI");
        eraseButton.setActionCommand("eraseButtonHDI");
    }

    public void configureListener(ActionListener listener) {
        this.firstHardDiskImagePathButton.addActionListener(listener);
        this.firstPhysicalHardDiskDriveButton.addActionListener(listener);
        this.firstLinuxPhysicalHardDiskDriveButton.addActionListener(listener);
        this.firstReadOnlyVirtualFATHardDiskPathButton
                .addActionListener(listener);
        this.firstReadWriteVirtualFATHardDiskPathButton
                .addActionListener(listener);
        this.secondHardDiskImagePathButton.addActionListener(listener);
        this.secondPhysicalHardDiskDriveButton.addActionListener(listener);
        this.secondLinuxPhysicalHardDiskDriveButton.addActionListener(listener);
        this.secondReadOnlyVirtualFATHardDiskPathButton
                .addActionListener(listener);
        this.secondReadWriteVirtualFATHardDiskPathButton
                .addActionListener(listener);
        this.thirdHardDiskImagePathButton.addActionListener(listener);
        this.thirdPhysicalHardDiskDriveButton.addActionListener(listener);
        this.thirdLinuxPhysicalHardDiskDriveButton.addActionListener(listener);
        this.thirdReadOnlyVirtualFATHardDiskPathButton
                .addActionListener(listener);
        this.thirdReadWriteVirtualFATHardDiskPathButton
                .addActionListener(listener);
        this.fourthHardDiskImagePathButton.addActionListener(listener);
        this.fourthPhysicalHardDiskDriveButton.addActionListener(listener);
        this.fourthLinuxPhysicalHardDiskDriveButton.addActionListener(listener);
        this.fourthReadOnlyVirtualFATHardDiskPathButton
                .addActionListener(listener);
        this.fourthReadWriteVirtualFATHardDiskPathButton
                .addActionListener(listener);
        okButton.addActionListener(listener);
        eraseButton.addActionListener(listener);
    }

    private void rechecks() {
        this.pack();
        this.repaint();
    }

    public String getFirstHardDiskOption() {
        return this.firstHardDiskOptionField.getText();
    }

    public String getSecondHardDiskOption() {
        return this.secondHardDiskOptionField.getText();
    }

    public String getThirdHardDiskOption() {
        return thirdHardDiskOptionField.getText();
    }

    public String getFourthHardDiskOption() {
        return fourthHardDiskOptionField.getText();
    }

    public void changesFirstHardDiskOptionField(String text) {
        this.firstHardDiskOptionField.setText(text);
    }

    public void changesSecondHardDiskOptionField(String text) {
        this.secondHardDiskOptionField.setText(text);
    }

    public void changesThirdHardDiskOptionField(String text) {
        this.thirdHardDiskOptionField.setText(text);
    }

    public void changesFourthHardDiskOptionField(String text) {
        this.fourthHardDiskOptionField.setText(text);
    }
}
