package net.sourceforge.javaqemu.control;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import net.sourceforge.javaqemu.model.DiskCreationModel;
import net.sourceforge.javaqemu.model.UsabilityModel;
import net.sourceforge.javaqemu.view.DiskCreationView;

public class DiskCreationControl {

    /*TO DO:
	 * put data in model... (MVC)
	 * */
    private DiskCreationModel mymodel;

    private DiskCreationView myview;

    private String message;

    public String getMessage() {
        return message;
    }

    public DiskCreationControl(String sizeMB, ActionListener listener) {
        this.mymodel = new DiskCreationModel(sizeMB);
        this.mymodel.setDefault_virtual_machines_path("");
        this.myview = new DiskCreationView();
        this.myview.configureListener(listener);
        this.myview.configureStandardMode();
        this.myview.initialize();
    }

    public void runningRoutine() throws IOException {
        this.myview.showThisInTheRunProcess(this.mymodel.getExecQemu_img());
        StringBuilder sb = new StringBuilder(this.mymodel.getExecQemu_img()[0]);
        sb.append(" ").append(this.mymodel.getExecQemu_img()[1]).append(" ");
        if (!this.mymodel.getExecQemu_img()[2].isEmpty()) {
            sb.append(this.mymodel.getExecQemu_img()[2]).append(" ");
        }
        sb.append(this.mymodel.getExecQemu_img()[3]).append(" ")
                .append(this.mymodel.getExecQemu_img()[4]);
        String[] cmdLine = UsabilityModel.getCmdLine(sb.toString());
        if (cmdLine.length == 0) {
            this.mymodel.setMyprocess(Runtime.getRuntime().exec(
                    sb.toString(), null));
        } else {
            this.mymodel.setMyprocess(Runtime.getRuntime().exec(
                    cmdLine, null));
        }
    }

    public boolean runsThisIfTrue()
            throws IOException, InterruptedException {
        this.setOptions();
        runningRoutine();
        return true;
    }

    public boolean runsThisIfFalse(String diskExtension, List<String> options)
            throws IOException, InterruptedException {
        this.setOptionCreationNewVM(diskExtension, options);
        runningRoutine();
        return true;
    }

    public boolean stops() {
        if (this.mymodel.getMyprocess() != null) {
            this.mymodel.getMyprocess().destroy();
        }
        return true;
    }

    public void showsOutput() throws IOException {
        StringBuilder result = new StringBuilder("The disk image creation process output is:\n");
        StringBuilder output = new StringBuilder();
        InputStreamReader iSReader = null;
        BufferedReader reader = null;
        String line;
        try {
            iSReader = new InputStreamReader(
                    this.mymodel.getMyprocess().getInputStream(),
                    Charset.forName("UTF-8"));
            reader = new BufferedReader(iSReader);
            line = reader.readLine();
            if (line != null) {
                output.append(line);
            }
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    output.append("\n").append(line);
                }
            }
            if (!output.toString().isEmpty()) {
                this.message = output.toString();
                result.append(output.toString());
                this.myview.showMessage(result.toString());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (iSReader != null) {
                    iSReader.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }
    }

    public void setPathQemu_img(String pathQemu_img) {
        this.mymodel.setQemu_imgPath(pathQemu_img);
    }

    public void setFileName(String text, String extension) {
        this.mymodel.setFileName(text, extension);
    }

    public String getFileName() {
        return this.mymodel.getFileName();
    }

    public void setDefault_virtual_machines_path(String text) {
        this.mymodel.setDefault_virtual_machines_path(text);
    }

    public boolean createsAdditionalDirectory(String path) {
        return this.mymodel.createsAdditionalDirectory(path);
    }

    public void change_visibility(boolean value) {
        this.myview.setVisible(value);
    }

    public void setSizeMB(String sizeMB) {
        this.mymodel.setSizeMB(sizeMB);
    }

    public String getDiskImageSize() {
        return (Double.parseDouble(this.myview.getEditor().getTextField()
                .getText().replace(",", ".")) * 1024)
                + "M";
    }

    public JTextField getDiskName() {
        return this.myview.getDiskName();
    }

    public JComboBox<String> getDiskExtension() {
        return this.myview.getDiskExtension();
    }

    public String getDiskImageFilePath() {
        return this.mymodel.getExecQemu_img()[3];
    }

    public void addsComponent(String diskExtension) {
        this.myview.addsComponent(diskExtension);
    }

