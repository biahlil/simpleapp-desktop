module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.base;
    requires transitive javafx.graphics;
    requires org.json;
    requires org.assertj.core;
    requires com.google.api.client;

    opens com.example to javafx.fxml;
    exports com.example;
}
