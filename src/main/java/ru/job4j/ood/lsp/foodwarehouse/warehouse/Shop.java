package ru.job4j.ood.lsp.foodwarehouse.warehouse;

import ru.job4j.ood.lsp.foodwarehouse.store.AbstractStore;
import ru.job4j.ood.lsp.foodwarehouse.model.Food;
import ru.job4j.ood.lsp.foodwarehouse.store.Store;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {

    private List<Food> shop;

    public Shop() {
        this.shop = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        int percent = freshChecker(food);
        if (percent > 25 && percent <= 100) {
            if (percent > 75) {
                food.discountPriceTwentyPercent();
            }
            shop.add(food);
        }
    }

    @Override
    public List<Food> get() {
        return shop;
    }

    @Override
    public int freshChecker(Food food) {
        return super.freshChecker(food);
    }
}
