package org.example.financetracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.SQLException;

import org.example.financetracker.users.User;
import org.example.financetracker.utils.PasswordEncrypter;

public class LoginController {
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    public TextField registerUsernameField;
    @FXML
    public PasswordField registerPasswordField;
    @FXML
    public PasswordField repeatPasswordField;

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

    private Alert userExistsAlert(){
        Alert userExistsAlert = new Alert(Alert.AlertType.ERROR);
        userExistsAlert.setTitle("Error");
        userExistsAlert.setHeaderText("User already exists");
        return userExistsAlert;
    }

    private Alert passwordNotMatchAlert(){
        Alert wrongRepeatedPasswordAlert = new Alert(Alert.AlertType.ERROR);
        wrongRepeatedPasswordAlert.setTitle("Error");
        wrongRepeatedPasswordAlert.setHeaderText("Passwords do not match");
        return wrongRepeatedPasswordAlert;
    }

    private Alert invalidLoginAlert(){
        Alert invalidLoginAlert = new Alert(Alert.AlertType.ERROR);
        invalidLoginAlert.setTitle("Error");
        invalidLoginAlert.setHeaderText("Invalid username or password");
        return invalidLoginAlert;
    }

    @FXML
    protected void onLoginButtonClick() throws SQLException {
        String username = usernameField.getText();
        String encryptedPassword = PasswordEncrypter.encryptPassword(passwordField.getText());
        if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            fillFormAlert().showAndWait();
            return;
        }
        if (User.isUserExist(username, encryptedPassword)) {
            System.out.println("Logged in");
            // MAIN WINDOW
        } else {
            invalidLoginAlert().showAndWait();
        }

    }

    @FXML
    protected void onRegisterButtonClick() {
        String username = registerUsernameField.getText();
        String encryptedPassword = PasswordEncrypter.encryptPassword(registerPasswordField.getText());
        if(registerUsernameField.getText().isEmpty() || registerPasswordField.getText().isEmpty() || repeatPasswordField.getText().isEmpty()){
            fillFormAlert().showAndWait();
            return;
        }

        if (!registerPasswordField.getText().equals(repeatPasswordField.getText())){
            passwordNotMatchAlert().showAndWait();
            return;
        }

        try {
            if (User.isUsernameExist(username)) {
                userExistsAlert().showAndWait();
                return;
            }
            User.insertUser(username, encryptedPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}