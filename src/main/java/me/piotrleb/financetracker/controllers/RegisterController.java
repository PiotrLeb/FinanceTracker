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


public class RegisterController {
    private double xOffset = 0;
    private double yOffset = 0;
    private Stage primaryStage = Main.getStage();
    @FXML
    private Pane topBar;
    @FXML
    private TextField textField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField repeatPasswordField;

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

    @FXML
    protected void exit(){
        System.exit(0);
    }

    public void toLoginView() throws Exception {
        Main.setRoot("views/login.fxml");
    }
}
