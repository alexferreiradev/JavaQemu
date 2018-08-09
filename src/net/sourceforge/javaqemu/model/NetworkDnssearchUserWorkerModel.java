package net.sourceforge.javaqemu.model;

import java.util.ArrayList;
import java.util.List;

public class NetworkDnssearchUserWorkerModel {

    public List<String> buildIt(String dnssearch) {
        List<String> result = new ArrayList<String>();
        String[] options = dnssearch.split("\n");
        for (String option : options) {
            result.add(option);
        }
        return result;
    }
}
