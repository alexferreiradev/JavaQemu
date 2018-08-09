package net.sourceforge.javaqemu.model;

import java.util.ArrayList;
import java.util.List;

public class NetworkTapWorkerModel {

    private NetworkWorkerModel mymodel;

    public NetworkTapWorkerModel(NetworkWorkerModel mymodel) {
        this.mymodel = mymodel;
    }

    public void buildIt(String vlan,
            String name,
            String fd,
            String script,
            String downscript,
            String helper) {
        List<String> result = new ArrayList<String>();
        result.add("tap");
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
        if (script != null) {
            if (!script.isEmpty()) {
                result.add("script=" + script);
            }
        }
        if (downscript != null) {
            if (!downscript.isEmpty()) {
                result.add("downscript=" + downscript);
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
