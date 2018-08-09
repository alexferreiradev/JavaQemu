package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.HardDiskModel;
import net.sourceforge.javaqemu.view.HardDiskView;

public class HardDiskControl implements ActionListener {

    private HardDiskModel mymodel;
    private HardDiskView myview;
    private PhysicalDriveControl[] myphysicaldrives;
    private FileControl myfile;

    public HardDiskControl(EmulationControl myemulation, FileControl myfile) {
        this.myview = new HardDiskView(myfile.getMymodel().getFirstHardDiskOption(),
                myfile.getMymodel().getSecondHardDiskOption(), myfile
                .getMymodel().getThirdHardDiskOption(), myfile
                .getMymodel().getFourthHardDiskOption());
        this.mymodel = new HardDiskModel(myemulation, myfile);
        this.myfile = myfile;
        this.myphysicaldrives = new PhysicalDriveControl[4];
    }

    public void starts() {
        this.myview.configureListener(this);
        this.myview.configureStandardMode();
    }

    public void setVisible(boolean value) {
        this.myview.setVisible(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ChangeDiskImagePathButton")) {
            this.myview
                    .setChoosertitle("Choose the first disk image path!");
            if (this.myview.chooseFiles()) {
                this.mymodel.setFirstHardDiskOption(this.myview.getChoice());
                this.myview.changesFirstHardDiskOptionField(this.myview.getChoice());
            }
        } else if (e.getActionCommand().equals(
                "SetFirstPhysicalHardDiskDriveButton")) {
            if (this.myphysicaldrives[0] == null) {
                this.myphysicaldrives[0] = new PhysicalDriveControl(this, myfile, 1);
                this.myphysicaldrives[0].change_my_visibility(true);
            } else {
                this.myphysicaldrives[0].change_my_visibility(true);
            }
        } else if (e.getActionCommand().equals("SetFirstLinuxPhysicalHardDiskDriveButton")) {
            this.myview.setChoosertitle("JavaQemu - First Linux Physical Drive Choice");
            this.myview.setFileDescription("Linux Hard Disk Device");
            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.mymodel.setFirstHardDiskOption(this.myview.getChoice());
                this.myview.changesFirstHardDiskOptionField(this.myview.getChoice());
            }
        } else if (e.getActionCommand().equals(
                "SetFirstReadOnlyVirtualFATHardDiskPathButton")) {
            this.myview.setChoosertitle("Choose the First Read-Only Virtual VFAT Path!");
            this.myview.setFileDescription("Read-Only Virtual VFAT Directory");
            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.mymodel.setFirstHardDiskOption(this.convertFatReadOnly(this.myview.getChoice()));
                this.myview.changesFirstHardDiskOptionField(this.convertFatReadOnly(this.myview.getChoice()));
            }
        } else if (e.getActionCommand().equals(
                "SetFirstReadWriteVirtualFATHardDiskPathButton")) {
            this.myview.setChoosertitle("Choose the First Read-Write Virtual VFAT Path!");
            this.myview.setFileDescription("Read-Write Virtual VFAT Directory");
            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.mymodel.setFirstHardDiskOption(this.convertFatReadWrite(this.myview.getChoice()));
                this.myview.changesFirstHardDiskOptionField(this.convertFatReadWrite(this.myview.getChoice()));
            }
        } else if (e.getActionCommand().equals(
                "ChangeSecondDiskImagePathButton")) {
            this.myview
                    .setChoosertitle("Choose the second disk image path!");
            if (this.myview.chooseFiles()) {
                this.mymodel.setSecondHardDiskOption(this.myview.getChoice());
                this.myview.changesSecondHardDiskOptionField(this.myview
                        .getChoice());
            }
        } else if (e.getActionCommand().equals(
                "SetSecondPhysicalHardDiskDriveButton")) {
            if (this.myphysicaldrives[1] == null) {
                this.myphysicaldrives[1] = new PhysicalDriveControl(this, myfile, 2);
                this.myphysicaldrives[1].change_my_visibility(true);
            } else {
                this.myphysicaldrives[1].change_my_visibility(true);
            }
        } else if (e.getActionCommand().equals("SetSecondLinuxPhysicalHardDiskDriveButton")) {
            this.myview.setChoosertitle("JavaQemu - Second Linux Physical Drive Choice");
            this.myview.setFileDescription("Linux Hard Disk Device");
            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.mymodel.setSecondHardDiskOption(this.myview.getChoice());
                this.myview.changesSecondHardDiskOptionField(this.myview.getChoice());
            }
        } else if (e.getActionCommand().equals(
                "SetSecondReadOnlyVirtualFATHardDiskPathButton")) {
            this.myview.setChoosertitle("Choose the Second Read-Only Virtual VFAT Path!");
            this.myview.setFileDescription("Read-Only Virtual VFAT Directory");
            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.mymodel.setSecondHardDiskOption(this.convertFatReadOnly(this.myview.getChoice()));
                this.myview.changesSecondHardDiskOptionField(this.convertFatReadOnly(this.myview.getChoice()));
            }
        } else if (e.getActionCommand().equals(
                "SetSecondReadWriteVirtualFATHardDiskPathButton")) {
            this.myview.setChoosertitle("Choose the Second Read-Write Virtual VFAT Path!");
            this.myview.setFileDescription("Read-Write Virtual VFAT Directory");
            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.mymodel.setSecondHardDiskOption(this.convertFatReadWrite(this.myview.getChoice()));
                this.myview.changesSecondHardDiskOptionField(this.convertFatReadWrite(this.myview.getChoice()));
            }
        } else if (e.getActionCommand()
                .equals("ChangeThirdDiskImagePathButton")) {
            this.myview
                    .setChoosertitle("Choose the third disk image path!");
            if (this.myview.chooseFiles()) {
                this.mymodel.setThirdHardDiskOption(this.myview.getChoice());
                this.myview.changesThirdHardDiskOptionField(this.myview
                        .getChoice());
            }
        } else if (e.getActionCommand().equals(
                "SetThirdPhysicalHardDiskDriveButton")) {
            if (this.myphysicaldrives[2] == null) {
                this.myphysicaldrives[2] = new PhysicalDriveControl(this, myfile, 3);
                this.myphysicaldrives[2].change_my_visibility(true);
            } else {
                this.myphysicaldrives[2].change_my_visibility(true);
            }
        } else if (e.getActionCommand().equals("SetThirdLinuxPhysicalHardDiskDriveButton")) {
            this.myview.setChoosertitle("JavaQemu - Third Linux Physical Drive Choice");
            this.myview.setFileDescription("Linux Hard Disk Device");
            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.mymodel.setThirdHardDiskOption(this.myview.getChoice());
                this.myview.changesThirdHardDiskOptionField(this.myview.getChoice());
            }
        } else if (e.getActionCommand().equals(
                "SetThirdReadOnlyVirtualFATHardDiskPathButton")) {
            this.myview.setChoosertitle("Choose the Third Read-Only Virtual VFAT Path!");
            this.myview.setFileDescription("Read-Only Virtual VFAT Directory");
            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.mymodel.setThirdHardDiskOption(this.convertFatReadOnly(this.myview.getChoice()));
                this.myview.changesThirdHardDiskOptionField(this.convertFatReadOnly(this.myview.getChoice()));
            }
        } else if (e.getActionCommand().equals(
                "SetThirdReadWriteVirtualFATHardDiskPathButton")) {
            this.myview.setChoosertitle("Choose the Third Read-Write Virtual VFAT Path!");
            this.myview.setFileDescription("Read-Write Virtual VFAT Directory");
            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.mymodel.setThirdHardDiskOption(this.convertFatReadWrite(this.myview.getChoice()));
                this.myview.changesThirdHardDiskOptionField(this.convertFatReadWrite(this.myview.getChoice()));
            }
        } else if (e.getActionCommand().equals(
                "ChangeFourthDiskImagePathButton")) {
            this.myview
                    .setChoosertitle("Choose the fourth disk image path!");
            if (this.myview.chooseFiles()) {
                this.mymodel.setFourthHardDiskOption(this.myview.getChoice());
                this.myview.changesFourthHardDiskOptionField(this.myview
                        .getChoice());
            }
        } else if (e.getActionCommand().equals(
                "SetFourthPhysicalHardDiskDriveButton")) {
            if (this.myphysicaldrives[3] == null) {
                this.myphysicaldrives[3] = new PhysicalDriveControl(this, myfile, 4);
                this.myphysicaldrives[3].change_my_visibility(true);
            } else {
                this.myphysicaldrives[3].change_my_visibility(true);
            }
        } else if (e.getActionCommand().equals("SetFourthLinuxPhysicalHardDiskDriveButton")) {
            this.myview.setChoosertitle("JavaQemu - Fourth Linux Physical Drive Choice");
            this.myview.setFileDescription("Linux Hard Disk Device");
            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.mymodel.setFourthHardDiskOption(this.myview.getChoice());
                this.myview.changesFourthHardDiskOptionField(this.myview.getChoice());
            }
        } else if (e.getActionCommand().equals(
                "SetFourthReadOnlyVirtualFATHardDiskPathButton")) {
            this.myview.setChoosertitle("Choose the Fourth Read-Only Virtual VFAT Path!");
            this.myview.setFileDescription("Read-Only Virtual VFAT Directory");
            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.mymodel.setFourthHardDiskOption(this.convertFatReadOnly(this.myview.getChoice()));
                this.myview.changesFourthHardDiskOptionField(this.convertFatReadOnly(this.myview.getChoice()));
            }
        } else if (e.getActionCommand().equals(
                "SetFourthReadWriteVirtualFATHardDiskPathButton")) {
            this.myview.setChoosertitle("Choose the Fourth Read-Write Virtual VFAT Path!");
            this.myview.setFileDescription("Read-Write Virtual VFAT Directory");
            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.mymodel.setFourthHardDiskOption(this.convertFatReadWrite(this.myview.getChoice()));
                this.myview.changesFourthHardDiskOptionField(this.convertFatReadWrite(this.myview.getChoice()));
            }
        } else if (e.getActionCommand().equals("okButtonHDI")) {
            if (!this.myview.getFirstHardDiskOption().equals(
                    this.mymodel.getFirstHardDiskOption())) {
                this.mymodel.setFirstHardDiskOption(this.myview.getFirstHardDiskOption());
                this.myview.changesFirstHardDiskOptionField(this.myview
                        .getFirstHardDiskOption());
            }

            if (!this.myview.getSecondHardDiskOption().equals(
                    this.mymodel.getSecondHardDiskOption())) {
                this.mymodel.setSecondHardDiskOption(this.myview
                        .getSecondHardDiskOption());
                this.myview.changesSecondHardDiskOptionField(this.myview
                        .getSecondHardDiskOption());
            }

            if (!this.myview.getThirdHardDiskOption().equals(
                    this.mymodel.getThirdHardDiskOption())) {
                this.mymodel.setThirdHardDiskOption(this.myview
                        .getThirdHardDiskOption());
                this.myview.changesThirdHardDiskOptionField(this.myview
                        .getThirdHardDiskOption());
            }

            if (!this.myview.getFourthHardDiskOption().equals(
                    this.mymodel.getFourthHardDiskOption())) {
                this.mymodel.setFourthHardDiskOption(this.myview
                        .getFourthHardDiskOption());
                this.myview.changesFourthHardDiskOptionField(this.myview
                        .getFourthHardDiskOption());
            }

            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("eraseButtonHDI")) {

            this.mymodel.setFirstHardDiskOption("");
            this.myview.changesFirstHardDiskOptionField("");

            this.mymodel.setSecondHardDiskOption("");
            this.myview.changesSecondHardDiskOptionField("");

            this.mymodel.setThirdHardDiskOption("");
            this.myview.changesThirdHardDiskOptionField("");

            this.mymodel.setFourthHardDiskOption("");
            this.myview.changesFourthHardDiskOptionField("");

            this.myview.setVisible(false);
        }
    }

    public void setPhysicalDriveChoice(int position, String choice) {
        if (position == 1) {
            if (!choice.isEmpty()) {
                this.mymodel.setFirstHardDiskOption(choice);
                this.myview.changesFirstHardDiskOptionField(choice);
            } else if (this.myview.getFirstHardDiskOption().startsWith(
                    "\\" + "\\" + "." + "\\" + "PhysicalDrive")) {
                this.mymodel.setFirstHardDiskOption("");
                this.myview.changesFirstHardDiskOptionField("");
            }
        } else if (position == 2) {
            if (!choice.isEmpty()) {
                this.mymodel.setSecondHardDiskOption(choice);
                this.myview.changesSecondHardDiskOptionField(choice);
            } else if (this.myview.getSecondHardDiskOption().startsWith(
                    "\\" + "\\" + "." + "\\" + "PhysicalDrive")) {
                this.mymodel.setSecondHardDiskOption("");
                this.myview.changesSecondHardDiskOptionField("");
            }
        } else if (position == 3) {
            if (!choice.isEmpty()) {
                this.mymodel.setThirdHardDiskOption(choice);
                this.myview.changesThirdHardDiskOptionField(choice);
            } else if (this.myview.getThirdHardDiskOption().startsWith(
                    "\\" + "\\" + "." + "\\" + "PhysicalDrive")) {
                this.mymodel.setThirdHardDiskOption("");
                this.myview.changesThirdHardDiskOptionField("");
            }
        } else if (position == 4) {
            if (!choice.isEmpty()) {
                this.mymodel.setFourthHardDiskOption(choice);
                this.myview.changesFourthHardDiskOptionField(choice);
            } else if (this.myview.getFourthHardDiskOption().startsWith(
                    "\\" + "\\" + "." + "\\" + "PhysicalDrive")) {
                this.mymodel.setFourthHardDiskOption("");
                this.myview.changesFourthHardDiskOptionField("");
            }
        }
    }

    public String convertFatReadOnly(String basis) {
        return "fat:" + basis;
    }

    public String convertFatReadWrite(String basis) {
        return "fat:rw:" + basis;
    }
}
