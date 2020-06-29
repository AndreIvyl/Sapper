package com.ivyl.sapper;

import com.ivyl.sapper.model.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/view.fxml"));
        primaryStage.setTitle("Sapper");
        primaryStage.setResizable(false);

        //Image from resourses
        primaryStage.getIcons().add(new Image(String.valueOf(getClass().getClassLoader().getResource("images/ivyl200.jpg"))));
        //primaryStage.getIcons().add(new Image("file:resources/images/ivyl200.jpg"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
