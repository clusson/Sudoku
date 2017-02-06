package com.clementlusson.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;


public class GridDraw extends View implements View.OnTouchListener{
    NumberSelect selectedNumber = null;

    Cell[][] arrCell = new Cell [9][9];

    NumberSelect[] arrNumber = new NumberSelect[9];
    vGrid grid;
    Integer startFillGrid;
    Integer totalFillGrid;


    public GridDraw(Context context, AttributeSet attrs) {
        super(context, attrs);

        grid = ((Grid) context).getGrid();
        int i = 0;
        for(int col = 0; col < 9; col++){
            for (int row = 0 ; row < 9; row++){
                Cell c = new Cell(new CellNumber(Character.getNumericValue(grid.grid.toCharArray()[i])), new Pair(row, col), 100 * col, 100 * row, (100 * col + 100), (100 * row + 100));
                arrCell[row][col] = c;
                i += 1;
            }
        }
        //draw numbers as keypad
        for(int key = 0; key < 9; key++){
            arrNumber[key] = new NumberSelect(key + 1, 100 * key + 10, 1000,  100 * key + 100,1100);
        }

        startFillGrid = getFillingGrid();
    }


    @Override
    public void onDraw(Canvas canvas){

        super.onDraw(canvas);
        setOnTouchListener(this);

        for(Cell[] carr : arrCell){
            for(Cell c : carr){
                c.draw(canvas);
            }
        }

        Paint paint = new Paint();
        paint.setStrokeWidth(2);
        for (int row = 0 ; row < 9; row++) {
            if(row % 3 == 0){
                canvas.drawLine(0, row * 100, 900, row * 100, paint);
            }
        }
        for (int col = 0 ; col < 9; col++) {
            if(col % 3 == 0){
                canvas.drawLine(col * 100, 0, col * 100, 900, paint);
            }
        }


        for(NumberSelect se : arrNumber){
            se.draw(canvas);
        }

    }
    

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int) event.getX();
        int y =(int) event.getY();
        Cell selectedcase = null;


        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                for(NumberSelect c : arrNumber){
                    if(c.isSelected(x, y)){
                        selectedNumber = c;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                for(Cell[] carr : arrCell){
                    for(Cell c : carr){
                        if(selectedNumber != null && c.isSelected(x, y)){
                            selectedcase = c;
                        }
                    }
                }

                if(selectedcase != null){
                    ArrayList<Cell> arrC = getGroupe(selectedcase);
                    boolean good = true;
                    for(Cell c : arrC){
                        if(c.i.nb == selectedNumber.i){
                            good = false;
                        }
                    }
                    //Check if win
                    if(good){
                        selectedcase.i.setNumber(selectedNumber.i);
                        totalFillGrid = getFillingGrid();
                        grid.done = (totalFillGrid - startFillGrid) / (81 - startFillGrid) * 100;
                        grid.grid = getGrid();
                    }

                }
                selectedNumber = null;
                break;
        }

        this.invalidate();
        return true;
    }

    public int getFillingGrid(){
        int r = 0;
        for(Cell[] arr : this.arrCell){
            for(Cell c : arr){
                if(c.i.nb != 0){
                    r+=1;
                }
            }
        }
        return r;
    }

    public String getGrid(){
        StringBuilder s = new StringBuilder();
        for(Cell[] arr : this.arrCell){
            for(Cell c : arr){
                if(c.i.nb != 0){
                    s.append(c.i.change);
                }
            }
        }
        return s.toString();
    }

    public ArrayList<Cell> getGroupe(Cell c){
        ArrayList<Cell> ar = new ArrayList<>();
        for(Cell[] arrC : this.arrCell){
            for(Cell cell : arrC){
                if(c.isOnGroup(cell)){
                    ar.add(cell);
                }
            }
        }
        return ar;
    }
}