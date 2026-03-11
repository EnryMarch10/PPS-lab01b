package it.unibo.pps.e2;

public interface Logics {

    /**
     * Attempt to move Knight on position (row, col), if possible.
     *
     * @return whether the pawn has been hit.
     */
    boolean hit(int row, int col);

    /**
     * @return whether position row, col has the knight.
     */
    boolean hasKnight(int row, int col);

    /**
     * @return whether position row, col has the pawn.
     */
    boolean hasPawn(int row, int col);
}
