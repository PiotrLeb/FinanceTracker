package org.example.financetracker.controllers;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.financetracker.LoginWindow;
import org.example.financetracker.users.Admin;
import java.sql.*;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private CheckBox rememberCheckBox;

    @FXML
    private Button submitButton;

    private String username = null;
    private String password = null;

    public void databaseConnect(){
        String url = "jdbc:https://www.phpmyadmin.net/";
        String user = "root";
        String passcode = "";
        String query = "SELECT username, password, FROM users";
        try (
                Connection connection = DriverManager.getConnection(url, user, passcode);

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                username = resultSet.getString("username");
                password = resultSet.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    private Alert initializeAlert(){
        Alert formAlert = new Alert(Alert.AlertType.ERROR);
        formAlert.setTitle("Error");
        formAlert.setHeaderText("Please fill the form");
        return formAlert;
    }

    @FXML
    protected void onSubmitButtonClickEmpty() {
        if(usernameField.getText().isEmpty() || emailField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            initializeAlert().showAndWait();
        }

    }

    public void onSubmitButtonClickIncorrect() {
        if (!usernameField.getText().equals(username) || !passwordField.getText().equals(password)){
            initializeAlert().showAndWait();
        }
    }

}