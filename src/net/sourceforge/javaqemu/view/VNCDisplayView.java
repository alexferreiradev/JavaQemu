package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sourceforge.javaqemu.control.FileControl;

public class VNCDisplayView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel jpanel;

    private JButton okButton, eraseButton;

    private GridLayout gridLayout;

    private JTextField iPAddressField;

    private JLabel iPAddressLabel;

    private JTextField tcpPortField;

    private JLabel tcpPortLabel;

    private JCheckBox reverseOption;

    private JCheckBox passwordOption;

    private JCheckBox lossyOption;

    private JCheckBox nonAdaptiveOption;

    private JLabel temp[];

    public VNCDisplayView(FileControl myfile) {
        this.jpanel = new JPanel();

        this.gridLayout = new GridLayout(7, 2);

        this.setTitle("JavaQemu - VNC Display Options");

        this.setContentPane(jpanel);

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        iPAddressLabel = new JLabel("IP Address: ");

        tcpPortLabel = new JLabel("TCP Port: 5900 + ");

        iPAddressField = new JTextField();

        tcpPortField = new JTextField();

        this.jpanel.setLayout(gridLayout);

        this.jpanel.add(iPAddressLabel);

        this.jpanel.add(iPAddressField);

        this.jpanel.add(tcpPortLabel);

        this.jpanel.add(tcpPortField);

        this.reverseOption = new JCheckBox("reverse");

        this.passwordOption = new JCheckBox("password");

        this.lossyOption = new JCheckBox("lossy");

        this.nonAdaptiveOption = new JCheckBox("non-adaptive");

        this.temp = new JLabel[4];

        for (int i = 0; i < this.temp.length; i++) {
            this.temp[i] = new JLabel();
        }

        this.jpanel.add(this.reverseOption);

        this.jpanel.add(this.temp[0]);

        this.jpanel.add(this.passwordOption);

        this.jpanel.add(this.temp[1]);

        this.jpanel.add(this.lossyOption);

        this.jpanel.add(this.temp[2]);

        this.jpanel.add(this.nonAdaptiveOption);

        this.jpanel.add(this.temp[3]);

        this.jpanel.add(okButton);

        this.jpanel.add(eraseButton);

        if (myfile.getMymodel().getDisplayType() != null) {
            if (myfile.getMymodel().getDisplayType().substring(0, 3)
                    .equals("vnc")) {
                this.iPAddressField.setText(myfile
                        .getMymodel()
                        .getDisplayType()
                        .substring(
                                4,
                                myfile.getMymodel().getDisplayType()
                                .indexOf(":")));
                if (myfile.getMymodel().getDisplayType().contains(",")) {
                    this.tcpPortField.setText(myfile
                            .getMymodel()
                            .getDisplayType()
                            .substring(
                                    myfile.getMymodel().getDisplayType()
                                    .indexOf(":") + 1,
                                    myfile.getMymodel().getDisplayType()
                                    .indexOf(",")));
                } else {
                    this.tcpPortField.setText(myfile
                            .getMymodel()
                            .getDisplayType()
                            .substring(
                                    myfile.getMymodel().getDisplayType()
                                    .indexOf(":") + 1));
                }
                if (myfile.getMymodel().getDisplayType().contains(",")) {
                    String[] otherOptions = myfile
                            .getMymodel()
                            .getDisplayType()
                            .substring(
                                    myfile.getMymodel().getDisplayType()
                                    .indexOf(",") + 1).split(",");
                    for (String option : otherOptions) {
                        if (option.equals("reverse")) {
                            this.reverseOption.setSelected(true);
                        } else if (option.equals("password")) {
                            this.passwordOption.setSelected(true);
                        } else if (option.equals("lossy")) {
                            this.lossyOption.setSelected(true);
                        } else if (option.equals("non-adaptive")) {
                            this.nonAdaptiveOption.setSelected(true);
                        }
                    }
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
    }

    public void configureStandardMode() {
        eraseButton.setActionCommand("eraseButton2");
        okButton.setActionCommand("okButton2");
    }

    public JTextField getiPAddressField() {
        return iPAddressField;
    }

    public JTextField getTcpPortField() {
        return tcpPortField;
    }

    public void setiPAddressField(String iPAddressField) {
        this.iPAddressField.setText(iPAddressField);
    }

    public void setTcpPortField(String tcpPortField) {
        this.tcpPortField.setText(tcpPortField);
    }

    public JCheckBox getReverseOption() {
        return reverseOption;
    }

    public JCheckBox getPasswordOption() {
        return passwordOption;
    }

    public JCheckBox getLossyOption() {
        return lossyOption;
    }

    public JCheckBox getNonAdaptiveOption() {
        return nonAdaptiveOption;
    }
}
