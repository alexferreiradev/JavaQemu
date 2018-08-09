package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextArea;

import net.sourceforge.javaqemu.model.LastUsedFileModel;
import net.sourceforge.javaqemu.model.LastUsedFolderEnumModel;
import net.sourceforge.javaqemu.model.LastUsedFolderModel;
import net.sourceforge.javaqemu.model.Model;
import net.sourceforge.javaqemu.model.UtilitiesModel;
import net.sourceforge.javaqemu.view.UtilitiesView;
import net.sourceforge.javaqemu.view.View;

public class Control implements ActionListener {

    private View view;
    private ConfigurationControl mycontrol;
    private EmulationControl myemulation;
    private VMCreationControl mycreation;
    private DiskCreationControl mydisk;
    private FileControl myfile;
    private VMClosingControl myclosing;
    private VMOpeningControl myopening;
    private List<VMConfigurationControl> myvmcontrol;
    private VMSavingControl mysaving;
    private UtilitiesView myutilitiesview;
    private UtilitiesModel myutilitiesmodel;
    private LastUsedFolderModel myLastUsedFolderModel;
    private LastUsedFileModel myLastUsedFileModel;

    public Control(View view) {
        this.view = view;
        this.view.configureListener(this);
        this.mycontrol = null;
        this.myemulation = null;
        this.mycreation = null;
        this.mydisk = null;
        this.myfile = null;
        this.myclosing = null;
        this.myopening = null;
        this.myvmcontrol = new ArrayList<VMConfigurationControl>();
        this.mysaving = null;
        this.myutilitiesview = null;
        this.myutilitiesmodel = null;

        this.myLastUsedFolderModel = (LastUsedFolderModel) Model
                .loadUserConfigurationLocally(
                        LastUsedFolderModel.class.getName());
        this.myLastUsedFileModel = (LastUsedFileModel) Model
                .loadUserConfigurationLocally(
                        LastUsedFileModel.class.getName());
    }

