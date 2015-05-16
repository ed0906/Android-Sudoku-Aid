package com.ifusion.sudoku;

/**
 * Created by Ed on 16/05/2015.
 */
public class SudokuGrid {

    private final int baseSize;
    private final int size;
    private final int[][] grid;

    public SudokuGrid(int baseSize) {
        this.baseSize = baseSize;
        this.size = baseSize * baseSize;
        this.grid = new int[size][size];
    }

    public int size() {
        return this.size;
    }

    public int baseSize() {
        return this.baseSize;
    }

    public int getCell(int row, int column) {
        return grid[row][column];
    }

    public int[] getRow(int index) {
        return grid[index];
    }

    public int[] getColumn(int index) {
        int[] contents = new int[size];
        for(int rowIndex = 0; rowIndex < size; rowIndex ++) {
            contents[rowIndex] = grid[rowIndex][index];
        }
        return contents;
    }

    public int[] getSubGrid(int y, int x) {
        int[] contents = new int[size];

        //Top left coordinate of sub grid
        int row = y * baseSize;
        int column = x * baseSize;

        int n = 0;
        for(int rowIndex = row; rowIndex < row + baseSize; rowIndex++) {
            for(int colIndex = column; colIndex < column + baseSize; colIndex++) {
                contents[n] = grid[rowIndex][colIndex];
                n++;
            }
        }

        return contents;
    }

    public boolean setCell(int row, int column, int value) {
        // Boundaries
        if(row < 0 || column < 0 || row > size() - 1 || column > size() - 1) {
            return false;
        }

        //Rows
        for(int cell : getRow(row)) {
            if(cell == value) {
                return false;
            }
        }

        //Columns
        for(int cell : getColumn(column)) {
            if(cell == value) {
                return false;
            }
        }

        //Subgrid
        int subGridRowIndex = row / baseSize();
        int subGridColumnIndex = column / baseSize();
        for(int cell : getSubGrid(subGridRowIndex,subGridColumnIndex)) {
            if(cell == value) {
                return false;
            }
        }

        grid[row][column] = value;
        return true;
    }
}
