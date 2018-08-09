package net.sourceforge.javaqemu.model;

import java.util.HashMap;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;
import net.sourceforge.javaqemu.view.NUMAView;

public class NUMAModel extends OptionsControl {

    private FileControl myfile;
    private static HashMap<Integer, Integer> gettingOptionsEnumModel;

    static {
        gettingOptionsEnumModel = new HashMap<Integer, Integer>();
        for (int i = 0; i < NUMAView.itemNumbers; i++) {
            gettingOptionsEnumModel.put(i,
                    OptionsEnumModel.NUMA1OPTION.getValor() + i);
        }
    }

    public NUMAModel(EmulationControl myemulation, FileControl myfile) {
        super(myemulation);
        this.myfile = myfile;

        HashMap<Integer, String> checkingMemFile = new HashMap<Integer, String>();
        checkingMemFile.put(0, myfile.getMymodel().getFirstNumaNodeMem());
        checkingMemFile.put(1, myfile.getMymodel().getSecondNumaNodeMem());
        checkingMemFile.put(2, myfile.getMymodel().getThirdNumaNodeMem());
        checkingMemFile.put(3, myfile.getMymodel().getFourthNumaNodeMem());
        checkingMemFile.put(4, myfile.getMymodel().getFifthNumaNodeMem());
        checkingMemFile.put(5, myfile.getMymodel().getSixthNumaNodeMem());
        checkingMemFile.put(6, myfile.getMymodel().getSeventhNumaNodeMem());
        checkingMemFile.put(7, myfile.getMymodel().getEighthNumaNodeMem());
        checkingMemFile.put(8, myfile.getMymodel().getNinthNumaNodeMem());
        checkingMemFile.put(9, myfile.getMymodel().getTenthNumaNodeMem());

        HashMap<Integer, String> checkingCpusFile = new HashMap<Integer, String>();
        checkingCpusFile.put(0, myfile.getMymodel().getFirstNumaNodeCpus());
        checkingCpusFile.put(1, myfile.getMymodel().getSecondNumaNodeCpus());
        checkingCpusFile.put(2, myfile.getMymodel().getThirdNumaNodeCpus());
        checkingCpusFile.put(3, myfile.getMymodel().getFourthNumaNodeCpus());
        checkingCpusFile.put(4, myfile.getMymodel().getFifthNumaNodeCpus());
        checkingCpusFile.put(5, myfile.getMymodel().getSixthNumaNodeCpus());
        checkingCpusFile.put(6, myfile.getMymodel().getSeventhNumaNodeCpus());
        checkingCpusFile.put(7, myfile.getMymodel().getEighthNumaNodeCpus());
        checkingCpusFile.put(8, myfile.getMymodel().getNinthNumaNodeCpus());
        checkingCpusFile.put(9, myfile.getMymodel().getTenthNumaNodeCpus());

        for (int i = 0; i < NUMAView.itemNumbers; i++) {
            if (checkingMemFile.get(i) != null
                    || checkingCpusFile.get(i) != null) {
                String[] cpus = checkingCpusFile.get(i).split("-");
                if (cpus.length == 2) {
                    this.buildIt(checkingMemFile.get(i), cpus[0], cpus[1], i);
                } else if (cpus.length == 1) {
                    this.buildIt(checkingMemFile.get(i), cpus[0], "", i);
                }
            }
        }

    }

