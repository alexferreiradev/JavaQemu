package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.PhysicalDriveModel;
import net.sourceforge.javaqemu.view.PhysicalDriveView;

public class PhysicalDriveControl implements ActionListener {

    private PhysicalDriveView myview;
    private PhysicalDriveModel mymodel;
    private HardDiskControl myhd;
    private int position;

    public PhysicalDriveControl(HardDiskControl myhd, FileControl myfile, int position) {
        this.myview = new PhysicalDriveView(myfile, position);
        this.myview.configureListener(this);
        this.myview.configureStandardMode();
        this.mymodel = new PhysicalDriveModel();
        this.myhd = myhd;
        this.position = position;
    }

    public void change_my_visibility(boolean value) {
        this.myview.setVisible(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("cancelButton")) {
            this.mymodel.unsetOption();
            this.myhd.setPhysicalDriveChoice(position, this.mymodel.getOption());
            this.change_my_visibility(false);
        } else if (e.getActionCommand().equals("okButton")) {
            this.mymodel.setOption((String) this.myview.getPhysicalDriveNumber().getSelectedItem());
            this.myhd.setPhysicalDriveChoice(position, this.mymodel.getOption());
            this.change_my_visibility(false);
        }
    }
}
