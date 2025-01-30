package org.example.financetracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.financetracker.users.User;
import org.example.financetracker.utils.PasswordEncrypter;


public class LoginController {
    @FXML
    public TextField registerUsernameField;

    @FXML
    public PasswordField registerPasswordField;

    @FXML
    public PasswordField repeatPasswordField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    /**
     *
     * @return
     */
    private Alert fillFormAlert(){
        Alert formAlert = new Alert(Alert.AlertType.ERROR);
        formAlert.setTitle("Error");
        formAlert.setHeaderText("Please fill the form");
        return formAlert;
    }

    @FXML
    protected void onLoginButtonClick() {
        if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty())
            fillFormAlert().showAndWait();
        // checker
    }

    @FXML
    protected void onRegisterButtonClick() {
        if(registerUsernameField.getText().isEmpty() || registerPasswordField.getText().isEmpty() || repeatPasswordField.getText().isEmpty())
            fillFormAlert().showAndWait();

        String username = usernameField.getText();
        String password = PasswordEncrypter.encryptPassword(passwordField.getText());

        User.insertUser(username, password);
    }

}