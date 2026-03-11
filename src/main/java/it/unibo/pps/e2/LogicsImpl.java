package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {

    private final Board board;
    private PointImpl.Knight knight;
	private final PointImpl.Pawn pawn;

    public LogicsImpl(final int size) {
    	board = new BoardImpl(size);
        final Point randomPoint1 = board.getRandomPosition();
        pawn = PointImpl.Pawn.of(randomPoint1.getX(), randomPoint1.getY());
        Point randomPoint2 = board.getRandomPosition();
        while (randomPoint2.equals(randomPoint1)) {
            randomPoint2 = board.getRandomPosition();
        }
        knight = PointImpl.Knight.of(randomPoint2.getX(), randomPoint2.getY());
    }

    public LogicsImpl(final int size, final Point knight, final Point pawn) {
        board = new BoardImpl(size);
        if (!board.isValid(knight) || !board.isValid(pawn)) {
            throw new IndexOutOfBoundsException();
        }
        if (pawn.equals(knight)) {
            throw new IllegalStateException();
        }
        this.pawn = PointImpl.Pawn.of(pawn.getX(), pawn.getY());
        this.knight = PointImpl.Knight.of(knight.getX(), knight.getY());
    }

	@Override
	public boolean hit(final int row, final int col) {
        if (!board.isValid(Point.of(row, col))) {
            throw new IndexOutOfBoundsException();
        }
		if (knight.isMoveValid(row, col)) {
            knight = PointImpl.Knight.of(row,col);
            return pawn.equals(knight);
        }
		return false;
	}

	@Override
	public boolean hasKnight(final int row, final int col) {
		return knight.equals(Point.of(row,col));
	}

	@Override
	public boolean hasPawn(final int row, final int col) {
		return pawn.equals(Point.of(row,col));
	}
}
