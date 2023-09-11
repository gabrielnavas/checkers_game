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

    public void setChecker(Checker checker) {
        this.checker = checker;
    }

    public PositionSquare getPosition() {
        return position;
    }

    public Checker getChecker() {
        return checker;
    }

    public Board getBoard() {
        return board;
    }
}
