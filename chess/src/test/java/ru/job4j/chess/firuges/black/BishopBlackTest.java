package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D1);
        Cell actual = bishopBlack.position();
        Cell expected = Cell.D1;
        assertEquals(expected, actual);
    }

    @Test
    void testPositionNotNull() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D1);
        assertNotNull(bishopBlack.position());
    }

    @Test
    void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D1);
        Figure actual = bishopBlack.copy(Cell.E2);
        BishopBlack expected = new BishopBlack(Cell.E2);
        assertEquals(expected.position(), actual.position());
    }

    @Test
    void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] actual = bishopBlack.way(Cell.G5);
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testWhenExeption() {
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    Cell position = Cell.D5;
                    Cell dest = Cell.D6;
                    BishopBlack bishopBlack = new BishopBlack(position);
                    bishopBlack.way(dest);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from D5 to D6");
    }

    @Test
    void testWhenIsNotDiagonal() {
        Cell position = Cell.B3;
        Cell dest = Cell.B4;
        BishopBlack bishopBlack = new BishopBlack(position);
        assertFalse(bishopBlack.isDiagonal(position, dest));
    }
}