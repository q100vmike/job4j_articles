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
        shop.add(food);
    }

    @Override
    public List<Food> get() {
        return shop;
    }
}
