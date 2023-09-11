package com.checker.api.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class BoardTest {

    Board board;


    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    public void shouldReturnTrueIfPositinOnTheBoard() {
        int onBoardPositionX = 0;
        int onBoardPositionY = 0;
        PositionSquare positionSquare = new PositionSquare(onBoardPositionX, onBoardPositionY);
        boolean offTheBoard =  board.isOnInsideBoard(positionSquare);
        assertTrue(offTheBoard);
    }

    @Test
    public void shouldReturnFalseIfPositinOffTheBoard() {
        int offBoardPositionX = Board.SIZE_BOARD;
        int offBoardPositionY = Board.SIZE_BOARD;
        PositionSquare positionSquare = new PositionSquare(offBoardPositionX, offBoardPositionY);
        boolean offTheBoard =  board.isOnInsideBoard(positionSquare);
        assertFalse(offTheBoard);
    }
}
