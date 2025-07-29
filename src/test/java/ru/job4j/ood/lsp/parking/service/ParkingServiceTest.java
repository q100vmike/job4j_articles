package ru.job4j.ood.lsp.parking.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.Car;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ParkingServiceTest {

    @Disabled
    @Test
    public void whenParkingServiceTest9Pass0Truck() {
        ParkingService ParkingService = new ParkingService(10, 6);
        PassengerCar car1 = new PassengerCar(1);
        Truck car2 = new Truck(2);
        Truck car3 = new Truck(4);

        List<Car> cars = List.of(car1, car2, car3);
        cars.stream().forEach(c -> ParkingService.park(c));

        int freePassengerSeats = ParkingService.getFreePassengerSeats();
        int freeTruckSeats = ParkingService.getFreeTruckSeats();

        Assertions.assertEquals(9, freePassengerSeats);
        Assertions.assertEquals(0, freeTruckSeats);
    }

    @Disabled
    @Test
    public void whenParkingServiceTest3Pass2Truck() {
        ParkingService ParkingService = new ParkingService(10, 6);
        PassengerCar car1 = new PassengerCar(1);
        PassengerCar car2 = new PassengerCar(1);
        Truck car3 = new Truck(1);
        Truck car4 = new Truck(4);
        Truck car5 = new Truck(4);

        List<Car> cars = List.of(car1, car2, car3, car4, car5);
        cars.stream().forEach(c -> ParkingService.park(c));

        int freePassengerSeats = ParkingService.getFreePassengerSeats();
        int freeTruckSeats = ParkingService.getFreeTruckSeats();

        Assertions.assertEquals(3, freePassengerSeats);
        Assertions.assertEquals(2, freeTruckSeats);
    }
    @Disabled
    @Test
    public void whenParkingServiceTest0Pass0Truck() {
        ParkingService ParkingService = new ParkingService(10, 10);
        Truck car1 = new Truck(5);
        Truck car2 = new Truck(5);
        Truck car3 = new Truck(5);
        Truck car4 = new Truck(5);

        List<Car> cars = List.of(car1, car2, car3, car4);
        cars.stream().forEach(c -> ParkingService.park(c));

        int freePassengerSeats = ParkingService.getFreePassengerSeats();
        int freeTruckSeats = ParkingService.getFreeTruckSeats();

        Assertions.assertEquals(0, freePassengerSeats);
        Assertions.assertEquals(0, freeTruckSeats);
    }
}