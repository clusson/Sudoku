package com.clementlusson.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class GridChoice extends AppCompatActivity {

    vGrille grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle objetbunble = this.getIntent().getExtras();
        grid = (vGrille) objetbunble.getSerializable("grid");

        setContentView(R.layout.activity_grid_choice);
    }

    public vGrille getGrid ()
    {
        return grid;

    }
}
