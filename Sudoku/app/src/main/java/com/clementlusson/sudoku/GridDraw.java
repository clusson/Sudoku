package com.clementlusson.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class GridDraw extends View implements View.OnTouchListener{
    NumberSelect selectedNumber = null;

    Cell[][] arrCell = new Cell [9][9];
    NumberSelect[] arrNumber = new NumberSelect[9];
    Integer totalFillGrid;
    Integer startFillGrid;
    vGrille grid;


    public GridDraw(Context context, AttributeSet attrs) {
        super(context, attrs);

        grid = ((GridChoice) context).getGrid();
        int i = 0;
        for(int column = 0; column < 9; column++){
            for (int row = 0 ; row < 9; row++){
                Cell c = new Cell(new CellNumber(Character.getNumericValue(grid.grid.toCharArray()[i])), new Pair(row, column), 100 * column, 100 * row, (100 * column + 100), (100 * row + 100));
                arrCell[row][column] = c;
                i += 1;
            }
        }
        startFillGrid = getRemplissageGrid();
        for(int place = 0; place < 9; place++){
            arrNumber[place] = new NumberSelect(place + 1, 100 * place, 880 , 0, 100 * place);
        }
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
        for (int column = 0 ; column < 9; column++) {
            if(column % 3 == 0){
                canvas.drawLine(column * 100, 0, column * 100, 900, paint);
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
                    boolean ok = true;
                    for(Cell c : arrC){
                        if(c.i.content == selectedNumber.i){
                            Log.d("Case", "case " + c.position.first + " " + c.position.second + " content : " + c.i.content);
                            ok = false;
                        }
                    }
                    if(ok){
                        selectedcase.i.setNumber(selectedNumber.i);
                        totalFillGrid = getRemplissageGrid();
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

    public int getRemplissageGrid(){
        int r = 0;
        for(Cell[] arrC : this.arrCell){
            for(Cell currentC : arrC){
                if(currentC.i.content != 0){
                    r+=1;
                }
            }
        }
        return r;
    }

    public String getGrid(){
        StringBuilder r = new StringBuilder();
        for(Cell[] arrC : this.arrCell){
            for(Cell currentC : arrC){
                if(currentC.i.content != 0){
                    r.append(currentC.i.content);
                }
            }
        }
        return r.toString();
    }

    public ArrayList<Cell> getGroupe(Cell c){
        ArrayList<Cell> rt = new ArrayList<>();
        for(Cell[] arrC : this.arrCell){
            for(Cell currentC : arrC){
                if(c.isOnGroup(currentC)){
                    rt.add(currentC);
                }
            }
        }
        return rt;
    }
}