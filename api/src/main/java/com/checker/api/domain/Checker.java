package com.checker.api.domain;

public class Checker {

    private final KindChecker kind;
    private  final Player owner;


    public Checker(KindChecker kind, Player owner) {
        this.kind = kind;
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

    public Player getOwner() {
        return owner;
    }
}
