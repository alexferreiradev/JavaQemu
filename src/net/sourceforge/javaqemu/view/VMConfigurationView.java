package net.sourceforge.javaqemu.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class VMConfigurationView extends JFileChooserView {

    private static final long serialVersionUID = 1L;

    private JPanel jContentPane = null; // @jve:decl-index=0:visual-constraint="105,58"

    private GridLayout gridLayout;

    private JButton okButton;

    private JButton resetRamSizeButton;

    private View myview;

    private JLabel ramDescription;

    private JSpinner ramSize;

    private SpinnerModel spinnerModel;

    private JSpinner.NumberEditor editor;

    private DecimalFormat format;

    private JButton changeDiskImagePaths;

    private JButton showDisplayOptions;

    private JButton showAdvancedOptions;

    private JButton showMachineOptions;

    private JButton showCPUOptions;

    private JButton showCDROMOptions;

    private JButton showFloppyOptions;

    private JButton showBootOptions;

    private JButton showKeyboardOptions;

    private JButton showSoundHardwareOptions;

    private JButton showSMPOptions;

    private JButton showNUMAOptions;

    private JButton showOtherMemoryOptions;

    private JButton showNetworkOptions;

    private JButton showRtcOptions;

    private JButton showImageOptions;

    private JButton showMonitorOptions;

    private JButton showUSBOptions;

    private JButton showSpecificBootOptions;

    private JButton showCustomOptions;

    private JLabel temp[];

    public VMConfigurationView(View myview, String initialRamValue) {
        super(null);
        this.gridLayout = new GridLayout(9, 3);

        this.initialize();
        this.setJpanel(jContentPane);

        this.okButton = new JButton("OK");

        this.resetRamSizeButton = new JButton("Reset RAM Size & Hide");

        this.setChoosertitle("Please, choose a file!");

        this.setChoice("");

        this.myview = myview;

        this.spinnerModel = new SpinnerNumberModel(
                Double.parseDouble(initialRamValue), // initial value
                0.0, // min
                10240.0, // max
                1); // step

        this.ramSize = new JSpinner(spinnerModel);

        editor = (JSpinner.NumberEditor) this.ramSize.getEditor();
        format = editor.getFormat();
        format.setMinimumFractionDigits(3);
        editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);

        this.ramDescription = new JLabel("Set the size of the RAM (MB): ");

        this.jContentPane.add(this.ramDescription);

        this.jContentPane.add(this.ramSize);

        changeDiskImagePaths = new JButton("Change the Hard Disk Options.");

        showDisplayOptions = new JButton("Change Display Options!");
        showAdvancedOptions = new JButton("Change Advanced Options!");

        temp = new JLabel[3];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new JLabel("");
        }

        jContentPane.add(this.temp[0]);
        jContentPane.add(this.changeDiskImagePaths);
        jContentPane.add(this.showDisplayOptions);
        jContentPane.add(this.showAdvancedOptions);

        showMachineOptions = new JButton("Change Machine Options!");
        new JLabel("");

        jContentPane.add(this.showMachineOptions);

        showCPUOptions = new JButton("Change CPU Options!");
        jContentPane.add(this.showCPUOptions);

        this.showCDROMOptions = new JButton("Change CDROM Options!");

        jContentPane.add(this.showCDROMOptions);

        this.showFloppyOptions = new JButton("Change Floppy Options!");

        jContentPane.add(this.showFloppyOptions);

        this.showBootOptions = new JButton("Change Boot Options!");

        jContentPane.add(this.showBootOptions);

        this.showKeyboardOptions = new JButton("Change Keyboard Options!");

        jContentPane.add(this.showKeyboardOptions);

        this.showSoundHardwareOptions = new JButton("Change Sound Hardware Options!");

        jContentPane.add(this.showSoundHardwareOptions);

        this.showSMPOptions = new JButton("Change SMP System Options!");
        this.showNUMAOptions = new JButton("Change NUMA Options!");

        jContentPane.add(this.showSMPOptions);
        jContentPane.add(this.showNUMAOptions);

        this.showOtherMemoryOptions = new JButton("Change Other Memory Options!");
        jContentPane.add(this.showOtherMemoryOptions);

        this.showNetworkOptions = new JButton("Change Network Options!");
        jContentPane.add(this.showNetworkOptions);

        this.showRtcOptions = new JButton("Change RTC Options!");
        jContentPane.add(this.showRtcOptions);

        this.showImageOptions = new JButton("Change Image Options!");
        jContentPane.add(this.showImageOptions);

        this.showMonitorOptions = new JButton("Change Monitor Options!");
        jContentPane.add(this.showMonitorOptions);

        this.showUSBOptions = new JButton("Change USB Options!");
        jContentPane.add(this.showUSBOptions);

        this.showSpecificBootOptions = new JButton("Change Specific Boot Options!");
        jContentPane.add(this.showSpecificBootOptions);

        this.showCustomOptions = new JButton("Change Custom Options!");
        jContentPane.add(this.showCustomOptions);

        jContentPane.add(this.temp[1]);
        jContentPane.add(this.temp[2]);

        jContentPane.add(this.okButton);
        jContentPane.add(this.resetRamSizeButton);

        this.rechecks();
    }

    private void initialize() {
        this.setContentPane(getJContentPane());

        this.setTitle("JavaQemu - VM Configuration");

        this.jContentPane.setLayout(this.gridLayout);

        this.pack();
        this.repaint();
    }

    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            // jContentPane.add(getNum1Field(), null);
        }
        return jContentPane;
    }

    public void configureStandardMode() {
        okButton.setActionCommand("okButton");
        resetRamSizeButton.setActionCommand("resetRamSizeButton");
        changeDiskImagePaths.setActionCommand("changeDiskOptionsPaths");
        showDisplayOptions.setActionCommand("showDisplayOptions");
        showAdvancedOptions.setActionCommand("showAdvancedOptions");
        showMachineOptions.setActionCommand("showMachineOptions");
        showCPUOptions.setActionCommand("showCPUOptions");
        showCDROMOptions.setActionCommand("showCDROMOptions");
        showFloppyOptions.setActionCommand("showFloppyOptions");
        showBootOptions.setActionCommand("showBootOptions");
        showKeyboardOptions.setActionCommand("showKeyboardOptions");
        showSoundHardwareOptions.setActionCommand("showSoundHardwareOptions");
        showSMPOptions.setActionCommand("showSMPOptions");
        showNUMAOptions.setActionCommand("showNUMAOptions");
        showOtherMemoryOptions.setActionCommand("showOtherMemoryOptions");
        showNetworkOptions.setActionCommand("showNetworkOptions");
        showRtcOptions.setActionCommand("showRtcOptions");
        showImageOptions.setActionCommand("showImageOptions");
        showMonitorOptions.setActionCommand("showMonitorOptions");
        showUSBOptions.setActionCommand("showUSBOptions");
        showSpecificBootOptions.setActionCommand("showSpecificBootOptions");
        showCustomOptions.setActionCommand("showCustomOptions");
    }

    public void configureListener(ActionListener listener) {
        okButton.addActionListener(listener);
        resetRamSizeButton.addActionListener(listener);
        changeDiskImagePaths.addActionListener(listener);
        showDisplayOptions.addActionListener(listener);
        showAdvancedOptions.addActionListener(listener);
        showMachineOptions.addActionListener(listener);
        showCPUOptions.addActionListener(listener);
        showCDROMOptions.addActionListener(listener);
        showFloppyOptions.addActionListener(listener);
        showBootOptions.addActionListener(listener);
        showKeyboardOptions.addActionListener(listener);
        showSoundHardwareOptions.addActionListener(listener);
        showSMPOptions.addActionListener(listener);
        showNUMAOptions.addActionListener(listener);
        showOtherMemoryOptions.addActionListener(listener);
        showNetworkOptions.addActionListener(listener);
        showRtcOptions.addActionListener(listener);
        showImageOptions.addActionListener(listener);
        showMonitorOptions.addActionListener(listener);
        showUSBOptions.addActionListener(listener);
        showSpecificBootOptions.addActionListener(listener);
        showCustomOptions.addActionListener(listener);
    }

    private void rechecks() {
        this.pack();
        this.repaint();
    }

    public void showMessage(String message) {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(500, 500));
        JTextArea textArea = new JTextArea(message);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setMargin(new Insets(5, 5, 5, 5));
        scrollPane.getViewport().setView(textArea);
        Object trueMessage = scrollPane;
        JOptionPane.showMessageDialog(null, trueMessage);
    }

    public JSpinner.NumberEditor getEditor() {
        return editor;
    }

    public void setRamSize(String aRamSize) {
        this.myview.getSelectedPanel().setRamSize(aRamSize);
    }
}
