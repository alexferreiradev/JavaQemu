package net.sourceforge.javaqemu.model;

public class VMConfigurationModel {

    private static String[] tagsOptions;

    private static int tagsOptionsSize = 81;

    static {
        tagsOptions = new String[tagsOptionsSize];
        tagsOptions[0] = "-m ";
        tagsOptions[1] = "-display ";
        tagsOptions[2] = "-nographic";
        tagsOptions[3] = "-vga ";
        tagsOptions[4] = "-full-screen";
        tagsOptions[5] = "-win2k-hack";
        tagsOptions[6] = "-no-acpi";
        tagsOptions[7] = "-machine ";
        tagsOptions[8] = "-cpu ";
        tagsOptions[9] = "-cdrom ";
        tagsOptions[10] = "-fda ";
        tagsOptions[11] = "-fdb ";
        tagsOptions[12] = "-boot ";
        tagsOptions[13] = "-k ";
        tagsOptions[14] = "-soundhw ";
        tagsOptions[15] = "-smp ";
        for (int i = 16; i <= 25; i++) {
            tagsOptions[i] = "-numa ";
        }
        tagsOptions[26] = "-no-frame";
        tagsOptions[27] = "-mem-path ";
        tagsOptions[28] = "-mem-prealloc";
        for (int i = 29; i <= 58; i++) {
            if (i % 3 == 1) {
                tagsOptions[i] = "-netdev ";
            } else {
                tagsOptions[i] = "-net ";
            }
        }
        tagsOptions[59] = "-rtc ";
        tagsOptions[60] = "-name ";
        tagsOptions[61] = "-snapshot";
        tagsOptions[62] = "-no-fd-bootchk";
        tagsOptions[63] = "-no-hpet";
        tagsOptions[64] = "-mtdblock ";
        tagsOptions[65] = "-sd ";
        tagsOptions[66] = "-pflash ";
        tagsOptions[67] = "-monitor ";
        tagsOptions[68] = "-qmp ";
        tagsOptions[69] = "-usb";
        for (int i = 70; i <= 77; i++) {
            tagsOptions[i] = "-usbdevice ";
        }
        tagsOptions[78] = "-kernel ";
        tagsOptions[79] = "-L ";
        tagsOptions[80] = "";
    }

    public VMConfigurationModel() {

    }

    public static String[] getTagsOptions() {
        return tagsOptions.clone();
    }
}
