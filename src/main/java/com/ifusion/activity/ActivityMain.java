package com.ifusion.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import android.view.View.OnClickListener;

import com.ifusion.R;
import com.ifusion.sudoku.SudokuGrid;

public class ActivityMain extends Activity {

    private TableLayout tableLayout;
    private Button solveButton;
    private Button hintButton;
    private SudokuGrid sudoku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableLayout = (TableLayout) super.findViewById(R.id.grid);

        solveButton = (Button) super.findViewById(R.id.button_solve);
        solveButton.setOnClickListener(solveButtonListener());

        hintButton = (Button) super.findViewById(R.id.button_hint);
        hintButton.setOnClickListener(hintButtonListener());

        sudoku = new SudokuGrid(2);

        refreshGrid();
    }

    private void refreshGrid() {
        tableLayout.removeAllViews();
        for (int row = 0; row < sudoku.size(); row++) {
            TableRow tableRow = new TableRow(super.getBaseContext());

            for (int col = 0; col < sudoku.size(); col++) {
                EditText editText = new EditText(super.getBaseContext());
                int cellValue = sudoku.getCell(row, col);
                if(cellValue != 0) {
                    editText.setText("" + cellValue);
                }
                editText.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT,1));
                editText.addTextChangedListener(tableCellListener(row, col));
                tableRow.addView(editText);
            }
            tableLayout.addView(tableRow);
        }
    }

    private OnClickListener solveButtonListener() {
        return new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ActivityMain", "onClick: solve");
            }
        };
    }

    private OnClickListener hintButtonListener() {
        return new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ActivityMain", "onClick: hint");
            }
        };
    }

    private TextWatcher tableCellListener(final int row, final int cell) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    String text = editable.toString();
                    if(text.isEmpty()) {
                        return;
                    }
                    int value = Integer.parseInt(text);
                    if(!sudoku.setCell(row, cell, value)) {
                        Toast.makeText(ActivityMain.this, "Check for duplicates...", Toast.LENGTH_SHORT).show();
                        editable.clear();
                    }
                } catch (Exception e) {
                    Log.e("Main Activity","Failed to convert digit", e);
                    Toast.makeText(ActivityMain.this, "Invalid digit", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }
}
