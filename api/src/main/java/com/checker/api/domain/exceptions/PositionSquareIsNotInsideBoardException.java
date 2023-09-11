package com.checker.api.domain.exceptions;

public class PositionSquareIsNotInsideBoardException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "the position square is not inside the board";

    public PositionSquareIsNotInsideBoardException() {
        super(PositionSquareIsNotInsideBoardException.DEFAULT_MESSAGE, new Exception(PositionSquareIsNotInsideBoardException.DEFAULT_MESSAGE));
    }
}
