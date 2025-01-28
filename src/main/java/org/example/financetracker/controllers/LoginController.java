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
    protected void onSubmitButtonClickCheck() {
        onSubmitButtonClickEmpty();
        onSubmitButtonClickIncorrect();
    }

    @FXML
    private void onSubmitButtonClickEmpty() {
        if(usernameField.getText().isEmpty() || emailField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            initializeAlert().showAndWait();
        }
    }
    
    @FXML
    private void onSubmitButtonClickIncorrect() {
        if (!usernameField.getText().equals(username) || !passwordField.getText().equals(password)){
            initializeAlert().showAndWait();
        }
    }
}