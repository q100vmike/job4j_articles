package ru.job4j.ood.lsp.foodwarehouse.store;

import ru.job4j.ood.lsp.foodwarehouse.model.Food;

import java.util.List;

public abstract class AbstractStore implements Store {

    @Override
    public void add(Food food) {

    }

    @Override
    public List<Food> get() {
        return List.of();
    }

    @Override
    public void discountPriceTwentyPercent(Food food) {
        food.setPrice(food.getPrice() - (food.getPrice() * 0.2));
    }
}
