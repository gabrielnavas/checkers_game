package com.checker.api.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        final Exception ex = assertThrows(Exception.class, () -> {
            player.makeMove(move);
            verify(move).isValid();
        });

        assertEquals(ex.getMessage(), "can not do this move");
    }

    @Test
    public void verifyCallExecuteMoveIfIsValidReturnTrue() {
        when(move.isValid()).thenReturn(true);

        assertThrows(Exception.class, () -> {
            player.makeMove(move);
            verify(move).execute();
        });
    }
}
