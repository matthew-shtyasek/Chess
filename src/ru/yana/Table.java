package ru.yana;

public class Table {
    private static Table instance;
    private Figure[][] table = new Figure[8][8];

    private Table() {
        arrangeByDefault();
    }

    public static Table getInstance() {
        if (instance == null) {
            instance = new Table();
        }
        return instance;
    }

    public void arrangeByDefault() {
        table[0][0] = new Rook(false);
        table[0][7] = new Rook(false);
        table[7][0] = new Rook(true);
        table[7][7] = new Rook(true);
        //throw new RuntimeException("Мы не можем расставить фигуры, логика не прописана");
    }

    public Figure[][] getTable() {
        return table;
    }

    public int[] findFigure(Figure figure) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == figure) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    public boolean isFigureInPos(int row, int col) {
        return table[row][col] != null;
    }

    public void moveFigure(Figure figure, int row, int col) {
        int[] coords = findFigure(figure);
        if (!(isCoordsCorrect(coords))) { //new int[] {row, col}
            throw new IllegalArgumentException("Фигуры нет в таблице.");
        }
        if (!isCoordsCorrect(row, col)) {
            throw new IndexOutOfBoundsException("Неверные координаты.");
        }
        table[row][col] = figure;
        table[coords[0]][coords[1]] = null;
    }

    public boolean isCoordsCorrect(int[] coords) {
        return isCoordsCorrect(coords[0], coords[1]);
    }

    public boolean isCoordsCorrect(int row, int col) {
        return (row >=0 && row < table.length)
                && (col >=0 && col < table.length);
    }
}
