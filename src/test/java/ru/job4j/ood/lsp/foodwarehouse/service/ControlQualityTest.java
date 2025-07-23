package ru.job4j.ood.lsp.foodwarehouse.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodwarehouse.model.Beer;
import ru.job4j.ood.lsp.foodwarehouse.model.Food;
import ru.job4j.ood.lsp.foodwarehouse.model.Fruit;
import ru.job4j.ood.lsp.foodwarehouse.model.Meat;
import ru.job4j.ood.lsp.foodwarehouse.store.Store;
import ru.job4j.ood.lsp.foodwarehouse.warehouse.Shop;
import ru.job4j.ood.lsp.foodwarehouse.warehouse.Trash;
import ru.job4j.ood.lsp.foodwarehouse.warehouse.Warehouse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class ControlQualityTest {

    @Test
    public void whenControlQualityTest() {

        Beer beer1 = new Beer("Guiness", 200, 5, LocalDateTime.of(2025, 7, 1, 0, 0),
                LocalDateTime.of(2026, 8, 1, 0, 0));

        Beer beer2 = new Beer("Amstel", 100, 10, LocalDateTime.of(2025, 7, 1, 0, 0),
                LocalDateTime.of(2025, 7, 17, 0, 0));

        Beer beer3 = new Beer("Ohota", 80, 50, LocalDateTime.of(2025, 7, 1, 0, 0),
                LocalDateTime.of(2025, 7, 16, 0, 0));

        Meat meat1 = new Meat("Сhicken", 400, 50, LocalDateTime.of(2025, 7, 18, 0, 0),
                LocalDateTime.of(2025, 7, 20, 0, 0));

        Meat meat2 = new Meat("Beef", 1000, 50, LocalDateTime.of(2025, 7, 10, 0, 0),
                LocalDateTime.of(2025, 7, 29, 0, 0));

        Fruit fruit1 = new Fruit("Apple", 120, 50, LocalDateTime.of(2025, 7, 1, 0, 0),
                LocalDateTime.of(2025, 7, 28, 0, 0));
        
        Fruit fruit2 = new Fruit("Orange", 90, 50, LocalDateTime.of(2025, 6, 18, 0, 0),
                LocalDateTime.of(2025, 7, 30, 0, 0));

        List<Food> foodList = List.of(beer1, beer2, beer3, meat1, meat2, fruit1, fruit2);
        List<Food> warehouseExpected = List.of(beer1);
        List<Food> shopExpected = List.of(meat2, fruit1, fruit2);
        List<Food> trashExpected = List.of(beer2, beer3, meat1);

        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();

        ControlQuality quality = new ControlQuality(shop, trash, warehouse);
        foodList.stream().forEach(f -> quality.addToStorage(f));

        List<Food> warehouseActual = warehouse.get();
        List<Food> shopActual = shop.get();
        List<Food> trashActual = trash.get();

        Assertions.assertEquals(warehouseExpected, warehouseActual);
        Assertions.assertEquals(shopExpected, shopActual);
        Assertions.assertEquals(trashExpected, trashActual);
    }

    @Test
    public void whenOnlyWarehouse() {
        LocalDateTime crBeer = LocalDateTime.of(2025, 7, 1, 0, 0);
        LocalDateTime expBeer = LocalDateTime.of(2026, 8, 22, 0, 0);
        Beer beer = new Beer("Guiness", 200, 5, crBeer, expBeer);

        LocalDateTime crMeat = LocalDateTime.of(2025, 7, 1, 0, 0);
        LocalDateTime expMeat = LocalDateTime.of(2026, 8, 1, 0, 0);
        Meat meat = new Meat("Beef", 1000, 50, crMeat,expMeat);

        LocalDateTime crFruit = LocalDateTime.of(2025, 7, 10, 0, 0);
        LocalDateTime expFruit = LocalDateTime.of(2026, 8, 22, 0, 0);
        Fruit fruit = new Fruit("Orange", 90, 50, crFruit, expFruit);

        List<Food> foodList = List.of(beer, meat, fruit);
        List<Food> warehouseExpected = List.of(beer, meat, fruit);

        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();

        ControlQuality quality = new ControlQuality(shop, trash, warehouse);
        foodList.stream().forEach(f -> quality.addToStorage(f));

        List<Food> warehouseActual = warehouse.get();

        Assertions.assertEquals(warehouseExpected, warehouseActual);
    }

    @Test
    public void whenOnlyShop() {
        LocalDateTime crBeer = LocalDateTime.of(2025, 7, 1, 0, 0);
        LocalDateTime expBeer = LocalDateTime.of(2025, 9, 1, 0, 0);
        Beer beer = new Beer("Guiness", 200, 5, crBeer, expBeer);

        LocalDateTime crMeat = LocalDateTime.of(2025, 7, 1, 0, 0);
        LocalDateTime expMeat = LocalDateTime.of(2025, 9, 10, 0, 0);
        Meat meat = new Meat("Beef", 1000, 50, crMeat,expMeat);

        LocalDateTime crFruit = LocalDateTime.of(2025, 5, 1, 0, 0);
        LocalDateTime expFruit = LocalDateTime.of(2025, 12, 1, 0, 0);
        Fruit fruit = new Fruit("Orange", 90, 50, crFruit, expFruit);

        List<Food> foodList = List.of(beer, meat, fruit);
        List<Food> shopExpected = List.of(beer, meat, fruit);

        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();

        ControlQuality quality = new ControlQuality(shop, trash, warehouse);
        foodList.stream().forEach(f -> quality.addToStorage(f));

        List<Food> shopActual = shop.get();

        Assertions.assertEquals(shopExpected, shopActual);
    }

    @Test
    public void whenOnlyTrash() {
        LocalDateTime crBeer = LocalDateTime.of(2024, 7, 1, 0, 0);
        LocalDateTime expBeer = LocalDateTime.of(2025, 9, 1, 0, 0);
        Beer beer = new Beer("Guiness", 200, 5, crBeer, expBeer);

        LocalDateTime crMeat = LocalDateTime.of(2023, 7, 1, 0, 0);
        LocalDateTime expMeat = LocalDateTime.of(2025, 9, 10, 0, 0);
        Meat meat = new Meat("Beef", 1000, 50, crMeat,expMeat);

        LocalDateTime crFruit = LocalDateTime.of(2020, 5, 1, 0, 0);
        LocalDateTime expFruit = LocalDateTime.of(2025, 12, 1, 0, 0);
        Fruit fruit = new Fruit("Orange", 90, 50, crFruit, expFruit);

        List<Food> foodList = List.of(beer, meat, fruit);
        List<Food> trashExpected = List.of(beer, meat, fruit);

        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();

        ControlQuality quality = new ControlQuality(shop, trash, warehouse);
        foodList.stream().forEach(f -> quality.addToStorage(f));

        List<Food> trashActual = shop.get();

        Assertions.assertEquals(trashExpected, trashActual);
    }
    @Test
    public void whenOnlyShopMinusTwentyPercentPrice() {
        LocalDateTime crBeer = LocalDateTime.of(2024, 7, 1, 0, 0);
        LocalDateTime expBeer = LocalDateTime.of(2025, 9, 1, 0, 0);
        Beer beer = new Beer("Guiness", 200, 5, crBeer, expBeer);

        LocalDateTime crMeat = LocalDateTime.of(2023, 7, 1, 0, 0);
        LocalDateTime expMeat = LocalDateTime.of(2025, 9, 10, 0, 0);
        Meat meat = new Meat("Beef", 1000, 50, crMeat,expMeat);

        LocalDateTime crFruit = LocalDateTime.of(2020, 5, 1, 0, 0);
        LocalDateTime expFruit = LocalDateTime.of(2025, 12, 1, 0, 0);
        Fruit fruit = new Fruit("Orange", 120, 50, crFruit, expFruit);

        Beer exp_beer = new Beer("Guiness", 160, 5, crBeer, expBeer);
        Meat exp_meat = new Meat("Beef", 800, 50, crMeat,expMeat);
        Fruit exp_fruit = new Fruit("Orange", 96, 50, crFruit, expFruit);

        List<Food> foodList = List.of(beer, meat, fruit);
        List<Food> trashExpected = List.of(exp_beer, exp_meat, exp_fruit);

        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();

        ControlQuality quality = new ControlQuality(shop, trash, warehouse);
        foodList.stream().forEach(f -> quality.addToStorage(f));

        List<Food> trashActual = shop.get();

        Assertions.assertEquals(trashExpected, trashActual);
    }
}