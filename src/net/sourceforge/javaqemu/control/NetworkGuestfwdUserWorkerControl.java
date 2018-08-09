package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.javaqemu.model.NetworkGuestfwdUserWorkerModel;
import net.sourceforge.javaqemu.view.NetworkGuestfwdUserWorkerView;

public class NetworkGuestfwdUserWorkerControl implements ActionListener {

    private NetworkGuestfwdUserWorkerModel mymodel;
    private NetworkGuestfwdUserWorkerView myview;
    private List<String> myResults;

    public NetworkGuestfwdUserWorkerControl(FileControl myfile, int position) {
        this.mymodel = new NetworkGuestfwdUserWorkerModel();
        this.myview = new NetworkGuestfwdUserWorkerView(myfile, position);
        this.myview.configureListener(this);
        this.myview.configureStandardMode();
        myResults = new ArrayList<String>();
    }

    public void change_my_visibility(boolean value) {
        this.myview.setVisible(value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("eraseButton")) {
            this.myview.getGuestfwd().setText("");
            this.myview.getOption().setText("");
            this.myview.getIpAddrServer().setText("");
            this.myview.getPort().setText("");
            this.myview.getSecondOption().setText("");
            this.myResults.clear();
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            this.myResults = this.mymodel.buildIt(this.myview.getGuestfwd()
                    .getText());
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("add")) {
            if (!this.myview.getIpAddrServer().getText().isEmpty()
                    || !this.myview.getPort().getText().isEmpty()
                    || !this.myview.getSecondOption().getText().isEmpty()) {
                this.myview.buildMe("tcp:"
                        + this.myview.getIpAddrServer().getText() + ":"
                        + this.myview.getPort().getText() + "-"
                        + this.myview.getSecondOption().getText());
            }
        } else if (e.getActionCommand().equals("remove")) {
            this.myview.removeMe(this.myview.getOption().getText());
        }
    }

    public List<String> getMyResults() {
        return this.myResults;
    }
}
