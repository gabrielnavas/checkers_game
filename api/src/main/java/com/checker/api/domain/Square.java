package com.checker.api.domain;

public class Square {

    private final PositionSquare position;
    private Checker checker;
    private final Board board;

    public Square(PositionSquare position, Checker checker, Board board) {
        this.position = position;
        this.checker = checker;
        this.board = board;
    }


    public boolean hasChecker() {
        return checker != null;
    }
}
