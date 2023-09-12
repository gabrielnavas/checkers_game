package com.checker.api.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class MoveTest {

    @Mock
    Board board;

    @InjectMocks
    PositionSquare positionSquareOrigin;

    @InjectMocks
    PositionSquare positionSquareDestiny;

    Move move;

    @BeforeEach
    void setup() {
        move = new Move(board, positionSquareOrigin, positionSquareDestiny);
        when(board.isMoveOnInsideBoard(move)).thenReturn(true);
    }

    @Test
    public void shouldCallIsMoveOnInsideBoardOnce() {
        move.isValid();
        verify(board, times(1)).isMoveOnInsideBoard(move);
    }

    @Test
    public void shouldCallSquarePositionHasCheckerOnce() {
        move.isValid();
        verify(board, times(1)).squarePositionHasChecker(positionSquareDestiny);
    }

    @Test
    public void shouldIsMoveOnInsideBoardReturnsFalse() {
        when(board.isMoveOnInsideBoard(move)).thenReturn(false);
        boolean isMoveReceived = move.isValid();
        assertFalse(isMoveReceived);
    }

    @Test
    public void shouldIsMoveOnInsideBoardReturnsTrue() {
        boolean isMoveReceived = move.isValid();
        assertTrue(isMoveReceived);
    }

    @Test
    public void shouldSquarePositionHasCheckerReturnsFalse() {
        when(board.squarePositionHasChecker(positionSquareDestiny)).thenReturn(true);
        boolean isMoveReceived = move.isValid();
        assertFalse(isMoveReceived);
    }

    @Test
    public void shouldSquarePositionHasCheckerReturnsTrue() {
        boolean isMoveReceived = move.isValid();
        assertTrue(isMoveReceived);
    }
}
