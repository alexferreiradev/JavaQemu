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

public class NetworkDnssearchUserWorkerView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridLayout gridLayout;

    private JLabel dnssearchDescription;

    private JTextArea dnssearch;

    private JButton add;

    private JTextField text;

    private JTextField option;

    private JButton remove;

    private JButton eraseButton;

    private JButton okButton;

    public NetworkDnssearchUserWorkerView(FileControl myfile, int position) {
        super();

        windowContent = new JPanel();

        gridLayout = new GridLayout(4, 2);

        windowContent.setLayout(gridLayout);

        dnssearchDescription = new JLabel("'dnssearch' Option(s):");

        windowContent.add(dnssearchDescription);

        dnssearch = new JTextArea("", 3, 30);
        dnssearch.setLineWrap(true);
        dnssearch.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(this.dnssearch);

        windowContent.add(scrollPane);

        this.option = new JTextField();

        this.add = new JButton("Add the option:");

        windowContent.add(this.add);

        this.text = new JTextField();

        windowContent.add(this.text);

        this.remove = new JButton("Remove the option:");

        windowContent.add(this.remove);

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
        this.dnssearch.append(option + "\n");
    }

    public void buildTextArea(String optionString) {
        String[] options = optionString.split(",");
        for (String option : options) {
            if (option.startsWith("dnssearch=")) {
                this.dnssearch.append(option.substring(option.indexOf("=") + 1) + "\n");
            }
        }
    }

    public void removeMe(String option) {
        String options[] = dnssearch.getText().split("\n");
        dnssearch.setText("");
        for (String anOption : options) {
            if (!anOption.equals(option)) {
                dnssearch.append(anOption + "\n");
            }
        }
    }

    private boolean contains(String option) {
        if (option.contains("user")) {
            return true;
        }
        return false;
    }

    public JTextArea getDnssearch() {
        return dnssearch;
    }

    public JTextField getOption() {
        return option;
    }

    public JTextField getText() {
        return text;
    }
}
