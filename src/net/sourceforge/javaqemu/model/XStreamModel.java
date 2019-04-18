package net.sourceforge.javaqemu.model;

import java.util.HashMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.IntConverter;
import com.thoughtworks.xstream.converters.basic.StringConverter;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamModel {

    private XStream stream = null;

    public XStream getStream() {
        if (stream == null) {
            stream = new XStream(new DomDriver()) {
            	@Override
                protected void setupConverters() {
                }
            };
            stream.registerConverter(new ReflectionConverter(stream.getMapper(), stream.getReflectionProvider()), XStream.PRIORITY_VERY_LOW);
            stream.registerConverter(new IntConverter(), XStream.PRIORITY_NORMAL);
            stream.registerConverter(new StringConverter(), XStream.PRIORITY_NORMAL);
            stream.registerConverter(new CollectionConverter(stream.getMapper()), XStream.PRIORITY_NORMAL);
            stream.registerConverter(new MapConverter(stream.getMapper(), HashMap.class));
            stream.autodetectAnnotations(true);
            stream.alias("lastUsedFolderModel", LastUsedFolderModel.class);
            stream.alias("lastUsedFileModel", LastUsedFileModel.class);
            XStream.setupDefaultSecurity(stream);
            stream.allowTypes(new Class[] { LastUsedFolderModel.class,
            		LastUsedFileModel.class });
        }

        return stream;
    }
}
