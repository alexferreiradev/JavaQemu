package net.sourceforge.javaqemu.model;

import java.io.File;
import java.util.ResourceBundle;

public class UsabilityModel {

    public static String getFileSeparator() {
        /*
		 * From:
		 * https://www.google.com.br/?gfe_rd=cr&ei=_q-BVLWKN4eX8Qf85IGYBA#q=file.pathseparator+java&safe=active
		 * to:
		 * http://stackoverflow.com/questions/5971964/file-separator-vs-pathseparator
         */
        return File.separator;
    }

    /*
	 * http://www.javaworld.com/article/2071275/core-java/when-runtime-exec---won-t.html
	 * http://alvinalexander.com/java/java-exec-processbuilder-process-1
	 * http://alvinalexander.com/java/java-exec-processbuilder-process-2
     */
    public static String[] getCmdLine(String option) {
        String separator = UsabilityModel.getFileSeparator();

        // MS Windows OSes
        if (separator.equals("\\")) {
            File file = new File("cmd.exe");
            if (file.exists()) {
                if (file.isFile()) {
                    if (file.canExecute()) {
                        String[] cmdLine = {
                            "cmd.exe",
                            "/C",
                            option
                        };
                        return cmdLine;
                    }
                }
            }
        } // Linux/BSD/Mac OSes
        else if (separator.equals("/")) {
            ResourceBundle bundle = ResourceBundle.getBundle("net.sourceforge.javaqemu.config/javaQemu");

            String binBashPath = bundle.getString("binBash");

            File file = new File(binBashPath);
            if (file.exists()) {
                if (file.isFile()) {
                    if (file.canExecute()) {
                        String[] cmdLine = {
                            binBashPath,
                            "-c",
                            option
                        };
                        return cmdLine;
                    }
                }
            }
        }
        return new String[0];
    }

    public static String fixPath(String path) {
        if (path.contains(" ")) {
            if (!path.contains("\"")) {
                StringBuilder sb = new StringBuilder("\"");
                sb.append(path).append("\"");
                path = sb.toString();
            }
        }
        return path;
    }
}
