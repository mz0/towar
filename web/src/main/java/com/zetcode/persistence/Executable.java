package com.zetcode.persistence;

import java.sql.SQLException;
import javax.naming.NamingException;


public interface Executable {
    
    void exec() throws SQLException, NamingException;
}
