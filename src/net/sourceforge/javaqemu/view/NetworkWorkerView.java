package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.sourceforge.javaqemu.control.FileControl;

public class NetworkWorkerView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridLayout gridLayout;

    private JCheckBox isEnabled;

    private JButton nicOptions;

    private JButton userOption;

    private JButton tapOption;

    private JButton bridgeOption;

    private JButton tcpSocketOption;

    private JButton udpSocketOption;

    private JButton vdeOption;

    private JButton hubportOption;

    private JButton dumpOption;

    private JButton disableButton;

    private JButton okButton;

    private JLabel temp[];

    public NetworkWorkerView(FileControl myfile, int position) {
        super();

        windowContent = new JPanel();

        gridLayout = new GridLayout(7, 2);

        windowContent.setLayout(gridLayout);

        isEnabled = new JCheckBox("Enable these options!");

        windowContent.add(this.isEnabled);

        this.temp = new JLabel[2];
        for (int i = 0; i < this.temp.length; i++) {
            this.temp[i] = new JLabel();
        }

        windowContent.add(this.temp[0]);

        nicOptions = new JButton("Use the nic option!");

        userOption = new JButton("Use the user option!");

        windowContent.add(this.nicOptions);

        windowContent.add(this.userOption);

        tapOption = new JButton("Use the tap option!");

        bridgeOption = new JButton("Use the bridge option!");

        windowContent.add(this.tapOption);

        windowContent.add(this.bridgeOption);

        tcpSocketOption = new JButton("Use the tcp socket option!");

        udpSocketOption = new JButton("Use the udp socket option!");

        windowContent.add(this.tcpSocketOption);

        windowContent.add(this.udpSocketOption);

        vdeOption = new JButton("Use the vde option!");

        windowContent.add(this.vdeOption);

        hubportOption = new JButton("Use the hubport option!");

        windowContent.add(this.hubportOption);

        dumpOption = new JButton("Use the dump option!");

        windowContent.add(this.dumpOption);

        windowContent.add(this.temp[1]);

        okButton = new JButton("OK");

        disableButton = new JButton("Disable");

        windowContent.add(okButton);

        windowContent.add(disableButton);

        this.setContentPane(windowContent);

        this.setTitle("JavaQemu - Network Option Choice");

        switch (position) {
            case 1:
                if (myfile.getMymodel().getFirstNetworkNICOption() != null
                        || (myfile.getMymodel().getFirstNetworkExtraOption() != null
                        || myfile.getMymodel().getFirstNetworkNetdevOption() != null)) {
                    this.isEnabled.setSelected(true);
                } else if (myfile.getMymodel().getFirstNetworkNICOption() == null
                        && myfile.getMymodel().getFirstNetworkExtraOption() == null
                        && myfile.getMymodel().getFirstNetworkNetdevOption() == null
                        && myfile.getMymodel().getSecondNetworkNICOption() == null
                        && myfile.getMymodel().getSecondNetworkExtraOption() == null
                        && myfile.getMymodel().getSecondNetworkNetdevOption() == null
                        && myfile.getMymodel().getThirdNetworkNICOption() == null
                        && myfile.getMymodel().getThirdNetworkExtraOption() == null
                        && myfile.getMymodel().getThirdNetworkNetdevOption() == null
                        && myfile.getMymodel().getFourthNetworkNICOption() == null
                        && myfile.getMymodel().getFourthNetworkExtraOption() == null
                        && myfile.getMymodel().getFourthNetworkNetdevOption() == null
                        && myfile.getMymodel().getFifthNetworkNICOption() == null
                        && myfile.getMymodel().getFifthNetworkExtraOption() == null
                        && myfile.getMymodel().getFifthNetworkNetdevOption() == null
                        && myfile.getMymodel().getSixthNetworkNICOption() == null
                        && myfile.getMymodel().getSixthNetworkExtraOption() == null
                        && myfile.getMymodel().getSixthNetworkNetdevOption() == null
                        && myfile.getMymodel().getSeventhNetworkNICOption() == null
                        && myfile.getMymodel().getSeventhNetworkExtraOption() == null
                        && myfile.getMymodel().getSeventhNetworkNetdevOption() == null
                        && myfile.getMymodel().getEighthNetworkNICOption() == null
                        && myfile.getMymodel().getEighthNetworkExtraOption() == null
                        && myfile.getMymodel().getEighthNetworkNetdevOption() == null
                        && myfile.getMymodel().getNinthNetworkNICOption() == null
                        && myfile.getMymodel().getNinthNetworkExtraOption() == null
                        && myfile.getMymodel().getNinthNetworkNetdevOption() == null
                        && myfile.getMymodel().getTenthNetworkNICOption() == null
                        && myfile.getMymodel().getTenthNetworkExtraOption() == null
                        && myfile.getMymodel().getTenthNetworkNetdevOption() == null) {
                    this.isEnabled.setSelected(true);
                }
                break;
            case 2:
                if (myfile.getMymodel().getSecondNetworkNICOption() != null
                        || (myfile.getMymodel().getSecondNetworkExtraOption() != null
                        || myfile.getMymodel().getSecondNetworkNetdevOption() != null)) {
                    this.isEnabled.setSelected(true);
                }
                break;
            case 3:
                if (myfile.getMymodel().getThirdNetworkNICOption() != null
                        || (myfile.getMymodel().getThirdNetworkExtraOption() != null
                        || myfile.getMymodel().getThirdNetworkNetdevOption() != null)) {
                    this.isEnabled.setSelected(true);
                }
                break;
            case 4:
                if (myfile.getMymodel().getFourthNetworkNICOption() != null
                        || (myfile.getMymodel().getFourthNetworkExtraOption() != null
                        || myfile.getMymodel().getFourthNetworkNetdevOption() != null)) {
                    this.isEnabled.setSelected(true);
                }
                break;
            case 5:
                if (myfile.getMymodel().getFifthNetworkNICOption() != null
                        || (myfile.getMymodel().getFifthNetworkExtraOption() != null
                        || myfile.getMymodel().getFifthNetworkNetdevOption() != null)) {
                    this.isEnabled.setSelected(true);
                }
                break;
            case 6:
                if (myfile.getMymodel().getSixthNetworkNICOption() != null
                        || (myfile.getMymodel().getSixthNetworkExtraOption() != null
                        || myfile.getMymodel().getSixthNetworkNetdevOption() != null)) {
                    this.isEnabled.setSelected(true);
                }
                break;
            case 7:
                if (myfile.getMymodel().getSeventhNetworkNICOption() != null
                        || (myfile.getMymodel().getSeventhNetworkExtraOption() != null
                        || myfile.getMymodel().getSeventhNetworkNetdevOption() != null)) {
                    this.isEnabled.setSelected(true);
                }
                break;
            case 8:
                if (myfile.getMymodel().getEighthNetworkNICOption() != null
                        || (myfile.getMymodel().getEighthNetworkExtraOption() != null
                        || myfile.getMymodel().getEighthNetworkNetdevOption() != null)) {
                    this.isEnabled.setSelected(true);
                }
                break;
            case 9:
                if (myfile.getMymodel().getNinthNetworkNICOption() != null
                        || (myfile.getMymodel().getNinthNetworkExtraOption() != null
                        || myfile.getMymodel().getNinthNetworkNetdevOption() != null)) {
                    this.isEnabled.setSelected(true);
                }
                break;
            case 10:
                if (myfile.getMymodel().getTenthNetworkNICOption() != null
                        || (myfile.getMymodel().getTenthNetworkExtraOption() != null
                        || myfile.getMymodel().getTenthNetworkNetdevOption() != null)) {
                    this.isEnabled.setSelected(true);
                }
                break;
            default:
                break;
        }

        this.rechecks();

    }

    private void rechecks() {
        this.pack();
        this.repaint();
    }

    public void configureListener(ActionListener listener) {
        disableButton.addActionListener(listener);
        okButton.addActionListener(listener);
        nicOptions.addActionListener(listener);
        userOption.addActionListener(listener);
        tapOption.addActionListener(listener);
        bridgeOption.addActionListener(listener);
        tcpSocketOption.addActionListener(listener);
        udpSocketOption.addActionListener(listener);
        vdeOption.addActionListener(listener);
        hubportOption.addActionListener(listener);
        dumpOption.addActionListener(listener);
    }

    public void configureStandardMode() {
        disableButton.setActionCommand("disableButton");
        okButton.setActionCommand("okButton");
        nicOptions.setActionCommand("nicOptions");
        userOption.setActionCommand("userOption");
        tapOption.setActionCommand("tapOption");
        bridgeOption.setActionCommand("bridgeOption");
        tcpSocketOption.setActionCommand("tcpSocketOption");
        udpSocketOption.setActionCommand("udpSocketOption");
        vdeOption.setActionCommand("vdeOption");
        hubportOption.setActionCommand("hubportOption");
        dumpOption.setActionCommand("dumpOption");
    }

    public JCheckBox getIsEnabled() {
        return isEnabled;
    }
}
