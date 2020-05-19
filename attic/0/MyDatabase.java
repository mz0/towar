package com.example;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
public class MyDatabase {  
      private  Connection con;  
      public Connection getCon() {  
            return con;  
      }  
      public MyDatabase(String url,String username,String password) {  
            try {  
                  Class.forName("oracle.jdbc.driver.OracleDriver");  
                  this.con = DriverManager.getConnection(url,username,password);  
            } catch (ClassNotFoundException e) {  
                  // TODO Auto-generated catch block  
                  e.printStackTrace();  
            } catch (SQLException e) {  
                  // TODO Auto-generated catch block  
                  e.printStackTrace();  
            }  
      }  
}
