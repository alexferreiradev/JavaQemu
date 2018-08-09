package net.sourceforge.javaqemu.model;

import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileModel {

    private String machineName;
    private String machineType;
    private String machineAccel1;
    private String machineAccel2;
    private String machineAccel3;
    private String machineKernel_irpchip;
    private String machineKvm_shadow_mem;
    private String machineDump_guest_core;
    private String machineMem_merge;
    private String cpuModel;
    private String cpuidFlags;
    private String cdrom;
    private String floppyDiskA;
    private String floppyDiskB;
    private String bootOrder1;
    private String bootOrder2;
    private String bootOrder3;
    private String bootOnce1;
    private String bootOnce2;
    private String bootOnce3;
    private String bootMenu;
    private String bootSplash;
    private String bootSplashTime;
    private String bootRebootTimeout;
    private String bootStrict;
    private String keyboardLayoutLanguage;
    private String firstHardDiskOption;
    private String secondHardDiskOption;
    private String thirdHardDiskOption;
    private String fourthHardDiskOption;
    private String ramSize;
    private String displayType;
    private String nographicOption;
    private String vgaType;
    private String fullscreenOption;
    private String win2khackOption;
    private String noacpiOption;
    private String soundHardwareOption;
    private String smpCpusNumber;
    private String smpCoresNumber;
    private String smpThreadsNumber;
    private String smpSocketsNumber;
    private String smpCpusMaxNumber;
    private String firstNumaNodeMem;
    private String firstNumaNodeCpus;
    private String secondNumaNodeMem;
    private String secondNumaNodeCpus;
    private String thirdNumaNodeMem;
    private String thirdNumaNodeCpus;
    private String fourthNumaNodeMem;
    private String fourthNumaNodeCpus;
    private String fifthNumaNodeMem;
    private String fifthNumaNodeCpus;
    private String sixthNumaNodeMem;
    private String sixthNumaNodeCpus;
    private String seventhNumaNodeMem;
    private String seventhNumaNodeCpus;
    private String eighthNumaNodeMem;
    private String eighthNumaNodeCpus;
    private String ninthNumaNodeMem;
    private String ninthNumaNodeCpus;
    private String tenthNumaNodeMem;
    private String tenthNumaNodeCpus;
    private String noFrameOption;
    private String memPathOption;
    private String memPreallocOption;
    private String firstNetworkNICOption;
    private String firstNetworkExtraOption;
    private String firstNetworkNetdevOption;
    private String secondNetworkNICOption;
    private String secondNetworkExtraOption;
    private String secondNetworkNetdevOption;
    private String thirdNetworkNICOption;
    private String thirdNetworkExtraOption;
    private String thirdNetworkNetdevOption;
    private String fourthNetworkNICOption;
    private String fourthNetworkExtraOption;
    private String fourthNetworkNetdevOption;
    private String fifthNetworkNICOption;
    private String fifthNetworkExtraOption;
    private String fifthNetworkNetdevOption;
    private String sixthNetworkNICOption;
    private String sixthNetworkExtraOption;
    private String sixthNetworkNetdevOption;
    private String seventhNetworkNICOption;
    private String seventhNetworkExtraOption;
    private String seventhNetworkNetdevOption;
    private String eighthNetworkNICOption;
    private String eighthNetworkExtraOption;
    private String eighthNetworkNetdevOption;
    private String ninthNetworkNICOption;
    private String ninthNetworkExtraOption;
    private String ninthNetworkNetdevOption;
    private String tenthNetworkNICOption;
    private String tenthNetworkExtraOption;
    private String tenthNetworkNetdevOption;
    private String rtcOption;
    private String nameOption;
    private String snapshotOption;
    private String noFdBootchkOption;
    private String noHpetOption;
    private String mtdblockOption;
    private String sdOption;
    private String pflashOption;
    private String monitorOption;
    private String qmpOption;
    private String usbDriverOption;
    private String usbMouseOption;
    private String usbTabletOption;
    private String usbWacomTabletOption;
    private String usbKeyboardOption;
    private String usbBrailleOption;
    private String usbDiskOption;
    private String usbSerialOption;
    private String usbNetOption;
    private String kernelBootOption;
    private String customOptions;

    private String defaultVMPath;
    private String execute_before_start_qemu;
    private String qemu_executable_path;
    private String execute_after_stop_qemu;
    private String qemu_img_executable_path;
    private String bios_vga_bios_keymaps_path;

    public boolean readXML(String xml) {
        boolean fixIt = false;
        boolean[] fixTasks = new boolean[4];
        Document dom;
        // Make an instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the
            // XML file
            dom = db.parse(xml);

            Element doc = dom.getDocumentElement();

            machineName = getTextValue(doc, "machineName");
            machineType = getTextValue(doc, "machineType");
            machineAccel1 = getTextValue(doc, "machineAccel1");
            machineAccel2 = getTextValue(doc, "machineAccel2");
            machineAccel3 = getTextValue(doc, "machineAccel3");
            machineKernel_irpchip = getTextValue(doc, "machineKernel_irpchip");
            machineKvm_shadow_mem = getTextValue(doc, "machineKvm_shadow_mem");
            machineDump_guest_core = getTextValue(doc, "machineDump_guest_core");
            machineMem_merge = getTextValue(doc, "machineMem_merge");
            cpuModel = getTextValue(doc, "cpuModel");
            cpuidFlags = getTextValue(doc, "cpuidFlags");
            cdrom = getTextValue(doc, "cdrom");

            if (cdrom != null) {
                if (cdrom.contains("\"")) {
                    if (!fixIt) {
                        fixIt = true;
                    }
                    cdrom = cdrom.replaceAll("\"", "");
                }
            }

            floppyDiskA = getTextValue(doc, "floppyDiskA");
            floppyDiskB = getTextValue(doc, "floppyDiskB");
            bootOrder1 = getTextValue(doc, "bootOrder1");
            bootOrder2 = getTextValue(doc, "bootOrder2");
            bootOrder3 = getTextValue(doc, "bootOrder3");
            bootOnce1 = getTextValue(doc, "bootOnce1");
            bootOnce2 = getTextValue(doc, "bootOnce2");
            bootOnce3 = getTextValue(doc, "bootOnce3");
            bootMenu = getTextValue(doc, "bootMenu");
            bootSplash = getTextValue(doc, "bootSplash");
            bootSplashTime = getTextValue(doc, "bootSplashTime");
            bootRebootTimeout = getTextValue(doc, "bootRebootTimeout");
            bootStrict = getTextValue(doc, "bootStrict");
            keyboardLayoutLanguage = getTextValue(doc, "keyboardLayoutLanguage");
            firstHardDiskOption = getTextValue(doc, "diskPath"); // Deprecated definition.
            if (firstHardDiskOption == null) {
                firstHardDiskOption = getTextValue(doc, "diskImagePath"); // Deprecated definition.
            }
            if (firstHardDiskOption == null) {
                firstHardDiskOption = getTextValue(doc, "firstHardDiskOption"); // Standard definition.
            }
            if (firstHardDiskOption != null) {
                if (firstHardDiskOption.contains("\"")) {
                    if (!fixIt) {
                        fixIt = true;
                    }
                    fixTasks[0] = true;
                }
            }

            secondHardDiskOption = getTextValue(doc, "secondDiskImagePath"); // Deprecated definition.
            if (secondHardDiskOption == null) {
                secondHardDiskOption = getTextValue(doc, "secondHardDiskOption"); // Standard definition.
            }
            if (secondHardDiskOption != null) {
                if (secondHardDiskOption.contains("\"")) {
                    if (!fixIt) {
                        fixIt = true;
                    }
                    fixTasks[1] = true;
                }
            }

            thirdHardDiskOption = getTextValue(doc, "thirdDiskImagePath"); // Deprecated definition.
            if (thirdHardDiskOption == null) {
                thirdHardDiskOption = getTextValue(doc, "thirdHardDiskOption"); // Standard definition.
            }
            if (thirdHardDiskOption != null) {
                if (thirdHardDiskOption.contains("\"")) {
                    if (!fixIt) {
                        fixIt = true;
                    }
                    fixTasks[2] = true;
                }
            }

            fourthHardDiskOption = getTextValue(doc, "fourthDiskImagePath"); // Deprecated definition.
            if (fourthHardDiskOption == null) {
                fourthHardDiskOption = getTextValue(doc, "fourthHardDiskOption"); // Standard definition.
            }
            if (thirdHardDiskOption != null) {
                if (thirdHardDiskOption.contains("\"")) {
                    if (!fixIt) {
                        fixIt = true;
                    }
                    fixTasks[3] = true;
                }
            }

            ramSize = getTextValue(doc, "ramSize");
            displayType = getTextValue(doc, "displayType");
            nographicOption = getTextValue(doc, "nographicOption");
            vgaType = getTextValue(doc, "vgaType");
            fullscreenOption = getTextValue(doc, "fullscreenOption");
            win2khackOption = getTextValue(doc, "win2khackOption");
            noacpiOption = getTextValue(doc, "noacpiOption");
            soundHardwareOption = getTextValue(doc, "soundHardwareOption");
            smpCpusNumber = getTextValue(doc, "smpCpusNumber");
            smpCoresNumber = getTextValue(doc, "smpCoresNumber");
            smpThreadsNumber = getTextValue(doc, "smpThreadsNumber");
            smpSocketsNumber = getTextValue(doc, "smpSocketsNumber");
            smpCpusMaxNumber = getTextValue(doc, "smpCpusMaxNumber");
            firstNumaNodeMem = getTextValue(doc, "firstNumaNodeMem");
            firstNumaNodeCpus = getTextValue(doc, "firstNumaNodeCpus");
            secondNumaNodeMem = getTextValue(doc, "secondNumaNodeMem");
            secondNumaNodeCpus = getTextValue(doc, "secondNumaNodeCpus");
            thirdNumaNodeMem = getTextValue(doc, "thirdNumaNodeMem");
            thirdNumaNodeCpus = getTextValue(doc, "thirdNumaNodeCpus");
            fourthNumaNodeMem = getTextValue(doc, "fourthNumaNodeMem");
            fourthNumaNodeCpus = getTextValue(doc, "fourthNumaNodeCpus");
            fifthNumaNodeMem = getTextValue(doc, "fifthNumaNodeMem");
            fifthNumaNodeCpus = getTextValue(doc, "fifthNumaNodeCpus");
            sixthNumaNodeMem = getTextValue(doc, "sixthNumaNodeMem");
            sixthNumaNodeCpus = getTextValue(doc, "sixthNumaNodeCpus");
            seventhNumaNodeMem = getTextValue(doc, "seventhNumaNodeMem");
            seventhNumaNodeCpus = getTextValue(doc, "seventhNumaNodeCpus");
            eighthNumaNodeMem = getTextValue(doc, "eighthNumaNodeMem");
            eighthNumaNodeCpus = getTextValue(doc, "eighthNumaNodeCpus");
            ninthNumaNodeMem = getTextValue(doc, "ninthNumaNodeMem");
            ninthNumaNodeCpus = getTextValue(doc, "ninthNumaNodeCpus");
            tenthNumaNodeMem = getTextValue(doc, "tenthNumaNodeMem");
            tenthNumaNodeCpus = getTextValue(doc, "tenthNumaNodeCpus");
            noFrameOption = getTextValue(doc, "noFrameOption");
            memPathOption = getTextValue(doc, "memPathOption");

            if (memPathOption != null) {
                if (memPathOption.contains("\"")) {
                    if (!fixIt) {
                        fixIt = true;
                    }
                    memPathOption = memPathOption.replaceAll("\"", "");
                }
            }

            memPreallocOption = getTextValue(doc, "memPreallocOption");
            firstNetworkNICOption = getTextValue(doc, "firstNetworkNICOption");
            firstNetworkExtraOption = getTextValue(doc, "firstNetworkExtraOption");
            firstNetworkNetdevOption = getTextValue(doc, "firstNetworkNetdevOption");
            secondNetworkNICOption = getTextValue(doc, "secondNetworkNICOption");
            secondNetworkExtraOption = getTextValue(doc, "secondNetworkExtraOption");
            secondNetworkNetdevOption = getTextValue(doc, "secondNetworkNetdevOption");
            thirdNetworkNICOption = getTextValue(doc, "thirdNetworkNICOption");
            thirdNetworkExtraOption = getTextValue(doc, "thirdNetworkExtraOption");
            thirdNetworkNetdevOption = getTextValue(doc, "thirdNetworkNetdevOption");
            fourthNetworkNICOption = getTextValue(doc, "fourthNetworkNICOption");
            fourthNetworkExtraOption = getTextValue(doc, "fourthNetworkExtraOption");
            fourthNetworkNetdevOption = getTextValue(doc, "fourthNetworkNetdevOption");
            fifthNetworkNICOption = getTextValue(doc, "fifthNetworkNICOption");
            fifthNetworkExtraOption = getTextValue(doc, "fifthNetworkExtraOption");
            fifthNetworkNetdevOption = getTextValue(doc, "fifthNetworkNetdevOption");
            sixthNetworkNICOption = getTextValue(doc, "sixthNetworkNICOption");
            sixthNetworkExtraOption = getTextValue(doc, "sixthNetworkExtraOption");
            sixthNetworkNetdevOption = getTextValue(doc, "sixthNetworkNetdevOption");
            seventhNetworkNICOption = getTextValue(doc, "seventhNetworkNICOption");
            seventhNetworkExtraOption = getTextValue(doc, "seventhNetworkExtraOption");
            seventhNetworkNetdevOption = getTextValue(doc, "seventhNetworkNetdevOption");
            eighthNetworkNICOption = getTextValue(doc, "eighthNetworkNICOption");
            eighthNetworkExtraOption = getTextValue(doc, "eighthNetworkExtraOption");
            eighthNetworkNetdevOption = getTextValue(doc, "eighthNetworkNetdevOption");
            ninthNetworkNICOption = getTextValue(doc, "ninthNetworkNICOption");
            ninthNetworkExtraOption = getTextValue(doc, "ninthNetworkExtraOption");
            ninthNetworkNetdevOption = getTextValue(doc, "ninthNetworkNetdevOption");
            tenthNetworkNICOption = getTextValue(doc, "tenthNetworkNICOption");
            tenthNetworkExtraOption = getTextValue(doc, "tenthNetworkExtraOption");
            tenthNetworkNetdevOption = getTextValue(doc, "tenthNetworkNetdevOption");
            rtcOption = getTextValue(doc, "rtcOption");
            nameOption = getTextValue(doc, "nameOption");
            snapshotOption = getTextValue(doc, "snapshotOption");
            noFdBootchkOption = getTextValue(doc, "noFdBootchkOption");
            noHpetOption = getTextValue(doc, "noHpetOption");
            mtdblockOption = getTextValue(doc, "mtdblockOption");
            sdOption = getTextValue(doc, "sdOption");
            pflashOption = getTextValue(doc, "pflashOption");
            monitorOption = getTextValue(doc, "monitorOption");
            qmpOption = getTextValue(doc, "qmpOption");
            usbDriverOption = getTextValue(doc, "usbDriverOption");
            usbMouseOption = getTextValue(doc, "usbMouseOption");
            usbTabletOption = getTextValue(doc, "usbTabletOption");
            usbWacomTabletOption = getTextValue(doc, "usbWacomTabletOption");
            usbKeyboardOption = getTextValue(doc, "usbKeyboardOption");
            usbBrailleOption = getTextValue(doc, "usbBrailleOption");
            usbDiskOption = getTextValue(doc, "usbDiskOption");
            usbSerialOption = getTextValue(doc, "usbSerialOption");
            usbNetOption = getTextValue(doc, "usbNetOption");
            kernelBootOption = getTextValue(doc, "kernelBootOption");
            customOptions = getTextValue(doc, "customOptions");

            if (fixIt) {
                if (fixTasks[0]) {
                    if (firstHardDiskOption != null)
                    {
                        firstHardDiskOption = firstHardDiskOption.replaceAll("\"", "");
                    }
                }

                if (fixTasks[1]) {
                    if (secondHardDiskOption != null)
                    {
                        secondHardDiskOption = secondHardDiskOption.replaceAll("\"", "");
                    }
                }

                if (fixTasks[2]) {
                    if (thirdHardDiskOption != null)
                    {                        
                        thirdHardDiskOption = thirdHardDiskOption.replaceAll("\"", "");
                    }
                }

                if (fixTasks[3]) {
                    if (fourthHardDiskOption != null)
                    {
                        fourthHardDiskOption = fourthHardDiskOption.replaceAll("\"", "");
                    }
                }

                saveToXML(xml);
            }

            return true;

        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        return false;
    }

    public boolean readConfigurationFromXML(String xml) {
        Document dom;
        // Make an instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the
            // XML file
            dom = db.parse(xml);

            Element doc = dom.getDocumentElement();

            defaultVMPath = getTextValue(doc, "defaultVMPath");
            execute_before_start_qemu = getTextValue(doc, "execute_before_start_qemu");
            qemu_executable_path = getTextValue(doc, "qemu_executable_path");
            execute_after_stop_qemu = getTextValue(doc, "execute_after_stop_qemu");
            qemu_img_executable_path = getTextValue(doc, "qemu_img_executable_path");
            bios_vga_bios_keymaps_path = getTextValue(doc, "bios_vga_bios_keymaps_path");
            return true;

        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        return false;
    }

    public void saveToXML(String xml) {
        Document dom;
        Element e = null;

        // instance of a DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use factory to get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // create instance of DOM
            dom = db.newDocument();

            dom.setXmlStandalone(true);

            // create the root element
            Element rootEle = dom.createElement("JavaQemuMachine");

            // create data elements and place them under root
            if (machineName != null) {
                e = dom.createElement("machineName");
                e.appendChild(dom.createTextNode(machineName));
                rootEle.appendChild(e);
            }

            if (machineType != null) {
                e = dom.createElement("machineType");
                e.appendChild(dom.createTextNode(machineType));
                rootEle.appendChild(e);
            }

            if (machineAccel1 != null) {
                e = dom.createElement("machineAccel1");
                e.appendChild(dom.createTextNode(machineAccel1));
                rootEle.appendChild(e);
            }

            if (machineAccel2 != null) {
                e = dom.createElement("machineAccel2");
                e.appendChild(dom.createTextNode(machineAccel2));
                rootEle.appendChild(e);
            }

            if (machineAccel3 != null) {
                e = dom.createElement("machineAccel3");
                e.appendChild(dom.createTextNode(machineAccel3));
                rootEle.appendChild(e);
            }

            if (machineKernel_irpchip != null) {
                e = dom.createElement("machineKernel_irpchip");
                e.appendChild(dom.createTextNode(machineKernel_irpchip));
                rootEle.appendChild(e);
            }

            if (machineKvm_shadow_mem != null) {
                e = dom.createElement("machineKvm_shadow_mem");
                e.appendChild(dom.createTextNode(machineKvm_shadow_mem));
                rootEle.appendChild(e);
            }

            if (machineDump_guest_core != null) {
                e = dom.createElement("machineDump_guest_core");
                e.appendChild(dom.createTextNode(machineDump_guest_core));
                rootEle.appendChild(e);
            }

            if (machineMem_merge != null) {
                e = dom.createElement("machineMem_merge");
                e.appendChild(dom.createTextNode(machineMem_merge));
                rootEle.appendChild(e);
            }

            if (cpuModel != null) {
                e = dom.createElement("cpuModel");
                e.appendChild(dom.createTextNode(cpuModel));
                rootEle.appendChild(e);
            }

            if (cpuidFlags != null) {
                e = dom.createElement("cpuidFlags");
                e.appendChild(dom.createTextNode(cpuidFlags));
                rootEle.appendChild(e);
            }

            if (cdrom != null) {
                if (cdrom.contains("\"")) {
                    cdrom = cdrom.replaceAll("\"", "");
                }
                e = dom.createElement("cdrom");
                e.appendChild(dom.createTextNode(cdrom));
                rootEle.appendChild(e);
            }

            if (floppyDiskA != null) {
                e = dom.createElement("floppyDiskA");
                e.appendChild(dom.createTextNode(floppyDiskA));
                rootEle.appendChild(e);
            }

            if (floppyDiskB != null) {
                e = dom.createElement("floppyDiskB");
                e.appendChild(dom.createTextNode(floppyDiskB));
                rootEle.appendChild(e);
            }

            if (bootOrder1 != null) {
                e = dom.createElement("bootOrder1");
                e.appendChild(dom.createTextNode(bootOrder1));
                rootEle.appendChild(e);
            }

            if (bootOrder2 != null) {
                e = dom.createElement("bootOrder2");
                e.appendChild(dom.createTextNode(bootOrder2));
                rootEle.appendChild(e);
            }

            if (bootOrder3 != null) {
                e = dom.createElement("bootOrder3");
                e.appendChild(dom.createTextNode(bootOrder3));
                rootEle.appendChild(e);
            }

            if (bootOnce1 != null) {
                e = dom.createElement("bootOnce1");
                e.appendChild(dom.createTextNode(bootOnce1));
                rootEle.appendChild(e);
            }

            if (bootOnce2 != null) {
                e = dom.createElement("bootOnce2");
                e.appendChild(dom.createTextNode(bootOnce2));
                rootEle.appendChild(e);
            }

            if (bootOnce3 != null) {
                e = dom.createElement("bootOnce3");
                e.appendChild(dom.createTextNode(bootOnce3));
                rootEle.appendChild(e);
            }

            if (bootMenu != null) {
                e = dom.createElement("bootMenu");
                e.appendChild(dom.createTextNode(bootMenu));
                rootEle.appendChild(e);
            }

            if (bootSplash != null) {
                e = dom.createElement("bootSplash");
                e.appendChild(dom.createTextNode(bootSplash));
                rootEle.appendChild(e);
            }

            if (bootSplashTime != null) {
                e = dom.createElement("bootSplashTime");
                e.appendChild(dom.createTextNode(bootSplashTime));
                rootEle.appendChild(e);
            }

            if (bootRebootTimeout != null) {
                e = dom.createElement("bootRebootTimeout");
                e.appendChild(dom.createTextNode(bootRebootTimeout));
                rootEle.appendChild(e);
            }

            if (bootStrict != null) {
                e = dom.createElement("bootStrict");
                e.appendChild(dom.createTextNode(bootStrict));
                rootEle.appendChild(e);
            }

            if (keyboardLayoutLanguage != null) {
                e = dom.createElement("keyboardLayoutLanguage");
                e.appendChild(dom.createTextNode(keyboardLayoutLanguage));
                rootEle.appendChild(e);
            }

            if (firstHardDiskOption != null) {
                if (firstHardDiskOption.contains("\"")) {
                    firstHardDiskOption = firstHardDiskOption.replaceAll("\"", "");
                }
                //e = dom.createElement("diskPath"); // deprecated
                e = dom.createElement("firstHardDiskOption");
                e.appendChild(dom.createTextNode(firstHardDiskOption));
                rootEle.appendChild(e);
            }

            if (secondHardDiskOption != null) {
                if (secondHardDiskOption.contains("\"")) {
                    secondHardDiskOption = secondHardDiskOption.replaceAll("\"", "");
                }
                e = dom.createElement("secondHardDiskOption");
                e.appendChild(dom.createTextNode(secondHardDiskOption));
                rootEle.appendChild(e);
            }

            if (thirdHardDiskOption != null) {
                if (thirdHardDiskOption.contains("\"")) {
                    thirdHardDiskOption = thirdHardDiskOption.replaceAll("\"", "");
                }
                e = dom.createElement("thirdHardDiskOption");
                e.appendChild(dom.createTextNode(thirdHardDiskOption));
                rootEle.appendChild(e);
            }

            if (fourthHardDiskOption != null) {
                if (fourthHardDiskOption.contains("\"")) {
                    fourthHardDiskOption = fourthHardDiskOption.replaceAll("\"", "");
                }
                e = dom.createElement("fourthHardDiskOption");
                e.appendChild(dom.createTextNode(fourthHardDiskOption));
                rootEle.appendChild(e);
            }

            if (ramSize != null) {
                e = dom.createElement("ramSize");
                e.appendChild(dom.createTextNode(ramSize));
                rootEle.appendChild(e);
            }

            if (displayType != null) {
                e = dom.createElement("displayType");
                e.appendChild(dom.createTextNode(displayType));
                rootEle.appendChild(e);
            }

            if (nographicOption != null) {
                e = dom.createElement("nographicOption");
                e.appendChild(dom.createTextNode(nographicOption));
                rootEle.appendChild(e);
            }

            if (vgaType != null) {
                e = dom.createElement("vgaType");
                e.appendChild(dom.createTextNode(vgaType));
                rootEle.appendChild(e);
            }

            if (fullscreenOption != null) {
                e = dom.createElement("fullscreenOption");
                e.appendChild(dom.createTextNode(fullscreenOption));
                rootEle.appendChild(e);
            }

            if (win2khackOption != null) {
                e = dom.createElement("win2khackOption");
                e.appendChild(dom.createTextNode(win2khackOption));
                rootEle.appendChild(e);
            }

            if (noacpiOption != null) {
                e = dom.createElement("noacpiOption");
                e.appendChild(dom.createTextNode(noacpiOption));
                rootEle.appendChild(e);
            }

            if (soundHardwareOption != null) {
                e = dom.createElement("soundHardwareOption");
                e.appendChild(dom.createTextNode(soundHardwareOption));
                rootEle.appendChild(e);
            }

            if (smpCpusNumber != null) {
                e = dom.createElement("smpCpusNumber");
                e.appendChild(dom.createTextNode(smpCpusNumber));
                rootEle.appendChild(e);
            }

            if (smpCoresNumber != null) {
                e = dom.createElement("smpCoresNumber");
                e.appendChild(dom.createTextNode(smpCoresNumber));
                rootEle.appendChild(e);
            }

            if (smpThreadsNumber != null) {
                e = dom.createElement("smpThreadsNumber");
                e.appendChild(dom.createTextNode(smpThreadsNumber));
                rootEle.appendChild(e);
            }

            if (smpSocketsNumber != null) {
                e = dom.createElement("smpSocketsNumber");
                e.appendChild(dom.createTextNode(smpSocketsNumber));
                rootEle.appendChild(e);
            }

            if (smpCpusMaxNumber != null) {
                e = dom.createElement("smpCpusMaxNumber");
                e.appendChild(dom.createTextNode(smpCpusMaxNumber));
                rootEle.appendChild(e);
            }

            if (firstNumaNodeMem != null) {
                e = dom.createElement("firstNumaNodeMem");
                e.appendChild(dom.createTextNode(firstNumaNodeMem));
                rootEle.appendChild(e);
            }

            if (firstNumaNodeCpus != null) {
                e = dom.createElement("firstNumaNodeCpus");
                e.appendChild(dom.createTextNode(firstNumaNodeCpus));
                rootEle.appendChild(e);
            }

            if (secondNumaNodeMem != null) {
                e = dom.createElement("secondNumaNodeMem");
                e.appendChild(dom.createTextNode(secondNumaNodeMem));
                rootEle.appendChild(e);
            }

            if (secondNumaNodeCpus != null) {
                e = dom.createElement("secondNumaNodeCpus");
                e.appendChild(dom.createTextNode(secondNumaNodeCpus));
                rootEle.appendChild(e);
            }

            if (thirdNumaNodeMem != null) {
                e = dom.createElement("thirdNumaNodeMem");
                e.appendChild(dom.createTextNode(thirdNumaNodeMem));
                rootEle.appendChild(e);
            }

            if (thirdNumaNodeCpus != null) {
                e = dom.createElement("thirdNumaNodeCpus");
                e.appendChild(dom.createTextNode(thirdNumaNodeCpus));
                rootEle.appendChild(e);
            }

            if (fourthNumaNodeMem != null) {
                e = dom.createElement("fourthNumaNodeMem");
                e.appendChild(dom.createTextNode(fourthNumaNodeMem));
                rootEle.appendChild(e);
            }

            if (fourthNumaNodeCpus != null) {
                e = dom.createElement("fourthNumaNodeCpus");
                e.appendChild(dom.createTextNode(fourthNumaNodeCpus));
                rootEle.appendChild(e);
            }

            if (fifthNumaNodeMem != null) {
                e = dom.createElement("fifthNumaNodeMem");
                e.appendChild(dom.createTextNode(fifthNumaNodeMem));
                rootEle.appendChild(e);
            }

            if (fifthNumaNodeCpus != null) {
                e = dom.createElement("fifthNumaNodeCpus");
                e.appendChild(dom.createTextNode(fifthNumaNodeCpus));
                rootEle.appendChild(e);
            }

            if (sixthNumaNodeMem != null) {
                e = dom.createElement("sixthNumaNodeMem");
                e.appendChild(dom.createTextNode(sixthNumaNodeMem));
                rootEle.appendChild(e);
            }

            if (sixthNumaNodeCpus != null) {
                e = dom.createElement("sixthNumaNodeCpus");
                e.appendChild(dom.createTextNode(sixthNumaNodeCpus));
                rootEle.appendChild(e);
            }

            if (seventhNumaNodeMem != null) {
                e = dom.createElement("seventhNumaNodeMem");
                e.appendChild(dom.createTextNode(seventhNumaNodeMem));
                rootEle.appendChild(e);
            }

            if (seventhNumaNodeCpus != null) {
                e = dom.createElement("seventhNumaNodeCpus");
                e.appendChild(dom.createTextNode(seventhNumaNodeCpus));
                rootEle.appendChild(e);
            }

            if (eighthNumaNodeMem != null) {
                e = dom.createElement("eighthNumaNodeMem");
                e.appendChild(dom.createTextNode(eighthNumaNodeMem));
                rootEle.appendChild(e);
            }

            if (eighthNumaNodeCpus != null) {
                e = dom.createElement("eighthNumaNodeCpus");
                e.appendChild(dom.createTextNode(eighthNumaNodeCpus));
                rootEle.appendChild(e);
            }

            if (ninthNumaNodeMem != null) {
                e = dom.createElement("ninthNumaNodeMem");
                e.appendChild(dom.createTextNode(ninthNumaNodeMem));
                rootEle.appendChild(e);
            }

            if (ninthNumaNodeCpus != null) {
                e = dom.createElement("ninthNumaNodeCpus");
                e.appendChild(dom.createTextNode(ninthNumaNodeCpus));
                rootEle.appendChild(e);
            }

            if (tenthNumaNodeMem != null) {
                e = dom.createElement("tenthNumaNodeMem");
                e.appendChild(dom.createTextNode(tenthNumaNodeMem));
                rootEle.appendChild(e);
            }

            if (tenthNumaNodeCpus != null) {
                e = dom.createElement("tenthNumaNodeCpus");
                e.appendChild(dom.createTextNode(tenthNumaNodeCpus));
                rootEle.appendChild(e);
            }

            if (noFrameOption != null) {
                e = dom.createElement("noFrameOption");
                e.appendChild(dom.createTextNode(noFrameOption));
                rootEle.appendChild(e);
            }

            if (memPathOption != null) {
                if (memPathOption.contains("\"")) {
                    memPathOption = memPathOption.replaceAll("\"", "");
                }
                e = dom.createElement("memPathOption");
                e.appendChild(dom.createTextNode(memPathOption));
                rootEle.appendChild(e);
            }

            if (memPreallocOption != null) {
                e = dom.createElement("memPreallocOption");
                e.appendChild(dom.createTextNode(memPreallocOption));
                rootEle.appendChild(e);
            }

            if (firstNetworkNICOption != null) {
                e = dom.createElement("firstNetworkNICOption");
                e.appendChild(dom.createTextNode(firstNetworkNICOption));
                rootEle.appendChild(e);
            }

            if (firstNetworkExtraOption != null) {
                e = dom.createElement("firstNetworkExtraOption");
                e.appendChild(dom.createTextNode(firstNetworkExtraOption));
                rootEle.appendChild(e);
            }

            if (firstNetworkNetdevOption != null) {
                e = dom.createElement("firstNetworkNetdevOption");
                e.appendChild(dom.createTextNode(firstNetworkNetdevOption));
                rootEle.appendChild(e);
            }

            if (secondNetworkNICOption != null) {
                e = dom.createElement("secondNetworkNICOption");
                e.appendChild(dom.createTextNode(secondNetworkNICOption));
                rootEle.appendChild(e);
            }

            if (secondNetworkExtraOption != null) {
                e = dom.createElement("secondNetworkExtraOption");
                e.appendChild(dom.createTextNode(secondNetworkExtraOption));
                rootEle.appendChild(e);
            }

            if (secondNetworkNetdevOption != null) {
                e = dom.createElement("secondNetworkNetdevOption");
                e.appendChild(dom.createTextNode(secondNetworkNetdevOption));
                rootEle.appendChild(e);
            }

            if (thirdNetworkNICOption != null) {
                e = dom.createElement("thirdNetworkNICOption");
                e.appendChild(dom.createTextNode(thirdNetworkNICOption));
                rootEle.appendChild(e);
            }

            if (thirdNetworkExtraOption != null) {
                e = dom.createElement("thirdNetworkExtraOption");
                e.appendChild(dom.createTextNode(thirdNetworkExtraOption));
                rootEle.appendChild(e);
            }

            if (thirdNetworkNetdevOption != null) {
                e = dom.createElement("thirdNetworkNetdevOption");
                e.appendChild(dom.createTextNode(thirdNetworkNetdevOption));
                rootEle.appendChild(e);
            }

            if (fourthNetworkNICOption != null) {
                e = dom.createElement("fourthNetworkNICOption");
                e.appendChild(dom.createTextNode(fourthNetworkNICOption));
                rootEle.appendChild(e);
            }

            if (fourthNetworkExtraOption != null) {
                e = dom.createElement("fourthNetworkExtraOption");
                e.appendChild(dom.createTextNode(fourthNetworkExtraOption));
                rootEle.appendChild(e);
            }

            if (fourthNetworkNetdevOption != null) {
                e = dom.createElement("fourthNetworkNetdevOption");
                e.appendChild(dom.createTextNode(fourthNetworkNetdevOption));
                rootEle.appendChild(e);
            }

            if (fifthNetworkNICOption != null) {
                e = dom.createElement("fifthNetworkNICOption");
                e.appendChild(dom.createTextNode(fifthNetworkNICOption));
                rootEle.appendChild(e);
            }

            if (fifthNetworkExtraOption != null) {
                e = dom.createElement("fifthNetworkExtraOption");
                e.appendChild(dom.createTextNode(fifthNetworkExtraOption));
                rootEle.appendChild(e);
            }

            if (fifthNetworkNetdevOption != null) {
                e = dom.createElement("fifthNetworkNetdevOption");
                e.appendChild(dom.createTextNode(fifthNetworkNetdevOption));
                rootEle.appendChild(e);
            }

            if (sixthNetworkNICOption != null) {
                e = dom.createElement("sixthNetworkNICOption");
                e.appendChild(dom.createTextNode(sixthNetworkNICOption));
                rootEle.appendChild(e);
            }

            if (sixthNetworkExtraOption != null) {
                e = dom.createElement("sixthNetworkExtraOption");
                e.appendChild(dom.createTextNode(sixthNetworkExtraOption));
                rootEle.appendChild(e);
            }

            if (sixthNetworkNetdevOption != null) {
                e = dom.createElement("sixthNetworkNetdevOption");
                e.appendChild(dom.createTextNode(sixthNetworkNetdevOption));
                rootEle.appendChild(e);
            }

            if (seventhNetworkNICOption != null) {
                e = dom.createElement("seventhNetworkNICOption");
                e.appendChild(dom.createTextNode(seventhNetworkNICOption));
                rootEle.appendChild(e);
            }

            if (seventhNetworkNetdevOption != null) {
                e = dom.createElement("seventhNetworkNetdevOption");
                e.appendChild(dom.createTextNode(seventhNetworkNetdevOption));
                rootEle.appendChild(e);
            }

            if (seventhNetworkExtraOption != null) {
                e = dom.createElement("seventhNetworkExtraOption");
                e.appendChild(dom.createTextNode(seventhNetworkExtraOption));
                rootEle.appendChild(e);
            }

            if (eighthNetworkNICOption != null) {
                e = dom.createElement("eighthNetworkNICOption");
                e.appendChild(dom.createTextNode(eighthNetworkNICOption));
                rootEle.appendChild(e);
            }

            if (eighthNetworkExtraOption != null) {
                e = dom.createElement("eighthNetworkExtraOption");
                e.appendChild(dom.createTextNode(eighthNetworkExtraOption));
                rootEle.appendChild(e);
            }

            if (eighthNetworkNetdevOption != null) {
                e = dom.createElement("eighthNetworkNetdevOption");
                e.appendChild(dom.createTextNode(eighthNetworkNetdevOption));
                rootEle.appendChild(e);
            }

            if (ninthNetworkNICOption != null) {
                e = dom.createElement("ninthNetworkNICOption");
                e.appendChild(dom.createTextNode(ninthNetworkNICOption));
                rootEle.appendChild(e);
            }

            if (ninthNetworkExtraOption != null) {
                e = dom.createElement("ninthNetworkExtraOption");
                e.appendChild(dom.createTextNode(ninthNetworkExtraOption));
                rootEle.appendChild(e);
            }

            if (ninthNetworkNetdevOption != null) {
                e = dom.createElement("ninthNetworkNetdevOption");
                e.appendChild(dom.createTextNode(ninthNetworkNetdevOption));
                rootEle.appendChild(e);
            }

            if (tenthNetworkNICOption != null) {
                e = dom.createElement("tenthNetworkNICOption");
                e.appendChild(dom.createTextNode(tenthNetworkNICOption));
                rootEle.appendChild(e);
            }

            if (tenthNetworkExtraOption != null) {
                e = dom.createElement("tenthNetworkExtraOption");
                e.appendChild(dom.createTextNode(tenthNetworkExtraOption));
                rootEle.appendChild(e);
            }

            if (tenthNetworkNetdevOption != null) {
                e = dom.createElement("tenthNetworkNetdevOption");
                e.appendChild(dom.createTextNode(tenthNetworkNetdevOption));
                rootEle.appendChild(e);
            }

            if (rtcOption != null) {
                e = dom.createElement("rtcOption");
                e.appendChild(dom.createTextNode(rtcOption));
                rootEle.appendChild(e);
            }

            if (nameOption != null) {
                e = dom.createElement("nameOption");
                e.appendChild(dom.createTextNode(nameOption));
                rootEle.appendChild(e);
            }

            if (snapshotOption != null) {
                e = dom.createElement("snapshotOption");
                e.appendChild(dom.createTextNode(snapshotOption));
                rootEle.appendChild(e);
            }

            if (noFdBootchkOption != null) {
                e = dom.createElement("noFdBootchkOption");
                e.appendChild(dom.createTextNode(noFdBootchkOption));
                rootEle.appendChild(e);
            }

            if (noHpetOption != null) {
                e = dom.createElement("noHpetOption");
                e.appendChild(dom.createTextNode(noHpetOption));
                rootEle.appendChild(e);
            }

            if (mtdblockOption != null) {
                e = dom.createElement("mtdblockOption");
                e.appendChild(dom.createTextNode(mtdblockOption));
                rootEle.appendChild(e);
            }

            if (sdOption != null) {
                e = dom.createElement("sdOption");
                e.appendChild(dom.createTextNode(sdOption));
                rootEle.appendChild(e);
            }

            if (pflashOption != null) {
                e = dom.createElement("pflashOption");
                e.appendChild(dom.createTextNode(pflashOption));
                rootEle.appendChild(e);
            }

            if (monitorOption != null) {
                e = dom.createElement("monitorOption");
                e.appendChild(dom.createTextNode(monitorOption));
                rootEle.appendChild(e);
            }

            if (qmpOption != null) {
                e = dom.createElement("qmpOption");
                e.appendChild(dom.createTextNode(qmpOption));
                rootEle.appendChild(e);
            }

            if (usbDriverOption != null) {
                e = dom.createElement("usbDriverOption");
                e.appendChild(dom.createTextNode(usbDriverOption));
                rootEle.appendChild(e);
            }

            if (usbMouseOption != null) {
                e = dom.createElement("usbMouseOption");
                e.appendChild(dom.createTextNode(usbMouseOption));
                rootEle.appendChild(e);
            }

            if (usbTabletOption != null) {
                e = dom.createElement("usbTabletOption");
                e.appendChild(dom.createTextNode(usbTabletOption));
                rootEle.appendChild(e);
            }

            if (usbWacomTabletOption != null) {
                e = dom.createElement("usbWacomTabletOption");
                e.appendChild(dom.createTextNode(usbWacomTabletOption));
                rootEle.appendChild(e);
            }

            if (usbKeyboardOption != null) {
                e = dom.createElement("usbKeyboardOption");
                e.appendChild(dom.createTextNode(usbKeyboardOption));
                rootEle.appendChild(e);
            }

            if (usbBrailleOption != null) {
                e = dom.createElement("usbBrailleOption");
                e.appendChild(dom.createTextNode(usbBrailleOption));
                rootEle.appendChild(e);
            }

            if (usbDiskOption != null) {
                e = dom.createElement("usbDiskOption");
                e.appendChild(dom.createTextNode(usbDiskOption));
                rootEle.appendChild(e);
            }

            if (usbSerialOption != null) {
                e = dom.createElement("usbSerialOption");
                e.appendChild(dom.createTextNode(usbSerialOption));
                rootEle.appendChild(e);
            }

            if (usbNetOption != null) {
                e = dom.createElement("usbNetOption");
                e.appendChild(dom.createTextNode(usbNetOption));
                rootEle.appendChild(e);
            }

            if (kernelBootOption != null) {
                e = dom.createElement("kernelBootOption");
                e.appendChild(dom.createTextNode(kernelBootOption));
                rootEle.appendChild(e);
            }

            if (customOptions != null) {
                e = dom.createElement("customOptions");
                e.appendChild(dom.createTextNode(customOptions));
                rootEle.appendChild(e);
            }

            dom.appendChild(rootEle);

            try {
                Transformer tr = TransformerFactory.newInstance()
                        .newTransformer();

                tr.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                tr.setOutputProperty(OutputKeys.VERSION, "1.0");
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "JavaQemuMachine");
                tr.setOutputProperty(
                        "{http://xml.apache.org/xslt}indent-amount", "4");

                tr.transform(new DOMSource(dom),
                        new StreamResult(new File(xml)));

            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out
                    .println("UsersXML: Error trying to instantiate DocumentBuilder "
                            + pce);
        }
    }

    public void saveConfigurationToXML(String xml) {
        Document dom;
        Element e = null;

        // instance of a DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use factory to get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // create instance of DOM
            dom = db.newDocument();

            dom.setXmlStandalone(true);

            // create the root element
            Element rootEle = dom.createElement("JavaQemuConfiguration");

            // create data elements and place them under root
            if (defaultVMPath != null) {
                e = dom.createElement("defaultVMPath");
                e.appendChild(dom.createTextNode(defaultVMPath));
                rootEle.appendChild(e);
            }

            if (execute_before_start_qemu != null) {
                //e = dom.createElement("diskPath"); // deprecated
                e = dom.createElement("execute_before_start_qemu");
                e.appendChild(dom.createTextNode(execute_before_start_qemu));
                rootEle.appendChild(e);
            }

            if (qemu_executable_path != null) {
                e = dom.createElement("qemu_executable_path");
                e.appendChild(dom.createTextNode(qemu_executable_path));
                rootEle.appendChild(e);
            }

            if (execute_after_stop_qemu != null) {
                e = dom.createElement("execute_after_stop_qemu");
                e.appendChild(dom.createTextNode(execute_after_stop_qemu));
                rootEle.appendChild(e);
            }

            if (qemu_img_executable_path != null) {
                e = dom.createElement("qemu_img_executable_path");
                e.appendChild(dom.createTextNode(qemu_img_executable_path));
                rootEle.appendChild(e);
            }

            if (bios_vga_bios_keymaps_path != null) {
                e = dom.createElement("bios_vga_bios_keymaps_path");
                e.appendChild(dom.createTextNode(bios_vga_bios_keymaps_path));
                rootEle.appendChild(e);
            }

            dom.appendChild(rootEle);

            try {
                Transformer tr = TransformerFactory.newInstance()
                        .newTransformer();

                tr.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                tr.setOutputProperty(OutputKeys.VERSION, "1.0");
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "JavaQemuMachine");
                tr.setOutputProperty(
                        "{http://xml.apache.org/xslt}indent-amount", "4");

                tr.transform(new DOMSource(dom),
                        new StreamResult(new File(xml)));

            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out
                    .println("UsersXML: Error trying to instantiate DocumentBuilder "
                            + pce);
        }
    }

    private String getTextValue(Element doc, String tag) {
        String value = null;
        NodeList nl;
        nl = doc.getElementsByTagName(tag);
        if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
            value = nl.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public void setFirstHardDiskOption(String firstHardDiskOption) {
        this.firstHardDiskOption = firstHardDiskOption;
    }

    public void setSecondHardDiskOption(String secondHardDiskOption) {
        this.secondHardDiskOption = secondHardDiskOption;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getMachineName() {
        return machineName;
    }

    public String getFirstHardDiskOption() {
        return firstHardDiskOption;
    }

    public String getSecondHardDiskOption() {
        return secondHardDiskOption;
    }

    public String getThirdHardDiskOption() {
        return thirdHardDiskOption;
    }

    public void setThirdHardDiskOption(String thirdHardDiskOption) {
        this.thirdHardDiskOption = thirdHardDiskOption;
    }

    public String getFourthHardDiskOption() {
        return fourthHardDiskOption;
    }

    public void setFourthHardDiskOption(String fourthHardDiskOption) {
        this.fourthHardDiskOption = fourthHardDiskOption;
    }

    public String checks_extension(String path) {
        String result = "";
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                result = "/";
                break;
            }
            if (path.charAt(i) == '\\') {
                result = "\\";
                break;
            }
        }
        return result;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    public void setConfiguration(JTextField default_virtual_machines_path_choice,
            JTextArea execute_before_start_qemu_choices,
            JTextField qemu_executable_path_choice,
            JTextArea execute_after_stop_qemu_choices,
            JTextField qemu_img_executable_path_choice,
            JTextField bios_vga_bios_keymaps_path_choice) {
        this.defaultVMPath = default_virtual_machines_path_choice.getText();
        this.execute_before_start_qemu = execute_before_start_qemu_choices.getText();
        this.qemu_executable_path = qemu_executable_path_choice.getText();
        this.execute_after_stop_qemu = execute_after_stop_qemu_choices.getText();
        this.qemu_img_executable_path = qemu_img_executable_path_choice.getText();
        this.bios_vga_bios_keymaps_path = bios_vga_bios_keymaps_path_choice.getText();
    }

    public void getConfiguration(JTextField default_virtual_machines_path_choice,
            JTextArea execute_before_start_qemu_choices,
            JTextField qemu_executable_path_choice,
            JTextArea execute_after_stop_qemu_choices,
            JTextField qemu_img_executable_path_choice,
            JTextField bios_vga_bios_keymaps_path_choice) {
        default_virtual_machines_path_choice.setText(this.defaultVMPath);
        execute_before_start_qemu_choices.setText(this.execute_before_start_qemu);
        qemu_executable_path_choice.setText(this.qemu_executable_path);
        execute_after_stop_qemu_choices.setText(this.execute_after_stop_qemu);
        qemu_img_executable_path_choice.setText(this.qemu_img_executable_path);
        bios_vga_bios_keymaps_path_choice.setText(this.bios_vga_bios_keymaps_path);
    }

    public String getDefaultVMPath() {
        return defaultVMPath;
    }

    public void setDefaultVMPath(String defaultVMPath) {
        this.defaultVMPath = defaultVMPath;
    }

    public String getExecute_before_start_qemu() {
        return execute_before_start_qemu;
    }

    public void setExecute_before_start_qemu(String execute_before_start_qemu) {
        this.execute_before_start_qemu = execute_before_start_qemu;
    }

    public String getQemu_executable_path() {
        return qemu_executable_path;
    }

    public void setQemu_executable_path(String qemu_executable_path) {
        this.qemu_executable_path = qemu_executable_path;
    }

    public String getExecute_after_stop_qemu() {
        return execute_after_stop_qemu;
    }

    public void setExecute_after_stop_qemu(String execute_after_stop_qemu) {
        this.execute_after_stop_qemu = execute_after_stop_qemu;
    }

    public String getQemu_img_executable_path() {
        return qemu_img_executable_path;
    }

    public void setQemu_img_executable_path(String qemu_img_executable_path) {
        this.qemu_img_executable_path = qemu_img_executable_path;
    }

    public String getBios_vga_bios_keymaps_path() {
        return bios_vga_bios_keymaps_path;
    }

    public void setBios_vga_bios_keymaps_path(String bios_vga_bios_keymaps_path) {
        this.bios_vga_bios_keymaps_path = bios_vga_bios_keymaps_path;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getNographicOption() {
        return nographicOption;
    }

    public void setNographicOption(String nographicOption) {
        this.nographicOption = nographicOption;
    }

    public String getVgaType() {
        return vgaType;
    }

    public void setVgaType(String vgaType) {
        this.vgaType = vgaType;
    }

    public String getFullscreenOption() {
        return fullscreenOption;
    }

    public void setFullscreenOption(String fullscreenOption) {
        this.fullscreenOption = fullscreenOption;
    }

    public String getWin2khackOption() {
        return win2khackOption;
    }

    public void setWin2khackOption(String win2khackOption) {
        this.win2khackOption = win2khackOption;
    }

    public String getNoacpiOption() {
        return noacpiOption;
    }

    public void setNoacpiOption(String noacpiOption) {
        this.noacpiOption = noacpiOption;
    }

    public String getMachineAccel1() {
        return machineAccel1;
    }

    public void setMachineAccel1(String machineAccel1) {
        this.machineAccel1 = machineAccel1;
    }

    public String getMachineAccel2() {
        return machineAccel2;
    }

    public void setMachineAccel2(String machineAccel2) {
        this.machineAccel2 = machineAccel2;
    }

    public String getMachineAccel3() {
        return machineAccel3;
    }

    public void setMachineAccel3(String machineAccel3) {
        this.machineAccel3 = machineAccel3;
    }

    public String getMachineKernel_irpchip() {
        return machineKernel_irpchip;
    }

    public void setMachineKernel_irpchip(String machineKernel_irpchip) {
        this.machineKernel_irpchip = machineKernel_irpchip;
    }

    public String getMachineKvm_shadow_mem() {
        return machineKvm_shadow_mem;
    }

    public void setMachineKvm_shadow_mem(String machineKvm_shadow_mem) {
        this.machineKvm_shadow_mem = machineKvm_shadow_mem;
    }

    public String getMachineDump_guest_core() {
        return machineDump_guest_core;
    }

    public void setMachineDump_guest_core(String machineDump_guest_core) {
        this.machineDump_guest_core = machineDump_guest_core;
    }

    public String getMachineMem_merge() {
        return machineMem_merge;
    }

    public void setMachineMem_merge(String machineMem_merge) {
        this.machineMem_merge = machineMem_merge;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getCpuidFlags() {
        return cpuidFlags;
    }

    public void setCpuidFlags(String cpuidFlags) {
        this.cpuidFlags = cpuidFlags;
    }

    public String getCdrom() {
        return cdrom;
    }

    public void setCdrom(String cdrom) {
        this.cdrom = cdrom;
    }

    public String getFloppyDiskA() {
        return floppyDiskA;
    }

    public void setFloppyDiskA(String floppyDiskA) {
        this.floppyDiskA = floppyDiskA;
    }

    public String getFloppyDiskB() {
        return floppyDiskB;
    }

    public void setFloppyDiskB(String floppyDiskB) {
        this.floppyDiskB = floppyDiskB;
    }

    public String getBootOrder1() {
        return bootOrder1;
    }

    public void setBootOrder1(String bootOrder1) {
        this.bootOrder1 = bootOrder1;
    }

    public String getBootOrder2() {
        return bootOrder2;
    }

    public void setBootOrder2(String bootOrder2) {
        this.bootOrder2 = bootOrder2;
    }

    public String getBootOrder3() {
        return bootOrder3;
    }

    public void setBootOrder3(String bootOrder3) {
        this.bootOrder3 = bootOrder3;
    }

    public String getBootOnce1() {
        return bootOnce1;
    }

    public void setBootOnce1(String bootOnce1) {
        this.bootOnce1 = bootOnce1;
    }

    public String getBootOnce2() {
        return bootOnce2;
    }

    public void setBootOnce2(String bootOnce2) {
        this.bootOnce2 = bootOnce2;
    }

    public String getBootOnce3() {
        return bootOnce3;
    }

    public void setBootOnce3(String bootOnce3) {
        this.bootOnce3 = bootOnce3;
    }

    public String getBootMenu() {
        return bootMenu;
    }

    public void setBootMenu(String bootMenu) {
        this.bootMenu = bootMenu;
    }

    public String getBootSplash() {
        return bootSplash;
    }

    public void setBootSplash(String bootSplash) {
        this.bootSplash = bootSplash;
    }

    public String getBootSplashTime() {
        return bootSplashTime;
    }

    public void setBootSplashTime(String bootSplashTime) {
        this.bootSplashTime = bootSplashTime;
    }

    public String getBootRebootTimeout() {
        return bootRebootTimeout;
    }

    public void setBootRebootTimeout(String bootRebootTimeout) {
        this.bootRebootTimeout = bootRebootTimeout;
    }

    public String getBootStrict() {
        return bootStrict;
    }

    public void setBootStrict(String bootStrict) {
        this.bootStrict = bootStrict;
    }

    public String getKeyboardLayoutLanguage() {
        return keyboardLayoutLanguage;
    }

    public void setKeyboardLayoutLanguage(String keyboardLayoutLanguage) {
        this.keyboardLayoutLanguage = keyboardLayoutLanguage;
    }

    public String getSoundHardwareOption() {
        return soundHardwareOption;
    }

    public void setSoundHardwareOption(String soundHardwareOption) {
        this.soundHardwareOption = soundHardwareOption;
    }

    public String getSmpCpusNumber() {
        return smpCpusNumber;
    }

    public void setSmpCpusNumber(String smpCpusNumber) {
        this.smpCpusNumber = smpCpusNumber;
    }

    public String getSmpCoresNumber() {
        return smpCoresNumber;
    }

    public void setSmpCoresNumber(String smpCoresNumber) {
        this.smpCoresNumber = smpCoresNumber;
    }

    public String getSmpThreadsNumber() {
        return smpThreadsNumber;
    }

    public void setSmpThreadsNumber(String smpThreadsNumber) {
        this.smpThreadsNumber = smpThreadsNumber;
    }

    public String getSmpSocketsNumber() {
        return smpSocketsNumber;
    }

    public void setSmpSocketsNumber(String smpSocketsNumber) {
        this.smpSocketsNumber = smpSocketsNumber;
    }

    public String getSmpCpusMaxNumber() {
        return smpCpusMaxNumber;
    }

    public void setSmpCpusMaxNumber(String smpCpusMaxNumber) {
        this.smpCpusMaxNumber = smpCpusMaxNumber;
    }

    public String getFirstNumaNodeMem() {
        return firstNumaNodeMem;
    }

    public void setFirstNumaNodeMem(String firstNumaNodeMem) {
        this.firstNumaNodeMem = firstNumaNodeMem;
    }

    public String getFirstNumaNodeCpus() {
        return firstNumaNodeCpus;
    }

    public void setFirstNumaNodeCpus(String firstNumaNodeCpus) {
        this.firstNumaNodeCpus = firstNumaNodeCpus;
    }

    public String getSecondNumaNodeMem() {
        return secondNumaNodeMem;
    }

    public void setSecondNumaNodeMem(String secondNumaNodeMem) {
        this.secondNumaNodeMem = secondNumaNodeMem;
    }

    public String getSecondNumaNodeCpus() {
        return secondNumaNodeCpus;
    }

    public void setSecondNumaNodeCpus(String secondNumaNodeCpus) {
        this.secondNumaNodeCpus = secondNumaNodeCpus;
    }

    public String getThirdNumaNodeMem() {
        return thirdNumaNodeMem;
    }

    public void setThirdNumaNodeMem(String thirdNumaNodeMem) {
        this.thirdNumaNodeMem = thirdNumaNodeMem;
    }

    public String getThirdNumaNodeCpus() {
        return thirdNumaNodeCpus;
    }

    public void setThirdNumaNodeCpus(String thirdNumaNodeCpus) {
        this.thirdNumaNodeCpus = thirdNumaNodeCpus;
    }

    public String getFourthNumaNodeMem() {
        return fourthNumaNodeMem;
    }

    public void setFourthNumaNodeMem(String fourthNumaNodeMem) {
        this.fourthNumaNodeMem = fourthNumaNodeMem;
    }

    public String getFourthNumaNodeCpus() {
        return fourthNumaNodeCpus;
    }

    public void setFourthNumaNodeCpus(String fourthNumaNodeCpus) {
        this.fourthNumaNodeCpus = fourthNumaNodeCpus;
    }

    public String getFifthNumaNodeMem() {
        return fifthNumaNodeMem;
    }

    public void setFifthNumaNodeMem(String fifthNumaNodeMem) {
        this.fifthNumaNodeMem = fifthNumaNodeMem;
    }

    public String getFifthNumaNodeCpus() {
        return fifthNumaNodeCpus;
    }

    public void setFifthNumaNodeCpus(String fifthNumaNodeCpus) {
        this.fifthNumaNodeCpus = fifthNumaNodeCpus;
    }

    public String getSixthNumaNodeMem() {
        return sixthNumaNodeMem;
    }

    public void setSixthNumaNodeMem(String sixthNumaNodeMem) {
        this.sixthNumaNodeMem = sixthNumaNodeMem;
    }

    public String getSixthNumaNodeCpus() {
        return sixthNumaNodeCpus;
    }

    public void setSixthNumaNodeCpus(String sixthNumaNodeCpus) {
        this.sixthNumaNodeCpus = sixthNumaNodeCpus;
    }

    public String getSeventhNumaNodeMem() {
        return seventhNumaNodeMem;
    }

    public void setSeventhNumaNodeMem(String seventhNumaNodeMem) {
        this.seventhNumaNodeMem = seventhNumaNodeMem;
    }

    public String getSeventhNumaNodeCpus() {
        return seventhNumaNodeCpus;
    }

    public void setSeventhNumaNodeCpus(String seventhNumaNodeCpus) {
        this.seventhNumaNodeCpus = seventhNumaNodeCpus;
    }

    public String getEighthNumaNodeMem() {
        return eighthNumaNodeMem;
    }

    public void setEighthNumaNodeMem(String eighthNumaNodeMem) {
        this.eighthNumaNodeMem = eighthNumaNodeMem;
    }

    public String getEighthNumaNodeCpus() {
        return eighthNumaNodeCpus;
    }

    public void setEighthNumaNodeCpus(String eighthNumaNodeCpus) {
        this.eighthNumaNodeCpus = eighthNumaNodeCpus;
    }

    public String getNinthNumaNodeMem() {
        return ninthNumaNodeMem;
    }

    public void setNinthNumaNodeMem(String ninthNumaNodeMem) {
        this.ninthNumaNodeMem = ninthNumaNodeMem;
    }

    public String getNinthNumaNodeCpus() {
        return ninthNumaNodeCpus;
    }

    public void setNinthNumaNodeCpus(String ninthNumaNodeCpus) {
        this.ninthNumaNodeCpus = ninthNumaNodeCpus;
    }

    public String getTenthNumaNodeMem() {
        return tenthNumaNodeMem;
    }

    public void setTenthNumaNodeMem(String tenthNumaNodeMem) {
        this.tenthNumaNodeMem = tenthNumaNodeMem;
    }

    public String getTenthNumaNodeCpus() {
        return tenthNumaNodeCpus;
    }

    public void setTenthNumaNodeCpus(String tenthNumaNodeCpus) {
        this.tenthNumaNodeCpus = tenthNumaNodeCpus;
    }

    public String getNoFrameOption() {
        return noFrameOption;
    }

    public void setNoFrameOption(String noFrameOption) {
        this.noFrameOption = noFrameOption;
    }

    public String getMemPathOption() {
        return memPathOption;
    }

    public void setMemPathOption(String memPathOption) {
        this.memPathOption = memPathOption;
    }

    public String getMemPreallocOption() {
        return memPreallocOption;
    }

    public void setMemPreallocOption(String memPreallocOption) {
        this.memPreallocOption = memPreallocOption;
    }

    public String getFirstNetworkNICOption() {
        return firstNetworkNICOption;
    }

    public void setFirstNetworkNICOption(String firstNetworkNICOption) {
        this.firstNetworkNICOption = firstNetworkNICOption;
    }

    public String getFirstNetworkExtraOption() {
        return firstNetworkExtraOption;
    }

    public void setFirstNetworkExtraOption(String firstNetworkExtraOption) {
        this.firstNetworkExtraOption = firstNetworkExtraOption;
    }

    public String getFirstNetworkNetdevOption() {
        return firstNetworkNetdevOption;
    }

    public void setFirstNetworkNetdevOption(String firstNetworkNetdevOption) {
        this.firstNetworkNetdevOption = firstNetworkNetdevOption;
    }

    public String getSecondNetworkNICOption() {
        return secondNetworkNICOption;
    }

    public void setSecondNetworkNICOption(String secondNetworkNICOption) {
        this.secondNetworkNICOption = secondNetworkNICOption;
    }

    public String getSecondNetworkExtraOption() {
        return secondNetworkExtraOption;
    }

    public void setSecondNetworkExtraOption(String secondNetworkExtraOption) {
        this.secondNetworkExtraOption = secondNetworkExtraOption;
    }

    public String getSecondNetworkNetdevOption() {
        return secondNetworkNetdevOption;
    }

    public void setSecondNetworkNetdevOption(String secondNetworkNetdevOption) {
        this.secondNetworkNetdevOption = secondNetworkNetdevOption;
    }

    public String getThirdNetworkNICOption() {
        return thirdNetworkNICOption;
    }

    public void setThirdNetworkNICOption(String thirdNetworkNICOption) {
        this.thirdNetworkNICOption = thirdNetworkNICOption;
    }

    public String getThirdNetworkExtraOption() {
        return thirdNetworkExtraOption;
    }

    public void setThirdNetworkExtraOption(String thirdNetworkExtraOption) {
        this.thirdNetworkExtraOption = thirdNetworkExtraOption;
    }

    public String getThirdNetworkNetdevOption() {
        return thirdNetworkNetdevOption;
    }

    public void setThirdNetworkNetdevOption(String thirdNetworkNetdevOption) {
        this.thirdNetworkNetdevOption = thirdNetworkNetdevOption;
    }

    public String getFourthNetworkNICOption() {
        return fourthNetworkNICOption;
    }

    public void setFourthNetworkNICOption(String fourthNetworkNICOption) {
        this.fourthNetworkNICOption = fourthNetworkNICOption;
    }

    public String getFourthNetworkExtraOption() {
        return fourthNetworkExtraOption;
    }

    public void setFourthNetworkExtraOption(String fourthNetworkExtraOption) {
        this.fourthNetworkExtraOption = fourthNetworkExtraOption;
    }

    public String getFourthNetworkNetdevOption() {
        return fourthNetworkNetdevOption;
    }

    public void setFourthNetworkNetdevOption(String fourthNetworkNetdevOption) {
        this.fourthNetworkNetdevOption = fourthNetworkNetdevOption;
    }

    public String getFifthNetworkNICOption() {
        return fifthNetworkNICOption;
    }

    public void setFifthNetworkNICOption(String fifthNetworkNICOption) {
        this.fifthNetworkNICOption = fifthNetworkNICOption;
    }

    public String getFifthNetworkExtraOption() {
        return fifthNetworkExtraOption;
    }

    public void setFifthNetworkExtraOption(String fifthNetworkExtraOption) {
        this.fifthNetworkExtraOption = fifthNetworkExtraOption;
    }

    public String getFifthNetworkNetdevOption() {
        return fifthNetworkNetdevOption;
    }

    public void setFifthNetworkNetdevOption(String fifthNetworkNetdevOption) {
        this.fifthNetworkNetdevOption = fifthNetworkNetdevOption;
    }

    public String getSixthNetworkNICOption() {
        return sixthNetworkNICOption;
    }

    public void setSixthNetworkNICOption(String sixthNetworkNICOption) {
        this.sixthNetworkNICOption = sixthNetworkNICOption;
    }

    public String getSixthNetworkExtraOption() {
        return sixthNetworkExtraOption;
    }

    public void setSixthNetworkExtraOption(String sixthNetworkExtraOption) {
        this.sixthNetworkExtraOption = sixthNetworkExtraOption;
    }

    public String getSixthNetworkNetdevOption() {
        return sixthNetworkNetdevOption;
    }

    public void setSixthNetworkNetdevOption(String sixthNetworkNetdevOption) {
        this.sixthNetworkNetdevOption = sixthNetworkNetdevOption;
    }

    public String getSeventhNetworkNICOption() {
        return seventhNetworkNICOption;
    }

    public void setSeventhNetworkNICOption(String seventhNetworkNICOption) {
        this.seventhNetworkNICOption = seventhNetworkNICOption;
    }

    public String getSeventhNetworkExtraOption() {
        return seventhNetworkExtraOption;
    }

    public void setSeventhNetworkExtraOption(String seventhNetworkExtraOption) {
        this.seventhNetworkExtraOption = seventhNetworkExtraOption;
    }

    public String getSeventhNetworkNetdevOption() {
        return seventhNetworkNetdevOption;
    }

    public void setSeventhNetworkNetdevOption(String seventhNetworkNetdevOption) {
        this.seventhNetworkNetdevOption = seventhNetworkNetdevOption;
    }

    public String getEighthNetworkNICOption() {
        return eighthNetworkNICOption;
    }

    public void setEighthNetworkNICOption(String eighthNetworkNICOption) {
        this.eighthNetworkNICOption = eighthNetworkNICOption;
    }

    public String getEighthNetworkExtraOption() {
        return eighthNetworkExtraOption;
    }

    public void setEighthNetworkExtraOption(String eighthNetworkExtraOption) {
        this.eighthNetworkExtraOption = eighthNetworkExtraOption;
    }

    public String getEighthNetworkNetdevOption() {
        return eighthNetworkNetdevOption;
    }

    public void setEighthNetworkNetdevOption(String eighthNetworkNetdevOption) {
        this.eighthNetworkNetdevOption = eighthNetworkNetdevOption;
    }

    public String getNinthNetworkNICOption() {
        return ninthNetworkNICOption;
    }

    public void setNinthNetworkNICOption(String ninthNetworkNICOption) {
        this.ninthNetworkNICOption = ninthNetworkNICOption;
    }

    public String getNinthNetworkExtraOption() {
        return ninthNetworkExtraOption;
    }

    public void setNinthNetworkExtraOption(String ninthNetworkExtraOption) {
        this.ninthNetworkExtraOption = ninthNetworkExtraOption;
    }

    public String getNinthNetworkNetdevOption() {
        return ninthNetworkNetdevOption;
    }

    public void setNinthNetworkNetdevOption(String ninthNetworkNetdevOption) {
        this.ninthNetworkNetdevOption = ninthNetworkNetdevOption;
    }

    public String getTenthNetworkNICOption() {
        return tenthNetworkNICOption;
    }

    public void setTenthNetworkNICOption(String tenthNetworkNICOption) {
        this.tenthNetworkNICOption = tenthNetworkNICOption;
    }

    public String getTenthNetworkExtraOption() {
        return tenthNetworkExtraOption;
    }

    public void setTenthNetworkExtraOption(String tenthNetworkExtraOption) {
        this.tenthNetworkExtraOption = tenthNetworkExtraOption;
    }

    public String getTenthNetworkNetdevOption() {
        return tenthNetworkNetdevOption;
    }

    public void setTenthNetworkNetdevOption(String tenthNetworkNetdevOption) {
        this.tenthNetworkNetdevOption = tenthNetworkNetdevOption;
    }

    public String getRtcOption() {
        return rtcOption;
    }

    public void setRtcOption(String rtcOption) {
        this.rtcOption = rtcOption;
    }

    public String getNameOption() {
        return nameOption;
    }

    public void setNameOption(String nameOption) {
        this.nameOption = nameOption;
    }

    public String getSnapshotOption() {
        return snapshotOption;
    }

    public void setSnapshotOption(String snapshotOption) {
        this.snapshotOption = snapshotOption;
    }

    public String getNoFdBootchkOption() {
        return noFdBootchkOption;
    }

    public void setNoFdBootchkOption(String noFdBootchkOption) {
        this.noFdBootchkOption = noFdBootchkOption;
    }

    public String getNoHpetOption() {
        return noHpetOption;
    }

    public void setNoHpetOption(String noHpetOption) {
        this.noHpetOption = noHpetOption;
    }

    public String getMtdblockOption() {
        return mtdblockOption;
    }

    public void setMtdblockOption(String mtdblockOption) {
        this.mtdblockOption = mtdblockOption;
    }

    public String getSdOption() {
        return sdOption;
    }

    public void setSdOption(String sdOption) {
        this.sdOption = sdOption;
    }

    public String getPflashOption() {
        return pflashOption;
    }

    public void setPflashOption(String pflashOption) {
        this.pflashOption = pflashOption;
    }

    public String getMonitorOption() {
        return monitorOption;
    }

    public void setMonitorOption(String monitorOption) {
        this.monitorOption = monitorOption;
    }

    public String getQmpOption() {
        return qmpOption;
    }

    public void setQmpOption(String qmpOption) {
        this.qmpOption = qmpOption;
    }

    public String getUsbDriverOption() {
        return usbDriverOption;
    }

    public void setUsbDriverOption(String usbDriverOption) {
        this.usbDriverOption = usbDriverOption;
    }

    public String getUsbMouseOption() {
        return usbMouseOption;
    }

    public void setUsbMouseOption(String usbMouseOption) {
        this.usbMouseOption = usbMouseOption;
    }

    public String getUsbTabletOption() {
        return usbTabletOption;
    }

    public void setUsbTabletOption(String usbTabletOption) {
        this.usbTabletOption = usbTabletOption;
    }

    public String getUsbWacomTabletOption() {
        return usbWacomTabletOption;
    }

    public void setUsbWacomTabletOption(String usbWacomTabletOption) {
        this.usbWacomTabletOption = usbWacomTabletOption;
    }

    public String getUsbKeyboardOption() {
        return usbKeyboardOption;
    }

    public void setUsbKeyboardOption(String usbKeyboardOption) {
        this.usbKeyboardOption = usbKeyboardOption;
    }

    public String getUsbBrailleOption() {
        return usbBrailleOption;
    }

    public void setUsbBrailleOption(String usbBrailleOption) {
        this.usbBrailleOption = usbBrailleOption;
    }

    public String getUsbDiskOption() {
        return usbDiskOption;
    }

    public void setUsbDiskOption(String usbDiskOption) {
        this.usbDiskOption = usbDiskOption;
    }

    public String getUsbSerialOption() {
        return usbSerialOption;
    }

    public void setUsbSerialOption(String usbSerialOption) {
        this.usbSerialOption = usbSerialOption;
    }

    public String getUsbNetOption() {
        return usbNetOption;
    }

    public void setUsbNetOption(String usbNetOption) {
        this.usbNetOption = usbNetOption;
    }

    public String getKernelBootOption() {
        return kernelBootOption;
    }

    public void setKernelBootOption(String kernelBootOption) {
        this.kernelBootOption = kernelBootOption;
    }

    public String getCustomOptions() {
        return customOptions;
    }

    public void setCustomOptions(String customOptions) {
        this.customOptions = customOptions;
    }
}
