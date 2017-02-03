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
    private int XOfSelection = 0;
    private int YOfSelection = 0;
    private float tileWidth = 0f;
    private float tileHeight = 0f;
    private Rect rect = new Rect();
    private int tab [][];
    private GridChoice mParams;
    private int largeur;
    private int hauteur;



    public GridDraw(Context context, AttributeSet attrs) {
        super(context,attrs);
    }


    @Override
    public void onDraw(Canvas canvas){

        Paint grid = new Paint();

        grid.setColor(Color.GRAY);
        grid.setStyle(Paint.Style.STROKE);
        grid.setStrokeWidth(4);

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
        largeur = canvas.getWidth();
        hauteur = canvas.getHeight();

    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:


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