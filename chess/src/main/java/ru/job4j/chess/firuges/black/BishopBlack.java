package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int deltaX = position.getX() > dest.getX() ? -1 : 1;
        int deltaY = position.getY() > dest.getY() ? -1 : 1;
        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        for (int i = 0; i < size; i++) {
            int x = position.getX() + (i + 1) * deltaX;
            int y = position.getY() + (i + 1) * deltaY;
            steps[i] = Cell.values()[8 * x + y];
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY()));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
