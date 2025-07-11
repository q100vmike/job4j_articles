package ru.job4j.ood.lsp;

public class Guitar extends MusicalInstruments {

    public Guitar(int maxInstruments) {
        super(maxInstruments);
    }

    @Override
    public void bowMovements(int count) {
        throw new UnsupportedOperationException("Guitar not supported bow movements");
    }

    public void resetInstruments() {
        maxInstruments = 0;
    }
}
