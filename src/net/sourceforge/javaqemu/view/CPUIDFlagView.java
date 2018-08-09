package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.sourceforge.javaqemu.control.FileControl;

public class CPUIDFlagView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel jpanel;

    private JList<String> selectedList;

    private JScrollPane selectedListScrollPane;

    private JComboBox<String> availableList;

    private JButton okButton, eraseAllButton, addButton, eraseButton, findButton;

    private GridLayout gridLayout;

    private Boolean loaded;

    public CPUIDFlagView(FileControl myfile) {
        this.jpanel = new JPanel();

        this.setTitle("JavaQemu - CPUID Flags Options");

        this.setContentPane(jpanel);

        gridLayout = new GridLayout(7, 1);

        this.jpanel.setLayout(gridLayout);

        selectedList = new JList<String>();
        selectedList.setVisibleRowCount(2);
        selectedList.setModel(new DefaultListModel<String>());

        selectedListScrollPane = new JScrollPane();
        selectedListScrollPane.setViewportView(selectedList);
        this.jpanel.add(selectedListScrollPane);

        addButton = new JButton("Add the new element below to list above");
        this.jpanel.add(addButton);

        String[] mycpuidflags = {"pbe", "ia64", "tm", "ht", "ss", "sse2",
            "sse", "fxsr", "mmx", "acpi", "ds", "clflush", "pn", "pse36",
            "pat", "cmov", "mca", "pge", "mtrr", "sep", "apic", "cx8",
            "mce", "pae", "msr", "tsc", "pse", "de", "vme", "fpu",
            "hypervisor", "rdrand", "f16c", "avx", "osxsave", "xsave",
            "aes", "tsc-deadline", "popcnt", "movbe", "x2apic", "sse4.2",
            "sse4_2", "sse4.1", "sse4_1", "dca", "pcid", "pdcm", "xtpr",
            "cx16", "fma", "cid", "ssse3", "tm2", "est", "smx", "vmx",
            "ds_cpl", "monitor", "dtes64", "pclmulqdq", "pclmuldq", "pni",
            "sse3", "smap", "adx", "rdseed", "rtm", "invpcid", "erms",
            "bmi2", "smep", "avx2", "hle", "bmi1", "fsgsbase", "3dnow",
            "3dnowext", "lm", "i64", "rdtscp", "pdpe1gb", "fxsr_opt",
            "ffxsr", "mmxext", "nx", "xd", "syscall", "perfctr_nb",
            "perfctr_core", "topoext", "tbm", "nodeid_msr", "tce", "fma4",
            "lwp", "wdt", "skinit", "xop", "ibs", "osvw", "3dnowprefetch",
            "misalignsse", "sse4a", "abm", "cr8legacy", "extapic", "svm",
            "cmp_legacy", "lahf_lm", "pmm-en", "pmm", "phe-en", "phe",
            "ace2-en", "ace2", "xcrypt-en", "xcrypt", "xstore-en",
            "xstore", "kvm_pv_eoi", "kvm_steal_time", "kvm_asyncpf",
            "kvmclock", "kvm_mmu", "kvm_nopiodelay", "kvmclock",
            "pfthreshold", "pause_filter", "decodeassists", "flushbyasid",
            "vmcb_clean", "tsc_scale", "nrip_save", "svm_lock", "lbrv",
            "npt"};

        availableList = new JComboBox<String>(mycpuidflags);
        this.jpanel.add(availableList);

        eraseButton = new JButton("Erase selected element from list above");
        this.jpanel.add(eraseButton);

        eraseAllButton = new JButton("Erase all");
        this.jpanel.add(eraseAllButton);

        findButton = new JButton("Find");
        this.jpanel.add(findButton);

        okButton = new JButton("OK");
        this.jpanel.add(okButton);

        this.loaded = false;

        if (myfile.getMymodel().getCpuidFlags() != null) {
            String[] basis
                    = myfile.getMymodel().getCpuidFlags().split(",");

            DefaultListModel<String> model = (DefaultListModel<String>) this.getSelectedList().getModel();

            for (int i = 0; i
                    < basis.length; i++) {
                if (!basis[i].isEmpty()) {
                    model.addElement(basis[i].substring(1));
                }
            }

            this.loaded = true;
        }

        this.rechecks();
    }

    private void rechecks() {
        this.pack();
        this.repaint();
    }

    public void configureListener(ActionListener listener) {
        addButton.addActionListener(listener);
        eraseButton.addActionListener(listener);
        eraseAllButton.addActionListener(listener);
        okButton.addActionListener(listener);
        findButton.addActionListener(listener);
    }

    public void configureStandardMode() {
        addButton.setActionCommand("addButton");
        eraseButton.setActionCommand("eraseButton2");
        eraseAllButton.setActionCommand("eraseAllButton");
        okButton.setActionCommand("okButton2");
        findButton.setActionCommand("findButton");
    }

    public Boolean getLoaded() {
        return loaded;
    }

    public JList<String> getSelectedList() {
        return selectedList;
    }

    public JComboBox<String> getAvailableList() {
        return availableList;
    }
}
