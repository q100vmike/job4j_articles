package ru.job4j.ood.exam;

public class Account {
    protected String id;
    protected double balance;
    private boolean vip = false;

    public Account(String id, double balance, boolean vip) {
        this.id = id;
        this.balance = balance;
        this.vip = vip;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isVip() {
        return vip;
    }
}
