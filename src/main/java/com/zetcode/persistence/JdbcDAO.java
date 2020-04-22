package com.zetcode.persistence;

import com.zetcode.bean.Car;
import com.zetcode.util.DBUtils;
import com.zetcode.util.ServiceLocator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import java.sql.SQLException;
import javax.sql.DataSource;

public class JdbcDAO implements CarDAO {
    Logger logger = Logger.getLogger("AppPersistence");

    private static final String DB1 = "java:comp/env/jdbc/cardata";
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pst;

    @Override
    public void saveCar(Car car) {
        execute(() -> {
            DataSource ds = ServiceLocator.getDataSource(DB1);
            con = ds.getConnection();
            pst = con.prepareStatement("INSERT INTO CARS(Name, Price) VALUES(?, ?)");
            pst.setString(1, car.getName());
            pst.setInt(2, car.getPrice());
            pst.executeUpdate();
        });
    }

    @Override
    public Car findCar(Long id) {
        Car car = new Car();
        execute(() -> {
            logger.log(Level.INFO, "111111111111111111111111111111111111111111111111111111");
            DataSource ds = ServiceLocator.getDataSource(DB1);
            logger.log(Level.INFO, "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
            con = ds.getConnection();
            
            pst = con.prepareStatement("SELECT * FROM CARS WHERE ID = (?)");
            pst.setLong(1, id);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                car.setId(rs.getLong(1));
                car.setName(rs.getString(2));
                car.setPrice(rs.getInt(3));
            }
        });
        return car;
    }

    @Override
    public List<Car> findAll() {
        List<Car> carList = new ArrayList<>();
        execute(() -> {
            DataSource ds = ServiceLocator.getDataSource(DB1);
            con = ds.getConnection();
            pst = con.prepareStatement("SELECT * FROM CARS");
            rs = pst.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getLong(1));
                car.setName(rs.getString(2));
                car.setPrice(rs.getInt(3));
                carList.add(car);
            }
        });
        return carList;
    }

    private void execute(Executable executable) {
        try {
            executable.exec();
        } catch (NamingException | SQLException e) {
            logger.log(Level.SEVERE, e.toString());
        } finally {
            DBUtils.closeResultSet(rs);
            DBUtils.closeStatement(pst);
            DBUtils.closeConnection(con);
        }
    }
}
