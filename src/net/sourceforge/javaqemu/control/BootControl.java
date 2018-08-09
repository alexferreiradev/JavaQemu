package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import net.sourceforge.javaqemu.model.BootModel;
import net.sourceforge.javaqemu.view.BootView;

public class BootControl implements ActionListener {

    private BootModel mymodel;
    private BootView myview;
    private FileControl myfile;

    public BootControl(EmulationControl myemulation, FileControl myfile) {
        this.mymodel = new BootModel(myemulation);
        this.myview = new BootView(myfile);
        this.myfile = myfile;
        if (myfile.getMymodel().getBootOrder1() != null
                || myfile.getMymodel().getBootOrder2() != null
                || myfile.getMymodel().getBootOrder3() != null
                || myfile.getMymodel().getBootOnce1() != null
                || myfile.getMymodel().getBootOnce2() != null
                || myfile.getMymodel().getBootOnce3() != null
                || myfile.getMymodel().getBootMenu() != null
                || myfile.getMymodel().getBootSplash() != null
                || myfile.getMymodel().getBootSplashTime() != null
                || myfile.getMymodel().getBootRebootTimeout() != null
                || myfile.getMymodel().getBootStrict() != null) {
            this.mymodel.buildIt(this.mymodel.buildOrderOrOnce(
                    (String) this.myview.getFirstOrder().getSelectedItem(),
                    (String) this.myview.getSecondOrder().getSelectedItem(),
                    (String) this.myview.getThirdOrder().getSelectedItem()),
                    this.mymodel.buildOrderOrOnce((String) this.myview
                            .getFirstOnce().getSelectedItem(),
                            (String) this.myview.getSecondOnce()
                            .getSelectedItem(), (String) this.myview
                            .getThirdOnce().getSelectedItem()),
                    (String) this.myview.getMenu().getSelectedItem(),
                    (String) this.myview.getSplashName().getText(), this
                    .buildString(this.myview.getSplashTime(),
                            this.myview.getEditor1().getTextField()
                            .getText().replace(".", "")
                            .replace(",", ".")), this
                    .buildString(this.myview.getRebootTimeout(),
                            this.myview.getEditor2().getTextField()
                            .getText().replace(".", "")
                            .replace(",", ".")),
                    (String) this.myview.getStrict().getSelectedItem());
        }
    }

    public void starts() {
        this.myview.configureListener(this);
        this.myview.configureStandardMode();
    }

