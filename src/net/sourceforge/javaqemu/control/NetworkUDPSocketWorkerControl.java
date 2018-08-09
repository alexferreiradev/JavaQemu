package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import net.sourceforge.javaqemu.model.NetworkUDPSocketWorkerModel;
import net.sourceforge.javaqemu.model.NetworkWorkerModel;
import net.sourceforge.javaqemu.view.NetworkUDPSocketWorkerView;

public class NetworkUDPSocketWorkerControl implements ActionListener {

    private NetworkUDPSocketWorkerView myview;
    private NetworkUDPSocketWorkerModel mymodel;
    private Calendar date;

    public NetworkUDPSocketWorkerControl(FileControl myfile,
            NetworkWorkerModel mymodel, int position) {
        this.mymodel = new NetworkUDPSocketWorkerModel(mymodel);
        this.myview = new NetworkUDPSocketWorkerView(myfile, position);
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
            if (!this.myview.getMulticastAddress().getText().isEmpty()) {
                this.myview.getMulticastAddress().setText("");
            }
            if (!this.myview.getMulticastPort().getText().isEmpty()) {
                this.myview.getMulticastPort().setText("");
            }
            if (!this.myview.getLocalAddress().getText().isEmpty()) {
                this.myview.getLocalAddress().setText("");
            }
            this.mymodel.buildIt((String) this.myview.getVlan().getSelectedItem(),
                    this.myview.getNameContents().getText(),
                    this.myview.getFd().getText(),
                    this.myview.getMulticastAddress().getText(),
                    this.myview.getMulticastPort().getText(),
                    this.myview.getLocalAddress().getText());
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            if (this.myview.getIsEnabled().isSelected()) {
                this.mymodel.buildIt((String) this.myview.getVlan().getSelectedItem(),
                        this.myview.getNameContents().getText(),
                        this.myview.getFd().getText(),
                        this.myview.getMulticastAddress().getText(),
                        this.myview.getMulticastPort().getText(),
                        this.myview.getLocalAddress().getText());
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
                if (!this.myview.getMulticastAddress().getText().isEmpty()) {
                    this.myview.getMulticastAddress().setText("");
                }
                if (!this.myview.getMulticastPort().getText().isEmpty()) {
                    this.myview.getMulticastPort().setText("");
                }
                if (!this.myview.getLocalAddress().getText().isEmpty()) {
                    this.myview.getLocalAddress().setText("");
                }
                this.mymodel.buildIt((String) this.myview.getVlan().getSelectedItem(),
                        this.myview.getNameContents().getText(),
                        this.myview.getFd().getText(),
                        this.myview.getMulticastAddress().getText(),
                        this.myview.getMulticastPort().getText(),
                        this.myview.getLocalAddress().getText());
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
