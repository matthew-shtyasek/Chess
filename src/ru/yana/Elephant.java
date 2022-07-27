package ru.yana;

public class Elephant extends Figure{
    Elephant (boolean isWhite) {
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
            !( coords[0] == row )
            && !( coords[1] == col )
            && !( Math.abs(row - coords[0]) == Math.abs(col - coords[1]) ) //todo: == rol || col for queen
        ) {
            return false;
        }
        if (coords[0] == row) {
            int inc = col - coords[1];
            for ( int column = coords[1]+inc; column != col+inc; column += inc ) {
                if (table.isFigureInPos(row, column)) {
                    return false;
                }
            }
        }
        else if (coords[1] == col) {
            int inc = row - coords[0];
            for ( int rowt = coords[0]+inc; rowt != row+inc; rowt += inc ) {
                if (table.isFigureInPos(rowt, col)) {
                    return false;
                }
            }
        }
        else {
            int incrow = row - coords[0];
            int inccol = col - coords[1];
            int column = coords[1]+inccol;
            for ( int rowt = coords[0]+incrow; rowt != row+incrow; rowt += incrow ) {
                if (table.isFigureInPos(rowt, column)) {
                    return false;
                }
                column += inccol;
            }
        }
        return true;
    }
}
