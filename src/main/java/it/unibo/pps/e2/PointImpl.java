package it.unibo.pps.e2;

public class PointImpl extends PairImpl<Integer, Integer> implements Point {

    public PointImpl(Integer x, Integer y) {
        super(x, y);
    }

    public interface Pawn extends Point {
        static Pawn of(Integer x, Integer y) {
            return new PawnImpl(x, y);
        }
    }

    public static class PawnImpl extends PointImpl implements Pawn {
        public PawnImpl(Integer x, Integer y) {
            super(x, y);
        }
    }

    public interface Knight extends Point {
        static Knight of(Integer x, Integer y) {
            return new KnightImpl(x, y);
        }

        boolean isMoveValid(int x, int y);
    }

    public static class KnightImpl extends PointImpl implements Knight {
        public KnightImpl(Integer x, Integer y) {
            super(x, y);
        }

        @Override
        public boolean isMoveValid(final int x, final int y) {
            int diffX = x - this.getX();
            int diffY = y - this.getY();
            return diffX != 0 && diffY != 0 && Math.abs(diffX) + Math.abs(diffY) == 3;
        }
    }
}
