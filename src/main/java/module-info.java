module org.example.financetracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.financetracker to javafx.fxml;
    exports org.example.financetracker;
    exports org.example.financetracker.controllers;
    opens org.example.financetracker.controllers to javafx.fxml;
}