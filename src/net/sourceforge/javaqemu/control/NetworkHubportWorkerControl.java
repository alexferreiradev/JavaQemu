package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.NetworkHubportWorkerModel;
import net.sourceforge.javaqemu.model.NetworkWorkerModel;
import net.sourceforge.javaqemu.view.NetworkHubportWorkerView;

public class NetworkHubportWorkerControl implements ActionListener {

    private NetworkHubportWorkerModel mymodel;
    private NetworkHubportWorkerView myview;

    public NetworkHubportWorkerControl(FileControl myfile,
            NetworkWorkerModel mymodel, int position) {
        this.mymodel = new NetworkHubportWorkerModel(mymodel);
        this.myview = new NetworkHubportWorkerView(myfile, position);
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
            this.myview.getId().setText("");
            this.myview.getHubid().setText("");
            this.mymodel.buildIt(
                    this.myview.getId().getText(),
                    this.myview.getHubid().getText());
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            if (this.myview.getIsEnabled().isSelected()) {
                this.mymodel.buildIt(
                        this.myview.getId().getText(),
                        this.myview.getHubid().getText());
            } else {
                this.myview.getId().setText("");
                this.myview.getHubid().setText("");
                this.mymodel.buildIt(
                        this.myview.getId().getText(),
                        this.myview.getHubid().getText());
            }
            this.myview.setVisible(false);
        }
    }

    public boolean isSelected() {
        return this.myview.getIsEnabled().isSelected();
    }
}
