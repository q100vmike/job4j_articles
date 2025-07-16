package ru.job4j.ood.lsp.foodwarehouse.service;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodwarehouse.model.Beer;
import ru.job4j.ood.lsp.foodwarehouse.model.Food;
import ru.job4j.ood.lsp.foodwarehouse.store.Store;
import ru.job4j.ood.lsp.foodwarehouse.warehouse.Shop;
import ru.job4j.ood.lsp.foodwarehouse.warehouse.Trash;
import ru.job4j.ood.lsp.foodwarehouse.warehouse.Warehouse;

import java.time.LocalDateTime;
import java.util.List;

class ControlQualityTest {

    @Test
    public void whenControlQualityTest() {
        Beer beer1 = new Beer("Guiness", 200, 5, LocalDateTime.of(2025, 7, 1, 0, 0),
                LocalDateTime.of(2025, 8, 1, 0, 0));
        Beer beer2 = new Beer("Amstel", 100, 10, LocalDateTime.of(2025, 7, 1, 0, 0),
                LocalDateTime.of(2025, 8, 15, 0, 0));
        Beer beer3 = new Beer("Ohota", 80, 50, LocalDateTime.of(2025, 7, 1, 0, 0),
                LocalDateTime.of(2025, 7, 17, 0, 0));

        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();

        int percent1 = ControlQuality.freshChecker(beer1);
        int percent2 = ControlQuality.freshChecker(beer2);
        int percent3 = ControlQuality.freshChecker(beer3);


/*
        3.1. Если срок годности израсходован меньше чем на 25%, продукт должен оказаться в Warehouse;

        3.2. Если срок годности израсходован от 25% до 75%, продукт должен оказаться в Shop;

        3.3. Если срок годности израсходован более, чем на 75%, то продукт должен оказаться в Shop и его
        цена должна быть снижена на размер скидки в 20 % от первоначальной цены.

        3.4. Если срок годности вышел (израсходован полностью) , продукт должен оказаться в Trash.
*/

        ControlQuality quality = new ControlQuality(new Shop(), new Trash(), new Warehouse());
        quality.addToStorage(beer1);
        quality.addToStorage(beer2);
        quality.addToStorage(beer3);

        List<Food> warehouseList = warehouse.get();
        List<Food> shopList = shop.get();
        List<Food> trashList = trash.get();

    }
}