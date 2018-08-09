package net.sourceforge.javaqemu.model;

public enum LastUsedFileEnumModel {
    SETQEMUEXECUTABLEFILE("SetQemuExecutableFile"),
    LOADJAVAQEMUCONFIGURATIONFILE("LoadJavaQemuConfigurationFile"),
    SETQEMUIMGEXECUTABLEFILE("SetQemuImgExecutableFile");

    private final String valor;

    LastUsedFileEnumModel(String valorOpcao) {
        this.valor = valorOpcao;
    }

    public String getValor() {
        return valor;
    }
}
