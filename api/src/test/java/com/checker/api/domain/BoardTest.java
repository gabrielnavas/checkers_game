package com.checker.api.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BoardTest {

    Board board;


    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    public void shouldReturnTrueOfFalseAtPosition() {
        Map<List<Integer>, Boolean> testsCases = new HashMap<>() {{
            put(Arrays.asList(-1, -1), false);
            put(Arrays.asList(Board.START_POSITION_BOARD-1, Board.START_POSITION_BOARD-1), false);
            put(Arrays.asList(8, 8), false);
            put(Arrays.asList(Board.END_POSITION_BOARD+1, Board.END_POSITION_BOARD-1), false);
            put(Arrays.asList(0, 0), true);
            put(Arrays.asList(7, 7), true);
            put(Arrays.asList(-1, 0), false);
            put(Arrays.asList(7, 8), false);
        }};

        for (Map.Entry<List<Integer>, Boolean> a : testsCases.entrySet()) {
            int positionX = a.getKey().get(0);
            int positionY = a.getKey().get(1);

            PositionSquare positionSquare = new PositionSquare(positionX, positionY);

            boolean expected = a.getValue();
            boolean received =  board.isOnInsideBoard(positionSquare);

            assertEquals(received, expected);
        }
    }
}
