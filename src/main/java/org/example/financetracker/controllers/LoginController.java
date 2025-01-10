package org.example.financetracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

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
    protected void onSubmitButtonClick() {
        initializeAlert();
        if(usernameField.getText().isEmpty() || emailField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            initializeAlert().showAndWait();
        }
    }
}