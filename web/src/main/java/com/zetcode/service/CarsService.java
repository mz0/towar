package com.zetcode.service;

import com.zetcode.bean.Car;
import com.zetcode.persistence.CarDAO;
import com.zetcode.persistence.JdbcDAO;
import java.util.List;

public class CarsService implements ICarsService {

    @Override
    public List<Car> findAllCars() {
        CarDAO carDAO = new JdbcDAO();
        return carDAO.findAll();
    }

    @Override
    public Car findCar(Long id) {
        CarDAO carDAO = new JdbcDAO();
        return carDAO.findCar(id);
    }

    @Override
    public void saveCar(Car car) {
        CarDAO carDAO = new JdbcDAO();
        carDAO.saveCar(car);
    }
}
