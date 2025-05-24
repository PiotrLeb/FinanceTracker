package me.piotrleb.financetracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import me.piotrleb.financetracker.Main;
import me.piotrleb.financetracker.users.User;
import me.piotrleb.financetracker.utils.UserPasser;


public class RegisterController {
    @FXML
    private TextField textField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField repeatPasswordField;

    private void usernameTaken() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Username is already taken");
        alert.showAndWait();
    }

    private void fillForm(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Please fill all the fields!");
        alert.showAndWait();
    }

    @FXML
    protected void register() throws Exception {
        String username = textField.getText();
        String password = passwordField.getText();
        String repeatPassword = repeatPasswordField.getText();

        if(username.isEmpty() || password.isEmpty()){
            fillForm();
            return;
        }

        if(User.isUsernameExist(username)){
            usernameTaken();
            return;
        }
        if(password.equals(repeatPassword)){
            User.insertUser(username, password);
            User user = new User(username, password);
            UserPasser.setInstance(user);
            Main.setRoot("views/main.fxml");
        }
    }

}
