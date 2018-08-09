package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import net.sourceforge.javaqemu.model.NetworkHostfwdUserWorkerModel;
import net.sourceforge.javaqemu.view.NetworkHostfwdUserWorkerView;

public class NetworkHostfwdUserWorkerControl implements ActionListener {

    private NetworkHostfwdUserWorkerModel mymodel;
    private NetworkHostfwdUserWorkerView myview;
    private List<String> myResults;

    public NetworkHostfwdUserWorkerControl(FileControl myfile, int position) {
        this.mymodel = new NetworkHostfwdUserWorkerModel();
        this.myview = new NetworkHostfwdUserWorkerView(myfile, position);
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
            this.myview.getHostfwd().setText("");
            this.myview.getConnectionType().setSelectedIndex(0);
            this.myview.getHostaddr().setText("");
            this.myview.getHostport().setText("");
            this.myview.getGuestaddr().setText("");
            this.myview.getGuestport().setText("");
            this.myview.getOption().setText("");
            this.myResults.clear();
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            this.myResults = this.mymodel.buildIt(this.myview.getHostfwd()
                    .getText());
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("add")) {
            if (!this.myview.getHostaddr().getText().isEmpty()
                    || !this.myview.getHostport().getText().isEmpty()
                    || !this.myview.getGuestaddr().getText().isEmpty()
                    || !this.myview.getGuestport().getText().isEmpty()) {
                this.myview.buildMe(this.myview.getConnectionType()
                        .getSelectedItem().toString().toLowerCase(Locale.ENGLISH)
                        + ":"
                        + this.myview.getHostaddr().getText()
                        + ":"
                        + this.myview.getHostport().getText()
                        + "-"
                        + this.myview.getGuestaddr().getText()
                        + ":"
                        + this.myview.getGuestport().getText());
            }
        } else if (e.getActionCommand().equals("remove")) {
            this.myview.removeMe(this.myview.getOption().getText());
        }
    }

    public List<String> getMyResults() {
        return this.myResults;
    }
}
