package net.sourceforge.javaqemu.model;

import java.util.HashMap;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("lastUsedFileModel")
public class LastUsedFileModel {

    private HashMap<String, String> map = null;

    public LastUsedFileModel() {
        map = new HashMap<String, String>();
        setLastUsedFile(LastUsedFileEnumModel.SETQEMUEXECUTABLEFILE.getValor(), "qemu-system-i386");
        setLastUsedFile(LastUsedFileEnumModel.LOADJAVAQEMUCONFIGURATIONFILE.getValor(), "");
        setLastUsedFile(LastUsedFileEnumModel.SETQEMUIMGEXECUTABLEFILE.getValor(), "qemu-img");
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    public String getLastUsedFile(String situationKey) {
        return getMap().get(situationKey);
    }

    public void setLastUsedFile(String situationKey, String value) {
        getMap().put(situationKey, value);
        Model.saveUserConfigurationLocally(this);
    }
}
