package com.ifusion.activity.sudoku;

import com.ifusion.sudoku.SudokuGrid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class SudokuGridTest {

    private SudokuGrid grid;

    @Test
    public void givenASudokuGrid_shouldReturnRow() throws Exception {
        // Given
        grid = new SudokuGrid(2);
        grid.set(0,0,1);
        grid.set(0,1,2);
        grid.set(0,2,3);
        grid.set(0,3,4);

        // Then
        assertArrayEquals(new int[]{1, 2, 3, 4}, grid.getRow(0));
    }

    @Test
    public void givenASudokuGrid_shouldReturnColumn() throws Exception {
        // Given
        grid = new SudokuGrid(2);
        grid.set(0,0,1);
        grid.set(1,0,2);
        grid.set(2,0,3);
        grid.set(3,0,4);

        // Then
        assertArrayEquals(new int[] {1,2,3,4}, grid.getColumn(0));
    }

    @Test
    public void givenASudokuGrid_shouldReturnSubGrid() throws Exception {
        // Given
        grid = new SudokuGrid(2);
        grid.set(0,0,1);
        grid.set(0,1,2);
        grid.set(1,0,3);
        grid.set(1,1,4);

        // Then
        assertArrayEquals(new int[] {1,2,3,4}, grid.getSubGrid(0, 0));
    }
}
