package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NetworkManagerView extends JFrame {

    private static final long serialVersionUID = 1L;

    private static final int emptyComponentsNumber = 7;

    private static final int numberOfEmptyComponentsFromAbove = 4;

    public static final int networkOptionsNumber = 10;

    private JPanel windowContent;

    private GridLayout gridLayout;

    private JLabel networkManagerLabel;

    private JButton networkoptions[];

    private JButton hideButton;

    private JButton okButton;

    private JLabel temp[];

    public NetworkManagerView() {
        super();

        windowContent = new JPanel();

        gridLayout = new GridLayout(4, 5);

        windowContent.setLayout(gridLayout);

        networkManagerLabel = new JLabel("Choose a network option:");

        windowContent.add(networkManagerLabel);

        this.temp = new JLabel[emptyComponentsNumber];
        for (int i = 0; i < emptyComponentsNumber; i++) {
            this.temp[i] = new JLabel();
            if (i < numberOfEmptyComponentsFromAbove) {
                windowContent.add(this.temp[i]);
            }
        }

        this.networkoptions = new JButton[networkOptionsNumber];
        for (int i = 0; i < networkOptionsNumber; i++) {
            this.networkoptions[i] = new JButton("Network Option " + (i + 1));
            windowContent.add(this.networkoptions[i]);
        }

        for (int i = numberOfEmptyComponentsFromAbove; i < emptyComponentsNumber; i++) {
            windowContent.add(this.temp[i]);
        }

        okButton = new JButton("OK");

        hideButton = new JButton("Hide");

        windowContent.add(okButton);

        windowContent.add(hideButton);

        this.setContentPane(windowContent);

        this.setTitle("JavaQemu - Network Manager Choice");

        this.rechecks();
    }

    private void rechecks() {
        this.pack();
        this.repaint();
    }

    public void configureListener(ActionListener listener) {
        hideButton.addActionListener(listener);
        okButton.addActionListener(listener);
        for (int i = 0; i < networkOptionsNumber; i++) {
            this.networkoptions[i].addActionListener(listener);
        }
    }

    public void configureStandardMode() {
        hideButton.setActionCommand("hideButton");
        okButton.setActionCommand("okButton");

        networkoptions[0].setActionCommand("networkOption1");
        networkoptions[1].setActionCommand("networkOption2");
        networkoptions[2].setActionCommand("networkOption3");
        networkoptions[3].setActionCommand("networkOption4");
        networkoptions[4].setActionCommand("networkOption5");
        networkoptions[5].setActionCommand("networkOption6");
        networkoptions[6].setActionCommand("networkOption7");
        networkoptions[7].setActionCommand("networkOption8");
        networkoptions[8].setActionCommand("networkOption9");
        networkoptions[9].setActionCommand("networkOption10");
    }
}
