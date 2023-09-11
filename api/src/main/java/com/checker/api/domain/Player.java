package com.checker.api.domain;

public abstract class Player {

    private final String username;
    private final Game game;
    private final Checker[] checkers;

    public Player(String username, Game game, Checker[] checkers) {
        this.username = username;
        this.game = game;
        this.checkers = checkers;
    }

    public void makeMove(Move move) throws Exception {
        boolean alreadyMove = move.isValid();
        if(!alreadyMove) {
            throw new Exception("can not do this move");
        }
        move.execute();
    }
}
