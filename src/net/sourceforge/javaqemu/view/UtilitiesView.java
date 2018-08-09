package net.sourceforge.javaqemu.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UtilitiesView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridBagLayout gridBagLayout;

    private GridBagConstraints gridBagConstraints;

    private JButton createNewDiskImageOption;

    private JButton seeOutputsOrErrorsFromProcesses;

    private JButton seeQemuVersion;

    private JButton seeQemuImgVersion;

    private JButton hideButton;

    public UtilitiesView() {
        super();

        windowContent = new JPanel();

        gridBagLayout = new GridBagLayout();
        this.gridBagConstraints = new GridBagConstraints();

        windowContent.setLayout(gridBagLayout);

        this.createNewDiskImageOption = new JButton(
                "Create a new disk image file");

        this.seeOutputsOrErrorsFromProcesses = new JButton("See the output(s) or error(s) of the running processes!");

        this.seeQemuVersion = new JButton("See the version of the qemu executable file!");

        this.seeQemuImgVersion = new JButton("See the version of the qemu-img executable file!");

        hideButton = new JButton("Hide");

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        windowContent.add(createNewDiskImageOption, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;

        windowContent.add(seeOutputsOrErrorsFromProcesses, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        windowContent.add(seeQemuVersion, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;

        windowContent.add(seeQemuImgVersion, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;

        windowContent.add(hideButton, gridBagConstraints);

    }

    public void initialize() {
        this.setContentPane(windowContent);
        this.setTitle("Utilities of the JavaQemu!");
        this.pack();
    }

    public void configureListener(ActionListener listener) {
        createNewDiskImageOption.addActionListener(listener);
        seeOutputsOrErrorsFromProcesses.addActionListener(listener);
        seeQemuVersion.addActionListener(listener);
        seeQemuImgVersion.addActionListener(listener);
        hideButton.addActionListener(listener);
    }

    public void configureStandardMode() {
        createNewDiskImageOption.setActionCommand("CreateNewDiskImageFile");
        seeOutputsOrErrorsFromProcesses.setActionCommand("seeOutputsFromProcesses");
        seeQemuVersion.setActionCommand("seeQemuVersion");
        seeQemuImgVersion.setActionCommand("seeQemuImgVersion");
        hideButton.setActionCommand("Hide_Utilities");
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

    public static void showMessageAnywhere(String message) {
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
}
