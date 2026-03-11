package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    private static final int SIDE = 5;
    private Board board;

    @BeforeEach
    void init() {
        board = new BoardImpl(SIDE);
    }

    @Test
    public void pointsBelong() {
        assertTrue(board.isValid(Point.of(0, 0)));
        assertFalse(board.isValid(Point.of(-1, -1)));
        assertFalse(board.isValid(Point.of(3, -1)));
    }

    @Test
    public void randomPosIsValid() {
        IntStream.range(0, 1000).forEach(_ -> assertTrue(board.isValid(board.getRandomPosition())));
    }
}
