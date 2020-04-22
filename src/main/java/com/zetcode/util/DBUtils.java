package com.zetcode.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtils {

    private static final Logger logger = Logger.getLogger("AppPersistence");

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                logger.log(Level.INFO, "Could not close JDBC ResultSet", ex);
            } catch (Throwable ex) {
                logger.log(Level.INFO, "Unexpected exception on closing JDBC ResultSet", ex);
            }
        }
    }

    public static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                logger.log(Level.INFO, "Could not close JDBC Statement", ex);
            } catch (Throwable ex) {
                logger.log(Level.INFO, "Unexpected exception on closing JDBC Statement", ex);
            }
        }
    }    

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                logger.log(Level.INFO, "Could not close JDBC Connection", ex);
            } catch (Throwable ex) {
                logger.log(Level.INFO, "Unexpected exception on closing JDBC Connection", ex);
            }
        }
    }
}
