package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {                     // Этот метод используется для получения позиции фигуры на поле. Он возвращает тип перечисления.
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            return new Cell[0];
        } else {
            int size = Math.abs(source.x - dest.x);
            Cell[] steps = new Cell[size];
            int sourceIndex = source.ordinal();
            int destIndex = dest.ordinal();
            int reverseMod = (sourceIndex < destIndex) ? 1 : -1;    //движение назад по списку элементов
            int step = 9 * reverseMod;                              //шаг для диагонали направлением на ЮВ или СЗ
            if ((source.y > dest.y && reverseMod > 0) || (source.y < dest.y && reverseMod < 0)) {
                step = 7 * reverseMod;                              //шаг для диагонали направлением на ЮЗ или СВ
            }
            for (int i = 0; i < steps.length; i++) {
                sourceIndex += step;
                steps[i] = Cell.values()[sourceIndex];
            }
            return steps;
        }
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        int resultX = Math.abs(source.x - dest.x);
        int resultY = Math.abs(source.y - dest.y);
        if (resultX == resultY) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
