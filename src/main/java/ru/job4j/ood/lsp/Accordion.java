package ru.job4j.ood.lsp;

public class Accordion extends MusicalInstruments {

    public Accordion(int maxInstruments) {
        super(maxInstruments);
    }

    @Override
    public void numberOfKeys(int keys) {
        if (keys < 0 || keys > 100) {
            throw new IllegalArgumentException("Invalid Accordion");
        }
    }
}
