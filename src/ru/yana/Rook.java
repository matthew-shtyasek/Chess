package ru.yana;

public class Rook extends Figure {
    Rook (boolean isWhite) {
        this.isWhite = isWhite;
    }

    @Override
    boolean makeMove(int row, int col) {
        Table table = Table.getInstance();
        //isMoveExist();
        if ( !table.isFigureInPos(row, col) && isMoveExist(row,col) ) {
            table.moveFigure(this, row, col);
            return true;
        }
        //Table.getInstance().getTable()
        return false;
    }

    @Override
    boolean isMoveExist(int row, int col) {
        Table table = Table.getInstance();
        int[] coords = table.findFigure(this);

        if ( !( table.isCoordsCorrect(row, col) && table.isCoordsCorrect(coords) ) ) {
            return false;
        }
        if ( ( coords[0] != row && coords[1] != col )
            || ( coords[0] == row && coords[1] == col ) ) {
            return false;
        }

        int inc = row - coords[0];
        if (inc == 0) {
            inc = col - coords[1] > 0 ? 1 : -1;
            for ( int column = coords[1]+inc; column != col+inc; column += inc ) {
                if (table.isFigureInPos(row, column)) {
                    return false;
                }
            }
        }
        else {
            inc = inc > 0 ? 1 : -1;
            for ( int rowt = coords[0]+inc; rowt != row; rowt += inc) {
                if (table.isFigureInPos(rowt, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "r";
    }

    public static void main(String[] args) {
        Table table = Table.getInstance();
        printTable(table);
        table.getTable()[7][0].makeMove(7, 6);
        printTable(table);
    }

    public static void printTable(Table table) {
        for ( Figure[] row : table.getTable() ) {
            for ( Figure figure : row ) {
                System.out.printf(" %s ", figure);
            }
            System.out.println();
        }
        System.out.println();
    }
}