package ru.job4j.chess.figures.black;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class BishopBlackTest {
    @Test
    public void initialPositionTest() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        Assert.assertThat(bishop.position(), is(Cell.C8));

    }

    @Test
    public void copyPositionTest() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        bishop = (BishopBlack) bishop.copy(Cell.E6);
        Assert.assertThat(bishop.position(), is(Cell.E6));
    }

    @Test
    public void isDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.F3);
        boolean result = bishop.isDiagonal(bishop.position(), Cell.C6);
        Assert.assertThat(result, is(true));
    }

    @Test
    public void isNotDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.F3);
        boolean result = bishop.isDiagonal(bishop.position(), Cell.F8);
        Assert.assertThat(result, is(false));
    }

    @Test
    public void C1G5DownRight() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] result = bishop.way(bishop.position(), Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void A8C6DownLeft() {
        BishopBlack bishop = new BishopBlack(Cell.A8);
        Cell[] result = bishop.way(bishop.position(), Cell.C6);
        Cell[] expected = {Cell.B7, Cell.C6};
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void H1C6UpRight() {
        BishopBlack bishop = new BishopBlack(Cell.H1);
        Cell[] result = bishop.way(bishop.position(), Cell.C6);
        Cell[] expected = {Cell.G2, Cell.F3, Cell.E4, Cell.D5, Cell.C6};
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void H1C6UpLeft() {
        BishopBlack bishop = new BishopBlack(Cell.E5);
        Cell[] result = bishop.way(bishop.position(), Cell.B2);
        Cell[] expected = {Cell.D4, Cell.C3, Cell.B2};
        Assert.assertThat(result, is(expected));
    }

}


