package org.example.financetracker.users;

import javafx.scene.control.Alert;
import org.example.financetracker.database.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {

    protected String username;
    protected String password;

    /**
     *
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @param username
     * @param password
     */
    public static void insertUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?,?)";
        try (Connection connection = DatabaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Error");
            } else {
                System.out.println("Number of rows inserted"+ rowsAffected);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("There was an error saving the user data. Please try again.");
            alert.showAndWait();
        }
    }

    /**
     *
     * @param username
     * @return
     * @throws SQLException
     */
    public static boolean isUsernameExist(String username) throws SQLException {
        Connection connection = DatabaseConnector.getConnection();
        String query = "select * from users where username = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.executeQuery();

        while (preparedStatement.getResultSet().next()) {
            if (preparedStatement.getResultSet().getString("username").equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public static boolean isUserExist(String username, String password) throws SQLException {

        Connection connection = DatabaseConnector.getConnection();
            boolean userExists = false;
            String query = "select * from users where username = ? and password = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeQuery();

            while (preparedStatement.getResultSet().next()) {
                if (preparedStatement.getResultSet().getString("username").equals(username) && preparedStatement.getResultSet().getString("password").equals(password)){
                    userExists = true;
                    break;
                }
            }
            return userExists;

    }
}
