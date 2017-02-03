package com.clementlusson.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Random;

public class GridChoice extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent defineIntent = new Intent(GridChoice.this, ChargeGrid.class);
            startActivity(defineIntent);
    }

    public class vGrille{
        int level;
        int num;
        int done;

        public vGrille (){

        }
        public vGrille(int level, int num, int done){
            this.level = level;
            this.num = num;
            this.done = done;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bun  =  this.getIntent().getExtras();
        setContentView(R.layout.activity_grid_choice);

        if (bun != null)
        {
                ListView liste = (ListView) findViewById(R.id.liste);
                ArrayList<vGrille> values = new ArrayList<vGrille>();
                Random rand = new Random();

                for (int i = 0; i < 3; i++) {
                    values.add(new vGrille(bun.getInt("levelKey"),i+1,rand.nextInt(100)));
                }
                MyAdapter adapter = new MyAdapter(this,values);
                liste.setAdapter(adapter);
                liste.setOnItemClickListener(this);
        }
    }
}
