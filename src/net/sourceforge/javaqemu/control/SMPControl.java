package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.OptionsEnumModel;
import net.sourceforge.javaqemu.model.SMPModel;
import net.sourceforge.javaqemu.model.VMConfigurationModel;
import net.sourceforge.javaqemu.view.SMPView;

public class SMPControl implements ActionListener {

    private SMPView myview;
    private SMPModel mymodel;

    public SMPControl(EmulationControl myemulation, FileControl myfile) {
        this.myview = new SMPView(myfile);
        this.mymodel = new SMPModel(myemulation, myfile);
    }

    public void starts() {
        this.myview.configureStandardMode();
        this.myview.configureListener(this);
    }

    public void change_the_visibility_of_view(Boolean value) {
        this.myview.setVisible(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("eraseButton")) {
            this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SMPOPTION.getValor()]);
            this.myview.getCpuNumbers().setSelectedIndex(0);
            this.myview.getCoreNumbers().setSelectedIndex(0);
            this.myview.getThreadNumbers().setSelectedIndex(0);
            this.myview.getSocketNumbers().setSelectedIndex(0);
            this.myview.getMaxCpuNumbers().setSelectedIndex(0);
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            this.mymodel.buildIt((String) this.myview.getCpuNumbers()
                    .getSelectedItem(), (String) this.myview.getCoreNumbers()
                    .getSelectedItem(), (String) this.myview.getThreadNumbers()
                    .getSelectedItem(), (String) this.myview.getSocketNumbers()
                    .getSelectedItem(), (String) this.myview.getMaxCpuNumbers()
                    .getSelectedItem());
            this.myview.setVisible(false);
        }
    }

}
