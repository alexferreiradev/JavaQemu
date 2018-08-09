package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sourceforge.javaqemu.control.FileControl;

public class SpecificBootView extends JFileChooserView {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridLayout gridLayout;

    private JButton chooseKernel;

    private JTextField kernel;

    private JButton eraseButton;

    private JButton okButton;

    public SpecificBootView(FileControl myfile) {
        super(null);

        windowContent = new JPanel();

        gridLayout = new GridLayout(2, 2);

        windowContent.setLayout(gridLayout);

        chooseKernel = new JButton("Choose the kernel image:");

        windowContent.add(chooseKernel);

        kernel = new JTextField();

        windowContent.add(kernel);

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        windowContent.add(okButton);

        windowContent.add(eraseButton);

        this.setContentPane(windowContent);
        this.setJpanel(windowContent);

        this.setTitle("JavaQemu - Specific Boot Choice");

        if (myfile.getMymodel().getKernelBootOption() != null) {
            if (!myfile.getMymodel().getKernelBootOption().isEmpty()) {
                this.kernel.setText(myfile.getMymodel().getKernelBootOption());
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
        chooseKernel.addActionListener(listener);
    }

    public void configureStandardMode() {
        eraseButton.setActionCommand("eraseButton");
        okButton.setActionCommand("okButton");
        chooseKernel.setActionCommand("chooseKernel");
    }

    public JTextField getKernel() {
        return kernel;
    }
}
