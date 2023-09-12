package com.checker.api.domain;

public class Move {
    private final PositionSquare positionSquareOrigin;
    private final PositionSquare positionSquareDestiny;
    private final Board board;

    public Move(Board board, PositionSquare origin, PositionSquare destiny) {
        this.board = board;
        this.positionSquareOrigin = origin;
        this.positionSquareDestiny = destiny;
    }

    public boolean isValid() {
        return board.isMoveOnInsideBoard(this);
    }

    public void execute() {

    }

    public PositionSquare getPositionSquareDestiny() {
        return positionSquareDestiny;
    }

    public PositionSquare getPositionSquareOrigin() {
        return positionSquareOrigin;
    }
}
