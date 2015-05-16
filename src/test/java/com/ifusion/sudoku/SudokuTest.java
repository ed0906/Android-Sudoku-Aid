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

    private Sudoku sudoku;

    @Test
    public void shouldStartWithEmptyGrid() {
        // Given
        sudoku = new Sudoku(2);

        // Then
        assertEquals(0,sudoku.get(0,0));
    }

    @Test
    public void shouldDisallowIdenticalNumberInSameRow() {
        // Given
        sudoku = new Sudoku(2);

        // Then
        assertTrue(sudoku.set(0,0,1));
        assertFalse(sudoku.set(0,3,1));
    }

    @Test
    public void shouldDisallowIdenticalNumberInSameColumn() {
        // Given
        sudoku = new Sudoku(2);

        // Then
        assertTrue(sudoku.set(0,0,1));
        assertFalse(sudoku.set(3,0,1));
    }

    @Test
    public void shouldDisallowIdenticalNumberInSameSubGrid() {
        // Given
        sudoku = new Sudoku(2);

        // Then
        assertTrue(sudoku.set(0,0,1));
        assertFalse(sudoku.set(1,1,1));
    }
}
