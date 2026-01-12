package ru.job4j.ood.exam;

//commit1
//commit2
//commit3
public class FeeCalculator {

    private boolean clientType = false;
    private double fee = 0;

    public FeeCalculator(boolean clientType) {
        this.clientType = clientType;
        this.fee = clientType ? 0 : 0.015;
    }

    public void setFee(double fee) {
        if (!this.clientType) {
            this.fee = fee;
        }
    }

    public double getFee() {
        return clientType ? 0 : fee;
    }
}
