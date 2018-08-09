package net.sourceforge.javaqemu.model;

import java.util.ArrayList;
import java.util.List;

public class NetworkTCPSocketWorkerModel {

    private NetworkWorkerModel mymodel;

    public NetworkTCPSocketWorkerModel(NetworkWorkerModel mymodel) {
        this.mymodel = mymodel;
    }

    public void buildIt(String vlan, String name, String fd, String hostListen,
            String portListen, String hostConnect, String portConnect) {
        List<String> result = new ArrayList<String>();
        result.add("socket");
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
        if (fd != null) {
            if (!fd.isEmpty()) {
                result.add("fd=" + fd);
            }
        }
        if (hostListen != null && portListen == null) {
            if (!hostListen.isEmpty()) {
                result.add("listen=" + hostListen + ":");
            }
        } else if (hostListen == null && portListen != null) {
            if (!portListen.isEmpty()) {
                result.add("listen=:" + portListen);
            }
        } else if (hostListen != null && portListen != null) {
            if (!hostListen.isEmpty() || !portListen.isEmpty()) {
                result.add("listen=" + hostListen + ":" + portListen);
            }
        }
        if (hostConnect != null && portConnect == null) {
            if (!hostConnect.isEmpty()) {
                result.add("connect=" + hostConnect + ":");
            }
        } else if (hostConnect == null && portConnect != null) {
            if (!portConnect.isEmpty()) {
                result.add("connect=:" + portConnect);
            }
        } else if (hostConnect != null && portConnect != null) {
            if (!hostConnect.isEmpty() || !portConnect.isEmpty()) {
                result.add("connect=" + hostConnect + ":" + portConnect);
            }
        }

        mymodel.buildIt("-net", result.toArray(new String[result.size()]));
    }
}
