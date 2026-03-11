package it.unibo.pps.e2;

public interface Point extends Pair<Integer, Integer> {
    static Point of(Integer x, Integer y) {
        return new PointImpl(x, y);
    }
    public static <T extends Point> Point from(T point) {
        return new PointImpl(point.getX(), point.getY());
    }
}
