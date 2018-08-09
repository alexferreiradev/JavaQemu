package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.sourceforge.javaqemu.model.ConfigurationModel;
import net.sourceforge.javaqemu.model.LastUsedFileEnumModel;
import net.sourceforge.javaqemu.model.LastUsedFileModel;
import net.sourceforge.javaqemu.model.LastUsedFolderEnumModel;
import net.sourceforge.javaqemu.model.LastUsedFolderModel;
import net.sourceforge.javaqemu.model.Model;
import net.sourceforge.javaqemu.view.ConfigurationView;

public class ConfigurationControl implements ActionListener {

    private ConfigurationView myview;

    private ConfigurationModel mymodel;

    private FileControl myfile;

    private LastUsedFolderModel myLastUsedFolderModel;

    private LastUsedFileModel myLastUsedFileModel;

    private Boolean isConfigured;

    public ConfigurationControl(LastUsedFolderModel myLastUsedFolderModel,
            LastUsedFileModel myLastUsedFileModel) {
        this.myview = new ConfigurationView();
        this.myview.setVisible(true);
        this.myview.configureListener(this);
        this.myview.configureStandardMode();

        this.myLastUsedFolderModel = myLastUsedFolderModel;
        this.myLastUsedFileModel = myLastUsedFileModel;
        this.mymodel = new ConfigurationModel(this.myLastUsedFolderModel, this.myLastUsedFileModel);

        this.myfile = new FileControl(this.myview.getWindowContent(), null);

        if (Model.isValidString(this.myLastUsedFileModel.getLastUsedFile(
                LastUsedFileEnumModel.LOADJAVAQEMUCONFIGURATIONFILE.getValor()))) {
            if (Model.isValidString(this.myLastUsedFolderModel.getLastUsedFolder(
                    LastUsedFolderEnumModel.OPENEXISTINGJAVAQEMUCONFIGURATION.getValor()))) {
                this.myfile.getMymodel().readConfigurationFromXML(
                        Model.combine(this.myLastUsedFolderModel.getLastUsedFolder(
                                LastUsedFolderEnumModel.OPENEXISTINGJAVAQEMUCONFIGURATION.getValor()),
                                this.myLastUsedFileModel.getLastUsedFile(
                                        LastUsedFileEnumModel.LOADJAVAQEMUCONFIGURATIONFILE.getValor())));
                this.myfile.getMymodel().getConfiguration(
                        this.myview.getDefault_virtual_machines_path_choice(),
                        this.myview.getExecute_before_start_qemu_choices(),
                        this.myview.getQemu_executable_path_choice(),
                        this.myview.getExecute_after_stop_qemu_choices(),
                        this.myview.getQemu_img_executable_path_choice(),
                        this.myview.getBios_vga_bios_keymaps_path_choice());
                this.mymodel.setDefault_virtual_machines_path(this.myfile.getMymodel().getDefaultVMPath());
                this.mymodel.setExecute_before_start_qemu(this.myview.getExecute_before_start_qemu_choices());
                this.mymodel.setQemu_executable_path(this.myview.getQemu_executable_path_choice());
                this.mymodel.setExecute_after_stop_qemu(this.myview.getExecute_after_stop_qemu_choices());
                this.mymodel.setQemu_img_executable_path(this.myview.getQemu_img_executable_path_choice());
                this.mymodel.setBios_vga_bios_keymaps_path(this.myview.getBios_vga_bios_keymaps_path_choice());
            }
        }

        this.isConfigured = false;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ExitCommand")) {
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("DirectoryChooser")) {
            this.setChoosertitle("JavaQemu Configuration - Choose the default VM directory!");
            this.myview.setFileDescription("Default VM Directory");
            if (this.myLastUsedFolderModel
                    .getLastUsedFolder(LastUsedFolderEnumModel.SETDEFAULTVMDIRECTORY
                            .getValor()) != null) {
                if (!this.myLastUsedFolderModel.getLastUsedFolder(
                        LastUsedFolderEnumModel.SETDEFAULTVMDIRECTORY
                        .getValor()).equals(".")) {
                    this.myview
                            .setCurrentDirectory(this.myLastUsedFolderModel
                                    .getLastUsedFolder(LastUsedFolderEnumModel.SETDEFAULTVMDIRECTORY
                                            .getValor()));
                } else if (this.myview.getDefault_virtual_machines_path_choice()
                        .getText().isEmpty()) {
                    this.myview.setCurrentDirectory(".");
                } else {
                    this.myview.setCurrentDirectory(this.myview
                            .getDefault_virtual_machines_path_choice()
                            .getText());
                }
            } else if (this.myview.getDefault_virtual_machines_path_choice()
                    .getText().isEmpty()) {
                this.myview.setCurrentDirectory(".");
            } else {
                this.myview.setCurrentDirectory(this.myview
                        .getDefault_virtual_machines_path_choice()
                        .getText());
            }

            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.mymodel.setDefault_virtual_machines_path(this.myview
                        .getChoice());
            }
            this.mymodel.setDefault_virtual_machines_option(true);
        } else if (e.getActionCommand().equals("OK")) {
            boolean do_my_view_invisible = true;
            if (this.mymodel.isDefault_virtual_machines_option()
                    && !this.checks_if_JTextField_is_changed(this.myview
                            .getDefault_virtual_machines_path_choice(),
                            this.mymodel.getDefault_virtual_machines_path())) {
                if (this.myview.getChooser() != null) {
                    this.mymodel.setDefault_virtual_machines_path(this.myview
                            .getDefault_virtual_machines_path_choice()
                            .getText());
                }
            }
            if (this.checks_if_JTextField_is_changed(
                    this.myview.getDefault_virtual_machines_path_choice(),
                    this.mymodel.getDefault_virtual_machines_path())) {
                File file = new File(this.myview
                        .getDefault_virtual_machines_path_choice().getText());
                if (file.isDirectory()) {
                    this.mymodel
                            .setDefault_virtual_machines_path_with_boolean(this.myview
                                    .getDefault_virtual_machines_path_choice()
                                    .getText());
                } else {
                    this.myview
                            .showMessage("Please, reconfigure the path of the default Virtual Machines first!\n"
                                    + "This path should be the path of a directory!\n"
                                    + "You can to cancel the configuration and the pending choices will be saved!");
                    do_my_view_invisible = false;
                }
            }

            this.mymodel.setExecute_before_start_qemu(this.myview
                    .getExecute_before_start_qemu_choices());
            File file = new File(this.myview.getQemu_executable_path_choice()
                    .getText());
            if (file.isFile()) {
                this.mymodel.setQemu_executable_path(this.myview
                        .getQemu_executable_path_choice());
            } else {
                this.myview
                        .showMessage("Please, reconfigure the path of the qemu executable first!\n"
                                + "This path should be the path of a file!\n"
                                + "You can to cancel the configuration and the pending choices will be saved!");
                do_my_view_invisible = false;
            }
            this.mymodel.setExecute_after_stop_qemu(this.myview
                    .getExecute_after_stop_qemu_choices());
            File anotherfile = new File(this.myview
                    .getQemu_img_executable_path_choice().getText());
            if (anotherfile.isFile()) {
                this.mymodel.setQemu_img_executable_path(this.myview
                        .getQemu_img_executable_path_choice());
            } else {
                this.myview
                        .showMessage("Please, reconfigure the path of the qemu-img executable first!\n"
                                + "This path should be the path of a file!\n"
                                + "You can to cancel the configuration and the pending choices will be saved!");
                do_my_view_invisible = false;
            }

            if (this.mymodel.isBios_vga_bios_keymaps_option()
                    && !this.checks_if_JTextField_is_changed(this.myview
                            .getBios_vga_bios_keymaps_path_choice(),
                            this.mymodel.getBios_vga_bios_keymaps_path().getText())) {
                if (this.myview.getChooser() != null) {
                    this.mymodel.setBios_vga_bios_keymaps_path(this.myview
                            .getBios_vga_bios_keymaps_path_choice());
                }
            }

            if (do_my_view_invisible) {
                this.myview.setVisible(false);
                if (!this.isConfigured) {
                    this.isConfigured = true;
                }

                if (this.myview.getJavaQemu_configuration_file_path() != null) {
                    this.myfile.getMymodel().setConfiguration(
                            this.myview.getDefault_virtual_machines_path_choice(),
                            this.myview.getExecute_before_start_qemu_choices(),
                            this.myview.getQemu_executable_path_choice(),
                            this.myview.getExecute_after_stop_qemu_choices(),
                            this.myview.getQemu_img_executable_path_choice(),
                            this.myview.getBios_vga_bios_keymaps_path_choice());
                    this.myfile.getMymodel().saveConfigurationToXML(
                            this.myview.getJavaQemu_configuration_file_path());
                }
            } else if (this.isConfigured) {
                this.isConfigured = false;
            }
        } else if (e.getActionCommand().equals("Hide")) {
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("QemuChooser")) {
            this.setChoosertitle("JavaQemu Configuration - Choose the qemu executable file!");
            if (Model
                    .isValidString(this.myLastUsedFolderModel
                            .getLastUsedFolder(LastUsedFolderEnumModel.SETQEMUEXECUTABLEDIRECTORY
                                    .getValor()))) {
                this.myview
                        .setCurrentDirectory(this.myLastUsedFolderModel
                                .getLastUsedFolder(LastUsedFolderEnumModel.SETQEMUEXECUTABLEDIRECTORY
                                        .getValor()));
            }
            this.myview.setFileDescription("Qemu Executable File");
            this.myview.chooseFile(true);
        } else if (e.getActionCommand().equals("QemuImgChooser")) {
            this.setChoosertitle("JavaQemu Configuration - Choose the qemu-img executable file!");
            if (Model.isValidString(this.myLastUsedFolderModel.getLastUsedFolder(
                    LastUsedFolderEnumModel.SETQEMUIMGEXECUTABLEDIRECTORY.getValor()))) {
                this.myview
                        .setCurrentDirectory(this.myLastUsedFolderModel
                                .getLastUsedFolder(LastUsedFolderEnumModel.SETQEMUIMGEXECUTABLEDIRECTORY.getValor()));
            }
            this.myview.setFileDescription("Qemu-img Executable File");
            this.myview.chooseFile(false);
        } else if (e.getActionCommand().equals("SaveConfiguration")) {
            this.setChoosertitle("JavaQemu Configuration - Choose the JavaQemu Configuration XML File!");
            this.myview.setCurrentDirectory(
                    this.myLastUsedFolderModel.getLastUsedFolder(
                            LastUsedFolderEnumModel.SAVEEXISTINGJAVAQEMUCONFIGURATION.getValor())
            );
            if (this.myview.chooseConfigurationFileToBeSaved()) {
                this.myLastUsedFolderModel.setLastUsedFolder(
                        LastUsedFolderEnumModel.SAVEEXISTINGJAVAQEMUCONFIGURATION.getValor(), (new File(this.myview.getJavaQemu_configuration_file_path())).getParent());
                this.myfile.getMymodel().setConfiguration(
                        this.myview.getDefault_virtual_machines_path_choice(),
                        this.myview.getExecute_before_start_qemu_choices(),
                        this.myview.getQemu_executable_path_choice(),
                        this.myview.getExecute_after_stop_qemu_choices(),
                        this.myview.getQemu_img_executable_path_choice(),
                        this.myview.getBios_vga_bios_keymaps_path_choice());
                this.myfile.getMymodel().saveConfigurationToXML(
                        this.myview.getJavaQemu_configuration_file_path());
            }
        } else if (e.getActionCommand().equals("OpenConfiguration")) {
            this.setChoosertitle("JavaQemu Configuration - Choose the JavaQemu Configuration XML File!");
            this.myview.setCurrentDirectory(
                    this.myLastUsedFolderModel.getLastUsedFolder(
                            LastUsedFolderEnumModel.OPENEXISTINGJAVAQEMUCONFIGURATION.getValor())
            );
            if (this.myview.chooseConfigurationFileToBeOpened()) {
                this.myLastUsedFolderModel.setLastUsedFolder(
                        LastUsedFolderEnumModel.OPENEXISTINGJAVAQEMUCONFIGURATION.getValor(), (new File(this.myview.getJavaQemu_configuration_file_path())).getParent());
                this.myLastUsedFileModel.setLastUsedFile(
                        LastUsedFileEnumModel.LOADJAVAQEMUCONFIGURATIONFILE.getValor(),
                        (new File(this.myview.getJavaQemu_configuration_file_path())).getName());
                this.myfile.getMymodel().readConfigurationFromXML(
                        this.myview.getJavaQemu_configuration_file_path());
                this.myfile.getMymodel().getConfiguration(
                        this.myview.getDefault_virtual_machines_path_choice(),
                        this.myview.getExecute_before_start_qemu_choices(),
                        this.myview.getQemu_executable_path_choice(),
                        this.myview.getExecute_after_stop_qemu_choices(),
                        this.myview.getQemu_img_executable_path_choice(),
                        this.myview.getBios_vga_bios_keymaps_path_choice());
                this.mymodel.setDefault_virtual_machines_path(this.myfile.getMymodel().getDefaultVMPath());
                this.mymodel.setExecute_before_start_qemu(this.myview.getExecute_before_start_qemu_choices());
                this.mymodel.setQemu_executable_path(this.myview.getQemu_executable_path_choice());
                this.mymodel.setExecute_after_stop_qemu(this.myview.getExecute_after_stop_qemu_choices());
                this.mymodel.setQemu_img_executable_path(this.myview.getQemu_img_executable_path_choice());
                this.mymodel.setBios_vga_bios_keymaps_path(this.myview.getBios_vga_bios_keymaps_path_choice());
            }
        } else if (e.getActionCommand().equals("LDirectoryPathChooser")) {
            this.setChoosertitle("JavaQemu Configuration - Choose the directory for the BIOS, VGA BIOS and keymaps!");
            this.myview.setCurrentDirectory(
                    this.myLastUsedFolderModel.getLastUsedFolder(
                            LastUsedFolderEnumModel.SETLOPTIONDIRECTORY.getValor()));
            this.myview.setFileDescription("Directory for the BIOS, VGA BIOS and keymaps");
            if (this.myview.chooseDirectoryForBiosVgaBiosKeymapsPath()) {
                this.mymodel.setBios_vga_bios_keymaps_path(
                        new JTextField(this.myview.getChoice()));
                this.myLastUsedFolderModel.setLastUsedFolder(LastUsedFolderEnumModel.SETLOPTIONDIRECTORY.getValor(),
                        this.myview.getChoice());
            }
            this.mymodel.setBios_vga_bios_keymaps_option(true);
        }
    }

    public void do_my_view_visible() {
        this.myview.setVisible(true);
    }

    public void setQemu_executable_path() {
        this.mymodel.setQemu_executable_path(this.myview
                .getQemu_executable_path_choice());
    }

    public void setBios_vga_bios_keymaps_path() {
        this.mymodel.setBios_vga_bios_keymaps_path(
                this.myview.getBios_vga_bios_keymaps_path_choice());
    }

    public boolean checks_if_JTextField_is_changed(JTextField textField,
            String string) {
        if (textField.getText().equals(string)) {
            return false;
        } else {
            return true;
        }
    }

    public String getDefault_virtual_machines_path() {
        return this.mymodel.getDefault_virtual_machines_path();
    }

    public JTextArea getExecute_before_start_qemu() {
        return this.mymodel.getExecute_before_start_qemu();
    }

    public JTextField getQemu_executable_path() {
        return this.mymodel.getQemu_executable_path();
    }

    public JTextField getQemu_img_executable_path() {
        return this.mymodel.getQemu_img_executable_path();
    }

    public JTextArea getExecute_after_stop_qemu() {
        return this.mymodel.getExecute_after_stop_qemu();
    }

    public JTextField getBios_vga_bios_keymaps_path() {
        return this.mymodel.getBios_vga_bios_keymaps_path();
    }

    public void setChoosertitle(String title) {
        this.myview.setChoosertitle(title);
    }

    public Boolean getIsConfigured() {
        return isConfigured;
    }
}
