package ru.job4j.ood.lsp.foodwarehouse.service;

import ru.job4j.ood.lsp.foodwarehouse.model.Food;
import ru.job4j.ood.lsp.foodwarehouse.store.Store;
import ru.job4j.ood.lsp.foodwarehouse.warehouse.Shop;
import ru.job4j.ood.lsp.foodwarehouse.warehouse.Warehouse;
import ru.job4j.ood.lsp.foodwarehouse.warehouse.Trash;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ControlQuality {

    private Shop shop;
    private Trash trash;
    private Warehouse warehouse;

    public ControlQuality(Shop shop, Trash trash, Warehouse warehouse) {
        this.shop = shop;
        this.trash = trash;
        this.warehouse = warehouse;
    }

    public void addToStorage(Food food) {
        Store store = getStorage(food);
        store.add(food);
    }

    public static int freshChecker(Food food) {
        int percent = 0;
        long daysGone = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDateTime.now());
        long daysAll = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        percent = (int) (daysGone * 100 / daysAll);

        return percent;
    }

    private Store getStorage(Food food) {
        Store store = null;
        int percent = 0;
        long daysGone = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDateTime.now());
        long daysAll = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        percent = (int) (daysGone * 100 / daysAll);

        if (percent < 25) {
            store = this.warehouse;
        } else if (percent > 25 && percent <= 75) {
            store = this.shop;
        } else if (percent > 75 && percent <= 100) {
            store = this.shop;
            store.discountPriceTwentyPercent(food);
        } else if (percent > 100) {
            store = this.trash;
        }
        return store;
    }
}
