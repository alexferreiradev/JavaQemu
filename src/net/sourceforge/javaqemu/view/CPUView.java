package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.sourceforge.javaqemu.control.FileControl;

public class CPUView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel jpanel;

    private JButton okButton, eraseButton;

    private GridLayout gridLayout;

    private JLabel cpuLabel, temp1;

    private JComboBox<String> cpuModels;

    private JButton showsFlagsButton;

    private Boolean loaded;

    public CPUView(FileControl myfile) {
        this.jpanel = new JPanel();

        this.gridLayout = new GridLayout(3, 2);

        this.setTitle("JavaQemu - CPU Options");

        this.setContentPane(jpanel);

        this.jpanel.setLayout(gridLayout);

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        String[] models = {"", "Qemu 64 bits: qemu64", "AMD Phenom: phenom",
            "Intel Core 2 Duo: core2duo", "KVM 64 bits: kvm64",
            "Qemu 32 bits: qemu32", "KVM 32 bits: kvm32",
            "Intel Core Duo: coreduo", "486: 486",
            "Intel Pentium: pentium", "Intel Pentium 2: pentium2",
            "Intel Pentium 3: pentium3", "AMD Athlon: athlon",
            "Intel n270: n270", "Intel Conroe: Conroe",
            "Intel Penryn: Penryn", "Intel Nehalem: Nehalem",
            "Intel Westmere: Westmere", "Intel Sandy Bridge: SandyBridge",
            "Intel Haswell: Haswell", "AMD Opteron: Opteron_G1",
            "AMD Opteron: Opteron_G2", "AMD Opteron: Opteron_G3",
            "AMD Opteron: Opteron_G4", "AMD Opteron: Opteron_G5",
            "Host: host"};

        cpuModels = new JComboBox<String>(models);
        cpuModels.setSelectedIndex(0);

        this.showsFlagsButton = new JButton("Show the cpuid flags:");

        this.cpuLabel = new JLabel("CPU model:");

        this.jpanel.add(this.cpuLabel);
        this.jpanel.add(this.cpuModels);

        this.temp1 = new JLabel("");

        this.jpanel.add(this.showsFlagsButton);
        this.jpanel.add(this.temp1);
        this.jpanel.add(this.okButton);
        this.jpanel.add(this.eraseButton);

        this.loaded = false;

        if (myfile.getMymodel().getCpuModel() != null) {
            if (myfile.getMymodel().getCpuModel().isEmpty()) {
                this.cpuModels.setSelectedItem(myfile.getMymodel()
                        .getCpuModel());
            } else if (myfile.getMymodel().getCpuModel().equals("qemu64")) {
                this.cpuModels.setSelectedItem("Qemu 64 bits: qemu64");
            } else if (myfile.getMymodel().getCpuModel().equals("phenom")) {
                this.cpuModels.setSelectedItem("AMD Phenom: phenom");
            } else if (myfile.getMymodel().getCpuModel().equals("core2duo")) {
                this.cpuModels.setSelectedItem("Intel Core 2 Duo: core2duo");
            } else if (myfile.getMymodel().getCpuModel().equals("kvm64")) {
                this.cpuModels.setSelectedItem("KVM 64 bits: kvm64");
            } else if (myfile.getMymodel().getCpuModel().equals("qemu32")) {
                this.cpuModels.setSelectedItem("Qemu 32 bits: qemu32");
            } else if (myfile.getMymodel().getCpuModel().equals("kvm32")) {
                this.cpuModels.setSelectedItem("KVM 32 bits: kvm32");
            } else if (myfile.getMymodel().getCpuModel().equals("coreduo")) {
                this.cpuModels.setSelectedItem("Intel Core Duo: coreduo");
            } else if (myfile.getMymodel().getCpuModel().equals("486")) {
                this.cpuModels.setSelectedItem("486: 486");
            } else if (myfile.getMymodel().getCpuModel().equals("pentium")) {
                this.cpuModels.setSelectedItem("Intel Pentium: pentium");
            } else if (myfile.getMymodel().getCpuModel().equals("pentium2")) {
                this.cpuModels.setSelectedItem("Intel Pentium 2: pentium2");
            } else if (myfile.getMymodel().getCpuModel().equals("pentium3")) {
                this.cpuModels.setSelectedItem("Intel Pentium 3: pentium3");
            } else if (myfile.getMymodel().getCpuModel().equals("athlon")) {
                this.cpuModels.setSelectedItem("AMD Athlon: athlon");
            } else if (myfile.getMymodel().getCpuModel().equals("n270")) {
                this.cpuModels.setSelectedItem("Intel n270: n270");
            } else if (myfile.getMymodel().getCpuModel().equals("Conroe")) {
                this.cpuModels.setSelectedItem("Intel Conroe: Conroe");
            } else if (myfile.getMymodel().getCpuModel().equals("Penryn")) {
                this.cpuModels.setSelectedItem("Intel Penryn: Penryn");
            } else if (myfile.getMymodel().getCpuModel().equals("Nehalem")) {
                this.cpuModels.setSelectedItem("Intel Nehalem: Nehalem");
            } else if (myfile.getMymodel().getCpuModel().equals("Westmere")) {
                this.cpuModels.setSelectedItem("Intel Westmere: Westmere");
            } else if (myfile.getMymodel().getCpuModel().equals("SandyBridge")) {
                this.cpuModels
                        .setSelectedItem("Intel Sandy Bridge: SandyBridge");
            } else if (myfile.getMymodel().getCpuModel().equals("Haswell")) {
                this.cpuModels.setSelectedItem("Intel Haswell: Haswell");
            } else if (myfile.getMymodel().getCpuModel().equals("Opteron_G1")) {
                this.cpuModels.setSelectedItem("AMD Opteron: Opteron_G1");
            } else if (myfile.getMymodel().getCpuModel().equals("Opteron_G2")) {
                this.cpuModels.setSelectedItem("AMD Opteron: Opteron_G2");
            } else if (myfile.getMymodel().getCpuModel().equals("Opteron_G3")) {
                this.cpuModels.setSelectedItem("AMD Opteron: Opteron_G3");
            } else if (myfile.getMymodel().getCpuModel().equals("Opteron_G4")) {
                this.cpuModels.setSelectedItem("AMD Opteron: Opteron_G4");
            } else if (myfile.getMymodel().getCpuModel().equals("Opteron_G5")) {
                this.cpuModels.setSelectedItem("AMD Opteron: Opteron_G5");
            } else if (myfile.getMymodel().getCpuModel().equals("host")) {
                this.cpuModels.setSelectedItem("Host: host");
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
        showsFlagsButton.addActionListener(listener);
    }

    public void configureStandardMode() {
        eraseButton.setActionCommand("eraseButton");
        okButton.setActionCommand("okButton");
        showsFlagsButton.setActionCommand("showsFlagButton");
    }

    public JComboBox<String> getCpuModels() {
        return cpuModels;
    }

    public Boolean getLoaded() {
        return loaded;
    }
}
