package com.clementlusson.sudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Grid extends AppCompatActivity {

    vGrid grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle objetbunble = this.getIntent().getExtras();
        grid = (vGrid) objetbunble.getSerializable("grid");

        setContentView(R.layout.activity_grid);
    }

    public vGrid getGrid ()
    {
        return grid;

    }
}
