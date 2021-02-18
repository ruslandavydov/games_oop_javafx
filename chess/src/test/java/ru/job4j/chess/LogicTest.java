package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.PawnWhite;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class LogicTest {

    @Test
    public void whenBishopBlackMoveRightUpThenTrue()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.move(Cell.F8, Cell.D6);
    }

    @Test
    public void whenBishopBlackMoveLeftDownThenTrue()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.D6));
        logic.move(Cell.D6, Cell.F8);
    }

    @Test
    public void whenBishopBlackPositionFinishEqStart() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell result = bishopBlack.position();
        Cell expect = Cell.C1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenBishopBlackWayThenCellSteps() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expect = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenKingBlackMoveForwardThenTrue()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new KingBlack(Cell.E8));
        logic.move(Cell.E8, Cell.E7);
    }

    @Test
    public void whenRookMoveForwardThenTrue()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new RookBlack(Cell.G6));
        logic.move(Cell.G6, Cell.G3);
    }

    @Test
    public void whenRookMoveRightThenTrue()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new RookBlack(Cell.G6));
        logic.move(Cell.G6, Cell.D6);
    }

    @Test
    public void whenPawnBlackMoveForwardThenTrue()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new PawnBlack(Cell.G7));
        logic.move(Cell.G7, Cell.G6);
    }

    @Test
    public void whenPawnWhiteMoveForwardThenTrue()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new PawnWhite(Cell.A2));
        logic.move(Cell.A2, Cell.A3);
    }

    @Test
    public void whenPawnBlackWayThenCellSteps() {
        PawnBlack pawnBlack = new PawnBlack(Cell.A7);
        Cell[] result = pawnBlack.way(Cell.A6);
        Cell[] expect = {Cell.A6};
        assertThat(result, is(expect));
    }

    @Test
    public void whenQueenBlackMoveForwardThenTrue()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new QueenBlack(Cell.E8));
        logic.move(Cell.E8, Cell.E3);
    }

    @Test
    public void whenKnightBlackMoveForwardThenTrue()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new KnightBlack(Cell.F5));
        logic.move(Cell.F5, Cell.G7);
    }
}
