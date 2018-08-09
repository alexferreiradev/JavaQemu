package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import net.sourceforge.javaqemu.model.NetworkUserWorkerModel;
import net.sourceforge.javaqemu.model.NetworkWorkerModel;
import net.sourceforge.javaqemu.view.NetworkUserWorkerView;

public class NetworkUserWorkerControl implements ActionListener {

    private NetworkUserWorkerView myview;
    private NetworkUserWorkerModel mymodel;
    private NetworkDnssearchUserWorkerControl mydnssearchcontrol;
    private NetworkGuestfwdUserWorkerControl myguestfwdcontrol;
    private NetworkHostfwdUserWorkerControl myhostfwdcontrol;

    public NetworkUserWorkerControl(FileControl myfile,
            NetworkWorkerModel mymodel, int position) {
        this.myview = new NetworkUserWorkerView(myfile, position);
        this.mymodel = new NetworkUserWorkerModel(mymodel);
        this.myview.configureListener(this);
        this.myview.configureStandardMode();
        this.mydnssearchcontrol = new NetworkDnssearchUserWorkerControl(myfile, position);
        this.myguestfwdcontrol = new NetworkGuestfwdUserWorkerControl(myfile, position);
        this.myhostfwdcontrol = new NetworkHostfwdUserWorkerControl(myfile, position);
    }

