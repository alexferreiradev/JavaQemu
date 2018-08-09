package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.OptionsDisplayModel;
import net.sourceforge.javaqemu.model.OptionsEnumModel;
import net.sourceforge.javaqemu.model.VMConfigurationModel;
import net.sourceforge.javaqemu.view.OptionsDisplayView;
import net.sourceforge.javaqemu.view.VNCDisplayView;

public class OptionsDisplayControl implements ActionListener {

    private OptionsDisplayView myview;
    private OptionsDisplayModel mymodel;
    private VNCDisplayView mysecondview;
    private String ipAddress;
    private String tcpPort;

    public OptionsDisplayControl(EmulationControl myemulation,
            FileControl myfile) {
        this.myview = new OptionsDisplayView(myfile);
        this.myview.configureListener(this);
        this.myview.configureStandardMode();
        this.mymodel = new OptionsDisplayModel(myemulation, myfile);
        this.mysecondview = new VNCDisplayView(myfile);
        this.mysecondview.configureListener(this);
        this.mysecondview.configureStandardMode();
        ipAddress = "";
        tcpPort = "";
    }

    public void change_my_visibility(boolean value) {
        this.myview.setVisible(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("eraseButton")) {
            if (this.myview.getDisplayType().isSelected()) {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.DISPLAYOPTION.getValor()]);
            }
            if (this.myview.getNoGraphicOption().isSelected()) {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOGRAPHICOPTION.getValor()]);
            }
            this.myview.getGroupButtons().clearSelection();

            if (this.myview.getVgaType().isSelected()) {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.VGAOPTION.getValor()]);
                this.myview.getVgaType().setSelected(false);
                this.myview.getVgaTypeChoice().setSelectedIndex(0);
            }

            if (this.myview.getFullScreenOption().isSelected()) {
                this.mymodel.unsetOption("-full-screen");
                this.myview.getFullScreenOption().setSelected(false);
            }

            if (this.myview.getNoframeOption().isSelected()) {
                this.mymodel.unsetOption("-no-frame");
                this.myview.getNoframeOption().setSelected(false);
            }

            this.change_my_visibility(false);
            ;
        } else if (e.getActionCommand().equals("okButton")) {
            if (this.myview.getDisplayType().isSelected()) {
                if (this.myview.getDisplayTypeChoice().getSelectedItem()
                        .equals("sdl")) {
                    this.mymodel.setDisplayTypeOption("sdl");
                } else if (this.myview.getDisplayTypeChoice().getSelectedItem()
                        .equals("curses")) {
                    this.mymodel.setDisplayTypeOption("curses");
                } else if (this.myview.getDisplayTypeChoice().getSelectedItem()
                        .equals("none")) {
                    this.mymodel.setDisplayTypeOption("none");
                } else if (this.myview.getDisplayTypeChoice().getSelectedItem()
                        .equals("vnc")) {
                    StringBuilder result = new StringBuilder();

                    if (!tcpPort.isEmpty()) {
                        result.append("vnc=").append(ipAddress)
                                .append(":").append(tcpPort);
                    } else {
                        result.append("vnc=127.0.0.1:0");
                    }
                    if (this.mysecondview.getReverseOption().isSelected()) {
                        result.append(",reverse");
                    }
                    if (this.mysecondview.getPasswordOption().isSelected()) {
                        result.append(",password");
                    }
                    if (this.mysecondview.getLossyOption().isSelected()) {
                        result.append(",lossy");
                    }
                    if (this.mysecondview.getNonAdaptiveOption().isSelected()) {
                        result.append(",non-adaptive");
                    }
                    this.mymodel.setDisplayTypeOption(result.toString());
                }
            } else {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.DISPLAYOPTION.getValor()]);
            }

            if (this.myview.getNoGraphicOption().isSelected()) {
                this.mymodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOGRAPHICOPTION.getValor()]);
            } else {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.NOGRAPHICOPTION.getValor()]);
            }

            if (this.myview.getVgaType().isSelected()) {
                if (this.myview.getVgaTypeChoice().getSelectedItem()
                        .equals("Cirrus Logic GD5446")) {
                    this.mymodel.setOption("-vga cirrus");
                } else if (this.myview.getVgaTypeChoice().getSelectedItem()
                        .equals("Standard VGA Card")) {
                    this.mymodel.setOption("-vga std");
                } else if (this.myview.getVgaTypeChoice().getSelectedItem()
                        .equals("Vmware SVGA-II")) {
                    this.mymodel.setOption("-vga vmware");
                } else if (this.myview.getVgaTypeChoice().getSelectedItem()
                        .equals("QXL Paravirtual VGA Card")) {
                    this.mymodel.setOption("-vga qxl");
                } else if (this.myview.getVgaTypeChoice().getSelectedItem()
                        .equals("None")) {
                    this.mymodel.setOption("-vga none");
                }
            } else {
                this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.VGAOPTION.getValor()]);
            }

            if (this.myview.getFullScreenOption().isSelected()) {
                this.mymodel.setOption("-full-screen");
            } else {
                this.mymodel.unsetOption("-full-screen");
            }

            if (this.myview.getNoframeOption().isSelected()) {
                this.mymodel.setOption("-no-frame");
            } else {
                this.mymodel.unsetOption("no-frame");
            }

            this.change_my_visibility(false);
        } else if (e.getActionCommand().equals("showVNCOptions")) {
            this.mysecondview.setVisible(true);
        } else if (e.getActionCommand().equals("eraseButton2")) {
            if (!mysecondview.getiPAddressField().getText().isEmpty()) {
                this.mysecondview.setiPAddressField("");
            }
            if (!mysecondview.getTcpPortField().getText().isEmpty()) {
                this.mysecondview.setTcpPortField("");
            }
            if (!this.ipAddress.isEmpty()) {
                this.ipAddress = "";
            }
            if (!this.tcpPort.isEmpty()) {
                this.tcpPort = "";
            }
            if (this.mysecondview.getReverseOption().isSelected()) {
                this.mysecondview.getReverseOption().setSelected(false);
            }
            if (this.mysecondview.getPasswordOption().isSelected()) {
                this.mysecondview.getPasswordOption().setSelected(false);
            }
            if (this.mysecondview.getLossyOption().isSelected()) {
                this.mysecondview.getLossyOption().setSelected(false);
            }
            if (this.mysecondview.getNonAdaptiveOption().isSelected()) {
                this.mysecondview.getNonAdaptiveOption().setSelected(false);
            }
            this.mymodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.DISPLAYOPTION.getValor()]);
            this.mysecondview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton2")) {
            if (!mysecondview.getiPAddressField().getText().isEmpty()) {
                if (!mysecondview.getiPAddressField().getText()
                        .equals(ipAddress)) {
                    this.ipAddress = mysecondview.getiPAddressField().getText();
                }
            }
            if (!mysecondview.getTcpPortField().getText().isEmpty()) {
                if (!mysecondview.getTcpPortField().getText().equals(tcpPort)) {
                    this.tcpPort = mysecondview.getTcpPortField().getText();
                }
            }
            this.mysecondview.setVisible(false);
        }
    }

    public String getDisplayTypeOption() {
        return this.mymodel.getDisplayTypeOption();
    }
}
