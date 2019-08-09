package com.visa.prj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static String DRIVER = DbConfig.getString("DRIVER"); //$NON-NLS-1$
    private static String URL = DbConfig.getString("URL"); //$NON-NLS-1$
    private static String USER  = DbConfig.getString("USER"); //$NON-NLS-1$
    private static String PWD = DbConfig.getString("PWD"); //$NON-NLS-1$
    
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PWD);
    }
    
    public static void closeConnection(Connection con) {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
