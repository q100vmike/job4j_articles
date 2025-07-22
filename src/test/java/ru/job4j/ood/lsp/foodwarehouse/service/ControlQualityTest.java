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
                LocalDateTime.of(2025, 7, 22, 0, 0));

        Fruit fruit1 = new Fruit("Apple", 120, 50, LocalDateTime.of(2025, 7, 1, 0, 0),
                LocalDateTime.of(2025, 7, 25, 0, 0));
        
        Fruit fruit2 = new Fruit("Orange", 90, 50, LocalDateTime.of(2025, 6, 18, 0, 0),
                LocalDateTime.of(2025, 7, 21, 0, 0));

        List<Food> foodList = List.of(beer1, beer2, beer3, meat1, meat2, fruit1, fruit2);
        List<Food> warehouseExpected = List.of(beer1);
        List<Food> shopExpected = List.of(meat2, fruit1, fruit2);
        List<Food> trashExpected = List.of(beer2, beer3, meat1);

        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();

        int percent1 = ControlQuality.freshChecker(meat2);
        int percent2 = ControlQuality.freshChecker(fruit1);
        int percent3 = ControlQuality.freshChecker(fruit2);


/*

Guiness 01.07.25 01.08.26 wh
Amstel  01.07.25 17.07.25 trash
Ohota   01.07.25 16.07.25 trash
Сhicken 18.07.25 20.07.25 trash
meat2 Beef    10.07.25 22.07.25 shop -20
fruit1 Apple   11.07.01 23.07.25 shop -20
fruit2 Orange  18.06.25 25.09.25 shop -20

        3.1. Если срок годности израсходован меньше чем на 25%, продукт должен оказаться в Warehouse;

        3.2. Если срок годности израсходован от 25% до 75%, продукт должен оказаться в Shop;

        3.3. Если срок годности израсходован более, чем на 75%, то продукт должен оказаться в Shop и его
        цена должна быть снижена на размер скидки в 20 % от первоначальной цены.

        3.4. Если срок годности вышел (израсходован полностью) , продукт должен оказаться в Trash.
*/

        ControlQuality quality = new ControlQuality(shop, trash, warehouse);
        foodList.stream().forEach(f -> quality.addToStorage(f));

        List<Food> warehouseActual = warehouse.get();
        List<Food> shopActual = shop.get();
        List<Food> trashActual = trash.get();

        Assertions.assertEquals(warehouseExpected, warehouseActual);
        Assertions.assertEquals(shopExpected, shopActual);
        Assertions.assertEquals(trashExpected, trashActual);
    }
}