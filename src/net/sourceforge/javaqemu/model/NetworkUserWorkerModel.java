package net.sourceforge.javaqemu.model;

import java.util.ArrayList;
import java.util.List;

public class NetworkUserWorkerModel {

    private NetworkWorkerModel mymodel;

    public NetworkUserWorkerModel(NetworkWorkerModel mymodel) {
        this.mymodel = mymodel;
    }

    public void buildIt(String vlan,
            String name,
            String net,
            String host,
            Boolean restrict,
            String hostname,
            String dhcpstart,
            String dns,
            List<String> dnssearch,
            String tftp,
            String bootfile,
            String smb,
            String smbserver,
            List<String> hostfwd,
            List<String> guestfwd) {
        List<String> result = new ArrayList<String>();
        result.add("user");
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
        if (net != null) {
            if (!net.isEmpty()) {
                result.add("net=" + net);
            }
        }
        if (host != null) {
            if (!host.isEmpty()) {
                result.add("host=" + host);
            }
        }
        if (restrict) {
            result.add("restrict=on");
        } else {
            result.add("restrict=off");
        }
        if (hostname != null) {
            if (!hostname.isEmpty()) {
                result.add("hostname=" + hostname);
            }
        }
        if (dhcpstart != null) {
            if (!dhcpstart.isEmpty()) {
                result.add("dhcpstart=" + dhcpstart);
            }
        }
        if (dns != null) {
            if (!dns.isEmpty()) {
                result.add("dns=" + dns);
            }
        }
        if (!dnssearch.isEmpty()) {
            for (String string : dnssearch) {
                result.add("dnssearch=" + string);
            }
        }
        if (tftp != null) {
            if (!tftp.isEmpty()) {
                result.add("tftp=" + tftp);
            }
        }
        if (bootfile != null) {
            if (!bootfile.isEmpty()) {
                result.add("bootfile=" + bootfile);
            }
        }
        if (smb != null) {
            if (!smb.isEmpty()) {
                result.add("smb=" + smb);
            }
        }
        if (smbserver != null) {
            if (!smbserver.isEmpty()) {
                result.add("smbserver=" + smbserver);
            }
        }
        if (!hostfwd.isEmpty()) {
            for (String string : hostfwd) {
                result.add("hostfwd=" + string);
            }
        }
        if (!guestfwd.isEmpty()) {
            for (String string : guestfwd) {
                result.add("guestfwd=" + string);
            }
        }
        mymodel.buildIt("-net", result.toArray(new String[result.size()]));

    }
}
