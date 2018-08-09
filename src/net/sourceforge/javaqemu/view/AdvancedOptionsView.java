package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sourceforge.javaqemu.control.FileControl;

public class AdvancedOptionsView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel jpanel;

    private GridLayout gridLayout;

    private JLabel temp[];

    private JCheckBox win2kHackOption;

    private JCheckBox noAcpiOption;

    private JLabel nameDescription;

    private JTextField name;

    private JCheckBox snapshotOption;

    private JCheckBox noFdBootchkOption;

    private JCheckBox noHpetOption;

    private JButton okButton, eraseButton;

    public AdvancedOptionsView(FileControl myfile) {
        this.jpanel = new JPanel();

        this.setTitle("JavaQemu - Advanced Options");

        this.setContentPane(jpanel);

        this.gridLayout = new GridLayout(7, 2);

        jpanel.setLayout(gridLayout);

        this.temp = new JLabel[8];
        for (int i = 0; i < this.temp.length; i++) {
            this.temp[i] = new JLabel();
        }

        win2kHackOption = new JCheckBox("Enable win2kHack Option!");

        jpanel.add(win2kHackOption);
        jpanel.add(temp[0]);

        noAcpiOption = new JCheckBox("Disable ACPI Support!");

        jpanel.add(noAcpiOption);
        jpanel.add(temp[1]);

        nameDescription = new JLabel("Guest name:");

        name = new JTextField();

        jpanel.add(nameDescription);

        jpanel.add(name);

        snapshotOption = new JCheckBox("Enable Snapshot Option!");

        jpanel.add(snapshotOption);
        jpanel.add(this.temp[2]);

        noFdBootchkOption = new JCheckBox("Disable boot signature checking for floppy disks in BIOS!");

        jpanel.add(noFdBootchkOption);
        jpanel.add(this.temp[3]);

        noHpetOption = new JCheckBox("Disable HPET Support!");

        jpanel.add(noHpetOption);
        jpanel.add(this.temp[4]);

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        jpanel.add(okButton);

        jpanel.add(eraseButton);

        if (myfile.getMymodel().getWin2khackOption() != null) {
            if (myfile.getMymodel().getWin2khackOption().equals("true")) {
                this.win2kHackOption.setSelected(true);
            }
        }

        if (myfile.getMymodel().getNoacpiOption() != null) {
            if (myfile.getMymodel().getNoacpiOption().equals("true")) {
                this.noAcpiOption.setSelected(true);
            }
        }

        if (myfile.getMymodel().getNameOption() != null) {
            this.name.setText(myfile.getMymodel().getNameOption());
        }

        if (myfile.getMymodel().getSnapshotOption() != null) {
            if (myfile.getMymodel().getSnapshotOption().equals("true")) {
                this.snapshotOption.setSelected(true);
            }
        }

        if (myfile.getMymodel().getNoFdBootchkOption() != null) {
            if (myfile.getMymodel().getNoFdBootchkOption().equals("true")) {
                this.noFdBootchkOption.setSelected(true);
            }
        }

        if (myfile.getMymodel().getNoHpetOption() != null) {
            if (myfile.getMymodel().getNoHpetOption().equals("true")) {
                this.noHpetOption.setSelected(true);
            }
        }

        this.pack();
        this.setVisible(false);
    }

    public void configureListener(ActionListener listener) {
        eraseButton.addActionListener(listener);
        okButton.addActionListener(listener);
    }

    public void configureStandardMode() {
        eraseButton.setActionCommand("eraseButton");
        okButton.setActionCommand("okButton");
    }

    public JCheckBox getWin2kHackOption() {
        return win2kHackOption;
    }

    public JCheckBox getNoAcpiOption() {
        return noAcpiOption;
    }

    public JTextField getNameContents() {
        return name;
    }

    public JCheckBox getSnapshotOption() {
        return snapshotOption;
    }

    public JCheckBox getNoFdBootchkOption() {
        return noFdBootchkOption;
    }

    public JCheckBox getNoHpetOption() {
        return noHpetOption;
    }
}
