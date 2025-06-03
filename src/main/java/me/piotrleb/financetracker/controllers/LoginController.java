package me.piotrleb.financetracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import me.piotrleb.financetracker.Main;
import me.piotrleb.financetracker.users.User;
import me.piotrleb.financetracker.utils.UserPasser;

public class LoginController {

    private Stage primaryStage = Main.getStage();
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private Pane topBar;
    @FXML
    private TextField textField;
    @FXML
    private PasswordField passwordField;

    @FXML
    protected void initialize() {
        topBar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        topBar.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });
    }

    private void fillForm(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Please fill all the fields!");
        alert.showAndWait();
    }

    private void invalidData(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Invalid username or password");
        alert.showAndWait();
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

    @FXML
    protected void exit(){
        System.exit(0);
    }

    public void toRegisterView() throws Exception {
        Main.setRoot("views/register.fxml");
    }
}