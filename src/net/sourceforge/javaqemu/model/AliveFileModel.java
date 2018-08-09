package net.sourceforge.javaqemu.model;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.JLabel;

public abstract class AliveFileModel {

    private String qemuPathDir;
    private int type;
    private long timeStamp;
    private JLabel messages;

    public String getQemuPathDir() {
        return qemuPathDir;
    }

    public void setQemuPathDir(String qemuPathDir) {
        this.qemuPathDir = qemuPathDir;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public JLabel getMessages() {
        return messages;
    }

    public void setMessages(JLabel messages) {
        this.messages = messages;
    }

    public AliveFileModel(String qemuPathDir, int type, String messages) {
        this.qemuPathDir = qemuPathDir;
        this.type = type;
        this.timeStamp = 0;
        this.setMessages(new JLabel(messages));
    }

    public abstract void checks() throws IOException;

    public boolean isFileUpdated(File file) {
        if (this.timeStamp != file.lastModified()) {
            this.timeStamp = file.lastModified();
            /*
			 http://stackoverflow.com/questions/541749/how-to-determine-an-objects-class-in-java
             */
            if (this instanceof AliveErrorFileModel) {
                System.out.println("Arquivo, de erro, atualizado em: " + new Date(this.timeStamp));
            } else if (this instanceof AliveOutputFileModel) {
                System.out.println("Arquivo, de saida, atualizado em: " + new Date(this.timeStamp));
            }
            // Yes, file is updated
            return true;
        } else {
            // No, file is not updated
            return false;
        }
    }
}
