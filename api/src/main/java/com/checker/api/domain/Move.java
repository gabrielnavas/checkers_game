package com.checker.api.domain;

import com.checker.api.domain.exceptions.PositionSquareIsNotInsideBoardException;

public class Move {
    private final PositionSquare origin;
    private final PositionSquare destiny;
    private final Board board;

    public Move(Board board, PositionSquare origin, PositionSquare destiny) {
        this.board = board;
        this.origin = origin;
        this.destiny = destiny;
    }

    public boolean isValid() {
        if(positionsIsOnInsideBoard()) {
            throw new PositionSquareIsNotInsideBoardException();
        }
        return true;
    }

    public void execute() {

    }

    private boolean positionsIsOnInsideBoard() {
        boolean originInsideBoard = board.isOnInsideBoard(origin);
        boolean destinyInsideBoard = board.isOnInsideBoard(destiny);
        return originInsideBoard || destinyInsideBoard;
    }
}
