package net.sourceforge.javaqemu.model;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;

public class SMPModel extends OptionsControl {

    private FileControl myfile;

    public SMPModel(EmulationControl myemulation,
            FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;

        if (this.myfile.getMymodel().getSmpCpusNumber() != null
                || this.myfile.getMymodel().getSmpCoresNumber() != null
                || this.myfile.getMymodel().getSmpThreadsNumber() != null
                || this.myfile.getMymodel().getSmpSocketsNumber() != null
                || this.myfile.getMymodel().getSmpCpusMaxNumber() != null) {
            this.buildIt(this.myfile.getMymodel().getSmpCpusNumber(),
                    this.myfile.getMymodel().getSmpCoresNumber(), this.myfile
                    .getMymodel().getSmpThreadsNumber(), this.myfile
                    .getMymodel().getSmpSocketsNumber(), this.myfile
                    .getMymodel().getSmpCpusMaxNumber());
        }
    }

    public void buildIt(String smpCpusNumbers, String smpCoresNumber,
            String smpThreadsNumber, String smpSocketsNumber,
            String smpCpusMaxNumber) {
        StringBuilder result = new StringBuilder("");
        result.append(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SMPOPTION.getValor()]);
        if (smpCpusNumbers != null) {
            if (!smpCpusNumbers.isEmpty()) {
                result.append("cpus=").append(smpCpusNumbers);
                this.myfile.getMymodel().setSmpCpusNumber(smpCpusNumbers);
            }
        }
        if (smpCoresNumber != null) {
            if (!smpCoresNumber.isEmpty()) {
                if (!result.toString().equals(
                        VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SMPOPTION.getValor()])) {
                    result.append(",");
                }
                result.append("cores=").append(smpCoresNumber);
                this.myfile.getMymodel().setSmpCoresNumber(smpCoresNumber);
            }
        }
        if (smpThreadsNumber != null) {
            if (!smpThreadsNumber.isEmpty()) {
                if (!result.toString().equals(
                        VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SMPOPTION.getValor()])) {
                    result.append(",");
                }
                result.append("threads=").append(smpThreadsNumber);
                this.myfile.getMymodel().setSmpThreadsNumber(smpThreadsNumber);
            }
        }
        if (smpSocketsNumber != null) {
            if (!smpSocketsNumber.isEmpty()) {
                if (!result.toString().equals(
                        VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SMPOPTION.getValor()])) {
                    result.append(",");
                }
                result.append("sockets=").append(smpSocketsNumber);
                this.myfile.getMymodel().setSmpSocketsNumber(smpSocketsNumber);
            }
        }
        if (smpCpusMaxNumber != null) {
            if (!smpCpusMaxNumber.isEmpty()) {
                if (!result.toString().equals(
                        VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SMPOPTION.getValor()])) {
                    result.append(",");
                }
                result.append("maxcpus=").append(smpCpusMaxNumber);
                this.myfile.getMymodel().setSmpCpusMaxNumber(smpCpusMaxNumber);
            }
        }
        if (!result.toString().equals(
                VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SMPOPTION.getValor()])) {
            this.setOption(result.toString().substring(result.toString().indexOf(" ") + 1));
        } else {
            this.unsetOption(VMConfigurationModel.getTagsOptions()[OptionsEnumModel.SMPOPTION.getValor()]);
        }

    }

    public void setOption(String option) {
        super.setOption(option, OptionsEnumModel.SMPOPTION.getValor());
    }

    public void unsetOption(String option) {
        super.unsetOption(option);
        this.myfile.getMymodel().setSmpCpusNumber("");
        this.myfile.getMymodel().setSmpCoresNumber("");
        this.myfile.getMymodel().setSmpThreadsNumber("");
        this.myfile.getMymodel().setSmpSocketsNumber("");
        this.myfile.getMymodel().setSmpCpusMaxNumber("");
    }
}
