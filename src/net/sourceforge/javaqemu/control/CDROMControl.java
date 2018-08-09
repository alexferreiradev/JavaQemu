package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.CDROMModel;
import net.sourceforge.javaqemu.view.CDROMView;

public class CDROMControl implements ActionListener {

    private CDROMModel mymodel;
    private CDROMView myview;
    private FileControl myfile;

    public CDROMControl(EmulationControl myemulation, FileControl myfile) {
        this.mymodel = new CDROMModel(myemulation, myfile);
        this.myview = new CDROMView(myfile);
        this.myfile = myfile;
        if (myfile.getMymodel().getCdrom() != null) {
            this.mymodel.setCdromOption(this.myview.getCdromText()
                    .getText(), "");
        }
    }

    public void starts() {
        this.myview.configureListener(this);
        this.myview.configureStandardMode();
    }

    public void change_my_visibility(Boolean value) {
        this.myview.setVisible(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("eraseButton")) {
            if (!this.myview.getCdromText().getText().isEmpty()) {
                this.myview.getCdromText().setText("");
            }

            this.mymodel.setCdromOption("", "image");
            this.myfile.getMymodel().setCdrom("");

            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            if (!this.myview.getCdromText().getText()
                    .equals(this.myview.getChoice())) {
                this.mymodel.setCdromOption(this.myview.getCdromText()
                        .getText(), "");
                this.myfile.getMymodel().setCdrom(
                        this.myview.getCdromText().getText());
            }
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("cdromDriveSelection")) {
            if (this.myview.chooseCDROMDrives()) {
                this.myview.getCdromText().setText(this.myview.getChoice());
                this.mymodel.setCdromOption(this.myview.getChoice(), "drive");
                this.myfile.getMymodel().setCdrom(this.myview.getChoice());
            }
        } else if (e.getActionCommand().equals("diskImageSelection")) {
            if (this.myview.chooseCDROMFiles()) {
                this.myview.getCdromText().setText(this.myview.getChoice());
                this.mymodel.setCdromOption(this.myview.getChoice(), "image");
                this.myfile.getMymodel().setCdrom(this.myview.getChoice());
            }
        }
    }
}
