package me.piotrleb.financetracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import me.piotrleb.financetracker.Main;
import me.piotrleb.financetracker.utils.UserPasser;

public class MainController {

    private double xOffset;
    private double yOffset;
    private Stage primaryStage = Main.getStage();

    @FXML
    private Pane topBar;
    @FXML
    private Label balance;
    @FXML
    private Label income;
    @FXML
    private Label savings;
    @FXML
    private Label expenses;

    @FXML
    protected void initialize(){
        topBar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        topBar.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

        balance.setText(String.valueOf(UserPasser.getInstance().getBalance()));
        income.setText(String.valueOf(UserPasser.getInstance().getIncome()));
        savings.setText(String.valueOf(UserPasser.getInstance().getSavings()));
        expenses.setText(String.valueOf(UserPasser.getInstance().getExpenses()));

    }

    @FXML
    protected void exit(){
        System.exit(0);
    }
}
