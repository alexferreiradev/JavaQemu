package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.ImageModel;
import net.sourceforge.javaqemu.model.OptionsEnumModel;
import net.sourceforge.javaqemu.model.VMConfigurationModel;
import net.sourceforge.javaqemu.view.ImageView;

public class ImageControl implements ActionListener {

    private ImageModel mymodel;
    private ImageView myview;

    public ImageControl(EmulationControl myemulation, FileControl myfile) {
        this.mymodel = new ImageModel(myemulation, myfile);
        this.myview = new ImageView(myfile);
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
            this.myview.getMtdblock().setText("");
            this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MTDBLOCKOPTION.getValor()]);

            this.myview.getSd().setText("");
            this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SDOPTION.getValor()]);

            this.myview.getPflash().setText("");
            this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.PFLASHOPTION.getValor()]);
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            if (!this.myview.getMtdblock().getText().isEmpty()) {
                this.mymodel.setMtdblock(this.myview.getMtdblock().getText());
                this.mymodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MTDBLOCKOPTION.getValor()]);
            } else {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MTDBLOCKOPTION.getValor()]);
            }
            if (!this.myview.getSd().getText().isEmpty()) {
                this.mymodel.setSd(this.myview.getSd().getText());
                this.mymodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SDOPTION.getValor()]);
            } else {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SDOPTION.getValor()]);
            }
            if (!this.myview.getPflash().getText().isEmpty()) {
                this.mymodel.setPflash(this.myview.getPflash().getText());
                this.mymodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.PFLASHOPTION.getValor()]);
            } else {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.PFLASHOPTION.getValor()]);
            }
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("mtdblockChooser")) {
            this.myview.setChoosertitle("Choose a file as the on-board Flash memory image!");
            this.myview.setFileDescription("File - on-board Flash memory image");
            if (this.myview.chooseAnyFile()) {
                this.myview.getMtdblock().setText(this.myview.getChoice());
            }
        } else if (e.getActionCommand().equals("sdChooser")) {
            this.myview.setChoosertitle("Choose a file as the SecureDigital card image!");
            this.myview.setFileDescription("File - SecureDigital card image");
            if (this.myview.chooseAnyFile()) {
                this.myview.getSd().setText(this.myview.getChoice());
            }
        } else if (e.getActionCommand().equals("pflashChooser")) {
            this.myview.setChoosertitle("Choose a file as the parallel flash image!");
            this.myview.setFileDescription("File - parallel flash image");
            if (this.myview.chooseAnyFile()) {
                this.myview.getPflash().setText(this.myview.getChoice());
            }
        }
    }

}
