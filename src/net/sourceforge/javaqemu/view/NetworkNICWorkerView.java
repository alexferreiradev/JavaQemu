package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sourceforge.javaqemu.control.FileControl;

public class NetworkNICWorkerView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridLayout gridLayout;

    private JCheckBox isEnabled;

    private JLabel temp[];

    private JLabel vlanDescription;

    private JComboBox<String> vlan;

    private JLabel macaddrDescription;

    private JTextField macaddr;

    private JLabel modelDescription;

    private JComboBox<String> model;

    private JLabel nameDescription;

    private JTextField name;

    private JLabel addrDescription;

    private JTextField addr;

    private JLabel vectorsNumberDescription;

    private JComboBox<String> vectorsNumber;

    private JButton eraseButton;

    private JButton okButton;

    public NetworkNICWorkerView(FileControl myfile, int position) {
        super();

        windowContent = new JPanel();

        gridLayout = new GridLayout(8, 2);

        windowContent.setLayout(gridLayout);

        isEnabled = new JCheckBox("Enable this option!");

        windowContent.add(this.isEnabled);

        temp = new JLabel[1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new JLabel();
        }

        windowContent.add(temp[0]);

        vlanDescription = new JLabel("Choose the VLAN:");

        windowContent.add(vlanDescription);

        String[] numberOptions = {"", "0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
            "27", "28", "29", "30", "31", "32", "33", "34", "35", "36",
            "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
            "47", "48", "49", "50", "51", "52", "53", "54", "55", "56",
            "57", "58", "59", "60", "61", "62", "63", "64", "65", "66",
            "67", "68", "69", "70", "71", "72", "73", "74", "75", "76",
            "77", "78", "79", "80", "81", "82", "83", "84", "85", "86",
            "87", "88", "89", "90", "91", "92", "93", "94", "95", "96",
            "97", "98", "99", "100"};

        this.vlan = new JComboBox<String>(numberOptions);

        windowContent.add(vlan);

        this.macaddrDescription = new JLabel("Choose the MAC address:");

        windowContent.add(this.macaddrDescription);

        this.macaddr = new JTextField();

        windowContent.add(this.macaddr);

        this.modelDescription = new JLabel("Choose the network card model:");

        windowContent.add(this.modelDescription);

        String[] modelOptions = {"", "virtio", "i82551", "i82557b",
            "i82559er", "ne2k_pci", "ne2k_isa", "pcnet", "rtl8139",
            "e1000", "smc91c111", "lance", "mcf_fec"};

        this.model = new JComboBox<String>(modelOptions);

        windowContent.add(this.model);

        this.nameDescription = new JLabel("Choose the name of the NIC:");

        windowContent.add(this.nameDescription);

        this.name = new JTextField();

        windowContent.add(this.name);

        this.addrDescription = new JLabel("Choose the device address:");

        windowContent.add(this.addrDescription);

        this.addr = new JTextField();

        windowContent.add(this.addr);

        vectorsNumberDescription = new JLabel("Choose the number of MSI-X vectors:");

        windowContent.add(this.vectorsNumberDescription);

        vectorsNumber = new JComboBox<String>(numberOptions);

        windowContent.add(this.vectorsNumber);

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        windowContent.add(okButton);

        windowContent.add(eraseButton);

        this.setContentPane(windowContent);

        this.setTitle("JavaQemu - Network NIC Choice");

        switch (position) {
            case 1:
                if (myfile.getMymodel().getFirstNetworkNICOption() != null) {
                    if (!myfile.getMymodel().getFirstNetworkNICOption().equals("none")) {
                        this.buildMe(myfile.getMymodel().getFirstNetworkNICOption());
                        this.isEnabled.setSelected(true);
                    }
                }
                break;
            case 2:
                if (myfile.getMymodel().getSecondNetworkNICOption() != null) {
                    this.buildMe(myfile.getMymodel().getSecondNetworkNICOption());
                    this.isEnabled.setSelected(true);
                }
                break;
            case 3:
                if (myfile.getMymodel().getThirdNetworkNICOption() != null) {
                    this.buildMe(myfile.getMymodel().getThirdNetworkNICOption());
                    this.isEnabled.setSelected(true);
                }
                break;
            case 4:
                if (myfile.getMymodel().getFourthNetworkNICOption() != null) {
                    this.buildMe(myfile.getMymodel().getFourthNetworkNICOption());
                    this.isEnabled.setSelected(true);
                }
                break;
            case 5:
                if (myfile.getMymodel().getFifthNetworkNICOption() != null) {
                    this.buildMe(myfile.getMymodel().getFifthNetworkNICOption());
                    this.isEnabled.setSelected(true);
                }
                break;
            case 6:
                if (myfile.getMymodel().getSixthNetworkNICOption() != null) {
                    this.buildMe(myfile.getMymodel().getSixthNetworkNICOption());
                    this.isEnabled.setSelected(true);
                }
                break;
            case 7:
                if (myfile.getMymodel().getSeventhNetworkNICOption() != null) {
                    this.buildMe(myfile.getMymodel().getSeventhNetworkNICOption());
                    this.isEnabled.setSelected(true);
                }
                break;
            case 8:
                if (myfile.getMymodel().getEighthNetworkNICOption() != null) {
                    this.buildMe(myfile.getMymodel().getEighthNetworkNICOption());
                    this.isEnabled.setSelected(true);
                }
                break;
            case 9:
                if (myfile.getMymodel().getNinthNetworkNICOption() != null) {
                    this.buildMe(myfile.getMymodel().getNinthNetworkNICOption());
                    this.isEnabled.setSelected(true);
                }
                break;
            case 10:
                if (myfile.getMymodel().getTenthNetworkNICOption() != null) {
                    this.buildMe(myfile.getMymodel().getTenthNetworkNICOption());
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
            if (option.startsWith("vlan=")) {
                this.vlan.setSelectedItem(option.substring(option.indexOf("=") + 1));
            } else if (option.startsWith("macaddr=")) {
                this.macaddr.setText(option.substring(option.indexOf("=") + 1));
            } else if (option.startsWith("model=")) {
                this.model.setSelectedItem(option.substring(option.indexOf("=") + 1));
            } else if (option.startsWith("name=")) {
                this.name.setText(option.substring(option.indexOf("=") + 1));
            } else if (option.startsWith("addr=")) {
                this.addr.setText(option.substring(option.indexOf("=") + 1));
            } else if (option.startsWith("vectors=")) {
                this.vectorsNumber.setSelectedItem(option.substring(option.indexOf("=") + 1));
            }
        }
    }

    public JCheckBox getIsEnabled() {
        return isEnabled;
    }

    public JComboBox<String> getVlan() {
        return vlan;
    }

    public JTextField getMacaddr() {
        return macaddr;
    }

    public JComboBox<String> getModel() {
        return model;
    }

    public JTextField getAddr() {
        return addr;
    }

    public JComboBox<String> getVectorsNumber() {
        return vectorsNumber;
    }

    public JTextField getNameContents() {
        return name;
    }
}
