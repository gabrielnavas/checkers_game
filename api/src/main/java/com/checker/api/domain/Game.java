package com.checker.api.domain;

public class Game {
    private final Board board;
    private final Player[] players;
    private Player current;

    private Player winner;

    private StatusGame status;

    public Game(Board board, Player[] players) {
        this.board = board;
        this.players = players;
        this.current = players[0];
        this.winner = null;
        this.status = StatusGame.ALREADY;
    }

    public void playMove(Move move) {

    }

    public boolean isGameOver() {
        return false;
    }

    public Board getBoard() {
        return board;
    }


    public Player[] getPlayers() {
        return players;
    }

    public Player getCurrent() {
        return current;
    }

    public Player getWinner() {
        return winner;
    }

    public StatusGame getStatus() {
        return status;
    }
}
