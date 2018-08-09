package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.sourceforge.javaqemu.control.FileControl;

public class NetworkGuestfwdUserWorkerView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridLayout gridLayout;

    private JLabel guestfwdDescription;

    private JTextArea guestfwd;

    private JButton add;

    private JLabel ipAddrServerDescription;

    private JTextField ipAddrServer;

    private JLabel portDescription;

    private JTextField port;

    private JLabel secondOptionDescription;

    private JTextField secondOption;

    private JLabel temp;

    private JTextField option;

    private JButton remove;

    private JButton eraseButton;

    private JButton okButton;

    public NetworkGuestfwdUserWorkerView(FileControl myfile, int position) {
        super();

        windowContent = new JPanel();

        gridLayout = new GridLayout(7, 2);

        windowContent.setLayout(gridLayout);

        guestfwdDescription = new JLabel("'guestfwd' Option(s):");

        windowContent.add(guestfwdDescription);

        guestfwd = new JTextArea("", 3, 30);
        guestfwd.setLineWrap(true);
        guestfwd.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(guestfwd);

        windowContent.add(scrollPane);

        this.add = new JButton("Add the following option:");

        windowContent.add(this.add);

        temp = new JLabel();

        windowContent.add(this.temp);

        ipAddrServerDescription = new JLabel("Choose the IP address server:");

        windowContent.add(this.ipAddrServerDescription);

        ipAddrServer = new JTextField();

        windowContent.add(this.ipAddrServer);

        portDescription = new JLabel("Choose the port:");

        windowContent.add(this.portDescription);

        port = new JTextField();

        windowContent.add(port);

        secondOptionDescription = new JLabel("Set the character device 'dev' or the command 'command' to be executed by 'cmd:command':");

        windowContent.add(secondOptionDescription);

        secondOption = new JTextField();

        windowContent.add(this.secondOption);

        this.remove = new JButton("Remove a option:");

        windowContent.add(this.remove);

        this.option = new JTextField();

        windowContent.add(this.option);

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        windowContent.add(okButton);

        windowContent.add(eraseButton);

        this.setContentPane(windowContent);

        this.setTitle("JavaQemu - Network User Choice");

        switch (position) {
            case 1:
                if (myfile.getMymodel().getFirstNetworkExtraOption() != null) {
                    if (this.contains(myfile.getMymodel()
                            .getFirstNetworkExtraOption())) {
                        this.buildTextArea(myfile.getMymodel()
                                .getFirstNetworkExtraOption());
                    }
                }
                break;
            case 2:
                if (myfile.getMymodel().getSecondNetworkExtraOption() != null) {
                    if (this.contains(myfile.getMymodel()
                            .getSecondNetworkExtraOption())) {
                        this.buildTextArea(myfile.getMymodel()
                                .getSecondNetworkExtraOption());
                    }
                }
                break;
            case 3:
                if (myfile.getMymodel().getThirdNetworkExtraOption() != null) {
                    if (this.contains(myfile.getMymodel().getThirdNetworkExtraOption())) {
                        this.buildTextArea(myfile.getMymodel().getThirdNetworkExtraOption());
                    }
                }
                break;
            case 4:
                if (myfile.getMymodel().getFourthNetworkExtraOption() != null) {
                    if (this.contains(myfile.getMymodel().getFourthNetworkExtraOption())) {
                        this.buildTextArea(myfile.getMymodel().getFourthNetworkExtraOption());
                    }
                }
                break;
            case 5:
                if (myfile.getMymodel().getFifthNetworkExtraOption() != null) {
                    if (this.contains(myfile.getMymodel().getFifthNetworkExtraOption())) {
                        this.buildTextArea(myfile.getMymodel().getFifthNetworkExtraOption());
                    }
                }
                break;
            case 6:
                if (myfile.getMymodel().getSixthNetworkExtraOption() != null) {
                    if (this.contains(myfile.getMymodel().getSixthNetworkExtraOption())) {
                        this.buildTextArea(myfile.getMymodel().getSixthNetworkExtraOption());
                    }
                }
                break;
            case 7:
                if (myfile.getMymodel().getSeventhNetworkExtraOption() != null) {
                    if (this.contains(myfile.getMymodel().getSeventhNetworkExtraOption())) {
                        this.buildTextArea(myfile.getMymodel().getSeventhNetworkExtraOption());
                    }
                }
                break;
            case 8:
                if (myfile.getMymodel().getEighthNetworkExtraOption() != null) {
                    if (this.contains(myfile.getMymodel().getEighthNetworkExtraOption())) {
                        this.buildTextArea(myfile.getMymodel().getEighthNetworkExtraOption());
                    }
                }
                break;
            case 9:
                if (myfile.getMymodel().getNinthNetworkExtraOption() != null) {
                    if (this.contains(myfile.getMymodel().getNinthNetworkExtraOption())) {
                        this.buildTextArea(myfile.getMymodel().getNinthNetworkExtraOption());
                    }
                }
                break;
            case 10:
                if (myfile.getMymodel().getTenthNetworkExtraOption() != null) {
                    if (this.contains(myfile.getMymodel().getTenthNetworkExtraOption())) {
                        this.buildTextArea(myfile.getMymodel().getTenthNetworkExtraOption());
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
        add.addActionListener(listener);
        remove.addActionListener(listener);
    }

    public void configureStandardMode() {
        eraseButton.setActionCommand("eraseButton");
        okButton.setActionCommand("okButton");
        add.setActionCommand("add");
        remove.setActionCommand("remove");
    }

    public void buildMe(String option) {
        this.guestfwd.append(option + "\n");
    }

    public void buildTextArea(String optionString) {
        String[] options = optionString.split(",");
        for (String option : options) {
            if (option.startsWith("guestfwd=")) {
                this.guestfwd.append(option.substring(option.indexOf("=") + 1) + "\n");
            }
        }
    }

    public void removeMe(String option) {
        String options[] = guestfwd.getText().split("\n");
        guestfwd.setText("");
        for (String anOption : options) {
            if (!anOption.equals(option)) {
                guestfwd.append(anOption + "\n");
            }
        }
    }

    private boolean contains(String option) {
        if (option.contains("user")) {
            return true;
        }
        return false;
    }

    public JTextArea getGuestfwd() {
        return guestfwd;
    }

    public JTextField getIpAddrServer() {
        return ipAddrServer;
    }

    public JTextField getPort() {
        return port;
    }

    public JTextField getSecondOption() {
        return secondOption;
    }

    public JTextField getOption() {
        return option;
    }
}
