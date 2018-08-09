package net.sourceforge.javaqemu.model;

import java.util.ArrayList;
import java.util.List;

public class NetworkDumpWorkerModel {

    private NetworkWorkerModel mymodel;

    public NetworkDumpWorkerModel(NetworkWorkerModel mymodel) {
        this.mymodel = mymodel;
    }

    public void buildIt(String vlan, String file, String len) {
        List<String> result = new ArrayList<String>();
        result.add("dump");
        if (vlan != null) {
            if (!vlan.isEmpty()) {
                result.add("vlan=" + vlan);
            }
        }
        if (file != null) {
            if (!file.isEmpty()) {
                result.add("file=" + file);
            }
        }
        if (len != null) {
            if (!len.isEmpty()) {
                result.add("len=" + len);
            }
        }
        mymodel.buildIt("-net", result.toArray(new String[result.size()]));
    }
}
