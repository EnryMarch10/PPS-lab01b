package it.unibo.pps.e2;

public interface Pair<X, Y> {
    static <X, Y> Pair<X,Y> of(X x, Y y) {
        return new PairImpl<>(x, y);
    }
    X getX();
    Y getY();
}
