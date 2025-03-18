module com.example.cw4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cw4 to javafx.fxml;
    exports com.example.cw4;
}