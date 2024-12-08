module org.example.financetracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.financetracker to javafx.fxml;
    exports org.example.financetracker;
}