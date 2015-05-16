package com.ifusion.sudoku;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Created by Ed on 16/05/2015.
 */

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class SudokuTest {

    private SudokuGrid sudoku;

    @Test
    public void shouldStartWithEmptyGrid() {
        // Given
        sudoku = new SudokuGrid(2);

        // Then
        assertEquals(0,sudoku.getCell(0,0));
    }

    @Test
    public void shouldDisallowIdenticalNumberInSameRow() {
        // Given
        sudoku = new SudokuGrid(2);

        // Then
        assertTrue(sudoku.setCell(0,0,1));
        assertFalse(sudoku.setCell(0,3,1));
    }

    @Test
    public void shouldDisallowIdenticalNumberInSameColumn() {
        // Given
        sudoku = new SudokuGrid(2);

        // Then
        assertTrue(sudoku.setCell(0,0,1));
        assertFalse(sudoku.setCell(3,0,1));
    }

    @Test
    public void shouldDisallowIdenticalNumberInSameSubGrid() {
        // Given
        sudoku = new SudokuGrid(2);

        // Then
        assertTrue(sudoku.setCell(0,0,1));
        assertFalse(sudoku.setCell(1,1,1));
    }
}
