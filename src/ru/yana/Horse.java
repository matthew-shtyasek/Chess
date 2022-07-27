package ru.yana;

public class Horse extends Figure {
    Horse (boolean isWhite) {
        this.isWhite = isWhite;
    }

    @Override
    boolean makeMove(int row, int col) {
        if (isMoveExist(row, col)) {
            Table.getInstance().moveFigure(this, row, col);
            return true;
        }
        return false;
    }

    @Override
    boolean isMoveExist(int row, int col) {
        Table table = Table.getInstance();
        int[] coords = table.findFigure(this);
        if (
            !( Math.abs(row - coords[0]) == 1
            && Math.abs(col - coords[1]) == 2 )
            && !( Math.abs(row - coords[0]) == 2
            && Math.abs(col - coords[1]) == 1 )
        ) {
            return false;
        }
        if (table.isFigureInPos(row, col)){
            return false;
        }
        return true;
    }
}
