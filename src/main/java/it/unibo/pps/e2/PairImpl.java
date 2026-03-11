package it.unibo.pps.e2;

/*
 * A standard generic Pair<X,Y>, with getters, hashCode, equals, and toString well implemented.
 */
public class PairImpl<X,Y> implements Pair<X, Y> {

	private final X x;
	private final Y y;

	public PairImpl(X x, Y y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
    public X getX() {
		return x;
	}

	@Override
    public Y getY() {
		return y;
	}

    @Override
	public int hashCode() {
        int result = (x != null ? x.hashCode() : 0);
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
	}

	@Override
	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Pair<?, ?> other)) return false;
        return (x == null ? other.getX() == null : x.equals(other.getX()))
            && (y == null ? other.getY() == null : y.equals(other.getY()));
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}
}
