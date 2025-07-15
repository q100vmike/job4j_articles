package ru.job4j.ood.lsp.foodwarehouse.model;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Food {

    private String name;

    private double price;

    private int discount;

    private LocalDateTime createDate;

    private LocalDateTime expiryDate;

    public Food(String name, double price, int discount, LocalDateTime createDate, LocalDateTime expiryDate) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Double.compare(price, food.price) == 0 && discount == food.discount && Objects.equals(name, food.name) && Objects.equals(createDate, food.createDate) && Objects.equals(expiryDate, food.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, discount, createDate, expiryDate);
    }
}
