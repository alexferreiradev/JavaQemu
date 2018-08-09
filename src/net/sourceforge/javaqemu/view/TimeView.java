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

public class TimeView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridLayout gridLayout;

    private JLabel rtcDescription;

    private JCheckBox isRTCEnabled;

    private JLabel temp[];

    private JLabel baseDescription;

    private JComboBox<String> base;

    private JLabel dateDescription;

    private JTextField date;

    private JLabel clockDescription;

    private JComboBox<String> clock;

    private JLabel driftfixDescription;

    private JComboBox<String> driftfix;

    private JButton eraseButton;

    private JButton okButton;

    public TimeView(FileControl myfile) {
        super();

        windowContent = new JPanel();

        gridLayout = new GridLayout(7, 2);

        windowContent.setLayout(gridLayout);

        rtcDescription = new JLabel("Choose the rtc option:");

        windowContent.add(rtcDescription);

        temp = new JLabel[2];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new JLabel();
        }

        windowContent.add(temp[0]);

        isRTCEnabled = new JCheckBox("Enable the rtc option!");

        windowContent.add(this.isRTCEnabled);

        windowContent.add(this.temp[1]);

        baseDescription = new JLabel("Choose the base option:");

        windowContent.add(this.baseDescription);

        String[] baseOptions = {"", "UTC - Universal Time Coordinated",
            "Local Time", "Specific Date"};

        this.base = new JComboBox<String>(baseOptions);

        windowContent.add(this.base);

        this.dateDescription = new JLabel("If you choose 'Specific Date' as base option, then specify it: ");

        windowContent.add(this.dateDescription);

        this.date = new JTextField();

        windowContent.add(this.date);

        this.clockDescription = new JLabel("Choose the clock option:");

        windowContent.add(this.clockDescription);

        String[] clockOptions = {"", "Host", "Virtual Machine"};

        this.clock = new JComboBox<String>(clockOptions);

        windowContent.add(this.clock);

        this.driftfixDescription = new JLabel("Choose the driftfix option:");

        windowContent.add(this.driftfixDescription);

        String[] driftfixOptions = {"", "None", "Slew"};

        this.driftfix = new JComboBox<String>(driftfixOptions);

        windowContent.add(this.driftfix);

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        windowContent.add(okButton);

        windowContent.add(eraseButton);

        this.setContentPane(windowContent);

        this.setTitle("JavaQemu - Time Choice");

        if (myfile.getMymodel().getRtcOption() != null) {
            this.isRTCEnabled.setSelected(true);
            String options[] = myfile.getMymodel().getRtcOption().split(",");
            for (String option : options) {
                if (option.startsWith("base=")) {
                    if (option.endsWith("utc")) {
                        this.base.setSelectedItem("UTC - Universal Time Coordinated");
                    } else if (option.endsWith("localtime")) {
                        this.base.setSelectedItem("Local Time");
                    } else {
                        this.base.setSelectedItem("Specific Date");
                        this.date.setText(option.substring(option.indexOf("=") + 1));
                    }
                } else if (option.startsWith("clock=")) {
                    if (option.endsWith("host")) {
                        this.clock.setSelectedItem("Host");
                    } else if (option.endsWith("vm")) {
                        this.clock.setSelectedItem("Virtual Machine");
                    }
                } else if (option.startsWith("driftfix=")) {
                    if (option.endsWith("none")) {
                        this.driftfix.setSelectedItem("None");
                    } else if (option.endsWith("slew")) {
                        this.driftfix.setSelectedItem("Slew");
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
        eraseButton.setActionCommand("eraseButton");
        okButton.setActionCommand("okButton");
    }

    public JCheckBox getIsEnabled() {
        return isRTCEnabled;
    }

    public JComboBox<String> getBase() {
        return base;
    }

    public JTextField getDate() {
        return date;
    }

    public JComboBox<String> getClock() {
        return clock;
    }

    public JComboBox<String> getDriftfix() {
        return driftfix;
    }
}
