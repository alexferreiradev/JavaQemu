package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import net.sourceforge.javaqemu.model.NetworkTCPSocketWorkerModel;
import net.sourceforge.javaqemu.model.NetworkWorkerModel;
import net.sourceforge.javaqemu.view.NetworkTCPSocketWorkerView;

public class NetworkTCPSocketWorkerControl implements ActionListener {

    private NetworkTCPSocketWorkerModel mymodel;
    private NetworkTCPSocketWorkerView myview;
    private Calendar date;

    public NetworkTCPSocketWorkerControl(FileControl myfile,
            NetworkWorkerModel mymodel, int position) {
        this.mymodel = new NetworkTCPSocketWorkerModel(mymodel);
        this.myview = new NetworkTCPSocketWorkerView(myfile, position);
        this.myview.configureListener(this);
        this.myview.configureStandardMode();
        this.date = Calendar.getInstance();
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
            if (!this.myview.getFd().getText().isEmpty()) {
                this.myview.getFd().setText("");
            }
            if (!this.myview.getHostListen().getText().isEmpty()) {
                this.myview.getHostListen().setText("");
            }
            if (!this.myview.getPortListen().getText().isEmpty()) {
                this.myview.getPortListen().setText("");
            }
            if (!this.myview.getHostConnect().getText().isEmpty()) {
                this.myview.getHostConnect().setText("");
            }
            if (!this.myview.getPortConnect().getText().isEmpty()) {
                this.myview.getPortConnect().setText("");
            }
            this.mymodel.buildIt((String) this.myview.getVlan().getSelectedItem(),
                    this.myview.getNameContents().getText(),
                    this.myview.getFd().getText(),
                    this.myview.getHostListen().getText(),
                    this.myview.getPortListen().getText(),
                    this.myview.getHostConnect().getText(),
                    this.myview.getPortConnect().getText());
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            if (this.myview.getIsEnabled().isSelected()) {
                this.mymodel.buildIt((String) this.myview.getVlan().getSelectedItem(),
                        this.myview.getNameContents().getText(),
                        this.myview.getFd().getText(),
                        this.myview.getHostListen().getText(),
                        this.myview.getPortListen().getText(),
                        this.myview.getHostConnect().getText(),
                        this.myview.getPortConnect().getText());
                this.date = Calendar.getInstance();
            } else {
                if (this.myview.getVlan().getSelectedIndex() != 0) {
                    this.myview.getVlan().setSelectedIndex(0);
                }
                if (!this.myview.getNameContents().getText().isEmpty()) {
                    this.myview.getNameContents().setText("");
                }
                if (!this.myview.getFd().getText().isEmpty()) {
                    this.myview.getFd().setText("");
                }
                if (!this.myview.getHostListen().getText().isEmpty()) {
                    this.myview.getHostListen().setText("");
                }
                if (!this.myview.getPortListen().getText().isEmpty()) {
                    this.myview.getPortListen().setText("");
                }
                if (!this.myview.getHostConnect().getText().isEmpty()) {
                    this.myview.getHostConnect().setText("");
                }
                if (!this.myview.getPortConnect().getText().isEmpty()) {
                    this.myview.getPortConnect().setText("");
                }
                this.mymodel.buildIt((String) this.myview.getVlan().getSelectedItem(),
                        this.myview.getNameContents().getText(),
                        this.myview.getFd().getText(),
                        this.myview.getHostListen().getText(),
                        this.myview.getPortListen().getText(),
                        this.myview.getHostConnect().getText(),
                        this.myview.getPortConnect().getText());
            }
            this.myview.setVisible(false);
        }
    }

    public void cleanMe() {
        if (this.myview.getIsEnabled().isSelected()) {
            this.myview.getIsEnabled().setSelected(false);
        }
    }

    public Calendar getDate() {
        return date;
    }

    public boolean isSelected() {
        return this.myview.getIsEnabled().isSelected();
    }
}
