package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        Predicate<Figure3T> func = Figure3T::hasMarkX;
        return isWin(func);
    }

    public boolean isWinnerO() {
        Predicate<Figure3T> func = Figure3T::hasMarkO;
        return isWin(func);
    }

    private boolean isWin (Predicate<Figure3T> func) {
        return this.fillBy(func, 0, 0, 1, 0) ||
                this.fillBy(func, 0, 1, 1, 0) ||
                this.fillBy(func, 0, 2, 1, 0) ||
                this.fillBy(func, 0, 0, 0, 1) ||
                this.fillBy(func, 1, 0, 0, 1) ||
                this.fillBy(func, 2, 0, 0, 1) ||
                this.fillBy(func, 0,0, 1, 1) ||
                this.fillBy(func, this.table.length - 1, 0, -1, 1);
    }

    public boolean hasGap() {
        return !Arrays.stream(table).flatMap(Arrays::stream).allMatch(x -> x.hasMarkO() || x.hasMarkO());
    }
}
