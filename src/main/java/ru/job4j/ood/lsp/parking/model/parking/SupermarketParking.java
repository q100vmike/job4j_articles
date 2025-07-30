package ru.job4j.ood.lsp.parking.model.parking;

import ru.job4j.ood.lsp.parking.model.car.Car;

import java.util.ArrayList;
import java.util.List;

public class SupermarketParking implements Parking {

    private int passengerLimit;
    private int truckLimit;
    private List<Car> passengerCars;
    private List<Car> truckCars;

    public SupermarketParking(int passengerLimit, int truckLimit) {
        this.passengerCars = new ArrayList<>();
        this.passengerLimit = passengerLimit;
        this.truckCars = new ArrayList<>();
        this.truckLimit = truckLimit;
    }

    @Override
    public void park(Car car) {
        int carLength = car.getLength();

        if (carLength == 1 && passengerLimit > 0) {
            passengerCars.add(car);
            passengerLimit--;
        }
        if (carLength > 1) {
            if (truckLimit >= carLength) {
                truckCars.add(car);
                truckLimit -= carLength;
            } else {
                if (passengerLimit >= carLength) {
                    passengerCars.add(car);
                    passengerLimit -= carLength;
                }
            }
        }

    }

    @Override
    public int getPassengerSeats() {
        return passengerLimit;
    }

    @Override
    public int getTruckSeats() {
        return truckLimit;
    }

    @Override
    public List<Car> getPassengerList() {
        return passengerCars;
    }

    @Override
    public List<Car> getTruckList() {
        return truckCars;
    }
}
