package net.sourceforge.javaqemu.model;

import java.io.File;

import net.sourceforge.javaqemu.view.UtilitiesView;

public class UserPreferencesModel {

    private static Boolean itWasCreated = false;
    private static Boolean itCanBeCreated = true;

    public static String getUserDataDirectory() {
        StringBuilder sb = new StringBuilder(512);
        sb.append(System.getProperty("user.home"))
                .append(File.separator).append(".javaQemu")
                .append(File.separator);
        File file = new File(sb.toString());
        if (!file.exists()) {
            try {
                itWasCreated = file.mkdirs();
            } catch (SecurityException ex) {
                itCanBeCreated = false;
            } finally {
                if (itCanBeCreated) {
                    if (itWasCreated) {
                        UtilitiesView.showMessageAnywhere("Congratulations! Your operating system support preferences writing to your user directory!\nBy the way, you will enjoy the user preference features.");
                    }
                }
            }
        }
        return sb.toString();
    }

    public static File getFileForCase(String className) {
        return getFileForGeneralCase(className, "xml");
    }

    public static File getFileForGeneralCase(String className, String type) {
        return new File(combine(getUserDataDirectory(), className + "." + type));
    }

    public static String combine(String path1, String path2) {
        File file1 = new File(path1);
        File file2 = new File(file1, path2);
        return file2.getPath();
    }

    public static Boolean getItWasCreated() {
        return itWasCreated;
    }

    public static Boolean getItCanBeCreated() {
        return itCanBeCreated;
    }
}
