package net.sourceforge.javaqemu.control;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.sourceforge.javaqemu.model.CustomOptionsModel;
import net.sourceforge.javaqemu.model.Model;
import net.sourceforge.javaqemu.view.CustomOptionsView;
import net.sourceforge.javaqemu.view.UtilitiesView;

public class CustomOptionsControl implements ActionListener {

    private CustomOptionsView myView;
    private CustomOptionsModel myModel;

    public CustomOptionsControl(EmulationControl myemulation, FileControl myfile) {
        this.myModel = new CustomOptionsModel(myemulation, myfile);
        this.myView = new CustomOptionsView(myfile);
        this.myView.configureStandardMode();
        this.myView.configureListener(this);
    }

    public void change_my_visibility(Boolean value) {
        this.myView.setVisible(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("eraseButton")) {
            DefaultListModel<String> listModel = (DefaultListModel<String>) this.myView.getListBox().getModel();
            listModel.removeAllElements();
            this.myView.getTextBox().setText("");
            this.myModel.setOption("");
            this.myModel.setFileOption("");
            this.myView.setVisible(false);
        } else if (e.getActionCommand().equals("eraseSelectedButton")) {
            DefaultListModel<String> model = (DefaultListModel<String>) this.myView.getListBox().getModel();
            int selectedIndex = this.myView.getListBox().getSelectedIndex();
            if (selectedIndex != -1) {
                model.remove(selectedIndex);

                StringBuilder sb = new StringBuilder(1024);
                StringBuilder fileSb = new StringBuilder(1024);

                if (model.getSize() > 0) {
                    sb.append((String) model.getElementAt(0));
                    fileSb.append((String) model.getElementAt(0));

                    for (int i = 1; i < model.getSize(); i++) {
                        sb.append(" ").append((String) model.getElementAt(i));
                        fileSb.append("\n").append((String) model.getElementAt(i));
                    }
                }

                this.myModel.setOption(sb.toString());
                this.myModel.setFileOption(fileSb.toString());
            }
        } else if (e.getActionCommand().equals("addButton")) {
            DefaultListModel<String> model = (DefaultListModel<String>) this.myView.getListBox().getModel();
            if (model.contains(this.myView.getTextBox().getText())) {
                UtilitiesView.showMessageAnywhere("This element already is added to the list.");
            } else if (Model.containCommonRoot(model, this.myView.getTextBox().getText())) {
                UtilitiesView.showMessageAnywhere("Another element already is added to the list, for this option.");
            } else {
                model.addElement(this.myView.getTextBox().getText());
                this.myView.rechecks();

                StringBuilder sb = new StringBuilder(1024);
                StringBuilder fileSb = new StringBuilder(1024);

                if (model.getSize() > 0) {
                    sb.append((String) model.getElementAt(0));
                    fileSb.append((String) model.getElementAt(0));

                    for (int i = 1; i < model.getSize(); i++) {
                        sb.append(" ").append((String) model.getElementAt(i));
                        fileSb.append("\n").append((String) model.getElementAt(i));
                    }
                }

                this.myModel.setOption(sb.toString());
                this.myModel.setFileOption(fileSb.toString());
            }
        } else if (e.getActionCommand().equals("okButton")) {
            this.myView.getTextBox().setText("");
            this.myView.setVisible(false);
        } else if (e.getActionCommand().equals("copyButton")) {
            DefaultListModel<String> model = (DefaultListModel<String>) this.myView.getListBox().getModel();
            int selectedIndex = this.myView.getListBox().getSelectedIndex();
            if (selectedIndex != -1) {
                this.myView.getTextBox().setText(model.getElementAt(selectedIndex));
            }
        } else if (e.getActionCommand().equals("modifyButton")) {
            DefaultListModel<String> model = (DefaultListModel<String>) this.myView.getListBox().getModel();
            int selectedIndex = this.myView.getListBox().getSelectedIndex();
            if (selectedIndex != -1) {
                if (this.myView.getTextBox().getText().isEmpty()) {
                    String message = "Sorry! The box text is empty!";
                    System.out.println(message);
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
                } else {
                    model.setElementAt(this.myView.getTextBox().getText(), selectedIndex);

                    StringBuilder sb = new StringBuilder(1024);
                    StringBuilder fileSb = new StringBuilder(1024);

                    if (model.getSize() > 0) {
                        sb.append((String) model.getElementAt(0));
                        fileSb.append((String) model.getElementAt(0));

                        for (int i = 1; i < model.getSize(); i++) {
                            sb.append(" ").append((String) model.getElementAt(i));
                            fileSb.append("\n").append((String) model.getElementAt(i));
                        }
                    }

                    this.myModel.setOption(sb.toString());
                    this.myModel.setFileOption(fileSb.toString());
                }
            } else {
                String message = "Sorry! You should to select a line from list above, first!";
                System.out.println(message);
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
        } else if (e.getActionCommand().equals("findButton")) {
            if (!this.myView.getTextBox().getText().isEmpty()) {
                DefaultListModel<String> model = (DefaultListModel<String>) this.myView.getListBox().getModel();
                if (model.contains(this.myView.getTextBox().getText())) {
                    UtilitiesView.showMessageAnywhere("The list contains the element: "
                            + this.myView.getTextBox().getText()
                            + ".");
                } else {
                    UtilitiesView.showMessageAnywhere("The list doesn't contain the element: "
                            + this.myView.getTextBox().getText()
                            + ".");
                }
            } else {
                UtilitiesView.showMessageAnywhere("Sorry! The box text is empty!");
            }
        }
    }

}
