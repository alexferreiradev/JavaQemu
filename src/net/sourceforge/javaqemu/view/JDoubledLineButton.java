package net.sourceforge.javaqemu.view;

import java.awt.BorderLayout;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class JDoubledLineButton extends JButton {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JLabel label1;
    private JLabel label2;

    public JDoubledLineButton() {
        // TODO Auto-generated constructor stub
    }

    public JDoubledLineButton(Icon arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    public JDoubledLineButton(String arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub		
    }

    public JDoubledLineButton(Action arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    public JDoubledLineButton(String arg0, Icon arg1) {
        super(arg0, arg1);
        // TODO Auto-generated constructor stub
    }

    public JDoubledLineButton(String string1, String string2) {
        super();
        this.setLayout(new BorderLayout());
        this.label1 = new JLabel(string1);
        this.label2 = new JLabel(string2);
        this.add(BorderLayout.NORTH, label1);
        this.add(BorderLayout.SOUTH, label2);
    }
}
