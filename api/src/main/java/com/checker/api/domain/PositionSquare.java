package com.checker.api.domain;

public class PositionSquare {
    private final int x;
    private final int y;

    public PositionSquare() {
        this(0, 0);
    }

    public PositionSquare(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
