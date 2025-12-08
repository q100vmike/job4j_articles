package ru.job4j.ood.exam;

public class FeeCalculator {
    private boolean clientType = false;
    private double fee = 0.015;

    public FeeCalculator(boolean clientType) {
        this.clientType = clientType;
    }

    public double getFee() {
        return clientType ? 0 : fee;
    }
}
