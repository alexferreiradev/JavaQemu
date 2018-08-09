package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import net.sourceforge.javaqemu.model.CPUModel;
import net.sourceforge.javaqemu.view.CPUIDFlagView;
import net.sourceforge.javaqemu.view.CPUView;
import net.sourceforge.javaqemu.view.UtilitiesView;

public class CPUControl implements ActionListener {

    private CPUModel mymodel;
    private CPUView mycpumodelview;
    private CPUIDFlagView mycpuidflagview;
    private FileControl myfile;

    public CPUControl(EmulationControl myemulation, FileControl myfile) {
        this.mymodel = new CPUModel(myemulation);
        this.mycpumodelview = new CPUView(myfile);
        this.mycpuidflagview = new CPUIDFlagView(myfile);
        this.myfile = myfile;
    }

    public void starts() {
        this.mycpumodelview.configureListener(this);
        this.mycpumodelview.configureStandardMode();
        this.mycpuidflagview.configureListener(this);
        this.mycpuidflagview.configureStandardMode();
        if (this.mycpuidflagview.getLoaded() || this.mycpumodelview.getLoaded()) {
            this.mymodel.buildCPUModel(this.mycpumodelview.getCpuModels());
            DefaultListModel<String> model = (DefaultListModel<String>) this.mycpuidflagview.getSelectedList().getModel();
            String[] result = new String[model.size()];
            for (int i = 0; i < model.size(); i++) {
                result[i] = model.getElementAt(i);
            }
            this.mymodel.buildCPUIDFlags(result);
            this.mymodel.buildIt();
        }
    }

    public void change_the_visibility_of_model_view(Boolean value) {
        this.mycpumodelview.setVisible(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("eraseButton")) {
            if (this.mycpumodelview.getCpuModels().getSelectedIndex() != 0) {
                this.mycpumodelview.getCpuModels().setSelectedIndex(0);
            }
            this.mymodel.buildCPUModel(this.mycpumodelview.getCpuModels());
            this.mymodel.buildIt();
            this.myfile.getMymodel().setCpuModel(this.mymodel.getCpuModel());
            this.mycpumodelview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            this.mymodel.buildCPUModel(this.mycpumodelview.getCpuModels());
            this.mymodel.buildIt();
            this.myfile.getMymodel().setCpuModel(this.mymodel.getCpuModel());
            this.mycpumodelview.setVisible(false);
        } else if (e.getActionCommand().equals("showsFlagButton")) {
            this.mycpuidflagview.setVisible(true);
        } else if (e.getActionCommand().equals("eraseButton2")) {
            DefaultListModel<String> model = (DefaultListModel<String>) this.mycpuidflagview.getSelectedList().getModel();
            int selectedIndex = this.mycpuidflagview.getSelectedList().getSelectedIndex();
            if (selectedIndex != -1) {
                model.remove(selectedIndex);
                String[] result = new String[model.size()];
                for (int i = 0; i < model.size(); i++) {
                    result[i] = model.getElementAt(i);
                }
                this.mymodel.buildCPUIDFlags(result);
                this.mymodel.buildIt();
                this.myfile.getMymodel().setCpuidFlags(this.mymodel.getCpuidFlags());
            }
        } else if (e.getActionCommand().equals("okButton2")) {
            this.mycpuidflagview.setVisible(false);
        } else if (e.getActionCommand().equals("addButton")) {
            DefaultListModel<String> model = (DefaultListModel<String>) this.mycpuidflagview.getSelectedList().getModel();
            if (!model.contains(this.mycpuidflagview.getAvailableList().getSelectedItem().toString())) {
                model.addElement(this.mycpuidflagview.getAvailableList().getSelectedItem().toString());
                String[] result = new String[model.size()];
                for (int i = 0; i < model.size(); i++) {
                    result[i] = model.getElementAt(i);
                }
                this.mymodel.buildCPUIDFlags(result);
                this.mymodel.buildIt();
                this.myfile.getMymodel().setCpuidFlags(this.mymodel.getCpuidFlags());
            } else {
                UtilitiesView.showMessageAnywhere("This element already is added to the list.");
            }
        } else if (e.getActionCommand().equals("eraseAllButton")) {
            DefaultListModel<String> model = (DefaultListModel<String>) this.mycpuidflagview.getSelectedList().getModel();
            model.removeAllElements();
            String[] result = new String[1];
            result[0] = "";

            this.mymodel.buildCPUIDFlags(result);
            this.mymodel.buildIt();
            this.myfile.getMymodel().setCpuidFlags(this.mymodel.getCpuidFlags());
            this.mycpuidflagview.setVisible(false);
        } else if (e.getActionCommand().equals("findButton")) {
            DefaultListModel<String> model = (DefaultListModel<String>) this.mycpuidflagview.getSelectedList().getModel();
            if (!model.contains(this.mycpuidflagview.getAvailableList()
                    .getSelectedItem().toString())) {
                UtilitiesView
                        .showMessageAnywhere("The list doesn't contain the element: "
                                + this.mycpuidflagview.getAvailableList()
                                .getSelectedItem().toString() + ".");
            } else {
                UtilitiesView
                        .showMessageAnywhere("The list contains the element: "
                                + this.mycpuidflagview.getAvailableList()
                                .getSelectedItem().toString() + ".");
            }
        }
    }
}
