package com.checker.api.domain;

import com.checker.api.domain.exceptions.PositionSquareIsNotInsideBoardException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerTest {

    @Mock
    Move move;

    @InjectMocks
    PlayerRed player;

    @Test
    public void verifyCallIsValidMoveCalled() throws Exception {
        when(move.isValid()).thenReturn(true);

        player.makeMove(move);
        verify(move).isValid();
    }

    @Test
    public void throwExceptionIfIsValidReturnFalse() {
        when(move.isValid()).thenReturn(false);

        final PositionSquareIsNotInsideBoardException ex = assertThrows(PositionSquareIsNotInsideBoardException.class, () -> {
            player.makeMove(move);
            verify(move).isValid();
        });

        assertEquals(ex.getMessage(), PositionSquareIsNotInsideBoardException.DEFAULT_MESSAGE);
    }

    @Test
    public void verifyCallExecuteMoveIfIsValidReturnTrue() throws Exception {
        when(move.isValid()).thenReturn(true);
        player.makeMove(move);
    }
}
