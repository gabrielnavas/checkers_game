package com.checker.api.domain;

public class Board {

    public static final int SIZE_BOARD = 8;
    public static final int START_POSITION_BOARD = 0;
    public static final int END_POSITION_BOARD = 7;

    private Square[][] square;

    public Board() {
        this.square = new Square[Board.SIZE_BOARD][Board.SIZE_BOARD];
    }

    public void setupBoard() {
    }

    public boolean isOnInsideBoard(PositionSquare square) {
        return  square.getX() >= Board.START_POSITION_BOARD
                && square.getY() >= Board.START_POSITION_BOARD
                    && square.getX() <= Board.END_POSITION_BOARD
                    && square.getY() <= Board.END_POSITION_BOARD;
    }

    public boolean isValidMove(Move move) {
        return false;
    }

    public Square getSquarePosition(PositionSquare position) {
        return null;
    }
}
