package ru.job4j.ood.lsp;

public class MusicalInstruments {

    protected int maxInstruments;

    public MusicalInstruments(int maxInstruments) {
        this.maxInstruments = maxInstruments;
    }

    public void play() {
    }

    public void bowMovements(int count) {
    }

    public void numberOfKeys(int keys) {
        if (keys < 0 || keys > 150) {
            throw new IllegalArgumentException("Invalid music instrument");
        }
    }
}
