package com.checker.api.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BoardTest {

    @InjectMocks
    PlayerRed playerRed;

    @InjectMocks
    PlayerWhite playerWhite;

    Move move;

    Board boardSut;

    Map<List<Integer>, Boolean> successfulCases;

    Map<List<Integer>, Boolean> failedCases;


    @BeforeEach
    void setup() {
        boardSut = new Board();

        successfulCases = new HashMap<>() {{
            put(Arrays.asList(0, 0), true);
            put(Arrays.asList(7, 7), true);
        }};

        failedCases = new HashMap<>() {{
            put(Arrays.asList(-1, -1), false);
            put(Arrays.asList(Board.START_POSITION_BOARD-1, Board.START_POSITION_BOARD-1), false);
            put(Arrays.asList(8, 8), false);
            put(Arrays.asList(Board.END_ROW_POSITION_BOARD+1, Board.END_ROW_POSITION_BOARD-1), false);
            put(Arrays.asList(-1, 0), false);
            put(Arrays.asList(7, 8), false);
        }};
    }

    @Test
    public void shouldCallSetupBoardWithPlayersNoThrowExceptions() {
        assertDoesNotThrow(() -> {
            boardSut.setupBoard(playerRed, playerWhite);
            Square[][] squares = boardSut.getSquares();

            for (int j = 1; j < Board.SIZE_BOARD; j += 2) {
                assertTrue(squares[0][j].hasChecker());
            }
            for (int j = 0; j < Board.SIZE_BOARD; j += 2) {
                assertTrue(squares[1][j].hasChecker());
            }
            for (int j = 1; j < Board.SIZE_BOARD; j += 2) {
                assertTrue(squares[2][j].hasChecker());
            }

            for (int j = 0; j < Board.SIZE_BOARD; j++) {
                assertFalse(squares[3][j].hasChecker());
            }
            for (int j = 0; j < Board.SIZE_BOARD; j++) {
                assertFalse(squares[4][j].hasChecker());
            }


            for (int j = 1; j < Board.SIZE_BOARD; j += 2) {
                assertTrue(squares[0][j].hasChecker());
            }
            for (int j = 0; j < Board.SIZE_BOARD; j += 2) {
                assertTrue(squares[1][j].hasChecker());
            }
            for (int j = 1; j < Board.SIZE_BOARD; j += 2) {
                assertTrue(squares[2][j].hasChecker());
            }
        });
    }

    @Test
    public void shouldCallSetupBoardVerifyRedCheckers() {
        assertDoesNotThrow(() -> {
            boardSut.setupBoard(playerRed, playerWhite);
            Square[][] squares = boardSut.getSquares();

            Square square = null;

            for (int j = 1; j < Board.SIZE_BOARD; j += 2) {
                square = squares[0][j];
                assertTrue(square.hasChecker());
            }
            for (int j = 0; j < Board.SIZE_BOARD; j += 2) {
                square = squares[1][j];
                assertTrue(square.hasChecker());
            }
            for (int j = 1; j < Board.SIZE_BOARD; j += 2) {
                square = squares[2][j];
                assertTrue(square.hasChecker());
            }
        });
    }

    @Test
    public void shouldCallSetupBoardVerifyTheBetWeen() {
        assertDoesNotThrow(() -> {
            boardSut.setupBoard(playerRed, playerWhite);
            Square[][] squares = boardSut.getSquares();

            Square square = null;

            for (int j = 0; j < Board.SIZE_BOARD; j ++) {
                square = squares[3][j];
                assertFalse(square.hasChecker());
            }
            for (int j = 0; j < Board.SIZE_BOARD; j ++) {
                square = squares[4][j];
                assertFalse(square.hasChecker());
            }
        });
    }

    @Test
    public void shouldCallSetupBoardVerifyWhiteCheckers() {
        assertDoesNotThrow(() -> {
            boardSut.setupBoard(playerRed, playerWhite);
            Square[][] squares = boardSut.getSquares();

            Square square = null;

            for (int j = 0; j < Board.SIZE_BOARD; j += 2) {
                square = squares[5][j];
                assertTrue(square.hasChecker());
            }
            for (int j = 1; j < Board.SIZE_BOARD; j += 2) {
                square = squares[6][j];
                assertTrue(square.hasChecker());
            }
            for (int j = 0; j < Board.SIZE_BOARD; j += 2) {
                square = squares[7][j];
                assertTrue(square.hasChecker());
            }
        });
    }

    @Test
    public void shouldReturnsTrueWithSuccessCrossSuccess() {

        // loop for origin case
        for (Map.Entry<List<Integer>, Boolean> originCase  : successfulCases.entrySet()) {
            // create the PositionSquare origin
            int originPositionX = originCase.getKey().get(0);
            int originPositionY = originCase.getKey().get(1);
            boolean expectedOriginPosition = originCase.getValue();
            PositionSquare positionSquareOrigin = new PositionSquare(originPositionX, originPositionY);

            // loop for destiny case
            for (Map.Entry<List<Integer>, Boolean> destinyCase  : successfulCases.entrySet()) {
                // create the Position origin
                int originDestinyX = destinyCase.getKey().get(0);
                int originDestinyY = destinyCase.getKey().get(1);
                boolean expectedDestinyPosition = destinyCase.getValue();
                PositionSquare positionSquareDestiny = new PositionSquare(originDestinyX, originDestinyY);

                // create the move
                move = new Move(boardSut, positionSquareOrigin, positionSquareDestiny);

                // expected boolean from origin and destiny position
                boolean isMoveExpected = expectedOriginPosition & expectedDestinyPosition;

                // call the correct method of sut
                boolean isMoveReceived = boardSut.isMoveOnInsideBoard(move);

                assertEquals(isMoveReceived, isMoveExpected);
            }
        }
    }

    @Test
    public void shouldReturnsFalseWithFailedCrossFailed() {

        // loop for origin case
        for (Map.Entry<List<Integer>, Boolean> originCase  : failedCases.entrySet()) {
            // create the PositionSquare origin
            int originPositionX = originCase.getKey().get(0);
            int originPositionY = originCase.getKey().get(1);
            boolean expectedOriginPosition = originCase.getValue();
            PositionSquare positionSquareOrigin = new PositionSquare(originPositionX, originPositionY);

            // loop for destiny case
            for (Map.Entry<List<Integer>, Boolean> destinyCase  : failedCases.entrySet()) {
                // create the Position origin
                int originDestinyX = destinyCase.getKey().get(0);
                int originDestinyY = destinyCase.getKey().get(1);
                boolean expectedDestinyPosition = destinyCase.getValue();
                PositionSquare positionSquareDestiny = new PositionSquare(originDestinyX, originDestinyY);

                // create the move
                Move move = new Move(boardSut, positionSquareOrigin, positionSquareDestiny);

                // expected boolean from origin and destiny position
                boolean isMoveExpected = expectedOriginPosition & expectedDestinyPosition;

                // call the correct method of sut
                boolean isMoveReceived = boardSut.isMoveOnInsideBoard(move);

                assertEquals(isMoveReceived, isMoveExpected);
            }
        }
    }

    @Test
    public void shouldReturnsFalseWithSuccessCrossFailed() {

        // loop for origin case
        for (Map.Entry<List<Integer>, Boolean> originCase  : successfulCases.entrySet()) {
            // create the PositionSquare origin
            int originPositionX = originCase.getKey().get(0);
            int originPositionY = originCase.getKey().get(1);
            boolean expectedOriginPosition = originCase.getValue();
            PositionSquare positionSquareOrigin = new PositionSquare(originPositionX, originPositionY);

            // loop for destiny case
            for (Map.Entry<List<Integer>, Boolean> destinyCase  : failedCases.entrySet()) {
                // create the Position origin
                int originDestinyX = destinyCase.getKey().get(0);
                int originDestinyY = destinyCase.getKey().get(1);
                boolean expectedDestinyPosition = destinyCase.getValue();
                PositionSquare positionSquareDestiny = new PositionSquare(originDestinyX, originDestinyY);

                // create the move
                Move move = new Move(boardSut, positionSquareOrigin, positionSquareDestiny);

                // expected boolean from origin and destiny position
                boolean isMoveExpected = expectedOriginPosition & expectedDestinyPosition;

                // call the correct method of sut
                boolean isMoveReceived = boardSut.isMoveOnInsideBoard(move);

                assertEquals(isMoveReceived, isMoveExpected);
            }
        }
    }


    @Test
    public void shouldReturnsFalseWithFailedCrossSuccess() {

        // loop for origin case
        for (Map.Entry<List<Integer>, Boolean> originCase  : failedCases.entrySet()) {
            // create the PositionSquare origin
            int originPositionX = originCase.getKey().get(0);
            int originPositionY = originCase.getKey().get(1);
            boolean expectedOriginPosition = originCase.getValue();
            PositionSquare positionSquareOrigin = new PositionSquare(originPositionX, originPositionY);

            // loop for destiny case
            for (Map.Entry<List<Integer>, Boolean> destinyCase  : successfulCases.entrySet()) {
                // create the Position origin
                int originDestinyX = destinyCase.getKey().get(0);
                int originDestinyY = destinyCase.getKey().get(1);
                boolean expectedDestinyPosition = destinyCase.getValue();
                PositionSquare positionSquareDestiny = new PositionSquare(originDestinyX, originDestinyY);

                // create the move
                Move move = new Move(boardSut, positionSquareOrigin, positionSquareDestiny);

                // expected boolean from origin and destiny position
                boolean isMoveExpected = expectedOriginPosition & expectedDestinyPosition;

                // call the correct method of sut
                boolean isMoveReceived = boardSut.isMoveOnInsideBoard(move);

                assertEquals(isMoveReceived, isMoveExpected);
            }
        }
    }
}




