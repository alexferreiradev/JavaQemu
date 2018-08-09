package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.OptionsEnumModel;
import net.sourceforge.javaqemu.model.USBBrailleModel;
import net.sourceforge.javaqemu.model.USBDiskModel;
import net.sourceforge.javaqemu.model.USBDriverModel;
import net.sourceforge.javaqemu.model.USBKeyboardModel;
import net.sourceforge.javaqemu.model.USBMouseModel;
import net.sourceforge.javaqemu.model.USBNetModel;
import net.sourceforge.javaqemu.model.USBSerialModel;
import net.sourceforge.javaqemu.model.USBTabletModel;
import net.sourceforge.javaqemu.model.USBWacomTabletModel;
import net.sourceforge.javaqemu.model.VMConfigurationModel;
import net.sourceforge.javaqemu.view.USBView;

public class USBControl implements ActionListener {

    private USBView myview;
    private USBDriverModel mydrivermodel;
    private USBMouseModel mymousemodel;
    private USBTabletModel mytabletmodel;
    private USBWacomTabletModel mywacomtabletmodel;
    private USBKeyboardModel mykeyboardmodel;
    private USBBrailleModel mybraillemodel;
    private USBDiskModel mydiskmodel;
    private USBSerialModel myserialmodel;
    private USBNetModel mynetmodel;

    public USBControl(EmulationControl myemulation, FileControl myfile) {
        this.myview = new USBView(myfile);
        this.myview.configureListener(this);
        this.myview.configureStandardMode();
        this.mydrivermodel = new USBDriverModel(myemulation, myfile);
        this.mymousemodel = new USBMouseModel(myemulation, myfile);
        this.mytabletmodel = new USBTabletModel(myemulation, myfile);
        this.mywacomtabletmodel = new USBWacomTabletModel(myemulation, myfile);
        this.mykeyboardmodel = new USBKeyboardModel(myemulation, myfile);
        this.mybraillemodel = new USBBrailleModel(myemulation, myfile);
        this.mydiskmodel = new USBDiskModel(myemulation, myfile);
        this.myserialmodel = new USBSerialModel(myemulation, myfile);
        this.mynetmodel = new USBNetModel(myemulation, myfile);
    }

    public void change_my_visibility(boolean value) {
        this.myview.setVisible(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("eraseButton")) {

            if (this.myview.getUsb().isSelected()) {
                this.mydrivermodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBDRIVEROPTION.getValor()]);
                this.myview.getUsb().setSelected(false);
            }

