package com.ivyl.sapper.model;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bomb extends ImageView {
    public Bomb() {
      //  super("file:resources/images/bomb.jpg");
        super();

        //Image from resourses
        setImage(new Image(String.valueOf(getClass().getClassLoader().getResource("images/bomb.jpg"))));
        setFitWidth(30);
        setFitHeight(30);
    }
}
