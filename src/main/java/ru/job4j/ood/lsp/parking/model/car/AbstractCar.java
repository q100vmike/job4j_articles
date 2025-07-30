package ru.job4j.ood.lsp.parking.model.car;

public abstract class AbstractCar implements Car {
    private int length;

    public AbstractCar(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
