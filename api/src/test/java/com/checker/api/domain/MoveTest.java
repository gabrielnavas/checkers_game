package com.checker.api.domain;

import com.checker.api.domain.exceptions.PositionSquareIsNotInsideBoardException;
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

        when(board.isOnInsideBoard(positionSquareOrigin)).thenReturn(true);
        when(board.isOnInsideBoard(positionSquareDestiny)).thenReturn(true);
    }


    @Test
    public void shouldCallIsOnInsideBoardWithCorrectSquareOriginAndSquareDestiny() {
        move.isValid();
        verify(board, times(1)).isOnInsideBoard(positionSquareOrigin);
        verify(board, times(1)).isOnInsideBoard(positionSquareDestiny);
    }

    @Test
    public void shouldThrowExceptionsIfIsOnInsideBoarWithOriginReturnsFalse() {
        when(board.isOnInsideBoard(positionSquareOrigin)).thenReturn(false);

        final PositionSquareIsNotInsideBoardException ex;
        ex = assertThrows(PositionSquareIsNotInsideBoardException.class, () -> {
            move.isValid();
        });

        assertEquals(ex.getMessage(), PositionSquareIsNotInsideBoardException.DEFAULT_MESSAGE);
    }

    @Test
    public void shouldThrowExceptionsIfIsOnInsideBoarWithDestinyReturnsFalse() {
        when(board.isOnInsideBoard(positionSquareDestiny)).thenReturn(false);

        final PositionSquareIsNotInsideBoardException ex;
        ex = assertThrows(PositionSquareIsNotInsideBoardException.class, () -> {
            move.isValid();
        });

        assertEquals(ex.getMessage(), PositionSquareIsNotInsideBoardException.DEFAULT_MESSAGE);
    }
}
