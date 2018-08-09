package net.sourceforge.javaqemu.control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import net.sourceforge.javaqemu.model.FileModel;
import net.sourceforge.javaqemu.view.FileView;
import net.sourceforge.javaqemu.view.View;

public class FileControl {

    private List<FileModel> mymodel;

    private FileView myview;
    private int position;
    private View view;

    public FileControl(JPanel jpanel, View view) {
        super();
        mymodel = new ArrayList<FileModel>();
        myview = new FileView(jpanel);
        this.view = view;
    }

    public FileModel getMymodel() {
        if (this.view != null) {
            if (this.view.getActivePanel() == 0) {
                position = this.view.getSizeOfJTabbedPane();
            } else {
                position = this.view.getActivePanel();
            }
        } else {
            position = 0;
        }

        if (this.mymodel.size() <= position) {
            for (int i = this.mymodel.size(); i <= position; i++) {
                this.mymodel.add(i, null);
            }
        }
        if (this.mymodel.get(position) == null) {
            this.mymodel.set(position, new FileModel());
        }
        return mymodel.get(position);
    }

    public FileView getMyview() {
        return myview;
    }
}
