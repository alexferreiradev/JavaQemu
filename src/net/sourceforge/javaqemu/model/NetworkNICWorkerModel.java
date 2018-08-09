package net.sourceforge.javaqemu.model;

import java.util.ArrayList;
import java.util.List;

public class NetworkNICWorkerModel {

    private NetworkWorkerModel mymodel;

    public NetworkNICWorkerModel(NetworkWorkerModel mymodel) {
        this.mymodel = mymodel;
    }

    public void buildIt(String vlan,
            String macaddr,
            String model,
            String name,
            String addr,
            String vectors) {
        List<String> result = new ArrayList<String>();
        result.add("nic");
        if (vlan != null) {
            if (!vlan.isEmpty()) {
                result.add("vlan=" + vlan);
            }
        }
        if (macaddr != null) {
            if (!macaddr.isEmpty()) {
                result.add("macaddr=" + macaddr);
            }
        }
        if (model != null) {
            if (!model.isEmpty()) {
                result.add("model=" + model);
            }
        }
        if (name != null) {
            if (!name.isEmpty()) {
                result.add("name=" + name);
            }
        }
        if (addr != null) {
            if (!addr.isEmpty()) {
                result.add("addr=" + addr);
            }
        }
        if (vectors != null) {
            if (!vectors.isEmpty()) {
                result.add("vectors=" + vectors);
            }
        }
        mymodel.buildIt("-net", result.toArray(new String[result.size()]));

    }
}
