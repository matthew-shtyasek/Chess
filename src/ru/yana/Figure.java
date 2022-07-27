package ru.yana;

public abstract class Figure {
    protected boolean isWhite;

    abstract boolean makeMove(int row, int col);

    abstract boolean isMoveExist(int row, int col);
}
