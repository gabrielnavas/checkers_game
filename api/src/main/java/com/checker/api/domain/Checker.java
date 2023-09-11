package com.checker.api.domain;

public class Checker {

    private final KindChecker kind;
    private final Square square;
    private  final Player owner;

    public Checker(KindChecker kind, Square square, Player owner) {
        this.kind = kind;
        this.square = square;
        this.owner = owner;
    }

    public void move(PositionSquare position) {

    }

    public void promote() {

    }

    public boolean isPromoted() {
        return false;
    }

    public KindChecker getKind() {
        return kind;
    }

    public Square getSquare() {
        return square;
    }

    public Player getOwner() {
        return owner;
    }
}
