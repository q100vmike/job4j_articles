package ru.job4j.ood.lsp.foodwarehouse.model;

import java.time.LocalDateTime;

public class Fruit extends Food {

    public Fruit(String name, double price, int discount, LocalDateTime createDate, LocalDateTime expiryDate) {
        super(name, price, discount, createDate, expiryDate);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public int getDiscount() {
        return super.getDiscount();
    }

    @Override
    public void setDiscount(int discount) {
        super.setDiscount(discount);
    }

    @Override
    public LocalDateTime getCreateDate() {
        return super.getCreateDate();
    }

    @Override
    public void setCreateDate(LocalDateTime createDate) {
        super.setCreateDate(createDate);
    }

    @Override
    public LocalDateTime getExpiryDate() {
        return super.getExpiryDate();
    }

    @Override
    public void setExpiryDate(LocalDateTime expiryDate) {
        super.setExpiryDate(expiryDate);
    }

    public void discountPriceTwentyPercent() {
        setPrice(getPrice() - (getPrice() * 0.2));
    }
}
