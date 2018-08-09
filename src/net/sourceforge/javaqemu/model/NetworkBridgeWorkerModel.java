package net.sourceforge.javaqemu.model;

import java.util.ArrayList;
import java.util.List;

public class NetworkBridgeWorkerModel {

    private NetworkWorkerModel mymodel;

    public NetworkBridgeWorkerModel(NetworkWorkerModel mymodel) {
        this.mymodel = mymodel;
    }

    public void buildIt(String vlan,
            String name,
            String br,
            String helper) {
        List<String> result = new ArrayList<String>();
        result.add("bridge");
        if (vlan != null) {
            if (!vlan.isEmpty()) {
                result.add("vlan=" + vlan);
            }
        }

        if (name != null) {
            if (!name.isEmpty()) {
                result.add("name=" + name);
            }
        }

        if (br != null) {
            if (!br.isEmpty()) {
                result.add("br=" + br);
            }
        }

        if (helper != null) {
            if (!helper.isEmpty()) {
                result.add("helper=" + helper);
            }
        }
        mymodel.buildIt("-net", result.toArray(new String[result.size()]));
    }
}
