package me.piotrleb.financetracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import me.piotrleb.financetracker.Main;
import me.piotrleb.financetracker.users.User;
import me.piotrleb.financetracker.utils.UserPasser;

public class LoginController {

    @FXML
    public Label loginLabel;
    @FXML
    private TextField textField;
    @FXML
    private PasswordField passwordField;

    private Alert fillForm(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Please fill all the fields:");
        alert.showAndWait();
        return alert;
    }

    private Alert invalidData(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Invalid username or password");
        alert.showAndWait();
        return alert;
    }

    @FXML
    protected void signIn() throws Exception {
        String username = textField.getText();
        String password = passwordField.getText();

        if(username.isEmpty() || password.isEmpty()){
            fillForm();
            return;
        }
        if(!User.isUserExist(username, password)){
            invalidData();
            return;
        }

        User user = new User(username, password);
        UserPasser.setInstance(user);
        Main.setRoot("views/main.fxml");
    }

}