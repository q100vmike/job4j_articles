package ru.job4j.ood.lsp.parking.model.parking;

import ru.job4j.ood.lsp.parking.model.car.Car;

import java.util.List;

public interface Parking {

    public void park(Car car);

    public int getPassengerSeats();

    public int getTruckSeats();

    public List<Car> getPassengerList();

    public List<Car> getTruckList();
}
