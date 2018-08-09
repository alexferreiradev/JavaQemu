package net.sourceforge.javaqemu.model;

import java.util.ArrayList;
import java.util.List;

public class NetworkHostfwdUserWorkerModel {

    public List<String> buildIt(String hostfwd) {
        List<String> result = new ArrayList<String>();
        String[] options = hostfwd.split("\n");
        for (String option : options) {
            result.add(option);
        }
        return result;
    }
}
