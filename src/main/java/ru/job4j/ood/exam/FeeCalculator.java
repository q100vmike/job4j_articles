package ru.job4j.ood.exam;

public class FeeCalculator {
    private boolean clientType = false;
    private double fee = 0;

    public FeeCalculator(boolean clientType) {
        this.clientType = clientType;
        this.fee = 0.015;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getFee() {
        return clientType ? 0 : fee;
    }
}
