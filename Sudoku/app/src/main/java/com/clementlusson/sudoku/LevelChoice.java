package com.clementlusson.sudoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelChoice extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        Button but1 = (Button) findViewById(R.id.level1);
        but1.setOnClickListener(this);
        Button but2 = (Button) findViewById(R.id.level2);
        but2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent(this, GridChoice.class);
        Bundle bun = new Bundle();

        if (id == R.id.level1) {
            bun.putInt("levelKey",1);

        } else if (id == R.id.level2) {
            bun.putInt("levelKey",2);
        }
        intent.putExtras(bun);
        startActivity(intent);
    }
}
