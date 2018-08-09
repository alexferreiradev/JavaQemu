package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.sourceforge.javaqemu.control.FileControl;

public class MachineTypeView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel jpanel;

    private JButton okButton, eraseButton;

    private GridLayout gridLayout;

    private JLabel machineTypeLabel;

    private JComboBox<String> machineTypes;

    private JButton showOptionsButton;

    private JLabel empty1;

    private Boolean loaded;

    public MachineTypeView(FileControl myfile) {
        this.jpanel = new JPanel();

        this.gridLayout = new GridLayout(3, 2);

        this.setTitle("JavaQemu - Machine Options");

        this.setContentPane(jpanel);

        this.jpanel.setLayout(gridLayout);

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        this.machineTypeLabel = new JLabel("Machine Type: ");

        String[] types = {"", "Standard ACPI PCI Based PC: q35", "Standard ACPI PCI Based PC: pc-q35-1.6",
            "Standard ACPI PCI Based PC: pc-q35-1.5", "Standard ACPI PCI Based PC: pc-q35-1.4",
            "Standard ACPI PCI Based PC: pc", "Standard ACPI PCI Based PC: pc-i440fx-1.6",
            "Standard ACPI PCI Based PC: pc-i440fx-1.5", "Standard ACPI PCI Based PC: pc-i440fx-1.4",
            "Standard ACPI PCI Based PC: pc-1.3", "Standard ACPI PCI Based PC: pc-1.2",
            "Standard ACPI PCI Based PC: pc-1.1", "Standard ACPI PCI Based PC: pc-1.0",
            "Standard ACPI PCI Based PC: pc-0.15", "Standard ACPI PCI Based PC: pc-0.14",
            "Standard ACPI PCI Based PC: pc-0.13", "Standard ACPI PCI Based PC: pc-0.12",
            "Standard ACPI PCI Based PC: pc-0.11", "Standard ACPI PCI Based PC: pc-0.10",
            "Standard ISA Based PC: isapc", "None"};

        machineTypes = new JComboBox<String>(types);
        machineTypes.setSelectedIndex(0);

        this.jpanel.add(this.machineTypeLabel);
        this.jpanel.add(this.machineTypes);

        showOptionsButton = new JButton("Change Machine Properties!");
        this.jpanel.add(this.showOptionsButton);

        empty1 = new JLabel("");
        this.jpanel.add(empty1);

        this.jpanel.add(this.okButton);
        this.jpanel.add(this.eraseButton);

        this.loaded = false;

        if (myfile.getMymodel().getMachineType() != null) {
            if (myfile.getMymodel().getMachineType().equals("")) {
                this.machineTypes.setSelectedItem(myfile.getMymodel()
                        .getMachineType());
            } else if (myfile.getMymodel().getMachineType().equals("q35")) {
                this.machineTypes.setSelectedItem("Standard ACPI PCI Based PC: q35");
            } else if (myfile.getMymodel().getMachineType().equals("pc-q35-1.6")) {
                this.machineTypes.setSelectedItem("Standard ACPI PCI Based PC: pc-q35-1.6");
            } else if (myfile.getMymodel().getMachineType().equals("pc-q35-1.5")) {
                this.machineTypes.setSelectedItem("Standard ACPI PCI Based PC: pc-q35-1.5");
            } else if (myfile.getMymodel().getMachineType().equals("pc-q35-1.4")) {
                this.machineTypes.setSelectedItem("Standard ACPI PCI Based PC: pc-q35-1.4");
            } else if (myfile.getMymodel().getMachineType().equals("pc")) {
                this.machineTypes.setSelectedItem("Standard ACPI PCI Based PC: pc");
            } else if (myfile.getMymodel().getMachineType()
                    .equals("pc-i440fx-1.6")) {
                this.machineTypes
                        .setSelectedItem("Standard ACPI PCI Based PC: pc-i440fx-1.6");
            } else if (myfile.getMymodel().getMachineType()
                    .equals("pc-i440fx-1.5")) {
                this.machineTypes
                        .setSelectedItem("Standard ACPI PCI Based PC: pc-i440fx-1.5");
            } else if (myfile.getMymodel().getMachineType()
                    .equals("pc-i440fx-1.4")) {
                this.machineTypes
                        .setSelectedItem("Standard ACPI PCI Based PC: pc-i440fx-1.4");
            } else if (myfile.getMymodel().getMachineType().equals("pc-1.3")) {
                this.machineTypes.setSelectedItem("Standard ACPI PCI Based PC: pc-1.3");
            } else if (myfile.getMymodel().getMachineType().equals("pc-1.2")) {
                this.machineTypes.setSelectedItem("Standard ACPI PCI Based PC: pc-1.2");
            } else if (myfile.getMymodel().getMachineType().equals("pc-1.1")) {
                this.machineTypes.setSelectedItem("Standard ACPI PCI Based PC: pc-1.1");
            } else if (myfile.getMymodel().getMachineType().equals("pc-1.0")) {
                this.machineTypes.setSelectedItem("Standard ACPI PCI Based PC: pc-1.0");
            } else if (myfile.getMymodel().getMachineType().equals("pc-0.15")) {
                this.machineTypes.setSelectedItem("Standard ACPI PCI Based PC: pc-0.15");
            } else if (myfile.getMymodel().getMachineType().equals("pc-0.14")) {
                this.machineTypes.setSelectedItem("Standard ACPI PCI Based PC: pc-0.14");
            } else if (myfile.getMymodel().getMachineType().equals("pc-0.13")) {
                this.machineTypes.setSelectedItem("Standard ACPI PCI Based PC: pc-0.13");
            } else if (myfile.getMymodel().getMachineType().equals("pc-0.12")) {
                this.machineTypes.setSelectedItem("Standard ACPI PCI Based PC: pc-0.12");
            } else if (myfile.getMymodel().getMachineType().equals("pc-0.11")) {
                this.machineTypes.setSelectedItem("Standard ACPI PCI Based PC: pc-0.11");
            } else if (myfile.getMymodel().getMachineType().equals("pc-0.10")) {
                this.machineTypes.setSelectedItem("Standard ACPI PCI Based PC: pc-0.10");
            } else if (myfile.getMymodel().getMachineType().equals("isapc")) {
                this.machineTypes.setSelectedItem("Standard ISA Based PC: isapc");
            } else if (myfile.getMymodel().getMachineType().equals("none")) {
                this.machineTypes.setSelectedItem("None");
            }
            this.loaded = true;
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
        this.showOptionsButton.addActionListener(listener);
    }

    public void configureStandardMode() {
        eraseButton.setActionCommand("eraseButton");
        okButton.setActionCommand("okButton");
        showOptionsButton.setActionCommand("showOptionsButton");
    }

    public JComboBox<String> getMachineTypes() {
        return machineTypes;
    }

    public Boolean getLoaded() {
        return loaded;
    }
}
