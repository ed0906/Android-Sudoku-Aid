package com.ifusion.activity;

import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.ifusion.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ed on 16/05/2015.
 */

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class ActivityMainTest {

    private static ActivityMain activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(ActivityMain.class);
    }

    @Test
    public void whenEnterNoCharacter_thenCellShouldStayBlank() {
        // Given
        EditText editText = getCell(0,0);

        // When
        editText.setText("");

        // Then
        assertEquals(0, ShadowToast.shownToastCount());
        assertEquals("", editText.getText().toString());
    }

    @Test
    public void whenEnterInvalidCharacter_thenCellShouldStayBlank() {
        // Given
        EditText editText = getCell(0,0);

        // When
        editText.setText("invalid entry");

        // Then
        assertEquals(1, ShadowToast.shownToastCount());
        assertEquals("", editText.getText().toString());
    }

    private TableLayout tableLayout() {
        return (TableLayout) activity.findViewById(R.id.grid);
    }

    private EditText getCell(int row, int column) {
        return (EditText)((TableRow) tableLayout().getChildAt(row)).getChildAt(column);
    }
}
