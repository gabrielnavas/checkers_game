package com.checker.api.domain;

import com.checker.api.domain.exceptions.PositionSquareIsNotInsideBoard;

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
        boolean originInsideBoard = board.isOnInsideBoard(origin);
        boolean destinyInsideBoard = board.isOnInsideBoard(destiny);
        if(!originInsideBoard && !destinyInsideBoard) {
            throw new PositionSquareIsNotInsideBoard();
        }
        return true;
    }

    public void execute() {

    }
}
