package com.ivyl.sapper.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Board {
    private final static int BOARD_SIDE_SIZE = 10;
    private int bombCount;
    private ObservableList<ObservableList<Cell>> bombBoard;
    private CoordPairs coordPairs;
    //   ArrayList<CoordPair> bombCoords;
    // private Cell[][] bombBoard;

    public Board(int bombCount) {
        this.bombCount = bombCount;
        int bombCounter = 0;
        coordPairs = new CoordPairs();

        bombBoard = FXCollections.observableArrayList();
        for (int i = 0; i < BOARD_SIDE_SIZE; i++) {
            bombBoard.add(FXCollections.<Cell>observableArrayList());
            for (int j = 0; j < BOARD_SIDE_SIZE; j++) {
                Cell cell = new Cell(i, j);
                bombBoard.get(i).add(cell);
            }
        }

     //   ArrayList<CoordPairs> bombCoordsList = new ArrayList<CoordPairs>();
        while (bombCounter < bombCount) {
            int randomCellCol = (int) (Math.random() * 10);
            int randomRowCol = (int) (Math.random() * 10);
            boolean canSetBomb = true;

            for (CoordPairs cp : coordPairs.getCoordPairsList()) {
                if (cp.getCoordI() == randomCellCol && cp.getCoordJ() == randomRowCol) {
                    canSetBomb = false;
                    break;
                }
            }
            if (canSetBomb) {
             //   bombBoard.get(randomCellCol).get(randomRowCol).getChildren().add(new Bomb());
                CoordPairs bombCoords = new CoordPairs();
                bombCoords.setCoordI(randomCellCol);
                bombCoords.setCoordJ(randomRowCol);
                coordPairs.getCoordPairsList().add(bombCoords);
                bombCounter++;
            }
        }
    }

    public CoordPairs getCoordPairs() {
        return coordPairs;
    }

    public static int getBoardSideSize() {
        return BOARD_SIDE_SIZE;
    }

    public ObservableList<ObservableList<Cell>> getBombBoard() {
        return bombBoard;
    }
}
