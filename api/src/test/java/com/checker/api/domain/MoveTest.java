package com.checker.api.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

        move.isValid();

        verify(board, times(2)).isOnInsideBoard(positionSquare);
    }
}
