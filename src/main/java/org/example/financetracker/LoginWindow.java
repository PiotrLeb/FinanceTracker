package org.example.financetracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.financetracker.database.DatabaseConnection;
import org.example.financetracker.users.Admin;
import org.example.financetracker.users.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class LoginWindow extends Application {
    static DatabaseConnection connDb = new DatabaseConnection();
    /**
     *
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginWindow.class.getResource("/view/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1300, 900);
        String css = Objects.requireNonNull(this.getClass().getResource("/css/login.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Finance Tracker");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch();
        User user = new User("username","password","email");
        User admin = new Admin("1","2","3");
        try {
            connDb.databaseAskQuery("SELECT * FROM users;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}