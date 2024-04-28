package com.example.trabajocochedi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class CarrerasController implements Initializable {
    @FXML
    AnchorPane root;

    @FXML
    private ImageView imageViewCoche1;

    @FXML
    private ImageView imageViewCoche2;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnRestart;
    @FXML
    private Label lblPrimeraPosicion;

    private Vehiculo vehiculo1;
    private Vehiculo vehiculo2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vehiculo1 = new Vehiculo(imageViewCoche1, 1);
        vehiculo2 = new Vehiculo(imageViewCoche2, 2);

        Random random = new Random();

        this.btnStart.setOnAction(event -> {
            int randomDuration1 = 5 + random.nextInt(5);
            int randomDuration2 = 5 + random.nextInt(5); // Random duration between 5 and 10 seconds for car 2


            vehiculo1.moveTo(1000, randomDuration1); // Move coche1 in 5 seconds
            vehiculo2.moveTo(1000,  randomDuration2); // Move coche2 in 5 seconds

            btnRestart.setOnAction(event2 -> onRestartPressed());
        });
    }

    public void onRestartPressed() {
        vehiculo1.restart();
        vehiculo2.restart();
    }
}