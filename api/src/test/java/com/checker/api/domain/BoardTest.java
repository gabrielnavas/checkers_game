package com.checker.api.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BoardTest {

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
            put(Arrays.asList(Board.END_POSITION_BOARD+1, Board.END_POSITION_BOARD-1), false);
            put(Arrays.asList(-1, 0), false);
            put(Arrays.asList(7, 8), false);
        }};
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