    public void change_my_visibility(Boolean value) {
        this.myview.setVisible(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("eraseButton")) {
            if (this.myview.getFirstOrder().getSelectedIndex() != 0) {
                this.myview.getFirstOrder().setSelectedIndex(0);
            }
            myfile.getMymodel().setBootOrder1("");

            if (this.myview.getSecondOrder().getSelectedIndex() != 0) {
                this.myview.getSecondOrder().setSelectedIndex(0);
            }
            myfile.getMymodel().setBootOrder2("");

            if (this.myview.getThirdOrder().getSelectedIndex() != 0) {
                this.myview.getThirdOrder().setSelectedIndex(0);
            }
            myfile.getMymodel().setBootOrder3("");

            if (this.myview.getFirstOnce().getSelectedIndex() != 0) {
                this.myview.getFirstOnce().setSelectedIndex(0);
            }
            myfile.getMymodel().setBootOnce1("");

            if (this.myview.getSecondOnce().getSelectedIndex() != 0) {
                this.myview.getSecondOnce().setSelectedIndex(0);
            }
            myfile.getMymodel().setBootOnce2("");

            if (this.myview.getThirdOnce().getSelectedIndex() != 0) {
                this.myview.getThirdOnce().setSelectedIndex(0);
            }
            myfile.getMymodel().setBootOnce3("");

            if (this.myview.getMenu().getSelectedIndex() != 0) {
                this.myview.getMenu().setSelectedIndex(0);
            }
            myfile.getMymodel().setBootMenu(
                    (String) this.myview.getMenu().getSelectedItem());

            if (!this.myview.getSplashName().getText().isEmpty()) {
                this.myview.getSplashName().setText("");
            }
            this.myfile.getMymodel().setBootSplash(
                    this.myview.getSplashName().getText());

            if (this.myview.getSplashTime().isSelected()) {
                this.myview.getSplashTime().setSelected(false);
                this.myview.getEditor1().getTextField().setText("0");
            }
            this.myfile.getMymodel().setBootSplashTime("");

            if (this.myview.getRebootTimeout().isSelected()) {
                this.myview.getRebootTimeout().setSelected(false);
                this.myview.getEditor2().getTextField().setText("-1");
            }
            this.myfile.getMymodel().setBootRebootTimeout("");

            if (this.myview.getStrict().getSelectedIndex() != 0) {
                this.myview.getStrict().setSelectedIndex(0);
            }
            this.myfile.getMymodel().setBootStrict(
                    (String) this.myview.getStrict().getSelectedItem());

            this.mymodel.buildIt(this.mymodel.buildOrderOrOnce(
                    (String) this.myview.getFirstOrder().getSelectedItem(),
                    (String) this.myview.getSecondOrder().getSelectedItem(),
                    (String) this.myview.getThirdOrder().getSelectedItem()),
                    this.mymodel.buildOrderOrOnce((String) this.myview
                            .getFirstOnce().getSelectedItem(),
                            (String) this.myview.getSecondOnce()
                            .getSelectedItem(), (String) this.myview
                            .getThirdOnce().getSelectedItem()),
                    (String) this.myview.getMenu().getSelectedItem(),
                    (String) this.myview.getSplashName().getText(), this
                    .buildString(this.myview.getSplashTime(),
                            this.myview.getEditor1().getTextField()
                            .getText().replace(".", "")
                            .replace(",", ".")), this
                    .buildString(this.myview.getRebootTimeout(),
                            this.myview.getEditor2().getTextField()
                            .getText().replace(".", "")
                            .replace(",", ".")),
                    (String) this.myview.getStrict().getSelectedItem());
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            this.mymodel.buildIt(this.mymodel.buildOrderOrOnce(
                    (String) this.myview.getFirstOrder().getSelectedItem(),
                    (String) this.myview.getSecondOrder().getSelectedItem(),
                    (String) this.myview.getThirdOrder().getSelectedItem()),
                    this.mymodel.buildOrderOrOnce((String) this.myview
                            .getFirstOnce().getSelectedItem(),
                            (String) this.myview.getSecondOnce()
                            .getSelectedItem(), (String) this.myview
                            .getThirdOnce().getSelectedItem()),
                    (String) this.myview.getMenu().getSelectedItem(),
                    (String) this.myview.getSplashName().getText(), this
                    .buildString(this.myview.getSplashTime(),
                            this.myview.getEditor1().getTextField()
                            .getText().replace(".", "")
                            .replace(",", ".")), this
                    .buildString(this.myview.getRebootTimeout(),
                            this.myview.getEditor2().getTextField()
                            .getText().replace(".", "")
                            .replace(",", ".")),
                    (String) this.myview.getStrict().getSelectedItem());

            if (!((String) this.myview.getFirstOrder().getSelectedItem())
                    .isEmpty()) {
                myfile.getMymodel()
                        .setBootOrder1(
                                ((String) this.myview.getFirstOrder()
                                .getSelectedItem()).substring(0, 1));
            } else {
                myfile.getMymodel().setBootOrder1("");
            }

            if (!((String) this.myview.getSecondOrder().getSelectedItem())
                    .isEmpty()) {
                myfile.getMymodel().setBootOrder2(
                        ((String) this.myview.getSecondOrder()
                        .getSelectedItem()).substring(0, 1));
            } else {
                myfile.getMymodel().setBootOrder2("");
            }

            if (!((String) this.myview.getThirdOrder().getSelectedItem())
                    .isEmpty()) {
                myfile.getMymodel()
                        .setBootOrder3(
                                ((String) this.myview.getThirdOrder()
                                .getSelectedItem()).substring(0, 1));
            } else {
                myfile.getMymodel().setBootOrder3("");
            }

            if (!((String) this.myview.getFirstOnce().getSelectedItem())
                    .isEmpty()) {
                myfile.getMymodel().setBootOnce1(
                        ((String) this.myview.getFirstOnce().getSelectedItem())
                        .substring(0, 1));
            } else {
                myfile.getMymodel().setBootOnce1("");
            }

            if (!((String) this.myview.getSecondOnce().getSelectedItem())
                    .isEmpty()) {
                myfile.getMymodel()
                        .setBootOnce2(
                                ((String) this.myview.getSecondOnce()
                                .getSelectedItem()).substring(0, 1));
            } else {
                myfile.getMymodel().setBootOnce2("");
            }

            if (!((String) this.myview.getThirdOnce().getSelectedItem())
                    .isEmpty()) {
                myfile.getMymodel().setBootOnce3(
                        ((String) this.myview.getThirdOnce().getSelectedItem())
                        .substring(0, 1));
            } else {
                myfile.getMymodel().setBootOnce3("");
            }

            myfile.getMymodel().setBootMenu(
                    (String) this.myview.getMenu().getSelectedItem());

            this.myfile.getMymodel().setBootSplash(
                    this.myview.getSplashName().getText());

            this.myfile.getMymodel().setBootSplashTime(
                    this.buildString(this.myview.getSplashTime(), this.myview
                            .getEditor1().getTextField().getText()));

            this.myfile.getMymodel().setBootRebootTimeout(
                    this.buildString(this.myview.getRebootTimeout(),
                            this.myview.getEditor2().getTextField().getText()));

            this.myfile.getMymodel().setBootStrict(
                    (String) this.myview.getStrict().getSelectedItem());

            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("splashButton")) {
            if (this.myview.chooseSplashPicture()) {
                this.myview.getSplashName().setText(this.myview.getChoice());
                this.myfile.getMymodel().setBootSplash(
                        this.myview.getSplashName().getText());
            }
        } else if (e.getActionCommand().equals("firstOrder")
                || e.getActionCommand().equals("secondOrder")
                || e.getActionCommand().equals("thirdOrder")) {
            this.myview.resolveOrderOptions();
        } else if (e.getActionCommand().equals("firstOnce")
                || e.getActionCommand().equals("secondOnce")
                || e.getActionCommand().equals("thirdOnce")) {
            this.myview.resolveOnceOptions();
        }
    }

    public String buildString(JCheckBox mycheckbox, String mystring) {
        if (mycheckbox.isSelected()) {
            return mystring;
        } else {
            return "";
        }
    }

}
