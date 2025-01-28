package org.example.financetracker.database;

import java.sql.*;

public class DatabaseConnection {

    public String url = "jdbc:mysql://localhost:3306/financedb";
    public String user = "root";
    public String passcode = "";

    public String result = "";

    public void databaseAskQuery(String query) throws SQLException  {

        Connection connection = DriverManager.getConnection(url, user, passcode);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        result = String.valueOf(resultSet);

    }
}
