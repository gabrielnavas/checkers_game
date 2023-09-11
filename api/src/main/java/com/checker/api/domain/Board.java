package com.checker.api.domain;

public class Board {

    private static final int SIZE_BOARD = 8;

    private Square[][] square;

    public Board() {
        this.square = new Square[Board.SIZE_BOARD][Board.SIZE_BOARD];
    }

    public void setupBoard() {
    }

    public boolean isValidMove(Move move) {
        return false;
    }

    public Square getSquarePosition(PositionSquare position) {
        return null;
    }
}
