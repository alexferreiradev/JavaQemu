package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.NetworkWorkerModel;
import net.sourceforge.javaqemu.view.NetworkWorkerView;

public class NetworkWorkerControl implements ActionListener {

    private NetworkWorkerView myview;
    private NetworkWorkerModel mymodel;
    private NetworkNICWorkerControl myniccontrol;
    private NetworkUserWorkerControl myusercontrol;
    private NetworkTapWorkerControl mytapcontrol;
    private NetworkBridgeWorkerControl mybridgecontrol;
    private NetworkTCPSocketWorkerControl mytcpsocketcontrol;
    private NetworkUDPSocketWorkerControl myudpsocketcontrol;
    private NetworkVdeWorkerControl myvdecontrol;
    private NetworkHubportWorkerControl myhubcontrol;
    private NetworkDumpWorkerControl mydumpcontrol;

    public NetworkWorkerControl(EmulationControl myemulation, FileControl myfile, int position) {
        this.mymodel = new NetworkWorkerModel(myemulation, myfile, position);
        this.myview = new NetworkWorkerView(myfile, position);
        this.myniccontrol = new NetworkNICWorkerControl(myfile, this.mymodel, position);
        this.myusercontrol = new NetworkUserWorkerControl(myfile, this.mymodel, position);
        this.mytapcontrol = new NetworkTapWorkerControl(myfile, this.mymodel, position);
        this.mybridgecontrol = new NetworkBridgeWorkerControl(myfile, this.mymodel, position);
        this.mytcpsocketcontrol = new NetworkTCPSocketWorkerControl(myfile, this.mymodel, position);
        this.myudpsocketcontrol = new NetworkUDPSocketWorkerControl(myfile, this.mymodel, position);
        this.myvdecontrol = new NetworkVdeWorkerControl(myfile, this.mymodel, position);
        this.myhubcontrol = new NetworkHubportWorkerControl(myfile, this.mymodel, position);
        this.mydumpcontrol = new NetworkDumpWorkerControl(myfile, this.mymodel, position);
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
        if (e.getActionCommand().equals("disableButton")) {
            if (this.myniccontrol.isSelected()
                    || this.myusercontrol.isSelected()
                    || this.mytapcontrol.isSelected()
                    || this.mybridgecontrol.isSelected()
                    || this.mytcpsocketcontrol.isSelected()
                    || this.myudpsocketcontrol.isSelected()
                    || this.myvdecontrol.isSelected()
                    || this.myhubcontrol.isSelected()
                    || this.mydumpcontrol.isSelected()) {
                if (this.myview.getIsEnabled().isSelected()) {
                    this.myview.getIsEnabled().setSelected(false);
                }
                String[] options = new String[1];
                options[0] = "";
                this.mymodel.buildIt("-net", options);
            }
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            if (!this.myniccontrol.isSelected()
                    && !this.myusercontrol.isSelected()
                    && !this.mytapcontrol.isSelected()
                    && !this.mybridgecontrol.isSelected()
                    && !this.mytcpsocketcontrol.isSelected()
                    && !this.myudpsocketcontrol.isSelected()
                    && !this.myvdecontrol.isSelected()
                    && !this.myhubcontrol.isSelected()
                    && !this.mydumpcontrol.isSelected()
                    && this.myview.getIsEnabled().isSelected()) {
                String[] options = new String[1];
                options[0] = "";
                this.mymodel.buildIt("-net", options);
            }
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("nicOptions")) {
            this.myniccontrol.change_my_visibility(true);
        } else if (e.getActionCommand().equals("userOption")) {
            this.myusercontrol.change_my_visibility(true);
        } else if (e.getActionCommand().equals("tapOption")) {
            this.mytapcontrol.change_my_visibility(true);
        } else if (e.getActionCommand().equals("bridgeOption")) {
            this.mybridgecontrol.change_my_visibility(true);
        } else if (e.getActionCommand().equals("tcpSocketOption")) {
            this.mytcpsocketcontrol.change_my_visibility(true);
        } else if (e.getActionCommand().equals("udpSocketOption")) {
            this.myudpsocketcontrol.change_my_visibility(true);
        } else if (e.getActionCommand().equals("vdeOption")) {
            this.myvdecontrol.change_my_visibility(true);
        } else if (e.getActionCommand().equals("hubportOption")) {
            this.myhubcontrol.change_my_visibility(true);
        } else if (e.getActionCommand().equals("dumpOption")) {
            this.mydumpcontrol.change_my_visibility(true);
        }
    }

    public Boolean isEnabled() {
        return this.myview.getIsEnabled().isSelected();
    }

    public void cleanMe() {
        if (this.mymodel.getOption().equals("user")) {
            this.mytapcontrol.cleanMe();
            this.mybridgecontrol.cleanMe();
            this.mytcpsocketcontrol.cleanMe();
            this.myudpsocketcontrol.cleanMe();
            this.myvdecontrol.cleanMe();
            this.mydumpcontrol.cleanMe();
        } else if (this.mymodel.getOption().equals("tap")) {
            this.myusercontrol.cleanMe();
            this.mybridgecontrol.cleanMe();
            this.mytcpsocketcontrol.cleanMe();
            this.myudpsocketcontrol.cleanMe();
            this.myvdecontrol.cleanMe();
            this.mydumpcontrol.cleanMe();
        } else if (this.mymodel.getOption().equals("bridge")) {
            this.mytapcontrol.cleanMe();
            this.myusercontrol.cleanMe();
            this.mytcpsocketcontrol.cleanMe();
            this.myudpsocketcontrol.cleanMe();
            this.myvdecontrol.cleanMe();
            this.mydumpcontrol.cleanMe();
        } else if (this.mymodel.getOption().equals("socket")) {
            this.mytapcontrol.cleanMe();
            this.myusercontrol.cleanMe();
            this.mydumpcontrol.cleanMe();
            this.mybridgecontrol.cleanMe();
            this.myvdecontrol.cleanMe();
            if (this.mytcpsocketcontrol.getDate().after(myudpsocketcontrol.getDate())) {
                this.myudpsocketcontrol.cleanMe();
            } else {
                this.mytcpsocketcontrol.cleanMe();
            }
        } else if (this.mymodel.getOption().equals("vde")) {
            this.mytapcontrol.cleanMe();
            this.myusercontrol.cleanMe();
            this.mytcpsocketcontrol.cleanMe();
            this.myudpsocketcontrol.cleanMe();
            this.mydumpcontrol.cleanMe();
            this.mybridgecontrol.cleanMe();
        } else if (this.mymodel.getOption().equals("dump")) {
            this.mytapcontrol.cleanMe();
            this.myusercontrol.cleanMe();
            this.mytcpsocketcontrol.cleanMe();
            this.myudpsocketcontrol.cleanMe();
            this.mybridgecontrol.cleanMe();
            this.myvdecontrol.cleanMe();
        }
    }
}
