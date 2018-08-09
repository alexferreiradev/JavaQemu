package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.AdvancedOptionsModel;
import net.sourceforge.javaqemu.model.OptionsEnumModel;
import net.sourceforge.javaqemu.model.VMConfigurationModel;
import net.sourceforge.javaqemu.view.AdvancedOptionsView;
import net.sourceforge.javaqemu.view.View;

public class AdvancedOptionsControl implements ActionListener {

    private AdvancedOptionsModel mymodel;
    private AdvancedOptionsView myview;
    private View myMainView;

    public AdvancedOptionsControl(EmulationControl myemulation,
            FileControl myfile, View myView) {
        this.myview = new AdvancedOptionsView(myfile);
        this.myview.configureListener(this);
        this.myview.configureStandardMode();
        this.mymodel = new AdvancedOptionsModel(myemulation, myfile);
        this.myMainView = myView;
    }

    public void change_my_visibility(boolean value) {
        /*
		 http://stackoverflow.com/questions/17305584/textfield-not-updating-dynamically
         */
        if (value) {
            this.myview.getNameContents().setText(this.myMainView.getActiveTitle());
            this.myview.getNameContents().repaint();
        }
        this.myview.setVisible(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("eraseButton")) {
            this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.WIN2KHACKOPTION.getValor()]);
            this.myview.getWin2kHackOption().setSelected(false);

            this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOACPIOPTION.getValor()]);
            this.myview.getNoAcpiOption().setSelected(false);

            this.myview.getNameContents().setText("");
            this.myview.getNameContents().repaint();
            this.myMainView.changeNameJPanel("");
            this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NAMEOPTION.getValor()]);

            this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SNAPSHOTOPTION.getValor()]);
            this.myview.getSnapshotOption().setSelected(false);

            this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOFDBOOTCHKOPTION.getValor()]);
            this.myview.getNoFdBootchkOption().setSelected(false);

            this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOHPETOPTION.getValor()]);
            this.myview.getNoHpetOption().setSelected(false);

            this.change_my_visibility(false);
        } else if (e.getActionCommand().equals("okButton")) {

            if (this.myview.getWin2kHackOption().isSelected()) {
                this.mymodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.WIN2KHACKOPTION.getValor()]);
            } else {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.WIN2KHACKOPTION.getValor()]);
            }

            if (this.myview.getNoAcpiOption().isSelected()) {
                this.mymodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOACPIOPTION.getValor()]);
            } else {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOACPIOPTION.getValor()]);
            }

            if (!this.myview.getNameContents().getText().isEmpty()) {
                this.mymodel.setName(this.myview.getNameContents().getText());
                this.myMainView.changeNameJPanel(this.myview.getNameContents().getText());
                this.mymodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NAMEOPTION.getValor()]);
            } else {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NAMEOPTION.getValor()]);
            }

            if (this.myview.getSnapshotOption().isSelected()) {
                this.mymodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SNAPSHOTOPTION.getValor()]);
            } else {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SNAPSHOTOPTION.getValor()]);
            }

            if (this.myview.getNoFdBootchkOption().isSelected()) {
                this.mymodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOFDBOOTCHKOPTION.getValor()]);
            } else {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOFDBOOTCHKOPTION.getValor()]);
            }

            if (this.myview.getNoHpetOption().isSelected()) {
                this.mymodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOHPETOPTION.getValor()]);
            } else {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOHPETOPTION.getValor()]);
            }
            this.change_my_visibility(false);
        }
    }
}
