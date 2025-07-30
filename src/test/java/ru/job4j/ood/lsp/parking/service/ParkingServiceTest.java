package ru.job4j.ood.lsp.parking.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.model.car.Car;
import ru.job4j.ood.lsp.parking.model.PassengerCar;
import ru.job4j.ood.lsp.parking.model.Truck;
import ru.job4j.ood.lsp.parking.model.parking.SupermarketParking;


import java.util.List;


class ParkingServiceTest {

    @Test
    public void whenParkingServiceTest9Pass3Truck() {

        SupermarketParking supermarketParking = new SupermarketParking(10, 9);
        ParkingService ParkingService = new ParkingService(supermarketParking);
        PassengerCar car1 = new PassengerCar(1);
        Truck truck1 = new Truck(2);
        Truck truck2 = new Truck(4);

        List<Car> cars = List.of(car1, truck1, truck2);
        List<Car> expectedPassengerCars = List.of(car1);
        List<Car> expectedTruckCars = List.of(truck1, truck2);
        ParkingService.park(cars);

        int freePassengerSeats = ParkingService.getFreePassengerSeats();
        int freeTruckSeats = ParkingService.getFreeTruckSeats();

        Assertions.assertEquals(9, freePassengerSeats);
        Assertions.assertEquals(3, freeTruckSeats);
        Assertions.assertEquals(expectedPassengerCars, ParkingService.getPassengerList());
        Assertions.assertEquals(expectedTruckCars, ParkingService.getTruckList());
    }

    @Test
    public void whenParkingServiceTest2Pass3Truck() {
        SupermarketParking supermarketParking = new SupermarketParking(9, 7);
        ParkingService ParkingService = new ParkingService(supermarketParking);
        PassengerCar car1 = new PassengerCar(1);
        PassengerCar car2 = new PassengerCar(1);
        PassengerCar car3 = new PassengerCar(1);
        Truck truck1 = new Truck(4);
        Truck truck2 = new Truck(4);

        List<Car> cars = List.of(car1, car2, car3, truck1, truck2);
        List<Car> expectedPassengerCars = List.of(car1, car2, car3, truck2);
        List<Car> expectedTruckCars = List.of(truck1);
        ParkingService.park(cars);

        int freePassengerSeats = ParkingService.getFreePassengerSeats();
        int freeTruckSeats = ParkingService.getFreeTruckSeats();

        Assertions.assertEquals(2, freePassengerSeats);
        Assertions.assertEquals(3, freeTruckSeats);
        Assertions.assertEquals(expectedPassengerCars, ParkingService.getPassengerList());
        Assertions.assertEquals(expectedTruckCars, ParkingService.getTruckList());
    }

    @Test
    public void whenParkingServiceTest0Pass0Truck() {
        SupermarketParking supermarketParking = new SupermarketParking(10, 10);
        ParkingService ParkingService = new ParkingService(supermarketParking);
        Truck truck1 = new Truck(5);
        Truck truck2 = new Truck(5);
        Truck truck3 = new Truck(5);
        Truck truck4 = new Truck(5);

        List<Car> cars = List.of(truck1, truck2, truck3, truck4);
        List<Car> expectedPassengerCars = List.of(truck3, truck4);
        List<Car> expectedTruckCars = List.of(truck1, truck2);
        ParkingService.park(cars);

        int freePassengerSeats = ParkingService.getFreePassengerSeats();
        int freeTruckSeats = ParkingService.getFreeTruckSeats();

        Assertions.assertEquals(0, freePassengerSeats);
        Assertions.assertEquals(0, freeTruckSeats);
        Assertions.assertEquals(expectedPassengerCars, ParkingService.getPassengerList());
        Assertions.assertEquals(expectedTruckCars, ParkingService.getTruckList());
    }
}