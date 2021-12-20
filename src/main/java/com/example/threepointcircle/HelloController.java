package com.example.threepointcircle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.lang.Math;

public class HelloController implements Initializable {
    @FXML
    private Label result_middlepoint;
    @FXML
    private Button getResultButton;
    @FXML
    private TextField pointa;
    @FXML
    private TextField pointb;
    @FXML
    private TextField pointc;



    private double gleichung1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        getResultButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String[] pointaX = pointa.getText().split(",");

                berechne(pointaX);

            }
        });
    }



    public void berechne(String[] pointa) {
        // [0] ist X, [1] ist Y
        double x = 0;
        double y;
        System.out.println(pointa[0]);
        double gleichung1 = Math.pow(Double.parseDouble(pointa[0]) - x, 2);
        System.out.println(gleichung1);
    }

}