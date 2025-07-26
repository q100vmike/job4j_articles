package ru.job4j.ood.lsp.foodwarehouse.store;

import ru.job4j.ood.lsp.foodwarehouse.model.Food;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public abstract class AbstractStore implements Store {

    @Override
    public void add(Food food) {

    }

    @Override
    public List<Food> get() {
        return List.of();
    }

    public int freshChecker(Food food) {
        int percent = 0;
        long daysGone = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDateTime.now());
        long daysAll = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        percent = (int) (daysGone * 100 / daysAll);

        return percent;
    }
}
