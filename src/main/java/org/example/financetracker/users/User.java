package org.example.financetracker.users;

import javafx.scene.control.Alert;
import org.example.financetracker.database.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {

    protected String username;
    protected String password;
    protected String email;

    /**
     *
     * @param username
     * @param password
     * @param email
     */
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public static void insertUser(String username, String password, String email) {
        String sql = "INSERT INTO users (username, email, password) VALUES (?,?,?)";
        try (Connection connection = DatabaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("No rows affected");
            } else {
                System.out.println("Number of rows inserted"+ rowsAffected);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally, show a user-friendly error alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("There was an error saving the user data. Please try again.");
            alert.showAndWait();
        }
    }

}
