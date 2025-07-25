package ru.job4j.ood.lsp.foodwarehouse.service;

import ru.job4j.ood.lsp.foodwarehouse.model.Food;
import ru.job4j.ood.lsp.foodwarehouse.store.Store;
import ru.job4j.ood.lsp.foodwarehouse.warehouse.Shop;
import ru.job4j.ood.lsp.foodwarehouse.warehouse.Warehouse;
import ru.job4j.ood.lsp.foodwarehouse.warehouse.Trash;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    List<Store> stores = new ArrayList<>();

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public int freshChecker(Food food) {
        int percent = 0;
        long daysGone = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDateTime.now());
        long daysAll = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        percent = (int) (daysGone * 100 / daysAll);

        return percent;
    }

    public void addToStorage(Food food) {
        int percent = 0;
        long daysGone = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDateTime.now());
        long daysAll = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        percent = (int) (daysGone * 100 / daysAll);

        if (percent < 25) {
            stores.get(0).add(food);
        } else if (percent > 25 && percent <= 75) {
            stores.get(1).add(food);
        } else if (percent > 75 && percent <= 100) {
            food.discountPriceTwentyPercent();
            stores.get(1).add(food);
        } else if (percent > 100) {
            stores.get(2).add(food);
        }
    }
}
