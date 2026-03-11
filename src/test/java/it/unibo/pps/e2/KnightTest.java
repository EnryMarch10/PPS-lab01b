package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest {

    private PointImpl.Knight knight;

    @BeforeEach
    void init() {
        knight = new PointImpl.KnightImpl(0, 0);
    }

    @Test
    public void pointsBelong() {
        final Point[] stepsPerColumn = {Point.of(1, 2), Point.of(2, 1)};
        final Random random = new Random();
        IntStream.range(0, 1000).forEach(i -> {
            for (final var step : stepsPerColumn) {
                final int newX = knight.getX() + step.getX() * (random.nextBoolean() ? 1 : -1);
                final int newY = knight.getY() + step.getY() * (random.nextBoolean() ? 1 : -1);

                assertTrue(knight.isMoveValid(newX, newY));
                knight = PointImpl.Knight.of(newX, newY);
            }
        });
    }
}
