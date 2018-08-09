package net.sourceforge.javaqemu.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.javaqemu.model.NetworkDnssearchUserWorkerModel;
import net.sourceforge.javaqemu.view.NetworkDnssearchUserWorkerView;

public class NetworkDnssearchUserWorkerControl implements ActionListener {

    private NetworkDnssearchUserWorkerView myview;
    private NetworkDnssearchUserWorkerModel mymodel;
    private List<String> myResults;

    public NetworkDnssearchUserWorkerControl(FileControl myfile, int position) {
        this.mymodel = new NetworkDnssearchUserWorkerModel();
        this.myview = new NetworkDnssearchUserWorkerView(myfile, position);
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
            this.myview.getDnssearch().setText("");
            this.myview.getText().setText("");
            this.myview.getOption().setText("");
            this.myResults.clear();
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("okButton")) {
            this.myResults = this.mymodel.buildIt(this.myview.getDnssearch()
                    .getText());
            this.myview.setVisible(false);
        } else if (e.getActionCommand().equals("add")) {
            if (!this.myview.getText().getText().isEmpty()) {
                this.myview.buildMe(this.myview.getText().getText());
            }
        } else if (e.getActionCommand().equals("remove")) {
            this.myview.removeMe(this.myview.getOption().getText());
        }
    }

    public List<String> getMyResults() {
        return this.myResults;
    }

}
