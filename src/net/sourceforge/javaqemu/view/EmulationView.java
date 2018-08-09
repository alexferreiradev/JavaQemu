package net.sourceforge.javaqemu.view;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EmulationView {

    public void showThisAfterInTheRunProcess(String[] execQemu) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < execQemu.length; i++) {
            if (!execQemu[i].isEmpty()) {
                result.append(" ").append(execQemu[i]);
            }
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(500, 500));
        JTextArea textArea = new JTextArea("It will run up: \n"
                + result.toString());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setMargin(new Insets(5, 5, 5, 5));
        scrollPane.getViewport().setView(textArea);
        Object trueMessage = scrollPane;
        JOptionPane.showMessageDialog(null, trueMessage);
    }

    public void showScriptCommand(String given) {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(500, 500));
        JTextArea textArea = new JTextArea("It will run up: \n"
                + given);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setMargin(new Insets(5, 5, 5, 5));
        scrollPane.getViewport().setView(textArea);
        Object trueMessage = scrollPane;
        JOptionPane.showMessageDialog(null, trueMessage);
    }

    /*
	 * public void showThisBeforeInTheRunProcess(String pathQemu, String[]
	 * execQemu) { JOptionPane .showMessageDialog( null,
	 * "Debug! EmulationModel! \n" + "this.getPathQemu vale: " + pathQemu +
	 * "\nthis.execQemu[0] vale: " + execQemu[0] +
	 * "\nthis.getPathQemu.substring(1, this.getPathQemu.length() - 1) vale: " +
	 * pathQemu.substring(1, pathQemu.length() - 1) +
	 * "\nthis.execQemu[1] vale: " + execQemu[1] + "\nthis.execQemu[2] vale: " +
	 * execQemu[2]); }
     */
    public boolean warns() {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(500, 500));
        JTextArea textArea = new JTextArea("You are going to kill the current machine. Are you sure?\nIt would be better if you shut the virtual machine manually down.\nThis way damage on the disk image may occur.");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setMargin(new Insets(5, 5, 5, 5));
        scrollPane.getViewport().setView(textArea);
        Object trueMessage = scrollPane;
        /*
         * http://www.tiexpert.net/programacao/java/joptionpane.php
         */
        int response = JOptionPane
                .showConfirmDialog(
                        null,
                        trueMessage,
                        "Confirm stop Qemu", dialogButton);
        if (response == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
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
}
