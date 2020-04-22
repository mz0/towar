package com.zetcode.service;

import com.zetcode.bean.Car;
import java.util.List;

public interface ICarsService {
    
    List<Car> findAllCars();
    Car findCar(Long id);
    void saveCar(Car car);
}
