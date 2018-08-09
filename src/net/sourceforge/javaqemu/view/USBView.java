package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.sourceforge.javaqemu.control.FileControl;

public class USBView extends JFileChooserView {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridLayout gridLayout;

    private JCheckBox usb;

    private JCheckBox mouse;

    private JCheckBox tablet;

    private JCheckBox wacomTablet;

    private JCheckBox keyboard;

    private JCheckBox braille;

    private JCheckBox disk;

    private JButton fileChooser;

    private JTextField file;

    private JCheckBox serial;

    private JLabel vendoridText;

    private JTextField vendorid;

    private JLabel productidText;

    private JTextField productid;

    private JLabel devText;

    private JTextField dev;

    private JLabel temp[];

    private JButton eraseButton;

    private JButton okButton;

    private JSeparator[] separators;

    private int separatorArrayPosition;

    private JCheckBox net;

    private JLabel vlanDescription;

    private JComboBox<String> vlan;

    private JLabel macaddrDescription;

    private JTextField macaddr;

    private JLabel nameDescription;

    private JTextField name;

    private JLabel addrDescription;

    private JTextField addr;

    private JLabel vectorsNumberDescription;

    private JComboBox<String> vectorsNumber;

    public USBView(FileControl myfile) {
        super(null);

        windowContent = new JPanel();

        gridLayout = new GridLayout(24, 2);

        windowContent.setLayout(gridLayout);

        usb = new JCheckBox("Enable the USB driver");

        windowContent.add(this.usb);

        this.temp = new JLabel[9];

        for (int i = 0; i < this.temp.length; i++) {
            this.temp[i] = new JLabel();
        }

        windowContent.add(this.temp[0]);

        separators = new JSeparator[14];
        for (int i = 0; i < separators.length; i++) {
            separators[i] = new JSeparator(SwingConstants.HORIZONTAL);
        }
        separatorArrayPosition = 0;

        windowContent.add(this.separators[separatorArrayPosition++]);
        windowContent.add(this.separators[separatorArrayPosition++]);

        mouse = new JCheckBox("Add the USB Virtual Mouse device");

        windowContent.add(this.mouse);

        windowContent.add(this.temp[1]);

        tablet = new JCheckBox("Add the USB (touchscreen) Pointer device");

        windowContent.add(this.tablet);

        windowContent.add(this.temp[2]);

        wacomTablet = new JCheckBox(
                "Add the USB Virtual Wacom PenPartner tablet device");

        windowContent.add(wacomTablet);

        windowContent.add(this.temp[3]);

        keyboard = new JCheckBox("Add the Standard USB keyboard device");

        windowContent.add(this.keyboard);

        windowContent.add(this.temp[4]);

        braille = new JCheckBox("Add the USB Braille device");

        windowContent.add(this.braille);

        windowContent.add(this.temp[5]);

        windowContent.add(this.separators[separatorArrayPosition++]);
        windowContent.add(this.separators[separatorArrayPosition++]);

        disk = new JCheckBox("Add the USB Mass storage device");

        windowContent.add(this.disk);

        windowContent.add(this.temp[6]);

        fileChooser = new JButton(
                "Choose the file that is the basis for the USB Mass storage device:");

        windowContent.add(this.fileChooser);

        file = new JTextField();

        windowContent.add(this.file);

        windowContent.add(this.separators[separatorArrayPosition++]);
        windowContent.add(this.separators[separatorArrayPosition++]);

        serial = new JCheckBox(
                "Add the USB Serial converter to host character device");

        windowContent.add(this.serial);

        windowContent.add(this.temp[7]);

        vendoridText = new JLabel(
                "Choose the (USB Serial device) vendorid option:");

        windowContent.add(this.vendoridText);

        vendorid = new JTextField();

        windowContent.add(this.vendorid);

        productidText = new JLabel(
                "Choose the (USB Serial device) productid option:");

        windowContent.add(this.productidText);

        productid = new JTextField();

        windowContent.add(this.productid);

        devText = new JLabel("Choose the USB Serial device:");

        windowContent.add(this.devText);

        dev = new JTextField();

        windowContent.add(this.dev);

        windowContent.add(this.separators[separatorArrayPosition++]);
        windowContent.add(this.separators[separatorArrayPosition++]);

        net = new JCheckBox("Add the USB Net device");

        windowContent.add(this.net);
        windowContent.add(this.temp[8]);

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

        this.nameDescription = new JLabel("Choose the name of the usb net device:");

        windowContent.add(this.nameDescription);

        this.name = new JTextField();

        windowContent.add(this.name);

        this.addrDescription = new JLabel("Choose the usb device address:");

        windowContent.add(this.addrDescription);

        this.addr = new JTextField();

        windowContent.add(this.addr);

        vectorsNumberDescription = new JLabel("Choose the number of MSI-X vectors:");

        windowContent.add(this.vectorsNumberDescription);

        vectorsNumber = new JComboBox<String>(numberOptions);

        windowContent.add(this.vectorsNumber);

        windowContent.add(this.separators[separatorArrayPosition++]);
        windowContent.add(this.separators[separatorArrayPosition++]);

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        windowContent.add(okButton);

        windowContent.add(eraseButton);

        this.setContentPane(windowContent);

        this.setTitle("JavaQemu - USB Choice");

        if (myfile.getMymodel().getUsbDriverOption() != null) {
            if (myfile.getMymodel().getUsbDriverOption().equals("true")) {
                this.usb.setSelected(true);
            }
        }

        if (myfile.getMymodel().getUsbMouseOption() != null) {
            if (myfile.getMymodel().getUsbMouseOption().equals("true")) {
                this.mouse.setSelected(true);
            }
        }

        if (myfile.getMymodel().getUsbTabletOption() != null) {
            if (myfile.getMymodel().getUsbTabletOption().equals("true")) {
                this.tablet.setSelected(true);
            }
        }

        if (myfile.getMymodel().getUsbWacomTabletOption() != null) {
            if (myfile.getMymodel().getUsbWacomTabletOption().equals("true")) {
                this.wacomTablet.setSelected(true);
            }
        }

        if (myfile.getMymodel().getUsbKeyboardOption() != null) {
            if (myfile.getMymodel().getUsbKeyboardOption().equals("true")) {
                this.keyboard.setSelected(true);
            }
        }

        if (myfile.getMymodel().getUsbBrailleOption() != null) {
            if (myfile.getMymodel().getUsbBrailleOption().equals("true")) {
                this.braille.setSelected(true);
            }
        }

        if (myfile.getMymodel().getUsbDiskOption() != null) {
            if (!myfile.getMymodel().getUsbDiskOption().isEmpty()) {
                this.disk.setSelected(true);
                this.file.setText(myfile.getMymodel().getUsbDiskOption());
            }
        }

        if (myfile.getMymodel().getUsbSerialOption() != null) {
            if (!myfile.getMymodel().getUsbSerialOption().isEmpty()) {
                this.serial.setSelected(true);
                if (myfile.getMymodel().getUsbSerialOption()
                        .contains("vendorid=")
                        || myfile.getMymodel().getUsbSerialOption()
                        .contains("productid=")) {
                    if (myfile.getMymodel().getUsbSerialOption()
                            .contains("vendorid=")
                            && !myfile.getMymodel().getUsbSerialOption()
                            .contains("productid=")) {
                        if (myfile.getMymodel().getUsbSerialOption().contains(":")) {
                            vendorid.setText(myfile.getMymodel().getUsbSerialOption().substring(myfile.getMymodel().getUsbSerialOption().indexOf("=") + 1,
                                    myfile.getMymodel().getUsbSerialOption().indexOf(":")));
                            dev.setText(myfile.getMymodel().getUsbSerialOption().substring(myfile.getMymodel().getUsbSerialOption().indexOf(":") + 1));
                        } else {
                            vendorid.setText(myfile.getMymodel().getUsbSerialOption().substring(myfile.getMymodel().getUsbSerialOption().indexOf("=") + 1));
                        }

                    } else if (!myfile.getMymodel().getUsbSerialOption()
                            .contains("vendorid=")
                            && myfile.getMymodel().getUsbSerialOption()
                            .contains("productid=")) {
                        if (myfile.getMymodel().getUsbSerialOption().contains(":")) {
                            productid.setText(myfile.getMymodel().getUsbSerialOption().substring(myfile.getMymodel().getUsbSerialOption().indexOf("=") + 1,
                                    myfile.getMymodel().getUsbSerialOption().indexOf(":")));
                            dev.setText(myfile.getMymodel().getUsbSerialOption().substring(myfile.getMymodel().getUsbSerialOption().indexOf(":") + 1));
                        } else {
                            productid.setText(myfile.getMymodel().getUsbSerialOption().substring(myfile.getMymodel().getUsbSerialOption().indexOf("=") + 1));
                        }
                    } else if (myfile.getMymodel().getUsbSerialOption()
                            .contains("vendorid=")
                            && myfile.getMymodel().getUsbSerialOption()
                            .contains("productid=")) {
                        if (myfile.getMymodel().getUsbSerialOption().contains(":")) {
                            String work = myfile.getMymodel().getUsbSerialOption().substring(0, myfile.getMymodel().getUsbSerialOption().indexOf(":"));
                            vendorid.setText(work.substring(work.indexOf("=") + 1,
                                    work.indexOf(",")));
                            productid.setText(work.substring(work.indexOf(",") + 11));
                            dev.setText(myfile.getMymodel().getUsbSerialOption().substring(myfile.getMymodel().getUsbSerialOption().indexOf(":") + 1));
                        } else {
                            vendorid.setText(myfile.getMymodel().getUsbSerialOption().substring(myfile.getMymodel().getUsbSerialOption().indexOf("=") + 1,
                                    myfile.getMymodel().getUsbSerialOption().indexOf(",")));
                            productid.setText(myfile.getMymodel().getUsbSerialOption().substring(myfile.getMymodel().getUsbSerialOption().indexOf(",") + 11));
                        }
                    }
                } else {
                    this.dev.setText(myfile.getMymodel().getUsbSerialOption());
                }
            }
        }

        if (myfile.getMymodel().getUsbNetOption() != null) {
            if (!myfile.getMymodel().getUsbNetOption().isEmpty()) {
                this.net.setSelected(true);
                String[] options = myfile.getMymodel().getUsbNetOption().split(",");
                for (String option : options) {
                    if (option.startsWith("vlan=")) {
                        vlan.setSelectedItem(option.substring(option.indexOf("=") + 1));
                    } else if (option.startsWith("macaddr=")) {
                        macaddr.setText(option.substring(option.indexOf("=") + 1));
                    } else if (option.startsWith("name=")) {
                        this.name.setText(option.substring(option.indexOf("=") + 1));
                    } else if (option.startsWith("addr=")) {
                        this.addr.setText(option.substring(option.indexOf("=") + 1));
                    } else if (option.startsWith("vectors=")) {
                        this.vectorsNumber.setSelectedItem(option.substring(option.indexOf("=") + 1));
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
        fileChooser.addActionListener(listener);
    }

    public void configureStandardMode() {
        eraseButton.setActionCommand("eraseButton");
        okButton.setActionCommand("okButton");
        fileChooser.setActionCommand("fileChooser");
    }

    public JCheckBox getUsb() {
        return usb;
    }

    public JCheckBox getMouse() {
        return mouse;
    }

    public JCheckBox getTablet() {
        return tablet;
    }

    public JCheckBox getWacomTablet() {
        return wacomTablet;
    }

    public JCheckBox getKeyboard() {
        return keyboard;
    }

    public JCheckBox getBraille() {
        return braille;
    }

    public JCheckBox getDisk() {
        return disk;
    }

    public JTextField getFile() {
        return file;
    }

    public JCheckBox getSerial() {
        return serial;
    }

    public JTextField getVendorid() {
        return vendorid;
    }

    public JTextField getProductid() {
        return productid;
    }

    public JTextField getDev() {
        return dev;
    }

    public JCheckBox getNet() {
        return net;
    }

    public JComboBox<String> getVlan() {
        return vlan;
    }

    public JTextField getMacaddr() {
        return macaddr;
    }

    public String getName() {
        return name.getText();
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public JTextField getAddr() {
        return addr;
    }

    public JComboBox<String> getVectorsNumber() {
        return vectorsNumber;
    }
}
