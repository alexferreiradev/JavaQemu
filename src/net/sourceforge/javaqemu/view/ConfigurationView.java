package net.sourceforge.javaqemu.view;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConfigurationView extends JFileChooserView {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridLayout gridLayout;

    private JMenuBar menuBar;

    private JMenu fileMenu;
    private JMenuItem saveConfiguration;
    private JMenuItem openConfiguration;
    private JMenuItem exitCommand;

    private JLabel default_virtual_machines_path_description;

    private JTextField default_virtual_machines_path_choice;

    private JScrollPane default_virtual_machines_path_scroller;

    private JButton default_virtual_machines_path_chooser;

    private JLabel execute_before_start_qemu_description;

    private JTextArea execute_before_start_qemu_choices;

    private JScrollPane ascrollpane_start, ascrollpane_stop;

    private JLabel firstEmptyLabel, thirdEmptyLabel;

    private JLabel qemu_executable_path_description;

    private JTextField qemu_executable_path_choice;

    private JScrollPane qemu_executable_path_scroller;

    private JLabel qemu_img_executable_path_description;

    private JTextField qemu_img_executable_path_choice;

    private JScrollPane qemu_img_executable_path_scroller;

    private JLabel execute_after_stop_qemu_description;

    private JTextArea execute_after_stop_qemu_choices;

    private JButton ok, hide;

    private JButton qemu_executable_path_chooser;

    private JButton qemu_img_executable_path_chooser;

    private String javaQemu_configuration_file_path;

    private JLabel empty;

    private JLabel bios_vga_bios_keymaps_path_description;

    private JTextField bios_vga_bios_keymaps_path_choice;

    private JScrollPane bios_vga_bios_keymaps_path_scroller;

    private JButton bios_vga_bios_keymaps_path_chooser;

    public ConfigurationView() {
        super(null);
        windowContent = new JPanel();

        this.setJpanel(windowContent);

        gridLayout = new GridLayout(7, 3);

        windowContent.setLayout(gridLayout);

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");

        openConfiguration = new JMenuItem("Open configuration");
        fileMenu.add(openConfiguration);

        saveConfiguration = new JMenuItem("Save Configuration");
        fileMenu.add(saveConfiguration);

        exitCommand = new JMenuItem("Quit");
        fileMenu.add(exitCommand);

        menuBar.add(fileMenu);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        default_virtual_machines_path_description = new JLabel(
                "Default Virtual Machines Path: ");
        default_virtual_machines_path_choice = new JTextField(0);
        default_virtual_machines_path_scroller = new JScrollPane(
                default_virtual_machines_path_choice);
        default_virtual_machines_path_chooser = new JButton(
                "Choose the Default VM Directory!");
        windowContent.add(default_virtual_machines_path_description);
        windowContent.add(default_virtual_machines_path_scroller);
        windowContent.add(default_virtual_machines_path_chooser);

        execute_before_start_qemu_description = new JLabel(
                "Execute before start QEMU:");
        windowContent.add(execute_before_start_qemu_description);

        execute_before_start_qemu_choices = new JTextArea("", 3, 30);
        execute_before_start_qemu_choices.setLineWrap(true);
        execute_before_start_qemu_choices.setWrapStyleWord(true);

        ascrollpane_start = new JScrollPane(execute_before_start_qemu_choices);
        windowContent.add(ascrollpane_start);

        firstEmptyLabel = new JLabel("");
        windowContent.add(firstEmptyLabel);

        qemu_executable_path_description = new JLabel("Qemu Executable Path: ");
        windowContent.add(qemu_executable_path_description);

        qemu_executable_path_choice = new JTextField(0);
        qemu_executable_path_scroller = new JScrollPane(
                qemu_executable_path_choice);
        windowContent.add(qemu_executable_path_scroller);

        qemu_executable_path_chooser = new JButton(
                "Choose the Qemu Executable Path!");
        windowContent.add(qemu_executable_path_chooser);

        execute_after_stop_qemu_description = new JLabel(
                "Execute after stop QEMU:");
        windowContent.add(execute_after_stop_qemu_description);

        execute_after_stop_qemu_choices = new JTextArea("", 3, 30);
        execute_after_stop_qemu_choices.setLineWrap(true);
        execute_after_stop_qemu_choices.setWrapStyleWord(true);

        ascrollpane_stop = new JScrollPane(execute_after_stop_qemu_choices);
        windowContent.add(ascrollpane_stop);

        thirdEmptyLabel = new JLabel("");
        windowContent.add(thirdEmptyLabel);

        qemu_img_executable_path_description = new JLabel(
                "Qemu-img Executable Path: ");
        windowContent.add(qemu_img_executable_path_description);

        qemu_img_executable_path_choice = new JTextField(0);
        qemu_img_executable_path_scroller = new JScrollPane(
                qemu_img_executable_path_choice);
        windowContent.add(qemu_img_executable_path_scroller);

        qemu_img_executable_path_chooser = new JButton(
                "Choose the Qemu-img Executable Path!");
        windowContent.add(qemu_img_executable_path_chooser);

        bios_vga_bios_keymaps_path_description = new JLabel(
                "BIOS, VGA BIOS and keymaps Path:");
        windowContent.add(bios_vga_bios_keymaps_path_description);

        bios_vga_bios_keymaps_path_choice = new JTextField(0);
        bios_vga_bios_keymaps_path_scroller = new JScrollPane(
                bios_vga_bios_keymaps_path_choice);
        windowContent.add(bios_vga_bios_keymaps_path_scroller);

        bios_vga_bios_keymaps_path_chooser = new JButton(
                "Set the BIOS, VGA BIOS and keymaps Path!");
        windowContent.add(bios_vga_bios_keymaps_path_chooser);

        empty = new JLabel("");
        windowContent.add(empty);

        ok = new JButton("OK");
        windowContent.add(ok);

        hide = new JButton("Hide");
        windowContent.add(hide);

        initialize();
    }

    private void initialize() {
        this.setContentPane(windowContent);
        this.setJMenuBar(menuBar);
        this.setTitle("JavaQemu Configuration");
        this.pack();

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        if (this.getSize().width > width
                || this.getSize().height > height) {
            this.setSize(width, height);
        }
    }

    public void configureListener(ActionListener listener) {
        exitCommand.addActionListener(listener);
        default_virtual_machines_path_chooser.addActionListener(listener);
        ok.addActionListener(listener);
        hide.addActionListener(listener);
        qemu_executable_path_chooser.addActionListener(listener);
        qemu_img_executable_path_chooser.addActionListener(listener);
        saveConfiguration.addActionListener(listener);
        openConfiguration.addActionListener(listener);
        bios_vga_bios_keymaps_path_chooser.addActionListener(listener);
    }

    public void configureStandardMode() {
        exitCommand.setActionCommand("ExitCommand");
        default_virtual_machines_path_chooser
                .setActionCommand("DirectoryChooser");
        ok.setActionCommand("OK");
        hide.setActionCommand("Hide");
        qemu_executable_path_chooser.setActionCommand("QemuChooser");
        qemu_img_executable_path_chooser.setActionCommand("QemuImgChooser");
        saveConfiguration.setActionCommand("SaveConfiguration");
        openConfiguration.setActionCommand("OpenConfiguration");
        bios_vga_bios_keymaps_path_chooser.setActionCommand("LDirectoryPathChooser");
    }

    public JPanel getWindowContent() {
        return windowContent;
    }

    public void setDefault_virtual_machines_path_choice(
            JTextField default_virtual_machines_path_choice) {
        this.default_virtual_machines_path_choice = default_virtual_machines_path_choice;
    }

    public void setDefault_virtual_machines_path_choiceText(String text) {
        this.default_virtual_machines_path_choice.setText(text);
    }

    public JTextArea getExecute_before_start_qemu_choices() {
        return execute_before_start_qemu_choices;
    }

    public JTextField getQemu_executable_path_choice() {
        return qemu_executable_path_choice;
    }

    public JTextArea getExecute_after_stop_qemu_choices() {
        return execute_after_stop_qemu_choices;
    }

    public JTextField getDefault_virtual_machines_path_choice() {
        return default_virtual_machines_path_choice;
    }

    public JTextField getQemu_img_executable_path_choice() {
        return qemu_img_executable_path_choice;
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

    public boolean chooseDirectoryForDefaultVMPath() {
        boolean given = super.chooseDirectoryForDefaultVMPath();

        if (given) {
            this.setDefault_virtual_machines_path_choiceText(this.getChoice());
        }

        return given;
    }

    public boolean chooseDirectoryForBiosVgaBiosKeymapsPath() {
        boolean given = super.chooseDirectoryForBiosVgaBiosKeymapsPath();

        if (given) {
            this.setBios_vga_bios_keymaps_path_choiceText(this.getChoice());
        }

        return given;
    }

    public boolean chooseFile(boolean itisqemu) {
        boolean given = super.chooseAnyFile();

        if (given) {
            if (itisqemu) {
                this.qemu_executable_path_choice.setText(this.getChoice());
            } else {
                this.qemu_img_executable_path_choice.setText(this.getChoice());
            }
        }

        return given;
    }

    public boolean chooseConfigurationFileToBeSaved() {
        boolean given = super.chooseConfigurationFileToBeSaved();
        if (given) {
            if (this.getChoice().length() > 4) {
                if (this.getChoice().substring(this.getChoice().length() - 4).equals(".xml")) {
                    this.javaQemu_configuration_file_path = this.getChoice();
                } else {
                    this.javaQemu_configuration_file_path = this.getChoice() + ".xml";
                }
            } else {
                this.javaQemu_configuration_file_path = this.getChoice() + ".xml";
            }
        }
        return given;
    }

    public boolean chooseConfigurationFileToBeOpened() {
        super.setFileDescription("XML - JavaQemu Configuration Files");
        super.setFileExtension(".xml");

        boolean given = super.chooseFile();
        if (given) {
            if (this.getChoice().length() > 4) {
                if (this.getChoice().substring(this.getChoice().length() - 4).equals(".xml")) {
                    this.javaQemu_configuration_file_path = this.getChoice();
                } else {
                    this.javaQemu_configuration_file_path = this.getChoice() + ".xml";
                }
            } else {
                this.javaQemu_configuration_file_path = this.getChoice() + ".xml";
            }
        }
        return given;
    }

    public String getJavaQemu_configuration_file_path() {
        return javaQemu_configuration_file_path;
    }

    public JTextField getBios_vga_bios_keymaps_path_choice() {
        return bios_vga_bios_keymaps_path_choice;
    }

    public void setBios_vga_bios_keymaps_path_choice(
            JTextField bios_vga_bios_keymaps_path_choice) {
        this.bios_vga_bios_keymaps_path_choice = bios_vga_bios_keymaps_path_choice;
    }

    public void setBios_vga_bios_keymaps_path_choiceText(String text) {
        this.bios_vga_bios_keymaps_path_choice.setText(text);
    }
}
