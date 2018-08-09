package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.KernelBootModel;
import net.sourceforge.javaqemu.model.OptionsEnumModel;
import net.sourceforge.javaqemu.model.VMConfigurationModel;
import net.sourceforge.javaqemu.view.SpecificBootView;

public class SpecificBootControl implements ActionListener {

    private SpecificBootView myview;
    private KernelBootModel mykernel;

    public SpecificBootControl(EmulationControl myemulation, FileControl myfile) {
        this.myview = new SpecificBootView(myfile);
        this.myview.configureListener(this);
        this.myview.configureStandardMode();
        this.mykernel = new KernelBootModel(myemulation, myfile);
    }

    public void change_my_visibility(boolean value) {
        this.myview.setVisible(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("eraseButton")) {
            if (!this.myview.getKernel().getText().isEmpty()) {
                this.myview.getKernel().setText("");
            }
            this.mykernel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.KERNELBOOTOPTION.getValor()]);
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            if (!this.myview.getKernel().getText().isEmpty()) {
                this.mykernel.setOption(this.myview.getKernel().getText());
            } else {
                this.mykernel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.KERNELBOOTOPTION.getValor()]);
            }
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("chooseKernel")) {
            this.myview.setChoosertitle("Choose a file as kernel image!");
            this.myview.setFileDescription("File - Kernel Image");
            if (this.myview.chooseAnyFile()) {
                this.myview.getKernel().setText(this.myview.getChoice());
            }
        }
    }

}
