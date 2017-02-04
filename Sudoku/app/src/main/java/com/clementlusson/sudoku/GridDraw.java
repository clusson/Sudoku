package com.clementlusson.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridDraw extends View implements View.OnTouchListener{
    private static final String TAG = "Sudoku";
    private static final int GRID_MARGIN = 5;
    private int top, bottom, left, right;


    private ChargeGrid game;
    private int largeur;
    private int hauteur;

    String grid ="001700509573024106800501002700295018009400305652800007465080071000159004908007053";


    public GridDraw(Context context, AttributeSet attrs) {
        super(context,attrs);
        this.setOnTouchListener(this);
        this.game = (ChargeGrid) context;

    }


    @Override
    public void onDraw(Canvas canvas){

        Paint grid = new Paint();

        grid.setColor(Color.GRAY);
        grid.setStyle(Paint.Style.STROKE);


        //Taille des cases
        int gm = 80;

        for (int r=0; r<9; r++)
        {
            for (int c =0; c<9; c++ )
            {
                top = r*gm;
                bottom = top+gm;
                left = c*gm;
                right = left+gm;
                canvas.drawRect(left, top, right, bottom, grid);
            }
        }

        for (int i=0; i<9; i++)
        {
            top = 10*gm;
            bottom = top+gm;
            left = i*gm;
            right = left+gm;
            canvas.drawRect(left, top, right, bottom, grid);
            grid.setTextSize(55);
            canvas.drawText(String.valueOf(i+1),right-gm+23,bottom-20,grid);

        }

        largeur = canvas.getWidth();
        hauteur = canvas.getHeight();

        Rect rect = new Rect();

    }
    

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int) (event.getX()/80) +1;
        int y = (int) (event.getY()/80) +1;

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                Toast.makeText(this.getContext(),"X" + x + " | Y" +y,Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_MOVE:

                break;

            case MotionEvent.ACTION_UP:

                break;
        }
        this.invalidate();

        return true;
    }
}