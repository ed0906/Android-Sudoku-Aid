package com.ifusion.sudoku;

/**
 * Created by Ed on 16/05/2015.
 */

public class Sudoku {
    private final SudokuGrid grid;

    public Sudoku(int baseSize) {
        grid = new SudokuGrid(baseSize);
    }

    public int get(int row, int column) {
        return grid.getCell(row, column);
    }

    public boolean set(int row, int column, int value) {
        // Boundaries
        if(row < 0 || column < 0 || row > grid.size() - 1 || column > grid.size() - 1) {
            return false;
        }

        //Rows
        for(int cell : grid.getRow(row)) {
            if(cell == value) {
                return false;
            }
        }

        //Columns
        for(int cell : grid.getColumn(column)) {
            if(cell == value) {
                return false;
            }
        }

        //Subgrid
        int subGridRowIndex = row / grid.baseSize();
        int subGridColumnIndex = column / grid.baseSize();
        for(int cell : grid.getSubGrid(subGridRowIndex,subGridColumnIndex)) {
            if(cell == value) {
                return false;
            }
        }

        grid.setCell(row, column, value);
        return true;
    }
}
