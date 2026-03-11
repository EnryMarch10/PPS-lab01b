package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private final static int SIZE = 5;
    private Logics logic;
    private final Point pawn = Point.of(2, 2);
    private final Point knight_start = Point.of(0, 1);

    @BeforeEach
    void init() {
        this.logic = new LogicsImpl(SIZE, knight_start, pawn);
        assertTrue(logic.hasKnight(knight_start.getX(), knight_start.getY()));
        assertTrue(logic.hasPawn(pawn.getX(), pawn.getY()));
    }

    @Test
    public void invalidGame() {
        assertThrows(IndexOutOfBoundsException.class, () -> new LogicsImpl(SIZE, Point.of(-1, -1), pawn));
        assertThrows(IndexOutOfBoundsException.class, () -> new LogicsImpl(SIZE, knight_start, Point.of(-1, -1)));
        assertThrows(IllegalStateException.class, () -> new LogicsImpl(SIZE, knight_start, knight_start));
    }

    @Test
    public void tryGame() {
        final Pair<Integer, Integer> knightMove1 = Pair.of(1, 3);
        final Pair<Integer, Integer> knightMove2 = knight_start;
        final Pair<Integer, Integer> knightMove3 = pawn;

        final Pair<Integer, Integer> knightMoveInvalid = Pair.of(4, 4);

        // MOVE 1
        assertFalse(logic.hit(knightMove1.getX(), knightMove1.getY()));
        assertFalse(logic.hasKnight(knight_start.getX(), knight_start.getY()));
        assertTrue(logic.hasKnight(knightMove1.getX(), knightMove1.getY()));
        // MOVE INVALID
        assertFalse(logic.hit(knightMoveInvalid.getX(), knightMoveInvalid.getY()));
        // MOVE 2
        assertFalse(logic.hit(knightMove2.getX(), knightMove2.getY()));
        assertFalse(logic.hasKnight(knightMove1.getX(), knightMove1.getY()));
        assertTrue(logic.hasKnight(knightMove2.getX(), knightMove2.getY()));
        // MOVE 3
        assertTrue(logic.hit(knightMove3.getX(), knightMove3.getY()));
    }
}
