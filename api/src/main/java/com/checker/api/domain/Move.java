package com.checker.api.domain;

public class Move {
    private final PositionSquare origin;
    private final PositionSquare destiny;

    public Move(PositionSquare origin, PositionSquare destiny) {
        this.origin = origin;
        this.destiny = destiny;
    }

    public boolean isValid() {
        return false;
    }

    public void execute() {

    }

    public PositionSquare getOrigin() {
        return origin;
    }

    public PositionSquare getDestiny() {
        return destiny;
    }
}
