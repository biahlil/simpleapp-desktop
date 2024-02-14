module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires org.json;
    requires org.assertj.core;
    requires okhttp3;

    opens com.example to javafx.fxml;
    exports com.example;
}
