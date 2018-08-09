package net.sourceforge.javaqemu.control;

import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import net.sourceforge.javaqemu.model.OptionsEnumModel;
import net.sourceforge.javaqemu.model.VMCreationModel;
import net.sourceforge.javaqemu.view.VMCreationViewEnd;
import net.sourceforge.javaqemu.view.VMCreationViewPart1;
import net.sourceforge.javaqemu.view.VMCreationViewPart2;
import net.sourceforge.javaqemu.view.VMCreationViewPart3;
import net.sourceforge.javaqemu.view.View;

public class VMCreationControl implements ActionListener {

    private VMCreationViewPart1 myfirstview;

    private VMCreationViewPart2 mysecondview;

    private VMCreationViewPart3 mythirdview;

    private VMCreationViewEnd mylastview;

    private VMCreationModel mymodel;

    private DiskCreationControl mydisk;

    private FileControl myfile;

    private View view;

    private EmulationControl myemulation;

    private VMOpeningControl myopening;

    private List<VMConfigurationControl> myvmcontrol;

    public VMCreationControl(DiskCreationControl mydisk, String pathQemu_img,
            String default_virtual_machines_path, View view, FileControl file,
            EmulationControl myemulation,
            List<VMConfigurationControl> myvmcontrol) {
        this.myfirstview = new VMCreationViewPart1();
        this.myfirstview.setVisible(true);
        this.myfirstview.configureListener(this);
        this.myfirstview.configureStandardMode();

        this.mymodel = new VMCreationModel();
        this.mymodel.setQemu_imgPath(pathQemu_img);

        this.mysecondview = new VMCreationViewPart2(
                default_virtual_machines_path,
                this.mymodel.checks_extension(default_virtual_machines_path));
        this.mysecondview.setVisible(false);
        this.mysecondview.configureListener(this);
        this.mysecondview.configureStandardMode();

        this.mythirdview = new VMCreationViewPart3();
        this.mythirdview.setVisible(false);
        this.mythirdview.configureListener(this);
        this.mythirdview.configureStandardMode();

        this.mylastview = new VMCreationViewEnd();
        this.mylastview.setVisible(false);
        this.mylastview.configureListener(this);
        this.mylastview.configureStandardMode();

        this.mydisk = mydisk;
        this.view = view;

        this.myfile = file;

        this.myemulation = myemulation;

        this.myvmcontrol = myvmcontrol;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("Cancel1")) {
            this.myfirstview.setVisible(false);
        } else if (e.getActionCommand().equals("Next1")) {
            if (this.myfirstview.getFieldChoooseMachineName().getText()
                    .isEmpty()) {
                this.myfirstview.showMessage("Please, type a valid name!");
            } else {
                this.myfirstview.setVisible(false);
                this.mymodel.setChosenMachineName(this.myfirstview
                        .getFieldChoooseMachineName().getText());
                this.mysecondview.setChooseMachineName(this.mymodel
                        .getChosenMachineName());
                this.mysecondview.rechecks();
                this.mysecondview.setVisible(true);

            }
        } else if (e.getActionCommand().equals("Cancel2")) {
            this.mysecondview.setVisible(false);
        } else if (e.getActionCommand().equals("Back1")) {
            this.mysecondview.setVisible(false);
            this.myfirstview.setVisible(true);
        } else if (e.getActionCommand().equals("Next2")) {
            if (this.mysecondview.getFieldChooseVMPath().getText().isEmpty()) {
                this.mysecondview
                        .showMessage("Please, type a valid directory!");
            } else if (!this.mymodel
                    .checks_if_is_a_valid_directory(this.mysecondview
                            .getBasePath())) {
                this.mysecondview
                        .showMessage("Please, type a valid directory for the default machines path choice in the configuration section!");
            } else {
                this.mythirdview.getDiskName().setText(
                        this.myfirstview.getFieldChoooseMachineName()
                        .getText());
                File f = new File(this.mysecondview.getFieldChooseVMPath()
                        .getText()
                        + this.mymodel.checks_extension(this.mysecondview
                                .getFieldChooseVMPath().getText())
                        + this.myfirstview.getFieldChoooseMachineName()
                        .getText() + ".xml");
                if (f.exists()) {
                    this.mysecondview.showMessage("Warning:\nThe file '"
                            + (this.mysecondview.getFieldChooseVMPath()
                            .getText()
                            + this.mymodel.checks_extension(this.mysecondview
                                    .getFieldChooseVMPath().getText())
                            + this.myfirstview.getFieldChoooseMachineName()
                            .getText() + ".xml")
                            + "' already exists!\n"
                            + "This old VM will be overwritten!");
                }
                this.mysecondview.setVisible(false);
                this.mythirdview.setVisible(true);
            }

        } else if (e.getActionCommand().equals("Cancel3")) {
            this.mythirdview.setVisible(false);
        } else if (e.getActionCommand().equals("Back2")) {
            this.mythirdview.setVisible(false);
            this.mysecondview.setVisible(true);
        } else if (e.getActionCommand().equals("Finish")) {
            this.mymodel.setDiskImageSize(Double.parseDouble(this.mythirdview
                    .getEditor().getTextField().getText().replace(",", ".")));
            this.mydisk = new DiskCreationControl(
                    (this.mymodel.getDiskImageSize() * 1024) + "M", null);
            this.mydisk.setPathQemu_img(this.mymodel.getQemu_imgPath());
            this.mydisk.setDefault_virtual_machines_path(this.mysecondview
                    .getFieldChooseVMPath().getText());
            if (this.mythirdview.getDiskExtension().getItemAt(
                            this.mythirdview.getDiskExtension()
                            .getSelectedIndex()) != null)
            {
                this.mydisk.setFileName(
                    this.mythirdview.getDiskName().getText(),
                    this.mythirdview.getDiskExtension().getItemAt(
                            this.mythirdview.getDiskExtension()
                            .getSelectedIndex()));
            }
            this.mythirdview.setVisible(false);
            this.mydisk.createsAdditionalDirectory(this.mysecondview
                    .getFieldChooseVMPath().getText());
            try {
                this.mydisk
                        .runsThisIfFalse((String) this.mythirdview.getDiskExtension()
                                .getSelectedItem(),
                                this.setOptionCreationNewVM(
                                        (String) this.mythirdview
                                        .getDiskExtension()
                                        .getSelectedItem(),
                                        this.getObjects((String) this.mythirdview
                                                .getDiskExtension()
                                                .getSelectedItem()),
                                        this.getMoreOptions(this.getObjects((String) this.mythirdview
                                                .getDiskExtension()
                                                .getSelectedItem()))));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            try {
                this.mydisk.showsOutput();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            if (this.mydisk.getMessage() != null) {
                if (this.mydisk.getMessage().contains("Formatting")
                        || this.mydisk.getMessage().contains("Creating")) {
                    this.view.showMessage("The disk image was created!");
                }
            }
            this.mylastview.setVisible(true);
        } else if (e.getActionCommand().equals("No_option_pos_creation")) {
            this.mylastview.setVisible(false);
            this.myfile.getMymodel()
                    .setFirstHardDiskOption(this.mydisk.getFileName());
            this.myfile.getMymodel().setMachineName(
                    this.mymodel.getChosenMachineName());
            this.myfile.getMymodel().setRamSize("128");
            this.myfile.getMymodel().saveToXML(
                    this.mysecondview.getFieldChooseVMPath().getText()
                    + this.myfile.getMymodel().checks_extension(
                            this.mysecondview.getFieldChooseVMPath()
                            .getText())
                    + this.mymodel.getChosenMachineName() + ".xml");
        } else if (e.getActionCommand().equals("Yes_option_pos_creation")) {
            this.mylastview
                    .showMessage("You chose to open the new virtual machine!");
            this.mylastview.setVisible(false);

            this.myfile.getMymodel()
                    .setFirstHardDiskOption(this.mydisk.getFileName());
            this.myfile.getMymodel().setMachineName(
                    this.mymodel.getChosenMachineName());
            this.myfile.getMymodel().setRamSize("128");
            this.myfile.getMymodel().saveToXML(
                    this.mysecondview.getFieldChooseVMPath().getText()
                    + this.myfile.getMymodel().checks_extension(
                            this.mysecondview.getFieldChooseVMPath()
                            .getText())
                    + this.mymodel.getChosenMachineName() + ".xml");

            if (this.myopening == null) {
                this.myopening = new VMOpeningControl(this.view,
                        this.myemulation, this.myfile);
            }
            this.myopening.starts(this.myfile);
            int position;
            if (this.view.getActivePanel() == 0) {
                position = this.view.getSizeOfJTabbedPane();
            } else {
                position = this.view.getActivePanel();
            }
            if (this.myvmcontrol.size() <= position) {
                for (int i = this.myvmcontrol.size(); i <= position; i++) {
                    this.myvmcontrol.add(i, null);
                }
            }
            if (this.myvmcontrol.get(position) == null) {
                this.myvmcontrol.set(position,
                        new VMConfigurationControl(this.myemulation,
                                this.view, this.myfile));
                this.myvmcontrol.get(position).starts();
                this.myvmcontrol.get(position).getMyName().updateMe();
            }

            this.myemulation.setJPanel();
        } else if (e.getActionCommand().equals("VM_Path_Chooser")) {
            this.mysecondview.setFileDescription("VM Path Directory");
            if (this.mysecondview.chooseDirectoryForDefaultVMPath()) {
                this.mysecondview.getFieldChooseVMPath().setText(
                        this.mysecondview.getChoice());
            }
        } else if (e.getActionCommand().equals("DiskExtension")) {
            this.mythirdview.addsComponent((String) this.mythirdview
                    .getDiskExtension().getSelectedItem());
        }
        this.myemulation.change_options(OptionsEnumModel.RAMSIZE.getValor(),
                "-m " + this.myfile.getMymodel().getRamSize());
        this.myemulation.appends_options();
    }

    public void starts() {
        this.myfirstview.initialize();
        this.myfirstview.setVisible(true);

        this.mysecondview.initialize();

        this.mythirdview.initialize();

        this.mylastview.initialize();
    }

    public List<String> setOptionCreationNewVM(String option, List<ItemSelectable> objects,
            List<JComboBox<String>> moreOptions) {
        List<String> options = new ArrayList<String>();
        /*
		 * From:
		 * https://www.google.com.br/?gfe_rd=cr&ei=CzqIVIr2O4mX8Qe484CwAQ#q=check+if+object+is+instance+of+class+java&safe=active
		 * To:
		 * http://stackoverflow.com/questions/541749/how-to-determine-an-objects-class-in-java
         */
        if (option.equals(".qcow")) {
            for (Object object : objects) {
                if (object instanceof JRadioButton) {
                    if (((JRadioButton) object).isSelected()) {
                        options.add("encryption");
                    }
                } else if (object instanceof JCheckBox) {
                    if (((JCheckBox) object).isSelected()) {
                        options.add("encryption");
                    }
                }
            }
        } else if (option.equals(".qcow2")) {
            for (Object object : objects) {
                if (object instanceof JCheckBox) {
                    if (((JCheckBox) object).getText().equals("Encryption mode: on")) {
                        if (((JCheckBox) object).isSelected()) {
                            options.add("encryption");
                        }
                    }
                    if (((JCheckBox) object).getText().equals("Preallocation mode: metadata")) {
                        if (((JCheckBox) object).isSelected()) {
                            options.add("preallocation=metadata");
                        }
                    }
                    if (((JCheckBox) object).getText().equals("Cluster_size:")) {
                        for (JComboBox<String> anOption : moreOptions) {
                            if (anOption.getSelectedItem().equals("512k")) {
                                options.add("cluster_size=512k");
                            } else if (anOption.getSelectedItem().equals("1M")) {
                                options.add("cluster_size=1M");
                            } else if (anOption.getSelectedItem().equals("2M")) {
                                options.add("cluster_size=2M");
                            }
                        }
                    }
                }
            }
        } else if (option.equals(".vdi")) {
            for (Object object : objects) {
                if (object instanceof JRadioButton) {
                    if (((JRadioButton) object).isSelected()) {
                        options.add("static");
                    }
                }
            }
        } else if (option.equals(".vmdk")) {
            for (Object object : objects) {
                if (object instanceof JCheckBox) {
                    if (((JCheckBox) object).getText().equals("Compat6 option: on")) {
                        if (((JCheckBox) object).isSelected()) {
                            options.add("compat6");
                        }
                    }
                    if (((JCheckBox) object).getText().equals("VMDK subformat option:")) {
                        if (((JCheckBox) object).isSelected()) {
                            for (JComboBox<String> anOption : moreOptions) {
                                if (anOption.getSelectedItem().equals("monolithicSparse")) {
                                    options.add("subformat=monolithicSparse");
                                } else if (anOption.getSelectedItem().equals(
                                        "monolithicFlat")) {
                                    options.add("subformat=monolithicFlat");
                                } else if (anOption.getSelectedItem().equals(
                                        "twoGbMaxExtentSparse")) {
                                    options.add("subformat=twoGbMaxExtentSparse");
                                } else if (anOption.getSelectedItem().equals(
                                        "twoGbMaxExtentFlat")) {
                                    options.add("subformat=twoGbMaxExtentFlat");
                                } else if (anOption.getSelectedItem().equals(
                                        "streamOptimized")) {
                                    options.add("subformat=streamOptimized");
                                }
                            }
                        }
                    }
                }
            }
        } else if (option.equals(".vpc")) {
            for (Object object : objects) {
                if (object instanceof JRadioButton) {
                    if (((JRadioButton) object).isSelected()) {
                        for (JComboBox<String> anOption : moreOptions) {
                            if (anOption.getSelectedItem().equals("dynamic")) {
                                options.add("subformat=dynamic");
                            } else if (anOption.getSelectedItem().equals("fixed")) {
                                options.add("subformat=fixed");
                            }
                        }
                    }
                }
            }
        }
        return options;

    }

    public List<ItemSelectable> getObjects(String option) {
        List<ItemSelectable> result = new ArrayList<ItemSelectable>();
        /*
		 * From:
		 * https://www.google.com.br/?gfe_rd=cr&ei=PDGIVJGwJ4WX8Qeht4HgDg#q=add+all+elements+in+list+to+another+list+java&safe=active
		 * to:
		 * http://stackoverflow.com/questions/11273440/adding-one-list-to-another-list-in-java
         */
        if (option.equals(".qcow")
                || option.equals(".qcow2")
                || option.equals(".vmdk")) {
            result.addAll(this.getJCheckBox(option));
        } else if (option.equals(".vdi")
                || option.equals(".vpc")) {
            result.addAll(this.getJRadioButton(option));
        }

        return result;
    }

    private List<JCheckBox> getJCheckBox(String option) {
        List<JCheckBox> result = new ArrayList<JCheckBox>();
        if (option.equals(".qcow")) {
            result.add(this.mythirdview.getEncryption_box());
        } else if (option.equals(".qcow2")) {
            if (this.mythirdview.getEncryption_box().isSelected()) {
                result.add(this.mythirdview.getEncryption_box());
            }
            if (this.mythirdview.getPreallocation_metadata_box()
                    .isSelected()) {
                result.add(this.mythirdview.getPreallocation_metadata_box());
            }
            if (this.mythirdview.getCluster_size_box().isSelected()) {
                result.add(this.mythirdview.getCluster_size_box());
            }
        } else if (option.equals(".vmdk")) {
            if (this.mythirdview.getCompat6_vmdk_box().isSelected()) {
                result.add(this.mythirdview.getCompat6_vmdk_box());
            }
            if (this.mythirdview.getSubformat_vmdk_box().isSelected()) {
                result.add(this.mythirdview.getSubformat_vmdk_box());
            }
        }
        return result;
    }

    private List<ItemSelectable> getJRadioButton(String option) {
        List<ItemSelectable> result = new ArrayList<ItemSelectable>();
        if (option.equals(".vdi")) {
            if (this.mythirdview.getStatic_vdi_box().isSelected()) {
                result.add(this.mythirdview.getStatic_vdi_box());
            }
        } else if (option.equals(".vpc")) {
            if (this.mythirdview.getSubformat_vpc_box().isSelected()) {
                result.add(this.mythirdview.getSubformat_vpc_box());
            }
        }
        return result;
    }

    public List<JComboBox<String>> getMoreOptions(List<ItemSelectable> items) {
        List<JComboBox<String>> result = new ArrayList<JComboBox<String>>();
        for (ItemSelectable item : items) {
            if (item instanceof JCheckBox) {
                Object selected[] = item.getSelectedObjects();
                if (selected != null) {
                    if (((String) selected[0]).equals("Cluster_size:")) {
                        result.add(this.mythirdview.getCluster_size_options());
                    } else if (((String) selected[0]).equals("VMDK subformat option:")) {
                        result.add(this.mythirdview.getSubformat_vmdk_combo());
                    }
                }
            } else if (item instanceof JRadioButton) {
                Object selected[] = item.getSelectedObjects();
                if (selected != null) {
                    if (((String) selected[0]).equals("VPC subformat option:")) {
                        result.add(this.mythirdview.getSubformat_vpc_combo());
                    }
                }
            }
        }
        return result;
    }
}
