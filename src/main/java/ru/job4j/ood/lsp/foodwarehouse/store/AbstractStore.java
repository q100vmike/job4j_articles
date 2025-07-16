package ru.job4j.ood.lsp.foodwarehouse.store;

import ru.job4j.ood.lsp.foodwarehouse.model.Food;
import ru.job4j.ood.lsp.foodwarehouse.service.ControlQuality;
import ru.job4j.ood.lsp.foodwarehouse.warehouse.Shop;
import ru.job4j.ood.lsp.foodwarehouse.warehouse.Trash;
import ru.job4j.ood.lsp.foodwarehouse.warehouse.Warehouse;

import java.util.List;

public abstract class AbstractStore implements Store {

    @Override
    public void add(Food food) {

    }

    @Override
    public List<Food> get() {
        return List.of();
    }
}
