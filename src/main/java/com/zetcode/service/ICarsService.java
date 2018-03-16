package com.zetcode.service;

import com.zetcode.bean.Car;
import java.util.List;

public interface ICarsService {
    
    public List<Car> findAllCars();
    public Car findCar(Long id);
    public void saveCar(Car car);
}
