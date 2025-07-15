package ru.job4j.ood.lsp.foodwarehouse.warehouse;

import ru.job4j.ood.lsp.foodwarehouse.model.Food;
import ru.job4j.ood.lsp.foodwarehouse.store.AbstractStore;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AbstractStore {

    private List<Food> warehouse;

    public Warehouse() {
        this.warehouse = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        warehouse.add(food);
    }
}
