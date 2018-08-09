package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class ImageModel extends OptionsControl {

    private FileControl myfile;
    private String mtdblock;
    private String sd;
    private String pflash;

    public ImageModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;
        if (myfile.getMymodel().getMtdblockOption() != null) {
            this.mtdblock = myfile.getMymodel().getMtdblockOption();
            this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MTDBLOCKOPTION.getValor()]);
        }
        if (myfile.getMymodel().getSdOption() != null) {
            this.sd = myfile.getMymodel().getSdOption();
            this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SDOPTION.getValor()]);
        }
        if (myfile.getMymodel().getPflashOption() != null) {
            this.pflash = myfile.getMymodel().getPflashOption();
            this.setOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.PFLASHOPTION.getValor()]);
        }
    }

    public void setOption(String option) {
        if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MTDBLOCKOPTION.getValor()])) {
            if (this.mtdblock != null)
            {
                this.myfile.getMymodel().setMtdblockOption(this.mtdblock);
                this.mtdblock = UsabilityModel.fixPath(mtdblock);
                super.setOption(this.mtdblock, OptionsEnumModel.MTDBLOCKOPTION.getValor());
            }
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SDOPTION.getValor()])) {
            if (this.sd != null)
            {
                this.myfile.getMymodel().setSdOption(this.sd);
                sd = UsabilityModel.fixPath(sd);
                super.setOption(this.sd, OptionsEnumModel.SDOPTION.getValor());
            }            
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.PFLASHOPTION.getValor()])) {
            if (this.pflash != null)
            {
                this.myfile.getMymodel().setPflashOption(this.pflash);
                pflash = UsabilityModel.fixPath(pflash);
                super.setOption(this.pflash, OptionsEnumModel.PFLASHOPTION.getValor());
            }
        }
    }

    public void unsetOption(String option) {
        super.unsetOption(option);
        if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.MTDBLOCKOPTION.getValor()])) {
            this.myfile.getMymodel().setMtdblockOption("");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SDOPTION.getValor()])) {
            this.myfile.getMymodel().setSdOption("");
        } else if (option.equals(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.PFLASHOPTION.getValor()])) {
            this.myfile.getMymodel().setPflashOption("");
        }
    }

    public void setMtdblock(String mtdblock) {
        this.mtdblock = mtdblock;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    public void setPflash(String pflash) {
        this.pflash = pflash;
    }
}
