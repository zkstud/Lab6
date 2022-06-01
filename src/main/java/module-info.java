module com.example.lab6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports pl.lublin.wsei.java.cwiczenia.test;
    opens pl.lublin.wsei.java.cwiczenia.test to javafx.fxml;
}