package net.sourceforge.javaqemu.model;

public enum LastUsedFolderEnumModel {
    OPENEXISTINGVM("OpenExistingVM"), SAVEEXISTINGVM("SaveExistingVM"),
    OPENEXISTINGJAVAQEMUCONFIGURATION("OpenExistingJavaQemuConfiguration"),
    SAVEEXISTINGJAVAQEMUCONFIGURATION("SaveExistingJavaQemuConfiguration"),
    SETDEFAULTVMDIRECTORY("SetDefaultVMDirectory"),
    SETQEMUEXECUTABLEDIRECTORY("SetQemuExecutableDirectory"),
    SETQEMUIMGEXECUTABLEDIRECTORY("SetQemuImgExecutableDirectory"),
    SETLOPTIONDIRECTORY("SetLOptionDirectory");

    private final String valor;

    LastUsedFolderEnumModel(String valorOpcao) {
        valor = valorOpcao;
    }

    public String getValor() {
        return valor;
    }
}
