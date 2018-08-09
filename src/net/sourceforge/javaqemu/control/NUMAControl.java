package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.NUMAModel;
import net.sourceforge.javaqemu.view.NUMAView;

public class NUMAControl implements ActionListener {

    private NUMAView myview;
    private NUMAModel mymodel;

    public NUMAControl(EmulationControl myemulation, FileControl myfile) {
        this.myview = new NUMAView(myfile);
        this.mymodel = new NUMAModel(myemulation, myfile);
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
            for (int i = 0; i < NUMAView.itemNumbers; i++) {
                this.myview.getEnabledOptions()[i].setSelected(false);
                this.myview.getEditor(i).getTextField().setText("");
                this.myview.getCpuLeftNumbers()[i].setSelectedIndex(0);
                this.myview.getCpuRightNumbers()[i].setSelectedIndex(0);
                this.mymodel.buildIt(this.myview.getEditor(i).getTextField()
                        .getText(), (String) this.myview.getCpuLeftNumbers()[i]
                        .getSelectedItem(), (String) this.myview
                        .getCpuRightNumbers()[i].getSelectedItem(), i);
            }
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            for (int i = 0; i < NUMAView.itemNumbers; i++) {
                if (this.myview.getEnabledOptions()[i].isSelected()) {
                    this.mymodel.buildIt(this.myview.getEditor(i)
                            .getTextField().getText(), (String) this.myview
                            .getCpuLeftNumbers()[i].getSelectedItem(),
                            (String) this.myview.getCpuRightNumbers()[i]
                            .getSelectedItem(), i);
                } else {
                    this.myview.getEditor(i).getTextField().setText("");
                    this.myview.getCpuLeftNumbers()[i].setSelectedIndex(0);
                    this.myview.getCpuRightNumbers()[i].setSelectedIndex(0);
                    this.mymodel.buildIt(this.myview.getEditor(i).getTextField()
                            .getText(), (String) this.myview.getCpuLeftNumbers()[i]
                            .getSelectedItem(), (String) this.myview
                            .getCpuRightNumbers()[i].getSelectedItem(), i);
                }
            }
            this.myview.setVisible(false);
        }
    }

}
