module me.piotrleb.financetracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens me.piotrleb.financetracker to javafx.fxml;
    exports me.piotrleb.financetracker;
    exports me.piotrleb.financetracker.controllers;
    opens me.piotrleb.financetracker.controllers to javafx.fxml;
}