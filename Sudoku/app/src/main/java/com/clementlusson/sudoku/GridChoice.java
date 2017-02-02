package com.clementlusson.sudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

class monObject{

    public monObject(){

    }
    public String toString(){
        return " TOTO";
    }
}
public class GridChoice extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bun  =  this.getIntent().getExtras();
        Log.d("MYMESSAGE", bun.toString());
        setContentView(R.layout.activity_grid_choice);

        if (bun != null)
        {
            ListView liste = (ListView) findViewById(R.id.liste);
            String [] values = new String[] {"1", String.valueOf(bun.getInt("levelKey"))};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, values);

            liste.setAdapter(adapter);
        }
    }
}
