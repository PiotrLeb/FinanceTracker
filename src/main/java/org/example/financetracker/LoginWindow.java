package org.example.financetracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class LoginWindow extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginWindow.class.getResource("/view/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1500, 1000);
        String css = Objects.requireNonNull(this.getClass().getResource("/css/login.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Finance Tracker");
        stage.setScene(scene);
        stage.setResizable(false);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}