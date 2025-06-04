package ru.job4j.ood.srp;

import java.util.List;

public class CarMarket {

    public List<Car> cars;

    public void addCar() {
        Car car = new Car();
        cars.add(car);
    }
}
