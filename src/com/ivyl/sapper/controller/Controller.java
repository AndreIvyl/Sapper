package com.ivyl.sapper.controller;

import com.ivyl.sapper.model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Optional;


public class Controller {
    @FXML
    GridPane gridBoard;
    Game game;

    ObservableList<ObservableList<Cell>> visualBoard;

    public Controller() {

    }

    public void initialize() {
        game = new Game(20);
        visualBoard = game.getBoard().getBombBoard();
        for (int i = 0; i < visualBoard.size(); i++) {
            for (int j = 0; j < visualBoard.get(i).size(); j++) {
                gridBoard.add(visualBoard.get(i).get(j), i, j);
            }
        }
    }

    public void gridClick(MouseEvent mouseEvent) {
        int counter = 0;
        EventTarget target = mouseEvent.getTarget();
        if (target instanceof Bomb) {
            System.out.println("BOOM");
        } else if (target instanceof Cell) {
            Cell targetCell = (Cell) target;
            for (CoordPairs cp : game.getBoard().getCoordPairs().getCoordPairsList()) {
                if (cp.getCoordI() == targetCell.getPosX() && cp.getCoordJ() == targetCell.getPosY()) {
                    visualBoard.get(targetCell.getPosX()).get(targetCell.getPosY()).getChildren().add(new Bomb());
                    //sleep(1000);
                    for (int i = 0; i <= game.getBoard().getCoordPairs().getCoordPairsList().size()-1; i++) {
                        visualBoard.get(game.getBoard().getCoordPairs().getCoordPairsList().get(i).getCoordI())
                                   .get(game.getBoard().getCoordPairs().getCoordPairsList().get(i).getCoordJ()).getChildren().add(new Bomb());
                    }
                  //  sleep(1000);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("You are lose...");
                    alert.setContentText("Once more time?");
                    alert.setHeaderText("BOOM!!!");
                    ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(String.valueOf(getClass().getClassLoader().getResource("images/ivyl200.jpg"))));
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        gridBoard.getChildren().retainAll(gridBoard.getChildren().get(0));
                        visualBoard.clear();
                        game.getBoard().getBombBoard().clear();
                        game.getBoard().getCoordPairs().getCoordPairsList().clear();
                        initialize();
                        return;
                    } else {
                        System.exit(0);
                    }
                 //   return;
                }
            }
            for (CoordPairs cp : game.getBoard().getCoordPairs().getCoordPairsList()) {
                for (int i = targetCell.getPosX() - 1; i <= targetCell.getPosX() + 1; i++) {
                    for (int j = targetCell.getPosY() - 1; j <= targetCell.getPosY() + 1; j++) {
                        if (cp.getCoordI() == i && cp.getCoordJ() == j) {
                            counter++;
                        }
                    }

                }
            }
            EmptyCell emptyCell = new EmptyCell(String.valueOf(counter));
            switch (counter) {
                case 0:
                    emptyCell.setFill(Color.SKYBLUE);
                    break;
                case 1:
                    emptyCell.setFill(Color.BLUE);
                    break;
                case 2:
                    emptyCell.setFill(Color.GREEN);
                    break;
                case 3:
                    emptyCell.setFill(Color.DARKGREEN);
                    break;
                case 4:
                    emptyCell.setFill(Color.ORANGE);
                    break;
                case 5:
                    emptyCell.setFill(Color.ORANGERED);
                    break;
                case 6:
                    emptyCell.setFill(Color.RED);
                    break;
                case 7:
                    emptyCell.setFill(Color.DARKRED);
                    break;
                case 8:
                    emptyCell.setFill(Color.INDIGO);
                    break;
            }
            emptyCell.setFont(Font.font("Regular", FontWeight.BOLD, 24));
            targetCell.getChildren().add(emptyCell);
        }
    }

    public void menuNewClick(ActionEvent actionEvent) {
        gridBoard.getChildren().retainAll(gridBoard.getChildren().get(0));
        visualBoard.clear();
        game.getBoard().getBombBoard().clear();
        game.getBoard().getCoordPairs().getCoordPairsList().clear();
        initialize();
    }

    public void menuCloseClick(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void menuAboutClick(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Credits");
        alert.setContentText("At the end of the course \"Java OOP\" on Vertex Academy...");
        alert.setHeaderText("Made by:\n Melnikov Andrey (Ivyl)");
        ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(String.valueOf(getClass().getClassLoader().getResource("images/ivyl200.jpg"))));
        alert.showAndWait();
    }
}
