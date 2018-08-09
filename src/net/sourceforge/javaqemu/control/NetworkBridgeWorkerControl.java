package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.NetworkBridgeWorkerModel;
import net.sourceforge.javaqemu.model.NetworkWorkerModel;
import net.sourceforge.javaqemu.view.NetworkBridgeWorkerView;

public class NetworkBridgeWorkerControl implements ActionListener {

    private NetworkBridgeWorkerView myview;
    private NetworkBridgeWorkerModel mymodel;

    public NetworkBridgeWorkerControl(FileControl myfile,
            NetworkWorkerModel mymodel, int position) {
        this.myview = new NetworkBridgeWorkerView(myfile, position);
        this.mymodel = new NetworkBridgeWorkerModel(mymodel);
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
            if (!this.myview.getBridgeDevice().getText().isEmpty()) {
                this.myview.getBridgeDevice().setText("");
            }
            if (!this.myview.getHelper().getText().isEmpty()) {
                this.myview.getHelper().setText("");
            }
            this.mymodel.buildIt((String) this.myview.getVlan()
                    .getSelectedItem(),
                    this.myview.getNameContents().getText(), this.myview
                    .getBridgeDevice().getText(), this.myview
                    .getHelper().getText());
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            if (this.myview.getIsEnabled().isSelected()) {
                this.mymodel.buildIt((String) this.myview.getVlan()
                        .getSelectedItem(), this.myview.getNameContents()
                        .getText(), this.myview.getBridgeDevice().getText(),
                        this.myview.getHelper().getText());
            } else {
                if (this.myview.getVlan().getSelectedIndex() != 0) {
                    this.myview.getVlan().setSelectedIndex(0);
                }
                if (!this.myview.getNameContents().getText().isEmpty()) {
                    this.myview.getNameContents().setText("");
                }
                if (!this.myview.getBridgeDevice().getText().isEmpty()) {
                    this.myview.getBridgeDevice().setText("");
                }
                if (!this.myview.getHelper().getText().isEmpty()) {
                    this.myview.getHelper().setText("");
                }
                this.mymodel.buildIt((String) this.myview.getVlan()
                        .getSelectedItem(),
                        this.myview.getNameContents().getText(), this.myview
                        .getBridgeDevice().getText(), this.myview
                        .getHelper().getText());
            }
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("helperChooser")) {
            this.myview
                    .setChoosertitle("Choose the network helper to configure the TAP interface!");
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
