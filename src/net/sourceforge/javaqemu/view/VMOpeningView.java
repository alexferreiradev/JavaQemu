package net.sourceforge.javaqemu.view;

public class VMOpeningView {

    private View view;

    private JPanelCreationView mypanel;

    private String chosenMachineName;

    public VMOpeningView(View view, String chosenMachineName) {
        this.mypanel = null;
        this.view = view;
        this.chosenMachineName = chosenMachineName;
    }

    public boolean starts(String diskImagePath, String secondDiskImagePath,
            String thirdDiskImagePath, String fourthDiskImagePath,
            String ramSize) {
        this.mypanel = (JPanelCreationView) this.view
                .makeVMPanel(chosenMachineName);
        if (ramSize != null) {
            if (!ramSize.isEmpty()) {
                this.mypanel.setRamSize(ramSize);
            }
        } else {
            this.mypanel.setRamSize("128");
        }
        this.view.addCreationNewJPanel(mypanel, chosenMachineName);
        return true;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setChosenMachineName(String chosenMachineName) {
        this.chosenMachineName = chosenMachineName;
    }
}
