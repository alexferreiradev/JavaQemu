package net.sourceforge.javaqemu.view;

import java.io.File;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFileChooserView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JFileChooser chooser;

    private String choosertitle;

    private JPanel jpanel;

    private String choice;

    private String fileExtension;

    private String currentDirectory;

    private String fileDescription;

    public JFileChooserView(JPanel jpanel) {
        super();
        this.jpanel = jpanel;
        this.choice = "";
        this.currentDirectory = ".";
        this.fileExtension = ".xml";
        this.setChooser(new JFileChooser());
    }

    public JFileChooser getChooser() {
        return chooser;
    }

    public void setChooser(JFileChooser chooser) {
        this.chooser = chooser;
    }

    public String getChoosertitle() {
        return choosertitle;
    }

    public void setChoosertitle(String choosertitle) {
        this.choosertitle = choosertitle;
    }

    public JPanel getJpanel() {
        return jpanel;
    }

    public boolean chooseFile() {
        if (this.currentDirectory == null) {
            this.currentDirectory = ".";
        }

        this.getChooser().setCurrentDirectory(new java.io.File(this.currentDirectory));
        this.getChooser().setDialogTitle(this.getChoosertitle());
        this.getChooser().setFileSelectionMode(
                JFileChooser.FILES_ONLY);

        this.getChooser().setFileFilter(new DirectoryFileFilter());

        this.getChooser().setAcceptAllFileFilterUsed(false);
        if (this.getChooser().showOpenDialog(
                this.jpanel) == JFileChooser.APPROVE_OPTION) {
            this.choice = this.getChooser().getSelectedFile().getAbsolutePath();
            return true;
        }
        return false;
    }

    public boolean chooseAnyFile() {
        if (this.currentDirectory == null) {
            this.currentDirectory = ".";
        }

        this.getChooser().setCurrentDirectory(new java.io.File(this.currentDirectory));
        this.getChooser().setDialogTitle(this.getChoosertitle());
        this.getChooser().setFileSelectionMode(
                JFileChooser.FILES_ONLY);

        this.getChooser().setFileFilter(new AnyFileFilter());

        this.getChooser().setAcceptAllFileFilterUsed(false);
        if (this.getChooser().showOpenDialog(
                this.jpanel) == JFileChooser.APPROVE_OPTION) {
            this.choice = this.getChooser().getSelectedFile().getAbsolutePath();
            return true;
        }
        return false;
    }

    public boolean chooseFiles() {
        this.getChooser().setCurrentDirectory(new java.io.File(this.currentDirectory));
        this.getChooser().setDialogTitle(this.getChoosertitle());
        this.getChooser().setFileSelectionMode(
                JFileChooser.FILES_ONLY);

        this.getChooser().setFileFilter(new FilesFileFilter());

        this.getChooser().setAcceptAllFileFilterUsed(false);
        if (this.getChooser().showOpenDialog(
                this.jpanel) == JFileChooser.APPROVE_OPTION) {
            this.choice = this.getChooser().getSelectedFile().getAbsolutePath();
            return true;
        }
        return false;
    }

    public boolean chooseCDROMFiles() {
        this.getChooser().setCurrentDirectory(new java.io.File(this.currentDirectory));
        this.getChooser().setDialogTitle("Select a CDROM Image File!");
        this.getChooser().setFileSelectionMode(
                JFileChooser.FILES_ONLY);

        this.getChooser().setFileFilter(new CDROMImageFileFilter());

        this.getChooser().setAcceptAllFileFilterUsed(false);
        if (this.getChooser().showOpenDialog(
                this.jpanel) == JFileChooser.APPROVE_OPTION) {
            this.choice = this.getChooser().getSelectedFile().getAbsolutePath();
            return true;
        }
        return false;
    }

    public boolean chooseCDROMDrives() {
        this.getChooser().setCurrentDirectory(new java.io.File("."));
        this.getChooser().setDialogTitle("Select a CDROM Drive!");
        this.getChooser().setFileSelectionMode(
                JFileChooser.DIRECTORIES_ONLY);

        this.getChooser().setFileFilter(new DirectoryFileFilter("CDROM Drive"));

        this.getChooser().setAcceptAllFileFilterUsed(false);
        if (this.getChooser().showOpenDialog(
                this.jpanel) == JFileChooser.APPROVE_OPTION) {
            this.choice = this.getChooser().getSelectedFile().getAbsolutePath();
            return true;
        }
        return false;
    }

    public boolean chooseFloppyFiles() {
        this.getChooser().setCurrentDirectory(new java.io.File(this.currentDirectory));
        this.getChooser().setDialogTitle("Select a Floppy Disk Image File!");
        this.getChooser().setFileSelectionMode(
                JFileChooser.FILES_ONLY);

        this.getChooser().setFileFilter(new FloppyImageFileFilter());

        this.getChooser().setAcceptAllFileFilterUsed(false);
        if (this.getChooser().showOpenDialog(
                this.jpanel) == JFileChooser.APPROVE_OPTION) {
            this.choice = this.getChooser().getSelectedFile().getAbsolutePath();
            return true;
        }
        return false;
    }

    public boolean chooseFloppyDrives() {
        this.getChooser().setCurrentDirectory(new java.io.File(this.currentDirectory));
        this.getChooser().setDialogTitle("Select a Floppy Drive!");
        this.getChooser().setFileSelectionMode(
                JFileChooser.DIRECTORIES_ONLY);

        this.getChooser().setFileFilter(new DirectoryFileFilter("Floppy Drive"));

        this.getChooser().setAcceptAllFileFilterUsed(false);
        if (this.getChooser().showOpenDialog(
                this.jpanel) == JFileChooser.APPROVE_OPTION) {
            this.choice = this.getChooser().getSelectedFile().getAbsolutePath();
            return true;
        }
        return false;
    }

    public boolean chooseDirectoryForDefaultVMPath() {
        if (this.currentDirectory == null) {
            this.currentDirectory = ".";
        }

        this.getChooser().setCurrentDirectory(new java.io.File(this.currentDirectory));
        this.getChooser().setDialogTitle(this.getChoosertitle());
        this.getChooser().setFileSelectionMode(
                JFileChooser.DIRECTORIES_ONLY);

        this.getChooser().setFileFilter(new DirectoryFileFilter());

        this.getChooser().setAcceptAllFileFilterUsed(false);
        if (this.getChooser().showOpenDialog(
                this.jpanel) == JFileChooser.APPROVE_OPTION) {
            this.choice = this.getChooser().getSelectedFile().getAbsolutePath();
            return true;
        }
        return false;
    }

    public boolean chooseDirectoryForBiosVgaBiosKeymapsPath() {
        if (this.currentDirectory == null) {
            this.currentDirectory = ".";
        }

        this.getChooser().setCurrentDirectory(new java.io.File(this.currentDirectory));
        this.getChooser().setDialogTitle(this.getChoosertitle());
        this.getChooser().setFileSelectionMode(
                JFileChooser.DIRECTORIES_ONLY);

        this.getChooser().setFileFilter(new DirectoryFileFilter());

        this.getChooser().setAcceptAllFileFilterUsed(false);
        if (this.getChooser().showOpenDialog(
                this.jpanel) == JFileChooser.APPROVE_OPTION) {
            this.choice = this.getChooser().getSelectedFile().getAbsolutePath();
            return true;
        }
        return false;
    }

    public boolean chooseConfigurationFileToBeSaved() {
        if (this.currentDirectory == null) {
            this.currentDirectory = ".";
        }

        this.getChooser().setCurrentDirectory(new java.io.File(this.currentDirectory));
        this.getChooser().setDialogTitle(this.getChoosertitle());
        this.getChooser().setFileSelectionMode(
                JFileChooser.FILES_ONLY);

        this.getChooser().setFileFilter(new ConfigurationFileFilter());

        this.getChooser().setAcceptAllFileFilterUsed(false);
        if (this.getChooser().showSaveDialog(
                this.jpanel) == JFileChooser.APPROVE_OPTION) {
            File selectedfile = this.getChooser().getSelectedFile();
            this.choice = selectedfile.getAbsolutePath();
            return true;
        }
        return false;
    }

    public boolean chooseSplashPicture() {
        this.getChooser().setCurrentDirectory(new java.io.File(this.currentDirectory));
        this.getChooser().setDialogTitle("Select a splash picture!");
        this.getChooser().setFileSelectionMode(
                JFileChooser.FILES_ONLY);

        this.getChooser().setFileFilter(new SplashPictureFileFilter());

        this.getChooser().setAcceptAllFileFilterUsed(false);
        if (this.getChooser().showOpenDialog(
                this.jpanel) == JFileChooser.APPROVE_OPTION) {
            this.choice = this.getChooser().getSelectedFile().getAbsolutePath();
            return true;
        }
        return false;
    }

    public String getChoice() {
        return choice;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public void setCurrentDirectory(String currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public void setJpanel(JPanel jpanel) {
        this.jpanel = jpanel;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getCurrentDirectory() {
        return currentDirectory;
    }

    class DirectoryFileFilter extends javax.swing.filechooser.FileFilter {

        public DirectoryFileFilter() {
            super();
        }

        public DirectoryFileFilter(String aFileDescription) {
            super();
            fileDescription = aFileDescription;
        }

        @Override
        public boolean accept(File f) {
            return f.getName().toLowerCase(Locale.ENGLISH).endsWith(fileExtension)
                    || f.isDirectory();
        }

        @Override
        public String getDescription() {
            return fileDescription;
        }

    }

    class AnyFileFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File f) {
            return true;
        }

        @Override
        public String getDescription() {
            return fileDescription;
        }

    }

    static class FilesFileFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File f) {
            return f.getName().toLowerCase(Locale.ENGLISH).endsWith(".img")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".qcow2")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".qed")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".qcow")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".cow")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".vdi")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".vmdk")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".vpc")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".bochs")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".cloop")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".dmg")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".parallels")
                    || f.isDirectory();
        }

        @Override
        public String getDescription() {
            return "QEMU Disk Image Files";
        }

    }

    static class CDROMImageFileFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File f) {
            return f.getName().toLowerCase(Locale.ENGLISH).endsWith(".img")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".iso")
                    || f.isDirectory();
        }

        @Override
        public String getDescription() {
            return "CDROM Image Files";
        }

    }

    static class FloppyImageFileFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File f) {
            return f.getName().toLowerCase(Locale.ENGLISH).endsWith(".img")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".iso")
                    || f.isDirectory();
        }

        @Override
        public String getDescription() {
            return "Floppy Disk Image Files";
        }

    }

    static class ConfigurationFileFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File f) {
            return f.getName().toLowerCase(Locale.ENGLISH).endsWith(".xml")
                    || f.isDirectory();
        }

        @Override
        public String getDescription() {
            return "XML - JavaQemu Configuration Files";
        }

    }

    static class SplashPictureFileFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File f) {
            return f.getName().toLowerCase(Locale.ENGLISH).endsWith(".jpeg")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".jpg")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".jpe")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".jfif")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".bmp")
                    || f.getName().toLowerCase(Locale.ENGLISH).endsWith(".dib")
                    || f.isDirectory();
        }

        @Override
        public String getDescription() {
            return "Splash Picture";
        }

    }
}
