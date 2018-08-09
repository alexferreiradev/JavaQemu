package net.sourceforge.javaqemu.model;

import java.util.ArrayList;
import java.util.List;

public class NetworkVdeWorkerModel {

    private NetworkWorkerModel mymodel;

    public NetworkVdeWorkerModel(NetworkWorkerModel mymodel) {
        this.mymodel = mymodel;
    }

    public void buildIt(String vlan, String name, String sock, String port,
            String group, String mode) {
        List<String> result = new ArrayList<String>();
        result.add("vde");
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
        if (sock != null) {
            if (!sock.isEmpty()) {
                result.add("sock=" + sock);
            }
        }
        if (port != null) {
            if (!port.isEmpty()) {
                result.add("port=" + port);
            }
        }
        if (group != null) {
            if (!group.isEmpty()) {
                result.add("group=" + group);
            }
        }
        if (mode != null) {
            if (!mode.isEmpty()) {
                result.add("mode=" + mode);
            }
        }
        mymodel.buildIt("-net", result.toArray(new String[result.size()]));
    }
}
