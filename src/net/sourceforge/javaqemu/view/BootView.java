package net.sourceforge.javaqemu.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import net.sourceforge.javaqemu.control.FileControl;

public class BootView extends JFileChooserView {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridBagLayout gridBagLayout;

    private GridBagConstraints gridBagConstraints;

    private JLabel orderLabel, onceLabel, firstOrderLabel, secondOrderLabel,
            thirdOrderLabel, firstOnceLabel, secondOnceLabel, thirdOnceLabel,
            menuLabel, splashLabel,
            strictLabel;

    private JCheckBox splashTime, rebootTimeout;

    private JComboBox<String> firstOrder, secondOrder, thirdOrder, firstOnce,
            secondOnce, thirdOnce, menu, strict;

    private JTextField splashName;

    private JButton splashButton;

    private JSpinner splashTimeSize, rebootTimeoutSize;

    private SpinnerModel spinnerModel1, spinnerModel2;

    private JSpinner.NumberEditor editor1, editor2;

    private DecimalFormat format1, format2;

    private JButton okButton, eraseButton;

    public BootView(FileControl myfile) {
        super(null);

        windowContent = new JPanel();

        this.setJpanel(windowContent);

        gridBagLayout = new GridBagLayout();
        this.gridBagConstraints = new GridBagConstraints();

        windowContent.setLayout(gridBagLayout);

        orderLabel = new JLabel("Select the boot order device:");

        onceLabel = new JLabel(
                "Select the boot order device only on the first startup:");

        firstOrderLabel = new JLabel("First Boot Order Device:");

        secondOrderLabel = new JLabel("Second Boot Order Device:");

        thirdOrderLabel = new JLabel("Third Boot Order Device:");

        firstOnceLabel = new JLabel("First Boot Order Device:");

        secondOnceLabel = new JLabel("Second Boot Order Device:");

        thirdOnceLabel = new JLabel("Third Boot Order Device:");

        menuLabel = new JLabel("Menu:");

        splashLabel = new JLabel("Splash picture:");

        splashTime = new JCheckBox("Set the splash picture show time (ms):");

        rebootTimeout = new JCheckBox(
                "Set the reboot timeout (ms) (-1, for not reboot!):");

        strictLabel = new JLabel("Strict:");

        String[] bootDevices = {"", "a - Floppy 1", "b - Floppy 2",
            "c - First Hard Disk", "d - First CDROM", "n - Network"};

        firstOrder = new JComboBox<String>(bootDevices);
        firstOrder.setSelectedIndex(0);

        secondOrder = new JComboBox<String>(bootDevices);
        secondOrder.setSelectedIndex(0);

        thirdOrder = new JComboBox<String>(bootDevices);
        thirdOrder.setSelectedIndex(0);

        firstOnce = new JComboBox<String>(bootDevices);
        firstOnce.setSelectedIndex(0);

        secondOnce = new JComboBox<String>(bootDevices);
        secondOnce.setSelectedIndex(0);

        thirdOnce = new JComboBox<String>(bootDevices);
        thirdOnce.setSelectedIndex(0);

        String[] states = {"", "on", "off"};

        menu = new JComboBox<String>(states);

        strict = new JComboBox<String>(states);

        eraseButton = new JButton("Erase");

        okButton = new JButton("OK");

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;

        windowContent.add(orderLabel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.gridwidth = 1;

        windowContent.add(firstOrderLabel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;

        windowContent.add(firstOrder, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.gridwidth = 1;

        windowContent.add(secondOrderLabel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.5;

        windowContent.add(secondOrder, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.gridwidth = 1;

        windowContent.add(thirdOrderLabel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.5;

        windowContent.add(thirdOrder, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;

        windowContent.add(onceLabel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.gridwidth = 1;

        windowContent.add(firstOnceLabel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.weightx = 0.5;

        windowContent.add(firstOnce, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.gridwidth = 1;

        windowContent.add(secondOnceLabel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.weightx = 0.5;

        windowContent.add(secondOnce, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.gridwidth = 1;

        windowContent.add(thirdOnceLabel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.weightx = 0.5;

        windowContent.add(thirdOnce, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;

        windowContent.add(menuLabel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;

        windowContent.add(menu, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;

        windowContent.add(splashLabel, gridBagConstraints);

        splashName = new JTextField();

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;

        windowContent.add(splashName, gridBagConstraints);

        splashButton = new JButton("Set the splash picture!");

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;

        windowContent.add(splashButton, gridBagConstraints);

        this.spinnerModel1 = new SpinnerNumberModel(0.0, // initial value
                0.0, // min
                86400000.0, // max				
                1); // step

        this.splashTimeSize = new JSpinner(spinnerModel1);

        editor1 = (JSpinner.NumberEditor) this.splashTimeSize.getEditor();
        format1 = editor1.getFormat();
        format1.setMinimumFractionDigits(3);
        editor1.getTextField().setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;

        windowContent.add(splashTime, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;

        windowContent.add(splashTimeSize, gridBagConstraints);

        this.spinnerModel2 = new SpinnerNumberModel(-1.0, // initial value
                -1.0, // min
                86400000.0, // max				
                1); // step

        this.rebootTimeoutSize = new JSpinner(spinnerModel2);

        editor2 = (JSpinner.NumberEditor) this.rebootTimeoutSize.getEditor();
        format2 = editor2.getFormat();
        format2.setMinimumFractionDigits(3);
        editor2.getTextField().setHorizontalAlignment(SwingConstants.CENTER);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;

        windowContent.add(rebootTimeout, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;

        windowContent.add(rebootTimeoutSize, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;

        windowContent.add(strictLabel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;

        windowContent.add(strict, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;

        windowContent.add(new JLabel(), gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;

        windowContent.add(okButton, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;

        windowContent.add(eraseButton, gridBagConstraints);

        if (myfile.getMymodel().getBootOrder1() != null) {
            for (int i = 0; i < bootDevices.length; i++) {
                if (!bootDevices[i].isEmpty()) {
                    if (myfile.getMymodel().getBootOrder1()
                            .equals(bootDevices[i].substring(0, 1))) {
                        this.firstOrder.setSelectedIndex(i);
                    }
                }
            }
        }

        if (myfile.getMymodel().getBootOrder2() != null) {
            for (int i = 0; i < bootDevices.length; i++) {
                if (!bootDevices[i].isEmpty()) {
                    if (myfile.getMymodel().getBootOrder2()
                            .equals(bootDevices[i].substring(0, 1))) {
                        this.secondOrder.setSelectedIndex(i);
                    }
                }
            }
        }

        if (myfile.getMymodel().getBootOrder3() != null) {
            for (int i = 0; i < bootDevices.length; i++) {
                if (!bootDevices[i].isEmpty()) {
                    if (myfile.getMymodel().getBootOrder3()
                            .equals(bootDevices[i].substring(0, 1))) {
                        this.thirdOrder.setSelectedIndex(i);
                    }
                }
            }
        }

        if (myfile.getMymodel().getBootOnce1() != null) {
            for (int i = 0; i < bootDevices.length; i++) {
                if (!bootDevices[i].isEmpty()) {
                    if (myfile.getMymodel().getBootOnce1()
                            .equals(bootDevices[i].substring(0, 1))) {
                        this.firstOnce.setSelectedIndex(i);
                    }
                }
            }
        }

        if (myfile.getMymodel().getBootOnce2() != null) {
            for (int i = 0; i < bootDevices.length; i++) {
                if (!bootDevices[i].isEmpty()) {
                    if (myfile.getMymodel().getBootOnce2()
                            .equals(bootDevices[i].substring(0, 1))) {
                        this.secondOnce.setSelectedIndex(i);
                    }
                }
            }
        }

        if (myfile.getMymodel().getBootOnce3() != null) {
            for (int i = 0; i < bootDevices.length; i++) {
                if (!bootDevices[i].isEmpty()) {
                    if (myfile.getMymodel().getBootOnce3()
                            .equals(bootDevices[i].substring(0, 1))) {
                        this.thirdOnce.setSelectedIndex(i);
                    }
                }
            }
        }

        if (myfile.getMymodel().getBootMenu() != null) {
            this.menu.setSelectedItem(myfile.getMymodel().getBootMenu());
        }

        if (myfile.getMymodel().getBootSplash() != null) {
            this.splashName.setText(myfile.getMymodel().getBootSplash());
        }

        if (myfile.getMymodel().getBootSplashTime() != null) {
            this.splashTime.setSelected(true);
            this.editor1.getTextField().setText(myfile.getMymodel().getBootSplashTime());
        }

        if (myfile.getMymodel().getBootRebootTimeout() != null) {
            this.rebootTimeout.setSelected(true);
            this.editor2.getTextField().setText(myfile.getMymodel().getBootRebootTimeout());
        }

        if (myfile.getMymodel().getBootStrict() != null) {
            this.strict.setSelectedItem(myfile.getMymodel().getBootStrict());
        }

        this.initialize();
        this.rechecks();
    }

    public void initialize() {
        this.setContentPane(windowContent);
        this.setTitle("Create a new Disk Image File!");
        this.pack();
    }

    private void rechecks() {
        this.pack();
        this.repaint();
    }

    public void configureListener(ActionListener listener) {
        eraseButton.addActionListener(listener);
        okButton.addActionListener(listener);
        splashButton.addActionListener(listener);
        firstOrder.addActionListener(listener);
        secondOrder.addActionListener(listener);
        thirdOrder.addActionListener(listener);
        firstOnce.addActionListener(listener);
        secondOnce.addActionListener(listener);
        thirdOnce.addActionListener(listener);
    }

    public void configureStandardMode() {
        eraseButton.setActionCommand("eraseButton");
        okButton.setActionCommand("okButton");
        splashButton.setActionCommand("splashButton");
        firstOrder.setActionCommand("firstOrder");
        secondOrder.setActionCommand("secondOrder");
        thirdOrder.setActionCommand("thirdOrder");
        firstOnce.setActionCommand("firstOnce");
        secondOnce.setActionCommand("secondOnce");
        thirdOnce.setActionCommand("thirdOnce");
    }

    public void resolveOrderOptions() {
        List<String> selectedobjects = new ArrayList<String>();
        String[] bootDevices = {"", "a - Floppy 1", "b - Floppy 2",
            "c - First Hard Disk", "d - First CDROM", "n - Network"};
        if (firstOrder.getSelectedIndex() != 0) {
            selectedobjects.add((String) firstOrder.getSelectedItem());
        }
        if (secondOrder.getSelectedIndex() != 0) {
            selectedobjects.add((String) secondOrder.getSelectedItem());
        }
        if (thirdOrder.getSelectedIndex() != 0) {
            selectedobjects.add((String) thirdOrder.getSelectedItem());
        }
        if (firstOrder.getSelectedIndex() == 0) {
            firstOrder.removeAllItems();
            for (int i = 0; i < bootDevices.length; i++) {
                if (!selectedobjects.contains(bootDevices[i])) {
                    firstOrder.addItem(bootDevices[i]);
                }
            }
            firstOrder.setSelectedIndex(0);
        }
        if (secondOrder.getSelectedIndex() == 0) {
            secondOrder.removeAllItems();
            for (int i = 0; i < bootDevices.length; i++) {
                if (!selectedobjects.contains(bootDevices[i])) {
                    secondOrder.addItem(bootDevices[i]);
                }
            }
            secondOrder.setSelectedIndex(0);
        }
        if (thirdOrder.getSelectedIndex() == 0) {
            thirdOrder.removeAllItems();
            for (int i = 0; i < bootDevices.length; i++) {
                if (!selectedobjects.contains(bootDevices[i])) {
                    thirdOrder.addItem(bootDevices[i]);
                }
            }
            thirdOrder.setSelectedIndex(0);
        }
    }

    public void resolveOnceOptions() {
        List<String> selectedobjects = new ArrayList<String>();
        String[] bootDevices = {"", "a - Floppy 1", "b - Floppy 2",
            "c - First Hard Disk", "d - First CDROM", "n - Network"};
        if (firstOnce.getSelectedIndex() != 0) {
            selectedobjects.add((String) firstOnce.getSelectedItem());
        }
        if (secondOnce.getSelectedIndex() != 0) {
            selectedobjects.add((String) secondOnce.getSelectedItem());
        }
        if (thirdOnce.getSelectedIndex() != 0) {
            selectedobjects.add((String) thirdOnce.getSelectedItem());
        }
        if (firstOnce.getSelectedIndex() == 0) {
            firstOnce.removeAllItems();
            for (int i = 0; i < bootDevices.length; i++) {
                if (!selectedobjects.contains(bootDevices[i])) {
                    firstOnce.addItem(bootDevices[i]);
                }
            }
            firstOnce.setSelectedIndex(0);
        }
        if (secondOnce.getSelectedIndex() == 0) {
            secondOnce.removeAllItems();
            for (int i = 0; i < bootDevices.length; i++) {
                if (!selectedobjects.contains(bootDevices[i])) {
                    secondOnce.addItem(bootDevices[i]);
                }
            }
            secondOnce.setSelectedIndex(0);
        }
        if (thirdOnce.getSelectedIndex() == 0) {
            thirdOnce.removeAllItems();
            for (int i = 0; i < bootDevices.length; i++) {
                if (!selectedobjects.contains(bootDevices[i])) {
                    thirdOnce.addItem(bootDevices[i]);
                }
            }
            thirdOnce.setSelectedIndex(0);
        }
    }

    public JComboBox<String> getFirstOrder() {
        return firstOrder;
    }

    public JComboBox<String> getSecondOrder() {
        return secondOrder;
    }

    public JComboBox<String> getThirdOrder() {
        return thirdOrder;
    }

    public JComboBox<String> getFirstOnce() {
        return firstOnce;
    }

    public JComboBox<String> getSecondOnce() {
        return secondOnce;
    }

    public JComboBox<String> getThirdOnce() {
        return thirdOnce;
    }

    public JComboBox<String> getMenu() {
        return menu;
    }

    public JTextField getSplashName() {
        return splashName;
    }

    public JSpinner.NumberEditor getEditor1() {
        return editor1;
    }

    public JCheckBox getSplashTime() {
        return splashTime;
    }

    public JCheckBox getRebootTimeout() {
        return rebootTimeout;
    }

    public JSpinner.NumberEditor getEditor2() {
        return editor2;
    }

    public JComboBox<String> getStrict() {
        return strict;
    }
}
