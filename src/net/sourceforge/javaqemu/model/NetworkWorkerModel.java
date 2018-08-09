package net.sourceforge.javaqemu.model;

import java.util.HashMap;

import net.sourceforge.javaqemu.control.EmulationControl;
import net.sourceforge.javaqemu.control.FileControl;
import net.sourceforge.javaqemu.control.OptionsControl;
import net.sourceforge.javaqemu.view.NetworkManagerView;

public class NetworkWorkerModel extends OptionsControl {

    private FileControl myfile;
    private static HashMap<Integer, Integer> gettingOptionsEnumModel;
    private int position;
    private String option;

    static {
        gettingOptionsEnumModel = new HashMap<Integer, Integer>();
        for (int i = 0; i < NetworkManagerView.networkOptionsNumber * 3; i++) {
            gettingOptionsEnumModel.put(i,
                    OptionsEnumModel.NETWORKNIC1OPTION.getValor() + i);
        }
    }

    public NetworkWorkerModel(EmulationControl myemulation, FileControl myfile,
            int position) {
        super(myemulation);
        this.myfile = myfile;
        this.position = position;
        option = "";

        switch (position) {
            case 1:
                if (myfile.getMymodel().getFirstNetworkNICOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getFirstNetworkNICOption().split(","));
                }
                if (myfile.getMymodel().getFirstNetworkExtraOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getFirstNetworkExtraOption().split(","));
                }
                if (myfile.getMymodel().getFirstNetworkNetdevOption() != null) {
                    this.buildIt("-netdev", myfile.getMymodel()
                            .getFirstNetworkNetdevOption().split(","));
                }
                break;
            case 2:
                if (myfile.getMymodel().getSecondNetworkNICOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getSecondNetworkNICOption().split(","));
                }
                if (myfile.getMymodel().getSecondNetworkExtraOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getSecondNetworkExtraOption().split(","));
                }
                if (myfile.getMymodel().getSecondNetworkNetdevOption() != null) {
                    this.buildIt("-netdev", myfile.getMymodel()
                            .getSecondNetworkNetdevOption().split(","));
                }
                break;
            case 3:
                if (myfile.getMymodel().getThirdNetworkNICOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getThirdNetworkNICOption().split(","));
                }
                if (myfile.getMymodel().getThirdNetworkExtraOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getThirdNetworkExtraOption().split(","));
                }
                if (myfile.getMymodel().getThirdNetworkNetdevOption() != null) {
                    this.buildIt("-netdev", myfile.getMymodel()
                            .getThirdNetworkNetdevOption().split(","));
                }
                break;
            case 4:
                if (myfile.getMymodel().getFourthNetworkNICOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getFourthNetworkNICOption().split(","));
                }
                if (myfile.getMymodel().getFourthNetworkExtraOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getFourthNetworkExtraOption().split(","));
                }
                if (myfile.getMymodel().getFourthNetworkNetdevOption() != null) {
                    this.buildIt("-netdev", myfile.getMymodel()
                            .getFourthNetworkNetdevOption().split(","));
                }
                break;
            case 5:
                if (myfile.getMymodel().getFifthNetworkNICOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getFifthNetworkNICOption().split(","));
                }
                if (myfile.getMymodel().getFifthNetworkExtraOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getFifthNetworkExtraOption().split(","));
                }
                if (myfile.getMymodel().getFifthNetworkNetdevOption() != null) {
                    this.buildIt("-netdev", myfile.getMymodel()
                            .getFifthNetworkNetdevOption().split(","));
                }
                break;
            case 6:
                if (myfile.getMymodel().getSixthNetworkNICOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getSixthNetworkNICOption().split(","));
                }
                if (myfile.getMymodel().getSixthNetworkExtraOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getSixthNetworkExtraOption().split(","));
                }
                if (myfile.getMymodel().getSixthNetworkNetdevOption() != null) {
                    this.buildIt("-netdev", myfile.getMymodel()
                            .getSixthNetworkNetdevOption().split(","));
                }
                break;
            case 7:
                if (myfile.getMymodel().getSeventhNetworkNICOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getSeventhNetworkNICOption().split(","));
                }
                if (myfile.getMymodel().getSeventhNetworkExtraOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getSeventhNetworkExtraOption().split(","));
                }
                if (myfile.getMymodel().getSeventhNetworkNetdevOption() != null) {
                    this.buildIt("-netdev", myfile.getMymodel()
                            .getSeventhNetworkNetdevOption().split(","));
                }
                break;
            case 8:
                if (myfile.getMymodel().getEighthNetworkNICOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getEighthNetworkNICOption().split(","));
                }
                if (myfile.getMymodel().getEighthNetworkExtraOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getEighthNetworkExtraOption().split(","));
                }
                if (myfile.getMymodel().getEighthNetworkNetdevOption() != null) {
                    this.buildIt("-netdev", myfile.getMymodel()
                            .getEighthNetworkNetdevOption().split(","));
                }
                break;
            case 9:
                if (myfile.getMymodel().getNinthNetworkNICOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getNinthNetworkNICOption().split(","));
                }
                if (myfile.getMymodel().getNinthNetworkExtraOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getNinthNetworkExtraOption().split(","));
                }
                if (myfile.getMymodel().getNinthNetworkNetdevOption() != null) {
                    this.buildIt("-netdev", myfile.getMymodel()
                            .getNinthNetworkNetdevOption().split(","));
                }
                break;
            case 10:
                if (myfile.getMymodel().getTenthNetworkNICOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getTenthNetworkNICOption().split(","));
                }
                if (myfile.getMymodel().getTenthNetworkExtraOption() != null) {
                    this.buildIt("-net", myfile.getMymodel()
                            .getTenthNetworkExtraOption().split(","));
                }
                if (myfile.getMymodel().getTenthNetworkNetdevOption() != null) {
                    this.buildIt("-netdev", myfile.getMymodel()
                            .getTenthNetworkNetdevOption().split(","));
                }
                break;
            default:
                break;
        }

    }

    public void buildIt(String tag, String[] options) {
        StringBuilder result = new StringBuilder(tag);
        int truePosition = 0;
        if (tag.equals("-net")) {
            if (options.length > 0) {
                if (options[0].equals("nic") || options[0].equals("none")) {
                    result.append(" ").append(options[0]);
                    for (int i = 1; i < options.length; i++) {
                        result.append(",").append(options[i]);
                    }
                    truePosition = (3 * (position - 1));
                    switch (position) {
                        case 1:
                            myfile.getMymodel().setFirstNetworkNICOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 2:
                            myfile.getMymodel().setSecondNetworkNICOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 3:
                            myfile.getMymodel().setThirdNetworkNICOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 4:
                            myfile.getMymodel().setFourthNetworkNICOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 5:
                            myfile.getMymodel().setFifthNetworkNICOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 6:
                            myfile.getMymodel().setSixthNetworkNICOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 7:
                            myfile.getMymodel().setSeventhNetworkNICOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 8:
                            myfile.getMymodel().setEighthNetworkNICOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 9:
                            myfile.getMymodel().setNinthNetworkNICOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 10:
                            myfile.getMymodel().setTenthNetworkNICOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        default:
                            break;
                    }
                } else if (options[0].equals("user")
                        || options[0].equals("tap")
                        || options[0].equals("bridge")
                        || options[0].equals("socket")
                        || options[0].equals("vde")
                        || options[0].equals("dump")) {
                    result.append(" ").append(options[0]);
                    for (int i = 1; i < options.length; i++) {
                        result.append(",").append(options[i]);
                    }
                    truePosition = (3 * (position - 1)) + 1;
                    switch (position) {
                        case 1:
                            myfile.getMymodel().setFirstNetworkExtraOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 2:
                            myfile.getMymodel().setSecondNetworkExtraOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 3:
                            myfile.getMymodel().setThirdNetworkExtraOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 4:
                            myfile.getMymodel().setFourthNetworkExtraOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 5:
                            myfile.getMymodel().setFifthNetworkExtraOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 6:
                            myfile.getMymodel().setSixthNetworkExtraOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 7:
                            myfile.getMymodel().setSeventhNetworkExtraOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 8:
                            myfile.getMymodel().setEighthNetworkExtraOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 9:
                            myfile.getMymodel().setNinthNetworkExtraOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 10:
                            myfile.getMymodel().setTenthNetworkExtraOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        default:
                            break;
                    }
                    option = options[0];
                }
            }
        } else if (tag.equals("-netdev")) {
            if (options.length > 0) {
                if (options[0].equals("hubport")) {
                    result.append(" ").append(options[0]);
                    for (int i = 1; i < options.length; i++) {
                        result.append(",").append(options[i]);
                    }
                    truePosition = (3 * (position - 1)) + 2;
                    switch (position) {
                        case 1:
                            myfile.getMymodel().setFirstNetworkNetdevOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 2:
                            myfile.getMymodel().setSecondNetworkNetdevOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 3:
                            myfile.getMymodel().setThirdNetworkNetdevOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 4:
                            myfile.getMymodel().setFourthNetworkNetdevOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 5:
                            myfile.getMymodel().setFifthNetworkNetdevOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 6:
                            myfile.getMymodel().setSixthNetworkNetdevOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 7:
                            myfile.getMymodel().setSeventhNetworkNetdevOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 8:
                            myfile.getMymodel().setEighthNetworkNetdevOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 9:
                            myfile.getMymodel().setNinthNetworkNetdevOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        case 10:
                            myfile.getMymodel().setTenthNetworkNetdevOption(
                                    result.toString().substring(
                                            result.toString().indexOf(" ") + 1));
                            break;
                        default:
                            break;
                    }
                }
            }
        }

        if ((result.toString().equals(tag) || result.toString().equals(tag + " " + options[0]))
                && !options[0].equals("none") || result.toString().equals(tag + " user,restrict=off")) {
            this.unsetOption(tag + " ", truePosition);
        } else {
            this.setOption(
                    result.toString().substring(
                            result.toString().indexOf(" ") + 1), truePosition);
        }
    }

    public void setOption(String option, int position) {
        super.setOption(option, gettingOptionsEnumModel.get(position));
    }

    public void unsetOption(String option, int position) {
        super.unsetOption(option, gettingOptionsEnumModel.get(position));
        switch (position % 3) {
            case 0:
                int oldPosition0 = (position / 3) + 1;
                switch (oldPosition0) {
                    case 1:
                        myfile.getMymodel().setFirstNetworkNICOption("");
                        break;
                    case 2:
                        myfile.getMymodel().setSecondNetworkNICOption("");
                        break;
                    case 3:
                        myfile.getMymodel().setThirdNetworkNICOption("");
                        break;
                    case 4:
                        myfile.getMymodel().setFourthNetworkNICOption("");
                        break;
                    case 5:
                        myfile.getMymodel().setFifthNetworkNICOption("");
                        break;
                    case 6:
                        myfile.getMymodel().setSixthNetworkNICOption("");
                        break;
                    case 7:
                        myfile.getMymodel().setSeventhNetworkNICOption("");
                        break;
                    case 8:
                        myfile.getMymodel().setEighthNetworkNICOption("");
                        break;
                    case 9:
                        myfile.getMymodel().setNinthNetworkNICOption("");
                        break;
                    case 10:
                        myfile.getMymodel().setTenthNetworkNICOption("");
                        break;
                    default:
                        break;
                }
                break;
            case 1:
                int oldPosition1 = ((position - 1) / 3) + 1;
                switch (oldPosition1) {
                    case 1:
                        myfile.getMymodel().setFirstNetworkExtraOption("");
                        break;
                    case 2:
                        myfile.getMymodel().setSecondNetworkExtraOption("");
                        break;
                    case 3:
                        myfile.getMymodel().setThirdNetworkExtraOption("");
                        break;
                    case 4:
                        myfile.getMymodel().setFourthNetworkExtraOption("");
                        break;
                    case 5:
                        myfile.getMymodel().setFifthNetworkExtraOption("");
                        break;
                    case 6:
                        myfile.getMymodel().setSixthNetworkExtraOption("");
                        break;
                    case 7:
                        myfile.getMymodel().setSeventhNetworkExtraOption("");
                        break;
                    case 8:
                        myfile.getMymodel().setEighthNetworkExtraOption("");
                        break;
                    case 9:
                        myfile.getMymodel().setNinthNetworkExtraOption("");
                        break;
                    case 10:
                        myfile.getMymodel().setTenthNetworkExtraOption("");
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                int oldPosition2 = ((position - 2) / 3) + 1;
                switch (oldPosition2) {
                    case 1:
                        myfile.getMymodel().setFirstNetworkNetdevOption("");
                        break;
                    case 2:
                        myfile.getMymodel().setSecondNetworkNetdevOption("");
                        break;
                    case 3:
                        myfile.getMymodel().setThirdNetworkNetdevOption("");
                        break;
                    case 4:
                        myfile.getMymodel().setFourthNetworkNetdevOption("");
                        break;
                    case 5:
                        myfile.getMymodel().setFifthNetworkNetdevOption("");
                        break;
                    case 6:
                        myfile.getMymodel().setSixthNetworkNetdevOption("");
                        break;
                    case 7:
                        myfile.getMymodel().setSeventhNetworkNetdevOption("");
                        break;
                    case 8:
                        myfile.getMymodel().setEighthNetworkNetdevOption("");
                        break;
                    case 9:
                        myfile.getMymodel().setNinthNetworkNetdevOption("");
                        break;
                    case 10:
                        myfile.getMymodel().setTenthNetworkNetdevOption("");
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    public String getOption() {
        return option;
    }
}
