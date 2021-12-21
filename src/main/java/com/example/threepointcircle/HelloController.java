package com.example.threepointcircle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label result_middlepoint;
    @FXML
    private Label result_Radius;
    @FXML
    private Button getResultButton;
    @FXML
    private TextField pointa;
    @FXML
    private TextField pointb;
    @FXML
    private TextField pointc;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        getResultButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String[] pointaX = pointa.getText().split(",");
                String[] pointbX = pointb.getText().split(",");
                String[] pointcX = pointc.getText().split(",");

                if (pointaX.length == 0 || pointcX.length == 0 || pointbX.length == 0)
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error occurred");
                    alert.setContentText("You have to enter your points to get the result.");
                    alert.show();
                }  else {
                    try {
                        berechne(pointaX, pointbX, pointcX);
                    } catch (Exception e) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error occurred");
                        alert.setContentText("An unknown error occurred. Please check the logs.");
                        alert.show();
                    }
                }
            }
        });
    }



    public double pow(double toDouble) {
        return Math.pow(toDouble, 2);
    }

    public void berechne(String[] pointa, String[] pointb, String[] pointc) {

        // [0] ist X, [1] ist Y
        double x1 = Double.parseDouble(pointa[0]);
        double y1 = Double.parseDouble(pointa[1]);
        double x2 = Double.parseDouble(pointb[0]);
        double y2 = Double.parseDouble(pointb[1]);
        double x3 = Double.parseDouble(pointc[0]);
        double y3 = Double.parseDouble(pointc[1]);

        // Konstanten
        double z = (2*y1 - 2*y2);
        double k = pow(x1) + pow(y1) - pow(x2) - pow(y2);

        // a = X Achsenabschnitt von M
        double a1 = pow(x3)*z + pow(y3)*z - pow(x1)*z - pow(y1)*z - (2*y3)*k + (2*y1)*k;
        double a2 = (-2*x1*z) - 2*y1*(-2)*x1 - 2*y1*2*x2 + 2*y3*(-2)*x1 + 2*y3*2*x2+2*x3*z;
        double a = a1 / a2;

        // b = Y Achsenabschnitt von M
        double b1 = k - 2*x1*a + 2*x2*a;
        double b = b1 / z;

        // c^2 = Radius
        double c1 = pow(x3 - a) + pow(y3-b);
        double c = Math.sqrt(c1);



        // GUI Stuff
        result_middlepoint.setText("Der Mittelpunkt des Kreises liegt bei: M( " + a + " | " + b + " )");
        result_middlepoint.setVisible(true);
        result_Radius.setText("Der Radius des Kreises beträgt: " + c + ", beziehungsweise: Wurzel aus " + c1);
        result_Radius.setVisible(true);
    }

}