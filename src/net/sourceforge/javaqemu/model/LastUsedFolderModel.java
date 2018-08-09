package net.sourceforge.javaqemu.model;

import java.util.HashMap;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("lastUsedFolderModel")
public class LastUsedFolderModel {

    private HashMap<String, String> map = null;

    public LastUsedFolderModel() {
        map = new HashMap<String, String>();
        setLastUsedFolder(LastUsedFolderEnumModel.OPENEXISTINGVM.getValor(), ".");
        setLastUsedFolder(LastUsedFolderEnumModel.SAVEEXISTINGVM.getValor(), ".");
        setLastUsedFolder(LastUsedFolderEnumModel.OPENEXISTINGJAVAQEMUCONFIGURATION.getValor(), ".");
        setLastUsedFolder(LastUsedFolderEnumModel.SAVEEXISTINGJAVAQEMUCONFIGURATION.getValor(), ".");
        setLastUsedFolder(LastUsedFolderEnumModel.SETDEFAULTVMDIRECTORY.getValor(), ".");
        setLastUsedFolder(LastUsedFolderEnumModel.SETQEMUEXECUTABLEDIRECTORY.getValor(), ".");
        setLastUsedFolder(LastUsedFolderEnumModel.SETQEMUIMGEXECUTABLEDIRECTORY.getValor(), ".");
        setLastUsedFolder(LastUsedFolderEnumModel.SETLOPTIONDIRECTORY.getValor(), ".");
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    public String getLastUsedFolder(String situationKey) {
        return getMap().get(situationKey);
    }

    public void setLastUsedFolder(String situationKey, String value) {
        getMap().put(situationKey, value);
        Model.saveUserConfigurationLocally(this);
    }
}
