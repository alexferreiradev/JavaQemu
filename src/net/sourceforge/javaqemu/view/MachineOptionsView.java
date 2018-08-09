package net.sourceforge.javaqemu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import net.sourceforge.javaqemu.control.FileControl;

public class MachineOptionsView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel jpanel;

    private JButton okButton, eraseButton;

    private GridLayout gridLayout;

    private JLabel accelLabel, temp1, temp2, others;

    private JComboBox<String> firstOption, secondOption, thirdOption;

    private JLabel first, second, third;

    private JLabel kernel_irqchipLabel;

    private JComboBox<String> kernel_irqchip;

    private JLabel kvm_shadow_memLabel;

    private JSpinner kvm_shadow_memSize;

    private SpinnerModel spinnerModel;

    private JSpinner.NumberEditor editor;

    private DecimalFormat format;

    private JLabel dump_guest_coreLabel;

    private JComboBox<String> dump_guest_core;

    private JLabel mem_mergeLabel;

    private JComboBox<String> mem_merge;

    private String[] on_off;

    private Boolean loaded;

    public MachineOptionsView(FileControl myfile) {
        this.jpanel = new JPanel();

        this.gridLayout = new GridLayout(10, 2);

        this.setTitle("JavaQemu - Machine Options");

        this.setContentPane(jpanel);

        this.jpanel.setLayout(gridLayout);

        okButton = new JButton("OK");

        eraseButton = new JButton("Erase");

        String[] accels = {"", "kvm", "xen", "tcg"};

        firstOption = new JComboBox<String>(accels);
        firstOption.setSelectedIndex(0);

        secondOption = new JComboBox<String>(accels);
        secondOption.setSelectedIndex(0);

        thirdOption = new JComboBox<String>(accels);
        thirdOption.setSelectedIndex(0);

        accelLabel = new JLabel("Select the order of the accelerator(s):");
        temp1 = new JLabel("");

        first = new JLabel("First:");
        second = new JLabel("Second");
        third = new JLabel("Third");

        this.jpanel.add(accelLabel);

        this.jpanel.add(temp1);
        this.jpanel.add(first);
        this.jpanel.add(firstOption);
        this.jpanel.add(second);
        this.jpanel.add(secondOption);
        this.jpanel.add(third);
        this.jpanel.add(thirdOption);

        this.temp2 = new JLabel("");
        this.others = new JLabel("Others options:");

        this.jpanel.add(this.others);
        this.jpanel.add(this.temp2);

        on_off = new String[]{"", "on", "off"};
        kernel_irqchipLabel = new JLabel("kernel_irqchip=");
        kernel_irqchip = new JComboBox<String>(on_off);

        kvm_shadow_memLabel = new JLabel("size(kvm_shadow_mem)=");

        this.jpanel.add(this.kernel_irqchipLabel);
        this.jpanel.add(this.kernel_irqchip);
        this.jpanel.add(kvm_shadow_memLabel);

        this.spinnerModel = new SpinnerNumberModel(0.0, // initial value
                0.0, // min
                4096.0, // max
                1); // step

        this.kvm_shadow_memSize = new JSpinner(spinnerModel);

        editor = (JSpinner.NumberEditor) this.kvm_shadow_memSize.getEditor();
        format = editor.getFormat();
        format.setMinimumFractionDigits(3);
        editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);

        this.jpanel.add(kvm_shadow_memSize);

        dump_guest_coreLabel = new JLabel("dump_guest-core=");
        dump_guest_core = new JComboBox<String>(on_off);

        this.jpanel.add(dump_guest_coreLabel);
        this.jpanel.add(dump_guest_core);

        mem_mergeLabel = new JLabel("mem-merge=");
        mem_merge = new JComboBox<String>(on_off);

        this.jpanel.add(mem_mergeLabel);
        this.jpanel.add(mem_merge);
        this.jpanel.add(this.okButton);
        this.jpanel.add(this.eraseButton);

        this.loaded = false;

        if (myfile.getMymodel().getMachineAccel1() != null) {
            this.firstOption.setSelectedItem(myfile.getMymodel().getMachineAccel1());
            this.loaded = true;
        }
        if (myfile.getMymodel().getMachineAccel2() != null) {
            this.secondOption.setSelectedItem(myfile.getMymodel().getMachineAccel2());
            this.loaded = true;
        }
        if (myfile.getMymodel().getMachineAccel3() != null) {
            this.thirdOption.setSelectedItem(myfile.getMymodel().getMachineAccel3());
            this.loaded = true;
        }
        if (myfile.getMymodel().getMachineKernel_irpchip() != null) {
            this.kernel_irqchip.setSelectedItem(myfile.getMymodel().getMachineKernel_irpchip());
            this.loaded = true;
        }
        if (myfile.getMymodel().getMachineKvm_shadow_mem() != null) {
            this.editor.getTextField().setText(myfile.getMymodel().getMachineKvm_shadow_mem());
            this.loaded = true;
        }
        if (myfile.getMymodel().getMachineDump_guest_core() != null) {
            this.dump_guest_core.setSelectedItem(myfile.getMymodel().getMachineDump_guest_core());
            this.loaded = true;
        }
        if (myfile.getMymodel().getMachineMem_merge() != null) {
            this.mem_merge.setSelectedItem(myfile.getMymodel().getMachineMem_merge());
            this.loaded = true;
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
        firstOption.addActionListener(listener);
        secondOption.addActionListener(listener);
        thirdOption.addActionListener(listener);
    }

    public void configureStandardMode() {
        eraseButton.setActionCommand("eraseButton2");
        okButton.setActionCommand("okButton2");
        firstOption.setActionCommand("firstOption");
        secondOption.setActionCommand("secondOption");
        thirdOption.setActionCommand("thirdOption");
    }

    public void resolveAccelOptions() {
        List<String> selectedobjects = new ArrayList<String>();
        String[] accels = {"", "kvm", "xen", "tcg"};
        if (firstOption.getSelectedIndex() != 0) {
            selectedobjects.add((String) firstOption.getSelectedItem());
        }
        if (secondOption.getSelectedIndex() != 0) {
            selectedobjects.add((String) secondOption.getSelectedItem());
        }
        if (thirdOption.getSelectedIndex() != 0) {
            selectedobjects.add((String) thirdOption.getSelectedItem());
        }
        if (firstOption.getSelectedIndex() == 0) {
            firstOption.removeAllItems();
            for (int i = 0; i < accels.length; i++) {
                if (!selectedobjects.contains(accels[i])) {
                    firstOption.addItem(accels[i]);
                }
            }
            firstOption.setSelectedIndex(0);
        }
        if (secondOption.getSelectedIndex() == 0) {
            secondOption.removeAllItems();
            for (int i = 0; i < accels.length; i++) {
                if (!selectedobjects.contains(accels[i])) {
                    secondOption.addItem(accels[i]);
                }
            }
            secondOption.setSelectedIndex(0);
        }
        if (thirdOption.getSelectedIndex() == 0) {
            thirdOption.removeAllItems();
            for (int i = 0; i < accels.length; i++) {
                if (!selectedobjects.contains(accels[i])) {
                    thirdOption.addItem(accels[i]);
                }
            }
            thirdOption.setSelectedIndex(0);
        }
    }

    public JComboBox<String> getFirstOption() {
        return firstOption;
    }

    public JComboBox<String> getSecondOption() {
        return secondOption;
    }

    public JComboBox<String> getThirdOption() {
        return thirdOption;
    }

    public JComboBox<String> getKernel_irqchip() {
        return kernel_irqchip;
    }

    public JComboBox<String> getDump_guest_core() {
        return dump_guest_core;
    }

    public JComboBox<String> getMem_merge() {
        return mem_merge;
    }

    public JSpinner.NumberEditor getEditor() {
        return editor;
    }

    public Boolean getLoaded() {
        return loaded;
    }
}
