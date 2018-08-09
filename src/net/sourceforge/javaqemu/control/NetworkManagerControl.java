package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.javaqemu.model.NetworkManagerModel;
import net.sourceforge.javaqemu.view.NetworkManagerView;

public class NetworkManagerControl implements ActionListener {

    private NetworkManagerView myview;
    private NetworkManagerModel mymodel;
    private NetworkWorkerControl mycontrol[];

    public NetworkManagerControl(EmulationControl myemulation,
            FileControl myfile) {
        this.myview = new NetworkManagerView();
        this.myview.configureListener(this);
        this.myview.configureStandardMode();
        this.mycontrol = new NetworkWorkerControl[NetworkManagerView.networkOptionsNumber];
        for (int i = 0; i < NetworkManagerView.networkOptionsNumber; i++) {
            this.mycontrol[i] = new NetworkWorkerControl(myemulation, myfile,
                    (i + 1));
            this.mycontrol[i].starts();
        }
        this.mymodel = new NetworkManagerModel(myemulation, myfile);
        if ((!mycontrol[0].isEnabled() && !mycontrol[1].isEnabled()
                && !mycontrol[2].isEnabled() && !mycontrol[3].isEnabled()
                && !mycontrol[4].isEnabled() && !mycontrol[5].isEnabled()
                && !mycontrol[6].isEnabled() && !mycontrol[7].isEnabled()
                && !mycontrol[8].isEnabled() && !mycontrol[9].isEnabled())) {
            this.mymodel.setOption("none");
            this.mymodel.buildIt("none");
        }
    }

    public void change_my_visibility(boolean value) {
        this.myview.setVisible(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("hideButton")) {
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            if ((!mycontrol[0].isEnabled() && !mycontrol[1].isEnabled()
                    && !mycontrol[2].isEnabled() && !mycontrol[3].isEnabled()
                    && !mycontrol[4].isEnabled() && !mycontrol[5].isEnabled()
                    && !mycontrol[6].isEnabled() && !mycontrol[7].isEnabled()
                    && !mycontrol[8].isEnabled() && !mycontrol[9].isEnabled())) {
                this.mymodel.setOption("none");
                this.mymodel.buildIt("none");
            }
            for (int i = 0; i < NetworkManagerView.networkOptionsNumber; i++) {
                if (this.mycontrol[i].isEnabled()) {
                    this.mycontrol[i].cleanMe();
                }
            }
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("networkOption1")) {
            this.mycontrol[0].change_the_visibility_of_view(true);
        } else if (e.getActionCommand().equals("networkOption2")) {
            this.mycontrol[1].change_the_visibility_of_view(true);
        } else if (e.getActionCommand().equals("networkOption3")) {
            this.mycontrol[2].change_the_visibility_of_view(true);
        } else if (e.getActionCommand().equals("networkOption4")) {
            this.mycontrol[3].change_the_visibility_of_view(true);
        } else if (e.getActionCommand().equals("networkOption5")) {
            this.mycontrol[4].change_the_visibility_of_view(true);
        } else if (e.getActionCommand().equals("networkOption6")) {
            this.mycontrol[5].change_the_visibility_of_view(true);
        } else if (e.getActionCommand().equals("networkOption7")) {
            this.mycontrol[6].change_the_visibility_of_view(true);
        } else if (e.getActionCommand().equals("networkOption8")) {
            this.mycontrol[7].change_the_visibility_of_view(true);
        } else if (e.getActionCommand().equals("networkOption9")) {
            this.mycontrol[8].change_the_visibility_of_view(true);
        } else if (e.getActionCommand().equals("networkOption10")) {
            this.mycontrol[9].change_the_visibility_of_view(true);
        }
    }

}
