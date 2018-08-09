package net.sourceforge.javaqemu.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Locale;

import net.sourceforge.javaqemu.model.AliveFilesEnumModel;

public class ProcessMessageView implements PropertyChangeListener {

    private int type;
    private EmulationView myView;

    public ProcessMessageView(int type, EmulationView myView) {
        this.type = type;
        this.myView = myView;
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        if (propertyName.equals("text")) {
            if (type == AliveFilesEnumModel.STDERR.getValor()) {
                if (!(e.getNewValue().toString().toLowerCase(Locale.ENGLISH).contains("qemu")
                        && e.getNewValue().toString().toLowerCase(Locale.ENGLISH).contains("terminating")
                        && e.getNewValue().toString().toLowerCase(Locale.ENGLISH).contains("signal")
                        && e.getNewValue().toString().toLowerCase(Locale.ENGLISH).contains("pid"))) {
                    myView.showMessage("Qemu might be running now!\nExternal error message:\n" + e.getNewValue());

                }
            } else if (type == AliveFilesEnumModel.STDOUT.getValor()) {
                myView.showMessage("External output message:\n" + e.getNewValue());
            } else if (type == AliveFilesEnumModel.ERR.getValor()) {
                if (!(e.getNewValue().toString().toLowerCase(Locale.ENGLISH).contains("qemu")
                        && e.getNewValue().toString().toLowerCase(Locale.ENGLISH).contains("terminating")
                        && e.getNewValue().toString().toLowerCase(Locale.ENGLISH).contains("signal")
                        && e.getNewValue().toString().toLowerCase(Locale.ENGLISH).contains("pid"))) {
                    myView.showMessage("Qemu might be running now!\nInternal error message:\n:" + e.getNewValue());
                }
            } else if (type == AliveFilesEnumModel.OUT.getValor()) {
                myView.showMessage("Internal output message:\n" + e.getNewValue());
            }
        }
    }
}
