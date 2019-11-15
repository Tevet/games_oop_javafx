package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;

public class LogicTest {
    private void buildTestTeam (Logic logic) {
        logic.add(new PawnBlack(Cell.A7));
        logic.add(new PawnBlack(Cell.B7));
        logic.add(new PawnBlack(Cell.C6));
        logic.add(new PawnBlack(Cell.D7));
        logic.add(new PawnBlack(Cell.E6));
        logic.add(new PawnBlack(Cell.F7));
        logic.add(new PawnBlack(Cell.G7));
        logic.add(new PawnBlack(Cell.H7));
        logic.add(new RookBlack(Cell.A8));
        logic.add(new KnightBlack(Cell.B8));
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new QueenBlack(Cell.D8));
        logic.add(new KingBlack(Cell.E8));
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new KnightBlack(Cell.G8));
        logic.add(new RookBlack(Cell.H8));
    }

    @Test
    public void wayIsFreeNotDiagonal() {
        Logic logic = new Logic();
        this.buildTestTeam(logic);
        boolean expected = false;
        boolean result = logic.move(Cell.C8, Cell.C7);
        Assert.assertThat(expected, is(result));
    }

    @Test
    public void wayIsClosedAndDiagonal() {
        Logic logic = new Logic();
        this.buildTestTeam(logic);
        boolean expected = false;
        boolean result = logic.move(Cell.C8, Cell.F5);
        Assert.assertThat(expected, is(result));
    }

    @Test
    public void wayIsFreeAndDiagonal() {
        Logic logic = new Logic();
        this.buildTestTeam(logic);
        boolean expected = true;
        boolean result = logic.move(Cell.F8, Cell.A3);
        Assert.assertThat(expected, is(result));
    }
}
