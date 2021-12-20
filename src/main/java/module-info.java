module com.example.threepointcircle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.threepointcircle to javafx.fxml;
    exports com.example.threepointcircle;
}