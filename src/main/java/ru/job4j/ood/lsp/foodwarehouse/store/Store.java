package ru.job4j.ood.lsp.foodwarehouse.store;

import ru.job4j.ood.lsp.foodwarehouse.model.Food;

import java.util.List;

public interface Store {

    public void add(Food food);

    public List<Food> get();

}
