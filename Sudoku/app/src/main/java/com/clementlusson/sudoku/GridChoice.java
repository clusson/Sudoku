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

public class GridChoice extends AppCompatActivity implements AdapterView.OnItemClickListener {


    public void getGame ()
    {
        try {
            // Create a URL for the desired page
            URL url = new URL("levels/0.txt");

            // Read all the text returned by the server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Activity lecontext = this;
            getGame();
            Intent defineIntent = new Intent(GridChoice.this, ChargeGrid.class);
            defineIntent.putExtra("vGrille", new vGrille(1,1,0));
            lecontext.startActivity(defineIntent);
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
