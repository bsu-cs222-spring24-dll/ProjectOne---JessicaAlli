module com.example.wikigui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wikigui to javafx.fxml;
    exports com.example.wikigui;
}