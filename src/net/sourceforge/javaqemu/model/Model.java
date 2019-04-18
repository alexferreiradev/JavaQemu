package net.sourceforge.javaqemu.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

import javax.swing.DefaultListModel;

import net.sourceforge.javaqemu.control.XStreamControl;

public class Model {

    private static String version = "v0.2.0a9";

    public static String getApplicationVersionString() {
        return version;
    }

    public static Boolean containCommonRoot(DefaultListModel<String> model, String option) {
        Boolean result = false;
        String[] subOptions = option.split(" ");

        for (Object element : model.toArray()) {
            String[] subElements = element.toString().split(" ");
            if (subElements[0].equals(subOptions[0])) {
                result = true;
                break;
            }
        }

        return result;
    }

    public static void saveUserConfigurationLocally(Object configuration) {
        Boolean itHasEnd = true;
        OutputStreamWriter fileWriter = null;
        FileOutputStream fileOutStream = null;
        try {
            if (configuration instanceof LastUsedFolderModel) {
                fileOutStream = new FileOutputStream(
                        UserPreferencesModel
                        .getFileForCase(LastUsedFolderModel.class
                                .getName()));
            } else if (configuration instanceof LastUsedFileModel) {
                fileOutStream = new FileOutputStream(
                        UserPreferencesModel
                        .getFileForCase(LastUsedFileModel.class
                                .getName()));
            }

            if (fileOutStream != null) {
                fileWriter = new OutputStreamWriter(fileOutStream,
                        Charset.forName("UTF8"));
            }
        } catch (FileNotFoundException e2) {
            itHasEnd = false;
        } finally {
            if (itHasEnd) {
                BufferedWriter bw = new BufferedWriter(fileWriter);
                try {
                    bw.write(XStreamControl.getInstance()
                            .getMyModel().getStream()
                            .toXML(configuration));
                } catch (IOException e2) {

                } finally {
                    try {
                        bw.close();
                    } catch (IOException e1) {

                    }
                }
            }

            try {
                if (fileOutStream != null) {
                    fileOutStream.close();
                }
            } catch (IOException e2) {

            } finally {
                try {
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (IOException e1) {

                }
            }
        }
    }

    public static Object loadUserConfigurationLocally(String className) {
        Object result = null;
        Boolean itHasResult = true;
        InputStreamReader fileReader = null;
        try {
            fileReader = new InputStreamReader(new FileInputStream(
                    UserPreferencesModel.getFileForCase(className)), Charset.forName("UTF-8"));
        } catch (FileNotFoundException e) {
            itHasResult = false;
        } finally {
            if (itHasResult) {
                BufferedReader br = new BufferedReader(fileReader);
                if (className.equals(LastUsedFolderModel.class.getName())) {
                    result = (LastUsedFolderModel) XStreamControl.getInstance()
                            .getMyModel().getStream().fromXML(br);
                } else if (className.equals(LastUsedFileModel.class.getName())) {
                    result = (LastUsedFileModel) XStreamControl.getInstance()
                            .getMyModel().getStream().fromXML(br);
                }
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Class<?> clazz;
                try {
                    clazz = Class.forName(className);
                    Constructor<?> ctor = clazz.getConstructor();
                    result = ctor.newInstance();
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {

            }
        }

        return result;
    }

    public static String combine(String path1, String path2) {
        File file1 = new File(path1);
        File file2 = new File(file1, path2);
        return file2.getPath();
    }

    public static Boolean isValidString(String string) {
        if (string == null) {
            return false;
        } else if (string.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
