package com.zetcode.persistence;

import com.zetcode.bean.Car;
import java.util.List;

public interface CarDAO {

  void saveCar(Car car);
  Car findCar(Long id);
  List<Car> findAll();
}
