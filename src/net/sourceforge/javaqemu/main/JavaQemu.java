package net.sourceforge.javaqemu.main;

import net.sourceforge.javaqemu.control.Control;
import net.sourceforge.javaqemu.view.View;

public class JavaQemu {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                View view = new View();
                Control control = new Control(view);

                control.starts();
            }
        });
    }
}
