package net.sourceforge.javaqemu.model;

import java.util.HashMap;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class SoundHardwareModel extends OptionsControl {

    private FileControl myfile;

    // Association "Description" - "Option".
    private static HashMap<String, String> trueOptions;

    // Association "Option" - "Description".
    private static HashMap<String, String> falseOptions;

    static {
        trueOptions = new HashMap<String, String>();
        trueOptions.put("", "");
        trueOptions.put("Creative Sound Blaster 16", "sb16");
        trueOptions.put("PC speaker", "pcspk");
        trueOptions.put("Intel HD Audio", "hda");
        trueOptions.put("Gravis Ultrasound GF1", "gus");
        trueOptions.put("ENSONIQ AudioPCI ES1370", "es1370");
        trueOptions.put("CS4231A", "cs4231a");
        trueOptions.put("Yamaha YM3812 (OPL2)", "adlib");
        trueOptions.put("Intel 82801AA AC97 Audio", "ac97");
        trueOptions.put("All of the above", "all");

        falseOptions = new HashMap<String, String>();
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
    }

    public SoundHardwareModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;

        if (this.myfile.getMymodel().getSoundHardwareOption() != null) {
            this.setOption(falseOptions.get(this.myfile.getMymodel().getSoundHardwareOption()));
        }

    }

    public void setOption(String option) {
        super.setOption(trueOptions.get(option),
                OptionsEnumModel.SOUNDHARDWAREOPTION.getValor());
        this.myfile.getMymodel()
                .setSoundHardwareOption(trueOptions.get(option));
    }

    public void unsetOption(String option) {
        super.unsetOption(option);
        this.myfile.getMymodel().setSoundHardwareOption("");
    }

}
