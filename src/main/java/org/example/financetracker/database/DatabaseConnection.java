package org.example.financetracker.database;

import java.sql.*;

public class DatabaseConnection {
    public static void connection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/financedb";
        String user = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url,user,password);
    }
}
