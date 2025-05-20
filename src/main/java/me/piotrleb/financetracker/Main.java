package me.piotrleb.financetracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/login.fxml")));
        Scene scene = new Scene(root, 1500, 1000);
        Font.loadFont(Objects.requireNonNull(getClass().getResource("/me/piotrleb/financetracker/fonts/LexendDeca-Regular.ttf")).toExternalForm(), 10);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("css/styles.css")).toExternalForm());
        stage.setTitle("Finance Tracker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}