    public void buildIt(String mem, String cpuOne, String cpuTwo, int position) {
        StringBuilder result = new StringBuilder("");
        result.append(VMConfigurationModel.getTagsOptions()[gettingOptionsEnumModel.get(position)]);
        if (mem != null) {
            if (!mem.isEmpty()) {
                result.append("node,mem=").append(mem.replace(",", "."));
                switch (position) {
                    case 0:
                        this.myfile.getMymodel().setFirstNumaNodeMem(mem);
                        break;
                    case 1:
                        this.myfile.getMymodel().setSecondNumaNodeMem(mem);
                        break;
                    case 2:
                        this.myfile.getMymodel().setThirdNumaNodeMem(mem);
                        break;
                    case 3:
                        this.myfile.getMymodel().setFourthNumaNodeMem(mem);
                        break;
                    case 4:
                        this.myfile.getMymodel().setFifthNumaNodeMem(mem);
                        break;
                    case 5:
                        this.myfile.getMymodel().setSixthNumaNodeMem(mem);
                        break;
                    case 6:
                        this.myfile.getMymodel().setSeventhNumaNodeMem(mem);
                        break;
                    case 7:
                        this.myfile.getMymodel().setEighthNumaNodeMem(mem);
                        break;
                    case 8:
                        this.myfile.getMymodel().setNinthNumaNodeMem(mem);
                        break;
                    case 9:
                        this.myfile.getMymodel().setTenthNumaNodeMem(mem);
                        break;
                    default:
                        break;
                }
            }
        }

        if (cpuOne != null && cpuTwo == null) {
            if (!cpuOne.isEmpty()) {
                if (result.toString().equals(
                        VMConfigurationModel.getTagsOptions()[gettingOptionsEnumModel.get(position)])) {
                    result.append("node");
                }
                result.append(",cpus=").append(cpuOne);
                setCpuFileOption(cpuOne, position);
            }
        }

        if (cpuOne == null && cpuTwo != null) {
            if (!cpuTwo.isEmpty()) {
                if (result.toString().equals(
                        VMConfigurationModel.getTagsOptions()[gettingOptionsEnumModel.get(position)])) {
                    result.append("node");
                }
                result.append(",cpus=").append(cpuTwo);
                setCpuFileOption(cpuTwo, position);
            }
        }

        if (cpuOne != null && cpuTwo != null) {
            if (!cpuOne.isEmpty() && cpuTwo.isEmpty()) {
                if (result.toString().equals(
                        VMConfigurationModel.getTagsOptions()[gettingOptionsEnumModel.get(position)])) {
                    result.append("node");
                }
                result.append(",cpus=").append(cpuOne);
                setCpuFileOption(cpuOne, position);
            } else if (cpuOne.isEmpty() && !cpuTwo.isEmpty()) {
                if (result.toString().equals(
                        VMConfigurationModel.getTagsOptions()[gettingOptionsEnumModel.get(position)])) {
                    result.append("node");
                }
                result.append(",cpus=").append(cpuTwo);
                setCpuFileOption(cpuTwo, position);
            } else if (!cpuOne.isEmpty() && !cpuTwo.isEmpty()) {
                if (result.toString().equals(
                        VMConfigurationModel.getTagsOptions()[gettingOptionsEnumModel.get(position)])) {
                    result.append("node");
                }
                result.append(",cpus=").append(cpuOne).append("-")
                        .append(cpuTwo);
                setCpuFileOption(cpuOne + "-" + cpuTwo, position);
            }
        }

        if (!result.toString().equals(
                VMConfigurationModel.getTagsOptions()[gettingOptionsEnumModel.get(position)])) {
            this.setOption(
                    result.toString().substring(
                            result.toString().indexOf(" ") + 1), position);
        } else {
            this.unsetOption(
                    VMConfigurationModel.getTagsOptions()[gettingOptionsEnumModel.get(position)], position);
        }

    }

    public void setOption(String option, int position) {
        super.setOption(option, gettingOptionsEnumModel.get(position));
    }

    public void unsetOption(String option, int position) {
        super.unsetOption(option, gettingOptionsEnumModel.get(position));
        switch (position) {
            case 0:
                myfile.getMymodel().setFirstNumaNodeMem("");
                myfile.getMymodel().setFirstNumaNodeCpus("");
                break;
            case 1:
                myfile.getMymodel().setSecondNumaNodeMem("");
                myfile.getMymodel().setSecondNumaNodeCpus("");
                break;
            case 2:
                myfile.getMymodel().setThirdNumaNodeMem("");
                myfile.getMymodel().setThirdNumaNodeCpus("");
                break;
            case 3:
                myfile.getMymodel().setFourthNumaNodeMem("");
                myfile.getMymodel().setFourthNumaNodeCpus("");
                break;
            case 4:
                myfile.getMymodel().setFifthNumaNodeMem("");
                myfile.getMymodel().setFifthNumaNodeCpus("");
                break;
            case 5:
                myfile.getMymodel().setSixthNumaNodeMem("");
                myfile.getMymodel().setSixthNumaNodeCpus("");
                break;
            case 6:
                myfile.getMymodel().setSeventhNumaNodeMem("");
                myfile.getMymodel().setSeventhNumaNodeCpus("");
                break;
            case 7:
                myfile.getMymodel().setEighthNumaNodeMem("");
                myfile.getMymodel().setEighthNumaNodeCpus("");
                break;
            case 8:
                myfile.getMymodel().setNinthNumaNodeMem("");
                myfile.getMymodel().setNinthNumaNodeCpus("");
                break;
            case 9:
                myfile.getMymodel().setTenthNumaNodeMem("");
                myfile.getMymodel().setTenthNumaNodeCpus("");
                break;
            default:
                break;
        }
    }

    private void setCpuFileOption(String option, int position) {
        switch (position) {
            case 0:
                this.myfile.getMymodel().setFirstNumaNodeCpus(option);
                break;
            case 1:
                this.myfile.getMymodel().setSecondNumaNodeCpus(option);
                break;
            case 2:
                this.myfile.getMymodel().setThirdNumaNodeCpus(option);
                break;
            case 3:
                this.myfile.getMymodel().setFourthNumaNodeCpus(option);
                break;
            case 4:
                this.myfile.getMymodel().setFifthNumaNodeCpus(option);
                break;
            case 5:
                this.myfile.getMymodel().setSixthNumaNodeCpus(option);
                break;
            case 6:
                this.myfile.getMymodel().setSeventhNumaNodeCpus(option);
                break;
            case 7:
                this.myfile.getMymodel().setEighthNumaNodeCpus(option);
                break;
            case 8:
                this.myfile.getMymodel().setNinthNumaNodeCpus(option);
                break;
            case 9:
                this.myfile.getMymodel().setTenthNumaNodeCpus(option);
                break;
            default:
                break;
        }
    }
}
