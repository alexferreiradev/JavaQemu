package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class BootModel extends OptionsControl {

    public BootModel(EmulationControl myemulation) {
        super(myemulation);
    }

    public String buildOrderOrOnce(String first, String second, String third) {
        StringBuilder result = new StringBuilder("");
        if (!first.isEmpty()) {
            result.append(first.substring(0, 1));
        }
        if (!second.isEmpty()) {
            result.append(second.substring(0, 1));
        }
        if (!third.isEmpty()) {
            result.append(third.substring(0, 1));
        }
        return result.toString();
    }

    public void buildIt(String drivesOrder, String drivesOnce, String menu,
            String splash, String splashTime, String rebootTimeout,
            String strict) {
        StringBuilder result = new StringBuilder("");
        if (!drivesOrder.isEmpty()) {
            result.append(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.BOOTOPTION.getValor()]).append("order=").append(drivesOrder);
        } else {
            result.append(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.BOOTOPTION.getValor()]);
        }
        if (!drivesOnce.isEmpty()) {
            if (!result.toString().equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.BOOTOPTION.getValor()])) {
                result.append(",");
            }
            result.append("once=").append(drivesOnce);
        }
        if (!menu.isEmpty()) {
            if (!result.toString().equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.BOOTOPTION.getValor()])) {
                result.append(",");
            }
            result.append("menu=").append(menu);
        }
        if (!splash.isEmpty()) {
            if (!result.toString().equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.BOOTOPTION.getValor()])) {
                result.append(",");
            }
            splash = UsabilityModel.fixPath(splash);
            result.append("splash=").append(splash);
        }
        if (!splashTime.isEmpty()) {
            if (!result.toString().equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.BOOTOPTION.getValor()])) {
                result.append(",");
            }
            result.append("splash-time=").append(splashTime);
        }
        if (!rebootTimeout.isEmpty()) {
            if (!result.toString().equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.BOOTOPTION.getValor()])) {
                result.append(",");
            }
            result.append("reboot-timeout=").append(rebootTimeout);
        }
        if (!strict.isEmpty()) {
            if (!result.toString().equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.BOOTOPTION.getValor()])) {
                result.append(",");
            }
            result.append("strict=").append(strict);
        }
        if (!result.toString().equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.BOOTOPTION.getValor()])) {
            super.setOption(result.toString().substring(result.toString().indexOf(" ") + 1),
                    OptionsEnumModel.BOOTOPTION.getValor());
        } else {
            super.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.BOOTOPTION.getValor()]);
        }
    }
}
