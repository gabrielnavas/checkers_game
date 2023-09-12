package com.checker.api.domain;

import com.checker.api.domain.exceptions.PositionSquareIsNotInsideBoardException;
import com.checker.api.domain.exceptions.SquareAlreadyHasCheckerException;

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
        return board.isValidMove(this);
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