            if (this.myview.getMouse().isSelected()) {
                this.mymousemodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBMOUSEOPTION.getValor()],
                        OptionsEnumModel.USBMOUSEOPTION.getValor());
                this.myview.getMouse().setSelected(false);
            }

            if (this.myview.getTablet().isSelected()) {
                this.mytabletmodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBTABLETOPTION.getValor()]);
                this.myview.getTablet().setSelected(false);
            }

            if (this.myview.getWacomTablet().isSelected()) {
                this.mywacomtabletmodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBWACOMTABLETOPTION.getValor()]);
                this.myview.getWacomTablet().setSelected(false);
            }

            if (this.myview.getKeyboard().isSelected()) {
                this.mykeyboardmodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBKEYBOARDOPTION.getValor()]);
                this.myview.getKeyboard().setSelected(false);
            }

            if (this.myview.getBraille().isSelected()) {
                this.mybraillemodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBBRAILLEOPTION.getValor()]);
                this.myview.getBraille().setSelected(false);
            }

            if (this.myview.getDisk().isSelected()) {
                this.mydiskmodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBDISKOPTION.getValor()]);
                this.myview.getDisk().setSelected(false);
                this.myview.getFile().setText("");
            }

            if (this.myview.getSerial().isSelected()) {
                this.myserialmodel.setVendorid("");
                this.myserialmodel.setProductid("");
                this.myserialmodel.setDev("");
                this.myserialmodel.setOption();
                this.myserialmodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBSERIALOPTION.getValor()]);
                this.myview.getSerial().setSelected(false);
                this.myview.getVendorid().setText("");
                this.myview.getProductid().setText("");
                this.myview.getDev().setText("");
            }

            if (this.myview.getNet().isSelected()) {
                this.mynetmodel.setVlan("");
                this.mynetmodel.setMacaddr("");
                this.mynetmodel.setName("");
                this.mynetmodel.setAddr("");
                this.mynetmodel.setVectors("");
                this.mynetmodel.setOption();
                this.mynetmodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBNETOPTION.getValor()]);
                this.myview.getNet().setSelected(false);
                this.myview.getVlan().setSelectedIndex(0);
                this.myview.getMacaddr().setText("");
                this.myview.setName("");
                this.myview.getAddr().setText("");
                this.myview.getVectorsNumber().setSelectedIndex(0);
            }

            this.change_my_visibility(false);
        } else if (e.getActionCommand().equals("okButton")) {

            if (this.myview.getUsb().isSelected()) {
                this.mydrivermodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBDRIVEROPTION.getValor()]);
            } else {
                this.mydrivermodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBDRIVEROPTION.getValor()]);
            }

            if (this.myview.getMouse().isSelected()) {
                this.mymousemodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBMOUSEOPTION.getValor()]);
            } else {
                this.mymousemodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBMOUSEOPTION.getValor()],
                        OptionsEnumModel.USBMOUSEOPTION.getValor());
            }

            if (this.myview.getTablet().isSelected()) {
                this.mytabletmodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBTABLETOPTION.getValor()]);
            } else {
                this.mytabletmodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBTABLETOPTION.getValor()],
                        OptionsEnumModel.USBTABLETOPTION.getValor());
            }

            if (this.myview.getWacomTablet().isSelected()) {
                this.mywacomtabletmodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBWACOMTABLETOPTION.getValor()]);
            } else {
                this.mywacomtabletmodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBWACOMTABLETOPTION.getValor()]);
            }

            if (this.myview.getKeyboard().isSelected()) {
                this.mykeyboardmodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBKEYBOARDOPTION.getValor()]);
            } else {
                this.mykeyboardmodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBKEYBOARDOPTION.getValor()]);
            }

            if (this.myview.getBraille().isSelected()) {
                this.mybraillemodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBBRAILLEOPTION.getValor()]);
            } else {
                this.mybraillemodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBBRAILLEOPTION.getValor()]);
            }

            if (this.myview.getDisk().isSelected()) {
                if (!this.myview.getFile().getText().isEmpty()) {
                    this.mydiskmodel.setFile(this.myview.getFile().getText());
                    this.mydiskmodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBDISKOPTION.getValor()]);
                } else {
                    this.myview.getFile().setText(this.mydiskmodel.getFile());
                }
            } else {
                this.mydiskmodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBDISKOPTION.getValor()]);
                this.myview.getFile().setText("");
            }

            if (this.myview.getSerial().isSelected()) {
                this.myserialmodel.setDev(this.myview.getDev().getText());
                this.myserialmodel.setVendorid(this.myview.getVendorid().getText());
                this.myserialmodel.setProductid(this.myview.getProductid().getText());
                this.myserialmodel.setOption();
                this.myserialmodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBSERIALOPTION.getValor()]);
            } else {
                this.myserialmodel.setVendorid("");
                this.myserialmodel.setProductid("");
                this.myserialmodel.setDev("");
                this.myserialmodel.setOption();
                this.myserialmodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBSERIALOPTION.getValor()]);
                this.myview.getVendorid().setText("");
                this.myview.getProductid().setText("");
                this.myview.getDev().setText("");
            }

            if (this.myview.getNet().isSelected()) {
                this.mynetmodel.setVlan((String) this.myview.getVlan().getSelectedItem());
                this.mynetmodel.setMacaddr(this.myview.getMacaddr().getText());
                this.mynetmodel.setName(this.myview.getName());
                this.mynetmodel.setAddr(this.myview.getAddr().getText());
                this.mynetmodel.setVectors((String) this.myview.getVectorsNumber().getSelectedItem());
                this.mynetmodel.setOption();
                this.mynetmodel.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBNETOPTION.getValor()]);
            } else {
                this.mynetmodel.setVlan("");
                this.mynetmodel.setMacaddr("");
                this.mynetmodel.setName("");
                this.mynetmodel.setAddr("");
                this.mynetmodel.setVectors("");
                this.mynetmodel.setOption();
                this.mynetmodel.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.USBNETOPTION.getValor()]);
                this.myview.getNet().setSelected(false);
                this.myview.getVlan().setSelectedIndex(0);
                this.myview.getMacaddr().setText("");
                this.myview.setName("");
                this.myview.getAddr().setText("");
                this.myview.getVectorsNumber().setSelectedIndex(0);
            }

            this.change_my_visibility(false);
        } else if (e.getActionCommand().equals("fileChooser")) {
            this.myview.setChoosertitle("Choose the file  that is the basis for the USB Mass storage device!");
            if (this.myview.chooseFiles()) {
                this.myview.getFile().setText(this.myview.getChoice());
            }
        }
    }

}
