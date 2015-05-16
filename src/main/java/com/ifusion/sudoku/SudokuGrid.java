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

    public boolean set(int row, int column, int value) {
        grid[row][column] = value;
        return true;
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
}