    public void starts() {
        this.view.setVisible(true);
        this.view.configureStandardMode();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ExitCommand")) {
            //System.exit(0);
            boolean runFurther = this.view.getSizeOfJTabbedPane() > 1;
            for (int i = 1; i < this.view.getSizeOfJTabbedPane(); i++) {
                this.myvmcontrol.remove(i);
            }

            if (runFurther) {
                if (this.myclosing == null) {
                    this.myclosing = new VMClosingControl(this.view,
                            this.myemulation);
                } else {
                    this.myclosing.setView(this.view);
                    this.myclosing.setMyemulation(this.myemulation);
                }
                this.myclosing.starts(true);
            }

            this.view.dispose();

            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                int n = 0;

                @Override
                public void run() {

                    if (++n == 2) {
                        timer.cancel();
                        System.exit(0);
                    }
                }
            }, 1000, 1000);
        } else if (e.getActionCommand().equals("AboutCommand")) {
            this.view.showAboutContents();
        } else if (e.getActionCommand().equals("ConfigureCommand")) {
            if (this.mycontrol == null) {
                this.mycontrol = new ConfigurationControl(
                        this.myLastUsedFolderModel, myLastUsedFileModel);
            } else {
                this.mycontrol.do_my_view_visible();
            }
        } else if (e.getActionCommand().equals("StartEmulation")) {
            if (this.myemulation == null) {
                this.myemulation = new EmulationControl(this.view);
            }
            if (this.mycontrol == null) {
                this.view
                        .showMessage("Please, configure the required parameters \nbefore starting the emulation with the qemu!");
                this.mycontrol = new ConfigurationControl(myLastUsedFolderModel,
                        myLastUsedFileModel);
            }

            if (this.mycontrol.getQemu_executable_path() == null) {
                this.mycontrol.setQemu_executable_path();
            }
            this.myemulation.setExecute_before_start_qemu(this
                    .JTextAreaToArrayListOfStrings(this.mycontrol
                            .getExecute_before_start_qemu()));
            if (this.myemulation.preruns(this.view.getActivePanel(), this.view
                    .getSelectedPanel().getTitle())) {
                this.view.showMessage("The pre-run script(s) is(are) gone.");
            }
            this.myemulation.setPathQemu(this.mycontrol
                    .getQemu_executable_path().getText());

            if (this.mycontrol.getBios_vga_bios_keymaps_path() == null) {
                this.mycontrol.setBios_vga_bios_keymaps_path();
            }

            this.myemulation.setBiosVgaBiosKeymapsPath(this.mycontrol
                    .getBios_vga_bios_keymaps_path().getText());

            if (this.view.getActivePanel() == 0) {
                this.view
                        .showMessage("Please, select an open virtual machine tab before starting the emulation.");
            }
            try {
                if (this.myemulation.runs(this.view.getActivePanel(), this.view
                        .getSelectedPanel().getTitle())) {
                    this.view.showMessage("If there were no errors so far, so the qemu should be running now!");
                } else if (!this.mycontrol.getIsConfigured()) {
                    this.mycontrol.do_my_view_visible();
                    this.view
                            .showMessage("The qemu has not been started!\nPlease, check the configuration parameters!"
                                    + "\nPlease, configure the path of the qemu executable first!");
                }
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } else if (e.getActionCommand().equals("StopEmulation")) {
            if (this.myemulation == null) {
                this.myemulation = new EmulationControl(view);
            }
            if (this.myemulation.warns()) {
                if (this.myemulation.stops(this.view.getActivePanel())) {
                    this.view.showMessage("The Qemu is not running now!");
                }

                if (this.mycontrol != null) {
                    this.myemulation.setExecute_after_stop_qemu(this
                            .JTextAreaToArrayListOfStrings(this.mycontrol
                                    .getExecute_after_stop_qemu()));
                    if (this.myemulation.postruns(this.view
                            .getActivePanel(), this.view.getSelectedPanel()
                            .getTitle())) {
                        this.view
                                .showMessage("The post-run script(s) is(are) gone.");
                    }
                }
            }
        } else if (e.getActionCommand().equals("CreateNewVM")) {
            if (this.myfile == null) {
                this.myfile = new FileControl(this.view.getMyUntitledJPanel(),
                        this.view);
            }
            if (this.myemulation == null) {
                this.myemulation = new EmulationControl(view);
            }
            if (this.mycontrol == null) {
                this.view
                        .showMessage("Please, configure the required options first!\n"
                                + "Please, configure the path of the qemu-img executable first!");
                this.mycontrol = new ConfigurationControl(myLastUsedFolderModel, myLastUsedFileModel);
            } else if (this.mycontrol.getQemu_img_executable_path() == null
                    || this.mycontrol.getQemu_img_executable_path()
                    .getText().isEmpty()) {
                this.view
                        .showMessage("Please, configure the path of the qemu-img executable first!");
                this.mycontrol.do_my_view_visible();

            } else if (this.mycontrol.getDefault_virtual_machines_path()
                    .isEmpty()) {
                this.view
                        .showMessage("Please, configure the path of the default Virtual Machines first!");
                this.mycontrol.do_my_view_visible();
            } else {
                this.mycreation = new VMCreationControl(this.mydisk,
                        this.mycontrol.getQemu_img_executable_path()
                        .getText(),
                        this.mycontrol
                        .getDefault_virtual_machines_path(),
                        this.view, this.myfile, this.myemulation,
                        this.myvmcontrol);
                this.mycreation.starts();
            }
        } else if (e.getActionCommand().equals("OpenExistingVM")) {
            if (this.myemulation == null) {
                this.myemulation = new EmulationControl(view);
            }
            if (this.myfile == null) {
                this.myfile = new FileControl(this.view.getMyUntitledJPanel(),
                        this.view);
            }
            this.myfile.getMyview().setFileExtension(".xml");
            this.myfile.getMyview().setChoosertitle("Choose an existing JavaQemu VM file!");
            this.myfile.getMyview().setFileDescription(
                    "XML - JavaQemu VM Files");
            this.myfile.getMyview().setCurrentDirectory(
                    this.myLastUsedFolderModel.getLastUsedFolder(
                            LastUsedFolderEnumModel.OPENEXISTINGVM.getValor()
                    ));
            if (this.myfile.getMyview().chooseFile()) {
                if (this.myfile.getMymodel().readXML(
                        this.myfile.getMyview().getChoice())) {
                    this.myLastUsedFolderModel.setLastUsedFolder(
                            LastUsedFolderEnumModel.OPENEXISTINGVM.getValor(), this.myfile.getMyview().getChooser().getCurrentDirectory()
                            .getAbsolutePath());

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
                } else {
                    this.view
                            .showMessage("Please, select a valid file (*.xml)!");
                }
            }
        } else if (e.getActionCommand().equals("CloseVM")) {
            int position;
            if (this.view.getActivePanel() == 0) {
                position = this.view.getSizeOfJTabbedPane();
            } else {
                position = this.view.getActivePanel();
            }
            this.myvmcontrol.remove(position);
            if (this.myclosing == null) {
                this.myclosing = new VMClosingControl(this.view,
                        this.myemulation);
            } else {
                this.myclosing.setView(this.view);
                this.myclosing.setMyemulation(this.myemulation);
            }
            this.myclosing.starts(false);
        } else if (e.getActionCommand().equals("ChangeMachineName")) {
            int position;
            if (this.view.getActivePanel() == 0) {
                position = this.view.getSizeOfJTabbedPane();
            } else {
                position = this.view.getActivePanel();
            }
            String machineName = this.view
                    .getInputMessage("Please, type a name for this VM:");
            if (machineName != null) {
                if (!machineName.isEmpty()) {
                    this.myfile.getMymodel().setMachineName(machineName);
                    this.view.changeNameJPanel(machineName);
                    this.myvmcontrol.get(position).getMyName().updateMe();
                } else {
                    this.view
                            .showMessage("Please, type a valid name for this VM!");
                }
            }
        } else if (e.getActionCommand().equals("ChangeMachineConfiguration")) {
            int position;
            if (this.view.getActivePanel() == 0) {
                position = this.view.getSizeOfJTabbedPane();
            } else {
                position = this.view.getActivePanel();
            }
            if (this.myvmcontrol.get(position) != null) {
                this.myvmcontrol.get(position).restarts();
            } else {
                if (this.myvmcontrol.size() <= position) {
                    for (int i = this.myvmcontrol.size(); i <= position; i++) {
                        this.myvmcontrol.add(i, null);
                    }
                }
                this.myvmcontrol.set(position, new VMConfigurationControl(
                        this.myemulation, this.view, this.myfile));
                this.myvmcontrol.get(position).starts();
                this.myvmcontrol.get(position).restarts();
            }
        } else if (e.getActionCommand().equals("SaveVM")) {
            if (this.mysaving == null) {
                this.mysaving = new VMSavingControl(
                        this.view.getSelectedPanel());
            } else {
                this.mysaving.setVMSavingViewJPanel(this.view.getSelectedPanel());
            }

            this.mysaving.getMyview().setCurrentDirectory(this.myLastUsedFolderModel.getLastUsedFolder(
                    LastUsedFolderEnumModel.SAVEEXISTINGVM.getValor()
            ));

            if (this.mysaving.chooseFile()) {
                String result = this.mysaving.getMyview().getChoice();
                if (result.length() < 5) {
                    result += ".xml";
                } else if (!result.substring(result.length() - 4).equals(".xml")) {
                    result += ".xml";
                }
                this.mysaving.setSavedVMPath(result);

                this.myLastUsedFolderModel.setLastUsedFolder(
                        LastUsedFolderEnumModel.SAVEEXISTINGVM.getValor(), this.mysaving.getMyview().getChooser().getCurrentDirectory()
                        .getAbsolutePath());

                this.myfile.getMymodel().saveToXML(
                        this.mysaving.getSavedVMPath());
            }
        } else if (e.getActionCommand().equals("CreateNewDiskImageFile")) {
            if (this.mydisk == null) {
                this.mydisk = new DiskCreationControl("0", this);
            }
            if (this.mycontrol == null) {
                this.view
                        .showMessage("Please, configure the required options first!"
                                + "\nPlease, configure the path of the default Virtual Machines first!");
                this.mycontrol = new ConfigurationControl(myLastUsedFolderModel, myLastUsedFileModel);
            } else if (this.mycontrol.getDefault_virtual_machines_path().isEmpty()) {
                this.view
                        .showMessage("Please, configure the path of the default Virtual Machines first!");
                this.mycontrol.do_my_view_visible();
            } else {
                this.mydisk.setDefault_virtual_machines_path(this.mycontrol
                        .getDefault_virtual_machines_path());
                if (this.mycontrol.getQemu_img_executable_path() == null) {
                    this.view
                            .showMessage("Please, configure the path of the qemu-img executable first!");
                    this.mycontrol.do_my_view_visible();
                } else {
                    this.mydisk.setPathQemu_img(this.mycontrol
                            .getQemu_img_executable_path().getText());
                    this.mydisk.change_visibility(true);
                }

            }
        } else if (e.getActionCommand().equals("Cancel_CreateNewDiskImageFile")) {
            this.mydisk.unsetBoxSelections();
            this.mydisk.change_visibility(false);
        } else if (e.getActionCommand().equals("OK_CreateNewDiskImageFile")) {
            this.mydisk.setSizeMB(this.mydisk.getDiskImageSize());
            this.mydisk.setFileName(this.mydisk.getDiskName().getText(),
                    (String) this.mydisk.getDiskExtension().getSelectedItem());
            try {
                this.mydisk.runsThisIfTrue();
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

            if (this.mydisk.getMessage().contains("Formatting")
                    || this.mydisk.getMessage().contains("Creating")) {
                this.view.showMessage("The disk image was created!");
            }

            this.mydisk.unsetBoxSelections();
            this.mydisk.change_visibility(false);
        } else if (e.getActionCommand().equals(
                "DiskExtension_CreateNewDiskImageFile")) {
            this.mydisk.addsComponent((String) this.mydisk.getDiskExtension()
                    .getSelectedItem());
        } else if (e.getActionCommand().equals("seeOutputsFromProcesses")) {
            try {
                if (this.myemulation == null) {
                    this.myemulation = new EmulationControl(view);
                }
                this.myemulation.showsMessages();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } else if (e.getActionCommand().equals("useUtilities")) {
            if (this.myutilitiesview == null) {
                this.myutilitiesview = new UtilitiesView();
                this.myutilitiesview.initialize();
                this.myutilitiesview.configureListener(this);
                this.myutilitiesview.configureStandardMode();
                this.myutilitiesview.setVisible(true);
            } else {
                this.myutilitiesview.setVisible(true);
            }
        } else if (e.getActionCommand().equals("Hide_Utilities")) {
            this.myutilitiesview.setVisible(false);
        } else if (e.getActionCommand().equals("seeQemuVersion")) {
            if (this.myutilitiesmodel == null) {
                try {
                    if (this.mycontrol != null) {
                        if (this.mycontrol.getQemu_executable_path() != null) {
                            this.myutilitiesmodel = new UtilitiesModel(Runtime
                                    .getRuntime().exec(
                                            this.mycontrol
                                            .getQemu_executable_path()
                                            .getText()
                                            + " -version"),
                                    myutilitiesview,
                                    getQemuPathDir(this.mycontrol
                                            .getQemu_executable_path()
                                            .getText()));
                            if (!this.myutilitiesmodel.inheritIO_Output_Qemu()) {
                                while (this.myutilitiesmodel.isRunning()) {

                                }
                                if (!this.myutilitiesmodel.readsFile()) {
                                    this.myutilitiesview
                                            .showMessage("Sorry! The requested information can not be obtained.");
                                }
                            }
                        } else {
                            this.view
                                    .showMessage("Please, configure the required options first!"
                                            + "\nPlease, configure the path of the default Virtual Machines first!");
                            this.mycontrol.do_my_view_visible();
                        }
                    } else {
                        this.view
                                .showMessage("Please, configure the required options first!"
                                        + "\nPlease, configure the path of the default Virtual Machines first!");
                        this.mycontrol = new ConfigurationControl(myLastUsedFolderModel, myLastUsedFileModel);
                    }
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else {
                try {
                    this.myutilitiesmodel.setMyprocess(Runtime.getRuntime()
                            .exec(this.mycontrol.getQemu_executable_path()
                                    .getText() + " -version"));
                    this.myutilitiesmodel
                            .setQemuPathDir(getQemuPathDir(this.mycontrol
                                    .getQemu_executable_path().getText()));
                    if (!this.myutilitiesmodel.inheritIO_Output_Qemu()) {
                        while (this.myutilitiesmodel.isRunning()) {

                        }
                        if (!this.myutilitiesmodel.readsFile()) {
                            this.myutilitiesview
                                    .showMessage("Sorry! The requested information can not be obtained.");
                        }
                    }
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        } else if (e.getActionCommand().equals("seeQemuImgVersion")) {
            if (this.myutilitiesmodel == null) {
                try {
                    if (this.mycontrol != null) {
                        if (this.mycontrol.getQemu_img_executable_path() != null) {
                            this.myutilitiesmodel = new UtilitiesModel(Runtime
                                    .getRuntime()
                                    .exec(this.mycontrol
                                            .getQemu_img_executable_path()
                                            .getText()), myutilitiesview, null);
                            if (!this.myutilitiesmodel
                                    .inheritIO_Output_QemuImg()) {
                                while (this.myutilitiesmodel.isRunning()) {

                                }
                                this.myutilitiesview
                                        .showMessage("Sorry! The requested information can not be obtained.");
                            }
                        } else {
                            this.view
                                    .showMessage("Please, configure the required options first!"
                                            + "\nPlease, configure the path of the default Virtual Machines first!");
                            this.mycontrol.do_my_view_visible();
                        }
                    } else {
                        this.view
                                .showMessage("Please, configure the required options first!"
                                        + "\nPlease, configure the path of the default Virtual Machines first!");
                        this.mycontrol = new ConfigurationControl(myLastUsedFolderModel, myLastUsedFileModel);
                    }
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else {
                try {
                    this.myutilitiesmodel.setMyprocess(Runtime.getRuntime()
                            .exec(this.mycontrol.getQemu_img_executable_path()
                                    .getText()));
                    this.myutilitiesmodel.setQemuPathDir(null);
                    if (!this.myutilitiesmodel.inheritIO_Output_QemuImg()) {
                        while (this.myutilitiesmodel.isRunning()) {

                        }
                        this.myutilitiesview
                                .showMessage("Sorry! The requested information can not be obtained.");
                    }
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        } else if (e.getActionCommand().equals("SeeQemuEmulationCommandLine")) {
            if (this.myemulation == null) {
                this.myemulation = new EmulationControl(this.view);

                if (this.mycontrol.getQemu_executable_path() != null) {
                    this.myemulation.setPathQemu(this.mycontrol
                            .getQemu_executable_path().getText());
                }

                if (this.mycontrol.getBios_vga_bios_keymaps_path() != null) {
                    this.myemulation.setBiosVgaBiosKeymapsPath(this.mycontrol
                            .getBios_vga_bios_keymaps_path().getText());
                }
            } else if (this.mycontrol != null) {
                if (this.mycontrol.getQemu_executable_path() != null) {
                    this.myemulation.setPathQemu(this.mycontrol
                            .getQemu_executable_path().getText());
                }

                if (this.mycontrol.getBios_vga_bios_keymaps_path() != null) {
                    this.myemulation.setBiosVgaBiosKeymapsPath(this.mycontrol
                            .getBios_vga_bios_keymaps_path().getText());
                }
            }

            if (this.view.getActivePanel() == 0) {
                this.view
                        .showMessage("Please, select an open virtual machine tab before seeing the Qemu emulation command line.");
            } else if (!this.myemulation.getFullCommandLine(
                    this.view.getActivePanel()).isEmpty()) {
                this.view
                        .showMessage("The Qemu emulation command line is:\n"
                                + this.myemulation
                                .getFullCommandLine(this.view
                                        .getActivePanel()) + "\n!");
            } else {
                this.view
                        .showMessage("Sorry! There is no Qemu emulation command line, or it is empty!");
            }
        }
    }

    public List<String> JTextAreaToArrayListOfStrings(JTextArea given) {
        List<String> result = new ArrayList<String>();
        if (given != null) {
            String[] helper = given.getText().split("\n");
            for (int i = 0; i < helper.length; i++) {
                result.add(helper[i]);
            }
        }
        return result;
    }

    private String getQemuPathDir(String qemuPath) {
        String extension = this.checks_extension(qemuPath);
        int position = qemuPath.lastIndexOf(extension);
        return qemuPath.substring(0, position);
    }

    private String checks_extension(String path) {
        String result = "";
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                result = "/";
                break;
            }
            if (path.charAt(i) == '\\') {
                result = "\\";
                break;
            }
        }
        return result;
    }
}
