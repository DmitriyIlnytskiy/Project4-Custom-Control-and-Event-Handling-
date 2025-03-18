module org.example.hw4_event_handling {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.hw4_event_handling to javafx.fxml;
    exports org.example.hw4_event_handling;
}