package com.checker.api.domain;

import java.util.function.BiFunction;

public class Board {

    public static final int SIZE_BOARD = 8;
    public static final int START_POSITION_BOARD = 0;
    private static final int END_ROW_POSITION_RED_BOARD = 2;
    private static final int START_ROW_POSITION_BETWEEN_BOARD = 3;
    private static final int END_ROW_POSITION_BETWEEN_BOARD = 4;
    private static final int START_ROW_POSITION_WHITE = 5;
    public static final int END_ROW_POSITION_BOARD = 7;

    private final BiFunction<Integer, Integer, Boolean> redRowEvenColumnOdd = (row, column) -> row % 2 == 0 && column % 2 != 0;
    private final BiFunction<Integer, Integer, Boolean> redRowOddColumnEven = (row, column) -> row % 2 != 0 && column % 2 == 0;

    private final BiFunction<Integer, Integer, Boolean> whiteRowOddColumnEven = (row, column) -> row % 2 != 0 && column % 2 == 0;
    private final BiFunction<Integer, Integer, Boolean> whiteRowEvenColumnOdd = (row, column) -> row % 2 == 0 && column % 2 != 0;

    private final Square[][] squares;

    public Board() {
        this.squares = new Square[Board.SIZE_BOARD][Board.SIZE_BOARD];
    }

    public void setupBoard(PlayerRed playerRed, PlayerWhite playerWhite) {
        setupRedCheckers(playerRed);
        setupBetweenSquares();
        setupWhiteCheckers(playerWhite);
    }

    public boolean isMoveOnInsideBoard(Move move) {
        boolean originInsideBoard = positionIsOnInsideBoard(move.getPositionSquareOrigin());
        boolean destinyInsideBoard = positionIsOnInsideBoard(move.getPositionSquareDestiny());
        return originInsideBoard && destinyInsideBoard;
    }

    private boolean positionIsOnInsideBoard(PositionSquare square) {
        return  square.getX() >= Board.START_POSITION_BOARD
                && square.getY() >= Board.START_POSITION_BOARD
                    && square.getX() <= Board.END_ROW_POSITION_BOARD
                    && square.getY() <= Board.END_ROW_POSITION_BOARD;
    }

    public boolean squarePositionHasChecker(PositionSquare position) {
        Square square = squares[position.getX()][position.getY()];
        return square.hasChecker();
    }

    private void setupRedCheckers(PlayerRed playerRed) {
        // add red checkers
        for (int row = START_POSITION_BOARD; row <= END_ROW_POSITION_RED_BOARD; row++) {
            for (int column = 0; column <= END_ROW_POSITION_BOARD; column++) {
                final PositionSquare positionSquare = new PositionSquare(row, column);
                Checker checker = null;

                if(redRowEvenColumnOdd.apply(row, column)
                        || redRowOddColumnEven.apply(row, column)) {
                    checker = new Checker(KindChecker.RED_CHECKER, playerRed);
                }

                final Square square = new Square(positionSquare , checker, this);
                squares[row][column] = square;
            }
        }
    }

    private void setupBetweenSquares() {

        for (int row = START_ROW_POSITION_BETWEEN_BOARD; row <= END_ROW_POSITION_BETWEEN_BOARD; row++) {
            for (int column = 0; column <= END_ROW_POSITION_BOARD; column++) {
                final PositionSquare positionSquare = new PositionSquare(row, column);
                final Square square = new Square(positionSquare , null, this);
                squares[row][column] = square;
            }
        }
    }

    private void setupWhiteCheckers(PlayerWhite playerWhite) {
        for (int row = START_ROW_POSITION_WHITE; row <= END_ROW_POSITION_BOARD; row++) {
            for (int column = 0; column <= END_ROW_POSITION_BOARD; column++) {
                final PositionSquare positionSquare = new PositionSquare(row, column);
                Checker checker = null;

                if(whiteRowOddColumnEven.apply(row, column)
                        || whiteRowEvenColumnOdd.apply(row, column)) {
                    checker = new Checker(KindChecker.WHITE_CHECKER, playerWhite);
                }

                final Square square = new Square(positionSquare , checker, this);
                squares[row][column] = square;
            }
        }
    }

    public Square[][] getSquares() {
        return squares;
    }
}
