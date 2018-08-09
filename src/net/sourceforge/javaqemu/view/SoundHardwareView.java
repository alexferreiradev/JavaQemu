package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.sourceforge.javaqemu.control.FileControl;

public class SoundHardwareView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel windowContent;

    private GridLayout gridLayout;

    private JLabel soundHardwareLabel;

    private JComboBox<String> soundHardware;

    private JButton eraseButton;

    private JButton okButton;

    // Association "option" - "Description".
    private HashMap<String, String> falseOptions;

    public SoundHardwareView(FileControl myfile) {
        super();

        windowContent = new JPanel();

        gridLayout = new GridLayout(2, 2);

        windowContent.setLayout(gridLayout);

        soundHardwareLabel = new JLabel("Choose the sound hardware:");

        windowContent.add(soundHardwareLabel);

        String[] soundHardwareOptions = {"", "Creative Sound Blaster 16",
            "PC speaker", "Intel HD Audio", "Gravis Ultrasound GF1",
            "ENSONIQ AudioPCI ES1370", "CS4231A", "Yamaha YM3812 (OPL2)",
            "Intel 82801AA AC97 Audio", "All of the above"};

        this.soundHardware = new JComboBox<String>(soundHardwareOptions);

        windowContent.add(soundHardware);

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        windowContent.add(okButton);

        windowContent.add(eraseButton);

        this.setContentPane(windowContent);

        this.setTitle("JavaQemu - Sound Hardware Choice");

        this.falseOptions = new HashMap<String, String>();
        falseOptions.put("", "");
        falseOptions.put("sb16", "Creative Sound Blaster 16");
        falseOptions.put("pcspk", "PC speaker");
        falseOptions.put("hda", "Intel HD Audio");
        falseOptions.put("gus", "Gravis Ultrasound GF1");
        falseOptions.put("es1370", "ENSONIQ AudioPCI ES1370");
        falseOptions.put("cs4231a", "CS4231A");
        falseOptions.put("adlib", "Yamaha YM3812 (OPL2)");
        falseOptions.put("ac97", "Intel 82801AA AC97 Audio");
        falseOptions.put("all", "All of the above");

        if (myfile.getMymodel().getSoundHardwareOption() != null) {
            this.getSoundHardware().setSelectedItem(
                    this.falseOptions.get(myfile.getMymodel()
                            .getSoundHardwareOption()));
        }

        this.rechecks();
    }

    private void rechecks() {
        this.pack();
        this.repaint();
    }

    public void configureListener(ActionListener listener) {
        eraseButton.addActionListener(listener);
        okButton.addActionListener(listener);
    }

    public void configureStandardMode() {
        eraseButton.setActionCommand("eraseButton");
        okButton.setActionCommand("okButton");
    }

    public JComboBox<String> getSoundHardware() {
        return soundHardware;
    }
}
