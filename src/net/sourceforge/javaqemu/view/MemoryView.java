package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sourceforge.javaqemu.control.FileControl;

public class MemoryView extends JFileChooserView {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridLayout gridLayout;

    private JLabel memoryPathLabel;

    private JTextField memoryPath;

    private JButton memoryPathChooser;

    private JCheckBox memPrealloc;

    private JButton eraseButton;

    private JButton okButton;

    private JLabel temp[];

    public MemoryView(FileControl myfile) {
        super(null);

        windowContent = new JPanel();
        this.setJpanel(windowContent);

        gridLayout = new GridLayout(3, 3);

        windowContent.setLayout(gridLayout);

        memoryPathLabel = new JLabel("Choose the memory path:");

        windowContent.add(memoryPathLabel);

        memoryPath = new JTextField();

        windowContent.add(memoryPath);

        memoryPathChooser = new JButton("Choose a directory as memory path!");

        windowContent.add(memoryPathChooser);

        memPrealloc = new JCheckBox("-mem-prealloc option!");

        windowContent.add(memPrealloc);

        temp = new JLabel[3];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = new JLabel();
            windowContent.add(temp[i]);
        }

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        windowContent.add(okButton);

        windowContent.add(eraseButton);

        this.setContentPane(windowContent);

        this.setTitle("JavaQemu - Other Memory Options");

        if (myfile.getMymodel().getMemPathOption() != null) {
            if (!myfile.getMymodel().getMemPathOption().isEmpty()) {
                this.memoryPath.setText(myfile.getMymodel().getMemPathOption());
            }
        }

        if (myfile.getMymodel().getMemPreallocOption() != null) {
            if (!myfile.getMymodel().getMemPreallocOption().isEmpty()) {
                if (myfile.getMymodel().getMemPreallocOption().equals("true")) {
                    this.memPrealloc.setSelected(true);
                }
            }
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
        memoryPathChooser.addActionListener(listener);
    }

    public void configureStandardMode() {
        eraseButton.setActionCommand("eraseButton");
        okButton.setActionCommand("okButton");
        memoryPathChooser.setActionCommand("memoryPathChooser");
    }

    public JTextField getMemoryPath() {
        return memoryPath;
    }

    public JCheckBox getMemPrealloc() {
        return memPrealloc;
    }
}
