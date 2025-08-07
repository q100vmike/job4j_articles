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

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void addToStorage(Food food) {
        stores.stream().forEach(s -> s.add(food));
    }

    public void resort() {
        List<Store> reStores = new ArrayList<>();
        for (Store store : stores) {
            reStores.add(store);
        }
        stores = reStores;
    }
}
