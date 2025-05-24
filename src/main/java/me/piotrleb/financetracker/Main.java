package me.piotrleb.financetracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        Main.stage = stage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/login.fxml")));
        Scene scene = new Scene(root, 1500, 1000);
        Font.loadFont(Objects.requireNonNull(getClass().getResource("/me/piotrleb/financetracker/fonts/LexendDeca-Regular.ttf")).toExternalForm(), 10);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("css/main.css")).toExternalForm());
        stage.setTitle("Finance Tracker");
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(fxml)));
        Scene scene = new Scene(root, 1500, 1000);
        Font.loadFont(Objects.requireNonNull(Main.class.getResource("/me/piotrleb/financetracker/fonts/LexendDeca-Regular.ttf")).toExternalForm(), 10);
        scene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("css/main.css")).toExternalForm());
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}