    public void setOptions() {
        if (this.myview.getDiskExtension().getSelectedItem().equals(".img")) {
            this.mymodel.unsetOption();
        } else if (this.myview.getDiskExtension().getSelectedItem()
                .equals(".qcow")) {
            if (this.myview.getEncryption_box().isSelected()) {
                this.mymodel.setOption("encryption");
            } else {
                this.mymodel.unsetOption();
            }
        } else if (this.myview.getDiskExtension().getSelectedItem()
                .equals(".qcow2")) {
            if (this.myview.getEncryption_box().isSelected()
                    || this.myview.getPreallocation_metadata_box().isSelected()
                    || this.myview.getCluster_size_box().isSelected()) {
                List<String> options = new ArrayList<String>();
                if (this.myview.getEncryption_box().isSelected()) {
                    options.add("encryption");
                }
                if (this.myview.getPreallocation_metadata_box().isSelected()) {
                    options.add("preallocation=metadata");
                }
                if (this.myview.getCluster_size_box().isSelected()) {
                    if (this.myview.getCluster_size_options().getSelectedItem()
                            .equals("512k")) {
                        options.add("cluster_size=512k");
                    } else if (this.myview.getCluster_size_options()
                            .getSelectedItem().equals("1M")) {
                        options.add("cluster_size=1M");
                    } else if (this.myview.getCluster_size_options()
                            .getSelectedItem().equals("2M")) {
                        options.add("cluster_size=2M");
                    }
                }
                this.mymodel.setOptions(options);
            } else {
                this.mymodel.unsetOption();
            }
        } else if (this.myview.getDiskExtension().getSelectedItem()
                .equals(".cow")) {
            this.mymodel.unsetOption();
        } else if (this.myview.getDiskExtension().getSelectedItem()
                .equals(".vdi")) {
            if (this.myview.getStatic_vdi_box().isSelected()) {
                this.mymodel.setOption("static");
            } else {
                this.mymodel.unsetOption();
            }
        } else if (this.myview.getDiskExtension().getSelectedItem()
                .equals(".vmdk")) {
            if (this.myview.getCompat6_vmdk_box().isSelected()
                    || this.myview.getSubformat_vmdk_box().isSelected()) {
                List<String> options = new ArrayList<String>();
                if (this.myview.getCompat6_vmdk_box().isSelected()) {
                    options.add("compat6");
                }

                if (this.myview.getSubformat_vmdk_box().isSelected()) {
                    if (this.myview.getSubformat_vmdk_combo().getSelectedItem()
                            .equals("monolithicSparse")) {
                        options.add("subformat=monolithicSparse");
                    } else if (this.myview.getSubformat_vmdk_combo()
                            .getSelectedItem().equals("monolithicFlat")) {
                        options.add("subformat=monolithicFlat");
                    } else if (this.myview.getSubformat_vmdk_combo()
                            .getSelectedItem().equals("twoGbMaxExtentSparse")) {
                        options.add("subformat=twoGbMaxExtentSparse");
                    } else if (this.myview.getSubformat_vmdk_combo()
                            .getSelectedItem().equals("twoGbMaxExtentFlat")) {
                        options.add("subformat=twoGbMaxExtentFlat");
                    } else if (this.myview.getSubformat_vmdk_combo()
                            .getSelectedItem().equals("streamOptimized")) {
                        options.add("subformat=streamOptimized");
                    }
                }
                this.mymodel.setOptions(options);
            } else {
                this.mymodel.unsetOption();
            }
        } else if (this.myview.getDiskExtension().getSelectedItem()
                .equals(".vpc")) {
            if (this.myview.getSubformat_vpc_box().isSelected()) {
                if (this.myview.getSubformat_vpc_combo().getSelectedItem()
                        .equals("dynamic")) {
                    this.mymodel.setOption("subformat=dynamic");
                } else if (this.myview.getSubformat_vpc_combo().getSelectedItem()
                        .equals("fixed")) {
                    this.mymodel.setOption("subformat=fixed");
                }
            } else {
                this.mymodel.unsetOption();
            }
        }
    }

    public void setOptionCreationNewVM(String diskExtension, List<String> options) {
        if (diskExtension.equals(".img")) {
            this.mymodel.unsetOption();
        } else if (diskExtension.equals(".qcow")) {
            if (options.contains("encryption")) {
                this.mymodel.setOption("encryption");
            } else {
                this.mymodel.unsetOption();
            }
        } else if (diskExtension.equals(".qcow2")) {
            if (options.contains("encryption")
                    || options.contains("preallocation=metadata")
                    || options.contains("cluster_size=512k")
                    || options.contains("cluster_size=1M")
                    || options.contains("cluster_size=2M")) {
                this.mymodel.setOptions(options);
            } else {
                this.mymodel.unsetOption();
            }
        } else if (diskExtension.equals(".cow")) {
            this.mymodel.unsetOption();
        } else if (diskExtension.equals(".vdi")) {
            if (options.contains("static")) {
                this.mymodel.setOption("static");
            } else {
                this.mymodel.unsetOption();
            }
        } else if (diskExtension.equals(".vmdk")) {
            if (options.contains("compat6")
                    || options.contains("monolithicSparse")
                    || options.contains("monolithicFlat")
                    || options.contains("twoGbMaxExtentSparse")
                    || options.contains("twoGbMaxExtentFlat")
                    || options.contains("streamOptimized")) {
                this.mymodel.setOptions(options);
            } else {
                this.mymodel.unsetOption();
            }
        } else if (diskExtension.equals(".vpc")) {
            if (options.contains("subformat=dynamic")
                    || options.contains("subformat=fixed")) {
                this.mymodel.setOptions(options);
            } else {
                this.mymodel.unsetOption();
            }
        }
    }

    public void unsetBoxSelections() {
        this.myview.getEncryption_box().setSelected(false);
        this.myview.getCluster_size_box().setSelected(false);
        this.myview.getCluster_size_options().setSelectedIndex(0);
        this.myview.getPreallocation_metadata_box().setSelected(false);
        this.myview.getStatic_vdi_box().setSelected(false);
        this.myview.getCompat6_vmdk_box().setSelected(false);
        this.myview.getSubformat_vmdk_box().setSelected(false);
        this.myview.getSubformat_vmdk_combo().setSelectedIndex(0);
        this.myview.getSubformat_vpc_box().setSelected(false);
    }
}
