package ru.yana;

public class Pawn extends Figure {
    private boolean isFirstMove = true;

    Pawn (boolean isWhite) {
        this.isWhite = isWhite;
    }

    @Override
    boolean makeMove(int row, int col) {
        if (isMoveExist(row, col)) {
            Table.getInstance().moveFigure(this, row, col);
            if (isFirstMove) {
                isFirstMove = false;
            }
            return true;
        }
        return false;
    }

    @Override
    boolean isMoveExist(int row, int col) {
        Table table = Table.getInstance();
        int[] coords = table.findFigure(this);
        if ( ( Math.abs(col - coords[1]) == 1 )
            && ( table.isFigureInPos(row, col) ) ) {
            return true;
        }
        else if ( ( coords[1] == col )
            && ( Math.abs(row - coords[0]) == 1 ) ) {
            return true;
        }
        else if ( isFirstMove
            && (Math.abs(row - coords[0]) == 2)) {
            return true;
        }
        return false;
    }
}
