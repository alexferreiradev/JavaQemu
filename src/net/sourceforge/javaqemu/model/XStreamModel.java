package net.sourceforge.javaqemu.model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamModel {

    private XStream stream = null;

    public XStream getStream() {
        if (stream == null) {
            stream = new XStream(new DomDriver());
            stream.autodetectAnnotations(true);
            stream.alias("lastUsedFolderModel", LastUsedFolderModel.class);
            stream.alias("lastUsedFileModel", LastUsedFileModel.class);
        }

        return stream;
    }
}
