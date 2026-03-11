package it.unibo.pps.e2;

import java.util.Random;

public class BoardImpl implements Board {

    private static final Random random = new Random();
    private final int side;

    public BoardImpl(final int side) {
        if (side <= 0) {
            throw new IllegalArgumentException("A board cannot have zero or negative side");
        }
        this.side = side;
    }

    @Override
    public boolean isValid(final Point point) {
        return point.getX() >= 0 && point.getY() >= 0 && point.getX() < side && point.getY() < side;
    }

    @Override
    public Point getRandomPosition() {
        return Point.of(random.nextInt(side), random.nextInt(side));
    }
}
