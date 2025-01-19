package org.example.financetracker.database;

import java.sql.*;

public class DatabaseConnector {
    private static Connection connection;
    private static final String url = "jdbc:mysql://localhost:3306/financedb";
    private static final String user = "root";
    private static final String password = "";

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed())
            connection.close();
    }
}
