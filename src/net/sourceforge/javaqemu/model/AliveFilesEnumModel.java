package net.sourceforge.javaqemu.model;

public enum AliveFilesEnumModel {
    STDOUT(0), STDERR(1), OUT(2), ERR(3);

    private final int valor;

    AliveFilesEnumModel(int valorOpcao) {
        valor = valorOpcao;
    }

    public int getValor() {
        return valor;
    }
}
