package net.sourceforge.javaqemu.model;

import java.io.File;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConfigurationModel {

    private String default_virtual_machines_path;

    private boolean default_virtual_machines_option;

    private JTextArea execute_before_start_qemu;

    private JTextField qemu_executable_path;

    private JTextField qemu_img_executable_path;

    private JTextArea execute_after_stop_qemu;

    private JTextField bios_vga_bios_keymaps_path;

    private boolean bios_vga_bios_keymaps_option;

    private LastUsedFolderModel myLastUsedFolderModel;

    private LastUsedFileModel myLastUsedFileModel;

    public ConfigurationModel(LastUsedFolderModel myLastUsedFolderModel,
            LastUsedFileModel myLastUsedFileModel) {

        default_virtual_machines_path = "";

        default_virtual_machines_option = false;

        bios_vga_bios_keymaps_option = false;

        this.myLastUsedFolderModel = myLastUsedFolderModel;

        this.myLastUsedFileModel = myLastUsedFileModel;
    }

    public String getDefault_virtual_machines_path() {
        return default_virtual_machines_path;
    }

    public void setDefault_virtual_machines_path(
            String default_virtual_machines_path) {
        if (this.checks_if_it_is_a_valid_directory(default_virtual_machines_path)) {
            this.default_virtual_machines_path = default_virtual_machines_path;
            this.myLastUsedFolderModel.setLastUsedFolder(
                    LastUsedFolderEnumModel.SETDEFAULTVMDIRECTORY
                    .getValor(), this.default_virtual_machines_path);
        }
    }

    public void setDefault_virtual_machines_path_with_boolean(
            String default_virtual_machines_path) {
        if (this.checks_if_it_is_a_valid_directory(default_virtual_machines_path)) {
            this.default_virtual_machines_path = default_virtual_machines_path;
            if (this.isDefault_virtual_machines_option()) {
                this.setDefault_virtual_machines_option(false);
            }
        }
    }

    public boolean isDefault_virtual_machines_option() {
        return default_virtual_machines_option;
    }

    public void setDefault_virtual_machines_option(
            boolean default_virtual_machines_option) {
        this.default_virtual_machines_option = default_virtual_machines_option;
    }

    public boolean checks_if_it_is_a_valid_directory(String path) {
        
        if (path != null)
        {
            File file = new File(path);

            if (!file.exists()) {
                return false;
            }

            if (file.isFile()) {
                return false;
            }

            if (!file.isDirectory()) {
                return false;
            }

            return true;
        }
        
        return false;
    }

    public JTextArea getExecute_before_start_qemu() {
        return execute_before_start_qemu;
    }

    public void setExecute_before_start_qemu(JTextArea execute_before_start_qemu) {
        this.execute_before_start_qemu = execute_before_start_qemu;
    }

    public JTextField getQemu_executable_path() {
        return qemu_executable_path;
    }

    public void setQemu_executable_path(JTextField qemu_executable_path) {
        this.qemu_executable_path = qemu_executable_path;
        if (!this.qemu_executable_path.getText().isEmpty()) {
            this.myLastUsedFolderModel.setLastUsedFolder(LastUsedFolderEnumModel.SETQEMUEXECUTABLEDIRECTORY.getValor(),
                    (new File(this.qemu_executable_path.getText()))
                    .getParent());
            this.myLastUsedFileModel.setLastUsedFile(LastUsedFileEnumModel.SETQEMUEXECUTABLEFILE.getValor(),
                    (new File(this.qemu_executable_path.getText()))
                    .getName());
        }
    }

    public JTextField getQemu_img_executable_path() {
        return qemu_img_executable_path;
    }

    public void setQemu_img_executable_path(JTextField qemu_img_executable_path) {
        this.qemu_img_executable_path = qemu_img_executable_path;
        if (!this.qemu_img_executable_path.getText().isEmpty()) {
            this.myLastUsedFolderModel.setLastUsedFolder(LastUsedFolderEnumModel.SETQEMUIMGEXECUTABLEDIRECTORY.getValor(),
                    (new File(this.qemu_img_executable_path.getText()))
                    .getParent());
            this.myLastUsedFileModel.setLastUsedFile(LastUsedFileEnumModel.SETQEMUIMGEXECUTABLEFILE.getValor(),
                    (new File(this.qemu_img_executable_path.getText()))
                    .getName());
        }
    }

    public JTextArea getExecute_after_stop_qemu() {
        return execute_after_stop_qemu;
    }

    public void setExecute_after_stop_qemu(JTextArea execute_after_stop_qemu) {
        this.execute_after_stop_qemu = execute_after_stop_qemu;
    }

    public JTextField getBios_vga_bios_keymaps_path() {
        return bios_vga_bios_keymaps_path;
    }

    public void setBios_vga_bios_keymaps_path(JTextField bios_vga_bios_keymaps_path) {
        this.bios_vga_bios_keymaps_path = bios_vga_bios_keymaps_path;
        if (!this.bios_vga_bios_keymaps_path.getText().isEmpty()) {
            this.myLastUsedFolderModel.setLastUsedFolder(LastUsedFolderEnumModel.SETLOPTIONDIRECTORY.getValor(),
                    bios_vga_bios_keymaps_path.getText());
        }
    }

    public boolean isBios_vga_bios_keymaps_option() {
        return bios_vga_bios_keymaps_option;
    }

    public void setBios_vga_bios_keymaps_option(boolean bios_vga_bios_keymaps_option) {
        this.bios_vga_bios_keymaps_option = bios_vga_bios_keymaps_option;
    }
}
