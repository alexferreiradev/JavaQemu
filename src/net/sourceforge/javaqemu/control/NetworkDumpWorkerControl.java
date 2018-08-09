package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.NetworkDumpWorkerModel;
import net.sourceforge.javaqemu.model.NetworkWorkerModel;
import net.sourceforge.javaqemu.view.NetworkDumpWorkerView;

public class NetworkDumpWorkerControl implements ActionListener {

    private NetworkDumpWorkerModel mymodel;
    private NetworkDumpWorkerView myview;

    public NetworkDumpWorkerControl(FileControl myfile,
            NetworkWorkerModel mymodel, int position) {
        this.mymodel = new NetworkDumpWorkerModel(mymodel);
        this.myview = new NetworkDumpWorkerView(myfile, position);
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
            if (!this.myview.getFile().getText().isEmpty()) {
                this.myview.getFile().setText("");
            }
            if (!this.myview.getLen().getText().isEmpty()) {
                this.myview.getLen().setText("");
            }
            this.mymodel.buildIt((String) this.myview.getVlan().getSelectedItem(),
                    this.myview.getFile().getText(),
                    this.myview.getLen().getText());
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            if (this.myview.getIsEnabled().isSelected()) {
                this.mymodel.buildIt((String) this.myview.getVlan().getSelectedItem(),
                        this.myview.getFile().getText(),
                        this.myview.getLen().getText());
            } else {
                if (this.myview.getVlan().getSelectedIndex() != 0) {
                    this.myview.getVlan().setSelectedIndex(0);
                }
                if (!this.myview.getFile().getText().isEmpty()) {
                    this.myview.getFile().setText("");
                }
                if (!this.myview.getLen().getText().isEmpty()) {
                    this.myview.getLen().setText("");
                }
                this.mymodel.buildIt((String) this.myview.getVlan().getSelectedItem(),
                        this.myview.getFile().getText(),
                        this.myview.getLen().getText());
            }
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("fileChooser")) {
            this.myview.setChoosertitle("Choose the file!");
            this.myview.setFileDescription("File");
            if (this.myview.chooseAnyFile()) {
                this.myview.getFile().setText(this.myview.getChoice());
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
