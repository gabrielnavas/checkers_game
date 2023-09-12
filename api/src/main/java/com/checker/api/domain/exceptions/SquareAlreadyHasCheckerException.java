package com.checker.api.domain.exceptions;

public class SquareAlreadyHasCheckerException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "square on try move checker already has checker";

    public SquareAlreadyHasCheckerException() {
        super(SquareAlreadyHasCheckerException.DEFAULT_MESSAGE, new Exception(SquareAlreadyHasCheckerException.DEFAULT_MESSAGE));
    }
}
