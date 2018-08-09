package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.sourceforge.javaqemu.control.FileControl;

public class CustomOptionsView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel jpanel;

    private JButton addButton, okButton, eraseSelectedButton, eraseButton,
            copyButton, modifyButton, findButton;

    private JLabel infoLabel;

    private GridLayout gridLayout;

    private JList<String> listBox;

    private JTextField textBox;

    private JScrollPane listScrollPane;

    private JScrollPane textBoxScrollPane;

    public CustomOptionsView(FileControl myfile) {
        this.jpanel = new JPanel();

        this.gridLayout = new GridLayout(10, 1);

        this.setTitle("JavaQemu - Custom Options");

        this.setContentPane(jpanel);

        this.jpanel.setLayout(gridLayout);

        this.textBox = new JTextField(0);

        this.textBoxScrollPane = new JScrollPane();
        this.textBoxScrollPane.setViewportView(this.textBox);

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        addButton = new JButton("Add new custom option");

        eraseSelectedButton = new JButton("Erase selected custom option");

        copyButton = new JButton("Copy selected custom option into text box");

        modifyButton = new JButton("Modify selected custom option from text box");

        findButton = new JButton("Find the text box option in the list");

        infoLabel = new JLabel("Please, insert unimplemented options here! The list of your options is showed below!");

        listBox = new JList<String>();
        listBox.setVisibleRowCount(2);
        listBox.setModel(new DefaultListModel<String>());

        listScrollPane = new JScrollPane();
        listScrollPane.setViewportView(listBox);

        this.jpanel.add(this.infoLabel);

        this.jpanel.add(this.listScrollPane);

        this.jpanel.add(this.textBoxScrollPane);

        this.jpanel.add(this.addButton);

        this.jpanel.add(this.eraseSelectedButton);

        this.jpanel.add(this.eraseButton);

        this.jpanel.add(this.copyButton);

        this.jpanel.add(this.modifyButton);

        this.jpanel.add(this.findButton);

        this.jpanel.add(this.okButton);

        if (myfile.getMymodel().getCustomOptions() != null) {
            String[] customOptions = myfile.getMymodel().getCustomOptions().split("\n");
            DefaultListModel<String> model = (DefaultListModel<String>) this.getListBox().getModel();
            for (String customOption : customOptions) {
                model.addElement(customOption);
            }
        }

        this.rechecks();
    }

    public void rechecks() {
        this.pack();
        this.repaint();
    }

    public void configureListener(ActionListener listener) {
        eraseButton.addActionListener(listener);
        okButton.addActionListener(listener);
        eraseSelectedButton.addActionListener(listener);
        addButton.addActionListener(listener);
        copyButton.addActionListener(listener);
        modifyButton.addActionListener(listener);
        findButton.addActionListener(listener);
    }

    public void configureStandardMode() {
        eraseButton.setActionCommand("eraseButton");
        okButton.setActionCommand("okButton");
        eraseSelectedButton.setActionCommand("eraseSelectedButton");
        addButton.setActionCommand("addButton");
        copyButton.setActionCommand("copyButton");
        modifyButton.setActionCommand("modifyButton");
        findButton.setActionCommand("findButton");
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JButton getEraseSelectedButton() {
        return eraseSelectedButton;
    }

    public JButton getEraseButton() {
        return eraseButton;
    }

    public JList<String> getListBox() {
        return listBox;
    }

    public JTextField getTextBox() {
        return textBox;
    }
}
