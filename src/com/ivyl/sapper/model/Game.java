package com.ivyl.sapper.model;

public class Game {
    private Board board;

    public Game(int bombCount) {
        board = new Board(bombCount);
    }

    public Board getBoard() {
        return board;
    }


}
