package com.checker.api.domain;

import com.checker.api.domain.exceptions.PositionSquareIsNotInsideBoardException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MoveTest {

    @Mock
    Board board;

    @InjectMocks
    PositionSquare positionSquare;

    Move move;

    @BeforeEach
    void setup() {
        move = new Move(board, positionSquare, positionSquare);
    }


    @Test
    public void shouldCallTwiceIsOnInsideBoard() {
        when(board.isOnInsideBoard(positionSquare)).thenReturn(true);

        assertThrows(PositionSquareIsNotInsideBoardException.class, () -> {
            move.isValid();
            verify(board, times(2)).isOnInsideBoard(positionSquare);
        });

    }

    @Test
    public void shouldThrowExceptionsIfIsOnInsideBoardReturnsFalse() {
        when(board.isOnInsideBoard(positionSquare)).thenThrow(new PositionSquareIsNotInsideBoardException());

        final PositionSquareIsNotInsideBoardException ex = assertThrows(PositionSquareIsNotInsideBoardException.class, () -> {
            move.isValid();
        });

        assertEquals(ex.getMessage(), PositionSquareIsNotInsideBoardException.DEFAULT_MESSAGE);
    }
}
