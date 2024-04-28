package com.example.trabajocochedi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class Vehiculo {
    private ImageView imageViewCoche;
    private double posicionInicialX;
    private int index;
    private double speed;
    private Timeline timeline;

    public Vehiculo(ImageView imageViewCoche,int index){
        this.imageViewCoche = imageViewCoche;
        this.posicionInicialX = imageViewCoche.getLayoutX();
        this.index = index;

        this.speed = 1;
        this.timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), e -> updateSpeed()));
        this.timeline.setCycleCount(Timeline.INDEFINITE);


        imageViewCoche.setVisible(true);
    }


    public void moveTo(double x, double duration) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(duration * speed), imageViewCoche);
        transition.setByX(x - imageViewCoche.getLayoutX());
        transition.play();
        imageViewCoche.getProperties().put("transition", transition);
        this.timeline.play();
    }

    private void updateSpeed() {
        Random random = new Random();
        double randomSpeed = 1 + (random.nextDouble() * 0.2);
        this.speed *= randomSpeed;
        System.out.println("Coche " + index + " velocidad: " + speed);
    }

    public void restart() {
        imageViewCoche.setTranslateX(posicionInicialX);
        speed = 1;
        timeline.stop();
        TranslateTransition transition = (TranslateTransition) imageViewCoche.getProperties().get("transition");
        if (transition != null) {
            transition.stop();
        }
    }

    public ImageView getImageViewCoche() {
        return imageViewCoche;
    }

    public void setImageViewCoche(ImageView imageViewCoche) {
        this.imageViewCoche = imageViewCoche;
    }

    public double getPosicionInicialX() {
        return posicionInicialX;
    }

    public void setPosicionInicialX(double posicionInicialX) {
        this.posicionInicialX = posicionInicialX;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }
}
