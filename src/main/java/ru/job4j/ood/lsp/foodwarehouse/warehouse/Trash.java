package ru.job4j.ood.lsp.foodwarehouse.warehouse;

import ru.job4j.ood.lsp.foodwarehouse.model.Food;
import ru.job4j.ood.lsp.foodwarehouse.store.AbstractStore;

import java.util.ArrayList;
import java.util.List;

public class Trash extends AbstractStore {

    private List<Food> trash;

    public Trash() {
        this.trash = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        trash.add(food);
    }
}
