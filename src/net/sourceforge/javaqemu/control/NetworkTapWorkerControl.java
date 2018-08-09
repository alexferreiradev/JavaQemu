package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.NetworkTapWorkerModel;
import net.sourceforge.javaqemu.model.NetworkWorkerModel;
import net.sourceforge.javaqemu.view.NetworkTapWorkerView;

public class NetworkTapWorkerControl implements ActionListener {

    private NetworkTapWorkerView myview;
    private NetworkTapWorkerModel mymodel;

    public NetworkTapWorkerControl(FileControl myfile,
            NetworkWorkerModel mymodel, int position) {
        this.myview = new NetworkTapWorkerView(myfile, position);
        this.mymodel = new NetworkTapWorkerModel(mymodel);
        this.myview.configureListener(this);
        this.myview.configureStandardMode();
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
            if (!this.myview.getScript().getText().isEmpty()) {
                this.myview.getScript().setText("");
            }
            if (!this.myview.getDownscript().getText().isEmpty()) {
                this.myview.getDownscript().setText("");
            }
            if (!this.myview.getHelper().getText().isEmpty()) {
                this.myview.getHelper().setText("");
            }
            this.mymodel.buildIt((String) this.myview.getVlan().getSelectedItem(),
                    this.myview.getNameContents().getText(),
                    this.myview.getFd().getText(),
                    this.myview.getScript().getText(),
                    this.myview.getDownscript().getText(),
                    this.myview.getHelper().getText());
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            if (this.myview.getIsEnabled().isSelected()) {
                this.mymodel.buildIt((String) this.myview.getVlan().getSelectedItem(),
                        this.myview.getNameContents().getText(),
                        this.myview.getFd().getText(),
                        this.myview.getScript().getText(),
                        this.myview.getDownscript().getText(),
                        this.myview.getHelper().getText());
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
                if (!this.myview.getScript().getText().isEmpty()) {
                    this.myview.getScript().setText("");
                }
                if (!this.myview.getDownscript().getText().isEmpty()) {
                    this.myview.getDownscript().setText("");
                }
                if (!this.myview.getHelper().getText().isEmpty()) {
                    this.myview.getHelper().setText("");
                }
                this.mymodel.buildIt((String) this.myview.getVlan().getSelectedItem(),
                        this.myview.getNameContents().getText(),
                        this.myview.getFd().getText(),
                        this.myview.getScript().getText(),
                        this.myview.getDownscript().getText(),
                        this.myview.getHelper().getText());
            }
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("scriptChooser")) {
            this.myview.setChoosertitle("Choose the network configure script file!");
            this.myview.setFileDescription("File - Network configure script file");
            if (this.myview.chooseAnyFile()) {
                this.myview.getScript().setText(this.myview.getChoice());
            }
        } else if (e.getActionCommand().equals("downscriptChooser")) {
            this.myview.setChoosertitle("Choose the network deconfigure script file!");
            this.myview.setFileDescription("File - Network deconfigure script file");
            if (this.myview.chooseAnyFile()) {
                this.myview.getDownscript().setText(this.myview.getChoice());
            }
        } else if (e.getActionCommand().equals("helperChooser")) {
            this.myview.setChoosertitle("Choose the network helper to configure the TAP interface!");
            this.myview.setFileDescription("File - Network helper");
            if (this.myview.chooseAnyFile()) {
                this.myview.getHelper().setText(this.myview.getChoice());
            }
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
