package ru.job4j.ood.lsp.parking.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.Car;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ParkingServiceTest {

    @Disabled
    @Test
    public void whenParkingServiceTest() {
        ParkingService ParkingService = new ParkingService(10, 6);
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(4);

        List<Car> cars = List.of(car1, car2, car3);
        cars.stream().forEach(c -> ParkingService.park(c));

    }
}