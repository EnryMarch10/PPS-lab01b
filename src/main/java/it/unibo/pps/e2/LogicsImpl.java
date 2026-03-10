package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {

    private final int size;
    private Pair<Integer,Integer> knight;
	private final Pair<Integer,Integer> pawn;

    public LogicsImpl(final int size) {
    	this.size = size;
        pawn = randomEmptyPosition();
        knight = randomEmptyPosition();
    }

    public LogicsImpl(final int size, final Pair<Integer,Integer> knight, final Pair<Integer,Integer> pawn) {
        this.size = size;
        checkCoordinates(knight.getX(), knight.getY());
        checkCoordinates(pawn.getX(), pawn.getY());
        if (pawn.equals(knight)) {
            throw new IllegalStateException();
        }
        this.pawn = pawn;
        this.knight = knight;
    }

	private Pair<Integer,Integer> randomEmptyPosition() {
        final Random random = new Random();
    	Pair<Integer,Integer> pos = new Pair<>(random.nextInt(size), random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return pawn != null && pawn.equals(pos) ? randomEmptyPosition() : pos;
    }

    private void checkCoordinates(final int row, final int col) {
        if (row < 0 || col < 0 || row >= size || col >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

	@Override
	public boolean hit(final int row, final int col) {
        checkCoordinates(row, col);
		// Below a compact way to express allowed moves for the knight
		int x = row - knight.getX();
		int y = col - knight.getY();
		if (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3) {
			knight = new Pair<>(row,col);
			return pawn.equals(knight);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return knight.equals(Pair.of(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return pawn.equals(Pair.of(row,col));
	}
}
