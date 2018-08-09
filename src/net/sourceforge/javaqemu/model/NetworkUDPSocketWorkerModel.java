package net.sourceforge.javaqemu.model;

import java.util.ArrayList;
import java.util.List;

public class NetworkUDPSocketWorkerModel {

    private NetworkWorkerModel mymodel;

    public NetworkUDPSocketWorkerModel(NetworkWorkerModel mymodel) {
        this.mymodel = mymodel;
    }

    public void buildIt(String vlan, String name, String fd, String maddr,
            String port, String addr) {
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
        if (maddr != null && port == null) {
            if (!maddr.isEmpty()) {
                result.add("mcast=" + maddr + ":");
            }
        } else if (maddr == null && port != null) {
            if (!port.isEmpty()) {
                result.add("mcast=:" + port);
            }
        } else if (maddr != null && port != null) {
            if (!maddr.isEmpty() || !port.isEmpty()) {
                result.add("mcast=" + maddr + ":" + port);
            }
        }
        if (addr != null) {
            if (!addr.isEmpty()) {
                result.add("localaddr=" + addr);
            }
        }

        mymodel.buildIt("-net", result.toArray(new String[result.size()]));
    }

}
