package com.checker.api.domain;

import com.checker.api.domain.exceptions.PositionSquareIsNotInsideBoardException;

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
            throw new PositionSquareIsNotInsideBoardException();
        }
        move.execute();
    }
}
