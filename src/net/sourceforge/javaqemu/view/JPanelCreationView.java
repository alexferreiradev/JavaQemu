package net.sourceforge.javaqemu.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JPanelCreationView extends JPanel {

    private static final long serialVersionUID = 1L;

    private String title;

    private JButton startButton;

    private JButton stopButton;

    private GridBagLayout gridBagLayout;

    private GridBagConstraints gridBagConstraints;

    private JButton closeButton;

    private JButton changeMachineNameButton;

    private JButton saveVMButton;

    private JLabel titleLabel;

    private JLabel machineNameLabel;

    private JButton changeMachineConfigurationButton;

    private JButton seeQemuEmulationCommandLineButton;

    private String ramSize;

    public JPanelCreationView(String title, JButton createNewVMoption,
            JButton openExistingVMoption, ActionListener listener,
            JButton useUtilities) {
        super();
        this.title = title;
        if (title != null && title.equals("Untitled")) {
            JLabel optionsDescription = new JLabel("Options:");

            optionsDescription.setHorizontalAlignment(JLabel.CENTER);

            this.setLayout(new GridLayout(4, 1));
            this.add(optionsDescription);
            this.add(createNewVMoption);
            this.add(openExistingVMoption);
            this.add(useUtilities);

        } else {

            this.gridBagLayout = new GridBagLayout();
            this.gridBagConstraints = new GridBagConstraints();

            this.setLayout(gridBagLayout);

            this.title = title;

            this.titleLabel = new JLabel(title);

            this.closeButton = new JButton("Close this VM");

            this.changeMachineNameButton = new JButton(
                    "Change the name of this VM");

            startButton = new JButton("Start");

            stopButton = new JButton("Stop");

            this.machineNameLabel = new JLabel("Machine name: ");

            this.changeMachineConfigurationButton = new JButton(
                    "Change VM Configuration");

            this.saveVMButton = new JButton("Save this VM");

            this.seeQemuEmulationCommandLineButton = new JButton("See Qemu emulation command line");

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.weightx = 0.5;

            this.add(this.machineNameLabel, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.weightx = 0.5;

            this.add(this.titleLabel, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.weightx = 0.5;
            gridBagConstraints.gridwidth = 2;

            this.add(changeMachineNameButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.weightx = 0.5;
            gridBagConstraints.gridwidth = 2;

            this.add(saveVMButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.weightx = 0.5;
            gridBagConstraints.gridwidth = 2;

            this.add(closeButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 4;
            gridBagConstraints.weightx = 0.5;
            gridBagConstraints.gridwidth = 1;

            this.add(startButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 4;
            gridBagConstraints.weightx = 0.5;

            this.add(stopButton, gridBagConstraints);

            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 5;
            gridBagConstraints.weightx = 0.5;
            gridBagConstraints.gridwidth = 2;

            this.add(changeMachineConfigurationButton, gridBagConstraints);

            gridBagConstraints.gridy = 6;

            this.add(seeQemuEmulationCommandLineButton, gridBagConstraints);
        }

        this.configureStandardMode();

        this.configureListener(listener);
    }

    public String getTitle() {
        return title;
    }

    public void configureStandardMode() {
        if (this.title != null) {
            if (!this.title.equals("Untitled")) {
                startButton.setActionCommand("StartEmulation");
                stopButton.setActionCommand("StopEmulation");
                closeButton.setActionCommand("CloseVM");
                changeMachineNameButton.setActionCommand("ChangeMachineName");
                changeMachineConfigurationButton
                        .setActionCommand("ChangeMachineConfiguration");
                saveVMButton.setActionCommand("SaveVM");
                seeQemuEmulationCommandLineButton.setActionCommand("SeeQemuEmulationCommandLine");
            }
        } else {
            startButton.setActionCommand("StartEmulation");
            stopButton.setActionCommand("StopEmulation");
            closeButton.setActionCommand("CloseVM");
            changeMachineNameButton.setActionCommand("ChangeMachineName");
            changeMachineConfigurationButton
                    .setActionCommand("ChangeMachineConfiguration");
            saveVMButton.setActionCommand("SaveVM");
            seeQemuEmulationCommandLineButton.setActionCommand("SeeQemuEmulationCommandLine");
        }
    }

    public void showMessage(String message) {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(500, 500));
        JTextArea textArea = new JTextArea(message);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setMargin(new Insets(5, 5, 5, 5));
        scrollPane.getViewport().setView(textArea);
        Object trueMessage = scrollPane;
        JOptionPane.showMessageDialog(null, trueMessage);
    }

    public void configureListener(ActionListener listener) {
        if (this.title != null) {
            if (!this.title.equals("Untitled")) {
                startButton.addActionListener(listener);
                stopButton.addActionListener(listener);
                closeButton.addActionListener(listener);
                changeMachineNameButton.addActionListener(listener);
                changeMachineConfigurationButton.addActionListener(listener);
                saveVMButton.addActionListener(listener);
                seeQemuEmulationCommandLineButton.addActionListener(listener);
            }
        } else {
            startButton.addActionListener(listener);
            stopButton.addActionListener(listener);
            closeButton.addActionListener(listener);
            changeMachineNameButton.addActionListener(listener);
            changeMachineConfigurationButton.addActionListener(listener);
            saveVMButton.addActionListener(listener);
            seeQemuEmulationCommandLineButton.addActionListener(listener);
        }
    }

    public void setTitle(String title) {
        this.title = title;
        this.titleLabel.setText(title);
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }
}
