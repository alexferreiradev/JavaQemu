package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sourceforge.javaqemu.control.FileControl;

public class CDROMView extends JFileChooserView {

    private static final long serialVersionUID = 1L;

    private JPanel jpanel;

    private JLabel cdromLabel;

    private JTextField cdromText;

    private JButton cdromDriveSelection,
            diskImageSelection;

    private JButton okButton, eraseButton;

    private GridLayout gridLayout;

    public CDROMView(FileControl myfile) {
        super(null);

        this.jpanel = new JPanel();

        this.gridLayout = new GridLayout(3, 2);

        this.setTitle("JavaQemu - CDROM Options");

        this.setContentPane(jpanel);

        this.setJpanel(jpanel);

        this.jpanel.setLayout(gridLayout);

        this.cdromLabel = new JLabel("Insert your CDROM option:");

        this.cdromText = new JTextField("");

        this.cdromDriveSelection = new JButton("Select a CDROM Drive!");

        this.diskImageSelection = new JButton("Select a CDROM image file!");

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        this.jpanel.add(this.cdromLabel);
        this.jpanel.add(this.cdromText);
        this.jpanel.add(this.cdromDriveSelection);
        this.jpanel.add(this.diskImageSelection);
        this.jpanel.add(this.okButton);
        this.jpanel.add(this.eraseButton);

        if (myfile.getMymodel().getCdrom() != null) {
            this.cdromText.setText(myfile.getMymodel()
                    .getCdrom());
        }

        this.rechecks();
    }

    private void rechecks() {
        this.pack();
        this.repaint();
    }

    public void configureListener(ActionListener listener) {
        this.cdromDriveSelection.addActionListener(listener);
        this.diskImageSelection.addActionListener(listener);
        eraseButton.addActionListener(listener);
        okButton.addActionListener(listener);
    }

    public void configureStandardMode() {
        this.cdromDriveSelection.setActionCommand("cdromDriveSelection");
        this.diskImageSelection.setActionCommand("diskImageSelection");
        eraseButton.setActionCommand("eraseButton");
        okButton.setActionCommand("okButton");
    }

    public JTextField getCdromText() {
        return cdromText;
    }
}
