package net.sourceforge.javaqemu.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VMCreationViewPart2 extends JFileChooserView {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridBagLayout gridBagLayout;

    private GridBagConstraints gridBagConstraints;

    private JLabel windowDescriptionLabel;

    private JLabel chooseMachineName_descriptionLabel;

    private JLabel chooseMachineName_choiceLabel;

    private JLabel chooseVMPathLabel;

    private JTextField chooseVMPathField;

    private JButton cancelButton;

    private JButton backButton;

    private JButton nextButton;

    private String chooseMachineName;

    private String basePath;

    private JButton virtual_machine_path_chooser;

    public VMCreationViewPart2(String default_virtual_machines_path,
            String additionalPath) {
        super(null);

        windowContent = new JPanel();

        gridBagLayout = new GridBagLayout();
        this.gridBagConstraints = new GridBagConstraints();

        windowContent.setLayout(gridBagLayout);

        this.setJpanel(windowContent);

        windowDescriptionLabel = new JLabel(
                "Choose location for the new machine:");

        chooseMachineName_descriptionLabel = new JLabel("Name:");

        chooseMachineName_choiceLabel = new JLabel();

        chooseVMPathLabel = new JLabel("Path:");

        chooseVMPathField = new JTextField(0);
        this.basePath = default_virtual_machines_path
                + additionalPath;

        virtual_machine_path_chooser = new JButton(
                "Choose a VM Directory!");

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        windowContent.add(windowDescriptionLabel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.gridwidth = 1;
        windowContent.add(chooseMachineName_descriptionLabel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        windowContent.add(chooseMachineName_choiceLabel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        windowContent.add(chooseVMPathLabel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        windowContent.add(chooseVMPathField, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        windowContent.add(virtual_machine_path_chooser, gridBagConstraints);

        cancelButton = new JButton("Cancel");

        backButton = new JButton("< Back");

        nextButton = new JButton("Next >");

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        windowContent.add(backButton, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        windowContent.add(nextButton, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        windowContent.add(cancelButton, gridBagConstraints);

        this.setChoosertitle("Please, choose a directory!");
    }

    public void initialize() {
        this.setContentPane(windowContent);
        this.setTitle("Create a new machine - Part 2");
        this.pack();
    }

    public void configureListener(ActionListener listener) {
        backButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
        nextButton.addActionListener(listener);
        virtual_machine_path_chooser.addActionListener(listener);
    }

    public void configureStandardMode() {
        backButton.setActionCommand("Back1");
        cancelButton.setActionCommand("Cancel2");
        nextButton.setActionCommand("Next2");
        virtual_machine_path_chooser.setActionCommand("VM_Path_Chooser");
    }

    public void rechecks() {
        chooseMachineName_choiceLabel.setText(this.chooseMachineName);
        this.pack();
        this.repaint();
    }

    public void setChooseMachineName(String chooseMachineName) {
        this.chooseMachineName = chooseMachineName;
        this.chooseVMPathField.setText(this.basePath
                + this.chooseMachineName);
    }

    public JTextField getFieldChooseVMPath() {
        return chooseVMPathField;
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

    public String getBasePath() {
        return basePath;
    }
}
