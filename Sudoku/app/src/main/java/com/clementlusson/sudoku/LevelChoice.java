package com.clementlusson.sudoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ALevelChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        Bundle objetbunble = this.getIntent().getExtras(); //get value
        Integer lvlId = (Integer) objetbunble.getSerializable("lvl");

        int fileResourceId = 0;
        int lvl = 0;
        switch(lvlId){
            case(R.id.lvl1):
                fileResourceId =R.raw.one;
                lvl = 1;
                break;
            case(R.id.lvl2):
                fileResourceId = R.raw.two;
                lvl = 2;
                break;
        }

        // get .txt files to create a new vGrid
        InputStream is = this.getResources().openRawResource(fileResourceId);

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder out = new StringBuilder();
        String line;
        int i = 1;

        final ArrayList<vGrid> grid = new ArrayList<>();

        try {
            while ((line = reader.readLine()) != null) {
                out.append(line);
                grid.add(new vGrid(lvl, i, 0, line));
                i += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        ListView list = (ListView) findViewById(R.id.list);
        final LevelChoice self = this;

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intention = new Intent(self, Grid.class);
                Bundle bdn = new Bundle();
                bdn.putSerializable("grid", grid.get(position));
                intention.putExtras(bdn);
                startActivity(intention);
            }
        });

        list.setAdapter(new MyAdapter(this, grid));

    }
}
