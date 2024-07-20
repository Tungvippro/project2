package org.example;

import java.sql.*;

public class ConnectDB {
    private static final String url = "jdbc:mysql://localhost:3306/doanki2";
    private static final String username = "root";
    private static final String password = "";
public static Connection conn;
    public static Connection getConnection() throws SQLException {
        return  conn = DriverManager.getConnection(url, username, password);

    }

}
