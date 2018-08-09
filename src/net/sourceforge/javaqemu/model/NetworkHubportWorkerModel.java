package net.sourceforge.javaqemu.model;

import java.util.ArrayList;
import java.util.List;

public class NetworkHubportWorkerModel {

    private NetworkWorkerModel mymodel;

    public NetworkHubportWorkerModel(NetworkWorkerModel mymodel) {
        this.mymodel = mymodel;
    }

    public void buildIt(String id, String hubid) {
        List<String> result = new ArrayList<String>();
        result.add("hubport");
        if (id != null) {
            if (!id.isEmpty()) {
                result.add("id=" + id);
            }
        }
        if (hubid != null) {
            if (!hubid.isEmpty()) {
                result.add("hubid=" + hubid);
            }
        }

        mymodel.buildIt("-netdev", result.toArray(new String[result.size()]));
    }
}
