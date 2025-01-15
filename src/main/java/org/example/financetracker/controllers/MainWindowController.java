package org.example.financetracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainWindowController {
    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {
        welcomeLabel.setText("Welcome to FinBank!");
    }
    
}
