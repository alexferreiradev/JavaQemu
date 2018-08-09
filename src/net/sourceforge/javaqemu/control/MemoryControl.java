package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.MemoryModel;
import net.sourceforge.javaqemu.model.OptionsEnumModel;
import net.sourceforge.javaqemu.model.VMConfigurationModel;
import net.sourceforge.javaqemu.view.MemoryView;

public class MemoryControl implements ActionListener {

    private MemoryView myview;
    private MemoryModel mymodel;

    public MemoryControl(EmulationControl myemulation, FileControl myfile) {
        myview = new MemoryView(myfile);
        this.mymodel = new MemoryModel(myemulation, myfile);
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
            this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MEMORYPATHOPTION.getValor()]);
            this.myview.getMemoryPath().setText("");
            this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MEMPREALLOC.getValor()]);
            this.myview.getMemPrealloc().setSelected(false);
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            this.mymodel.buildIt(this.myview.getMemoryPath().getText());
            if (this.myview.getMemPrealloc().isSelected()) {
                this.mymodel.buildIt();
            } else {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MEMPREALLOC.getValor()]);
            }
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("memoryPathChooser")) {
            this.myview
                    .setChoosertitle("Choose a directory as the memory path!");
            this.myview.setFileDescription("Directory - Memory Path");
            if (this.myview.chooseDirectoryForDefaultVMPath()) {
                this.myview.getMemoryPath().setText(this.myview.getChoice());
            }
        }
    }

}
