package ru.job4j.ood.lsp.parking.service;

import ru.job4j.ood.lsp.parking.model.car.Car;
import ru.job4j.ood.lsp.parking.model.parking.Parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingService {

    private Parking parking;

    public ParkingService(Parking parking) {
        this.parking = parking;
    }

    public int getFreePassengerSeats() {
        return parking.getPassengerSeats();
    }

    public int getFreeTruckSeats() {
        return parking.getTruckSeats();
    }

    public void park(List<Car> cars) {
        cars.stream().forEach(c -> parking.park(c));
    }

    public List<Car> getPassengerList() {
        return parking.getPassengerList();
    }

    public List<Car> getTruckList() {
        return parking.getTruckList();
    }
}