    public void change_my_visibility(boolean value) {
        this.myview.setVisible(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("eraseButton")) {
            if (this.myview.getIsEnabled().isSelected()) {
                this.myview.getIsEnabled().setSelected(false);
            }
            if (this.myview.getVlan().getSelectedIndex() != 0) {
                this.myview.getVlan().setSelectedIndex(0);
            }
            if (!this.myview.getNameContents().getText().isEmpty()) {
                this.myview.getNameContents().setText("");
            }
            if (!this.myview.getNet().getText().isEmpty()) {
                this.myview.getNet().setText("");
            }
            if (!this.myview.getHost().getText().isEmpty()) {
                this.myview.getHost().setText("");
            }
            if (this.myview.getRestrict().isSelected()) {
                this.myview.getRestrict().setSelected(false);
            }
            if (!this.myview.getHostname().getText().isEmpty()) {
                this.myview.getHostname().setText("");
            }
            if (!this.myview.getDhcpstart().getText().isEmpty()) {
                this.myview.getDhcpstart().setText("");
            }
            if (!this.myview.getDns().getText().isEmpty()) {
                this.myview.getDns().setText("");
            }
            if (!this.myview.getTftp().getText().isEmpty()) {
                this.myview.getTftp().setText("");
            }
            if (!this.myview.getBootfile().getText().isEmpty()) {
                this.myview.getBootfile().setText("");
            }
            if (!this.myview.getSmb().getText().isEmpty()) {
                this.myview.getSmb().setText("");
            }
            if (!this.myview.getSmbserver().getText().isEmpty()) {
                this.myview.getSmbserver().setText("");
            }
            this.mymodel.buildIt((String) this.myview.getVlan().getSelectedItem(),
                    this.myview.getNameContents().getText(),
                    this.myview.getNet().getText(),
                    this.myview.getHost().getText(),
                    this.myview.getRestrict().isSelected(),
                    this.myview.getHostname().getText(),
                    this.myview.getDhcpstart().getText(),
                    this.myview.getDns().getText(),
                    new ArrayList<String>(),
                    this.myview.getTftp().getText(),
                    this.myview.getBootfile().getText(),
                    this.myview.getSmb().getText(),
                    this.myview.getSmbserver().getText(),
                    new ArrayList<String>(),
                    new ArrayList<String>());
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            if (this.myview.getIsEnabled().isSelected()) {
                this.mymodel.buildIt((String) this.myview.getVlan().getSelectedItem(),
                        this.myview.getNameContents().getText(),
                        this.myview.getNet().getText(),
                        this.myview.getHost().getText(),
                        this.myview.getRestrict().isSelected(),
                        this.myview.getHostname().getText(),
                        this.myview.getDhcpstart().getText(),
                        this.myview.getDns().getText(),
                        this.mydnssearchcontrol.getMyResults(),
                        this.myview.getTftp().getText(),
                        this.myview.getBootfile().getText(),
                        this.myview.getSmb().getText(),
                        this.myview.getSmbserver().getText(),
                        this.myhostfwdcontrol.getMyResults(),
                        this.myguestfwdcontrol.getMyResults());
            } else {
                if (this.myview.getVlan().getSelectedIndex() != 0) {
                    this.myview.getVlan().setSelectedIndex(0);
                }
                if (!this.myview.getNameContents().getText().isEmpty()) {
                    this.myview.getNameContents().setText("");
                }
                if (!this.myview.getNet().getText().isEmpty()) {
                    this.myview.getNet().setText("");
                }
                if (!this.myview.getHost().getText().isEmpty()) {
                    this.myview.getHost().setText("");
                }
                if (this.myview.getRestrict().isSelected()) {
                    this.myview.getRestrict().setSelected(false);
                }
                if (!this.myview.getHostname().getText().isEmpty()) {
                    this.myview.getHostname().setText("");
                }
                if (!this.myview.getDhcpstart().getText().isEmpty()) {
                    this.myview.getDhcpstart().setText("");
                }
                if (!this.myview.getDns().getText().isEmpty()) {
                    this.myview.getDns().setText("");
                }
                if (!this.myview.getTftp().getText().isEmpty()) {
                    this.myview.getTftp().setText("");
                }
                if (!this.myview.getBootfile().getText().isEmpty()) {
                    this.myview.getBootfile().setText("");
                }
                if (!this.myview.getSmb().getText().isEmpty()) {
                    this.myview.getSmb().setText("");
                }
                if (!this.myview.getSmbserver().getText().isEmpty()) {
                    this.myview.getSmbserver().setText("");
                }
                this.mymodel.buildIt((String) this.myview.getVlan().getSelectedItem(),
                        this.myview.getNameContents().getText(),
                        this.myview.getNet().getText(),
                        this.myview.getHost().getText(),
                        this.myview.getRestrict().isSelected(),
                        this.myview.getHostname().getText(),
                        this.myview.getDhcpstart().getText(),
                        this.myview.getDns().getText(),
                        new ArrayList<String>(),
                        this.myview.getTftp().getText(),
                        this.myview.getBootfile().getText(),
                        this.myview.getSmb().getText(),
                        this.myview.getSmbserver().getText(),
                        new ArrayList<String>(),
                        new ArrayList<String>());
            }
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("dnssearch")) {
            this.mydnssearchcontrol.change_my_visibility(true);
        } else if (e.getActionCommand().equals("tftpChooser")) {
            this.myview.setChoosertitle("Choose a directory as the root directory of the built-in TFTP server!");
            this.myview.setFileDescription("Directory - root of the TFTP server");
            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.myview.getTftp().setText(this.myview.getChoice());
            }
        } else if (e.getActionCommand().equals("bootfileChooser")) {
            this.myview.setChoosertitle("Choose a file as the BOOTP filename for broadcasting!");
            this.myview.setFileDescription("File - BOOTP filename");
            if (this.myview.chooseAnyFile()) {
                this.myview.getBootfile().setText(this.myview.getChoice());
            }
        } else if (e.getActionCommand().equals("smbChooser")) {
            this.myview.setChoosertitle("Choose a directory as the root directory of the built-in SMB server!");
            this.myview.setFileDescription("Directory - root of the SMB server");
            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.myview.getSmb().setText(this.myview.getChoice());
            }
        } else if (e.getActionCommand().equals("hostfwd")) {
            this.myhostfwdcontrol.change_my_visibility(true);
        } else if (e.getActionCommand().equals("guestfwd")) {
            this.myguestfwdcontrol.change_my_visibility(true);
        }
    }

    public void cleanMe() {
        if (this.myview.getIsEnabled().isSelected()) {
            this.myview.getIsEnabled().setSelected(false);
        }
    }

    public boolean isSelected() {
        return this.myview.getIsEnabled().isSelected();
    }
}
