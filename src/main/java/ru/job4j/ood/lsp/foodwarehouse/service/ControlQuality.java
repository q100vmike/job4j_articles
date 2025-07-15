package ru.job4j.ood.lsp.foodwarehouse.service;

import ru.job4j.ood.lsp.foodwarehouse.model.Food;
import ru.job4j.ood.lsp.foodwarehouse.store.Store;

public class ControlQuality {

    public ControlQuality(Store store, Food food) {
        store.add(food);
    }
}
