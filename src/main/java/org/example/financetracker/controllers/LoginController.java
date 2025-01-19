package org.example.financetracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.financetracker.database.DatabaseConnector;
import org.example.financetracker.users.User;
import org.example.financetracker.utils.PasswordEncrypter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.Statement;

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
    protected void onSubmitButtonClick() throws SQLException, NoSuchAlgorithmException {
        DatabaseConnector dbConnector = new DatabaseConnector();
        if(usernameField.getText().isEmpty() || emailField.getText().isEmpty() || passwordField.getText().isEmpty())
            initializeAlert().showAndWait();

        String username = usernameField.getText();
        String email = emailField.getText();
        String password = PasswordEncrypter.encryptPassword(passwordField.getText());

        User.insertUser(username, password, email);

    }

}