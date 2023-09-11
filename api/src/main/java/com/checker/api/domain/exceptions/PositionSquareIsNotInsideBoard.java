package com.checker.api.domain.exceptions;

public class PositionSquareIsNotInsideBoard extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "the position square is not inside the board";

    public PositionSquareIsNotInsideBoard() {
        super(PositionSquareIsNotInsideBoard.DEFAULT_MESSAGE, new Exception(PositionSquareIsNotInsideBoard.DEFAULT_MESSAGE));
    }
}
