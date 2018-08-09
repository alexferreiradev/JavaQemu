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

public class NetworkHubportWorkerView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridLayout gridLayout;

    private JCheckBox isEnabled;

    private JLabel temp;

    private JLabel idDescription;

    private JTextField id;

    private JLabel hubidDescription;

    private JTextField hubid;

    private JButton eraseButton;

    private JButton okButton;

    public NetworkHubportWorkerView(FileControl myfile, int position) {
        super();

        windowContent = new JPanel();

        gridLayout = new GridLayout(4, 2);

        windowContent.setLayout(gridLayout);

        isEnabled = new JCheckBox("Enable this option!");

        windowContent.add(this.isEnabled);

        temp = new JLabel();

        windowContent.add(temp);

        idDescription = new JLabel("Choose the id:");

        windowContent.add(idDescription);

        id = new JTextField();

        windowContent.add(id);

        hubidDescription = new JLabel("Choose the hubid:");

        windowContent.add(hubidDescription);

        hubid = new JTextField();

        windowContent.add(hubid);

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        windowContent.add(okButton);

        windowContent.add(eraseButton);

        this.setContentPane(windowContent);

        this.setTitle("JavaQemu - Network Hub Port Choice");

        switch (position) {
            case 1:
                if (myfile.getMymodel().getFirstNetworkNetdevOption() != null) {
                    if (this.contains(myfile.getMymodel()
                            .getFirstNetworkNetdevOption())) {
                        this.buildMe(myfile.getMymodel()
                                .getFirstNetworkNetdevOption());
                        this.isEnabled.setSelected(true);
                    }
                }
                break;
            case 2:
                if (myfile.getMymodel().getSecondNetworkNetdevOption() != null) {
                    if (this.contains(myfile.getMymodel()
                            .getSecondNetworkNetdevOption())) {
                        this.buildMe(myfile.getMymodel()
                                .getSecondNetworkNetdevOption());
                        this.isEnabled.setSelected(true);
                    }
                }
                break;
            case 3:
                if (myfile.getMymodel().getThirdNetworkNetdevOption() != null) {
                    if (this.contains(myfile.getMymodel()
                            .getThirdNetworkNetdevOption())) {
                        this.buildMe(myfile.getMymodel()
                                .getThirdNetworkNetdevOption());
                        this.isEnabled.setSelected(true);
                    }
                }
                break;
            case 4:
                if (myfile.getMymodel().getFourthNetworkNetdevOption() != null) {
                    if (this.contains(myfile.getMymodel()
                            .getFourthNetworkNetdevOption())) {
                        this.buildMe(myfile.getMymodel()
                                .getFourthNetworkNetdevOption());
                        this.isEnabled.setSelected(true);
                    }
                }
                break;
            case 5:
                if (myfile.getMymodel().getFifthNetworkNetdevOption() != null) {
                    if (this.contains(myfile.getMymodel()
                            .getFifthNetworkNetdevOption())) {
                        this.buildMe(myfile.getMymodel()
                                .getFifthNetworkNetdevOption());
                        this.isEnabled.setSelected(true);
                    }
                }
                break;
            case 6:
                if (myfile.getMymodel().getSixthNetworkNetdevOption() != null) {
                    if (this.contains(myfile.getMymodel()
                            .getSixthNetworkNetdevOption())) {
                        this.buildMe(myfile.getMymodel()
                                .getSixthNetworkNetdevOption());
                        this.isEnabled.setSelected(true);
                    }
                }
                break;
            case 7:
                if (myfile.getMymodel().getSeventhNetworkNetdevOption() != null) {
                    if (this.contains(myfile.getMymodel()
                            .getSeventhNetworkNetdevOption())) {
                        this.buildMe(myfile.getMymodel()
                                .getSeventhNetworkNetdevOption());
                        this.isEnabled.setSelected(true);
                    }
                }
                break;
            case 8:
                if (myfile.getMymodel().getEighthNetworkNetdevOption() != null) {
                    if (this.contains(myfile.getMymodel()
                            .getEighthNetworkNetdevOption())) {
                        this.buildMe(myfile.getMymodel()
                                .getEighthNetworkNetdevOption());
                        this.isEnabled.setSelected(true);
                    }
                }
                break;
            case 9:
                if (myfile.getMymodel().getNinthNetworkNetdevOption() != null) {
                    if (this.contains(myfile.getMymodel()
                            .getNinthNetworkNetdevOption())) {
                        this.buildMe(myfile.getMymodel()
                                .getNinthNetworkNetdevOption());
                        this.isEnabled.setSelected(true);
                    }
                }
                break;
            case 10:
                if (myfile.getMymodel().getTenthNetworkNetdevOption() != null) {
                    if (this.contains(myfile.getMymodel()
                            .getTenthNetworkNetdevOption())) {
                        this.buildMe(myfile.getMymodel()
                                .getTenthNetworkNetdevOption());
                        this.isEnabled.setSelected(true);
                    }
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
        eraseButton.addActionListener(listener);
        okButton.addActionListener(listener);
    }

    public void configureStandardMode() {
        eraseButton.setActionCommand("eraseButton");
        okButton.setActionCommand("okButton");
    }

    private void buildMe(String optionString) {
        String options[] = optionString.split(",");

        for (String option : options) {
            if (option.startsWith("id=")) {
                this.id
                        .setText(option.substring(option.indexOf("=") + 1));
            } else if (option.startsWith("hubid=")) {
                this.hubid.setText(option.substring(option.indexOf("=") + 1));
            }
        }

    }

    public JCheckBox getIsEnabled() {
        return isEnabled;
    }

    private boolean contains(String option) {
        if (option.contains("hubport")) {
            return true;
        }
        return false;
    }

    public JTextField getId() {
        return id;
    }

    public JTextField getHubid() {
        return hubid;
    }
}
