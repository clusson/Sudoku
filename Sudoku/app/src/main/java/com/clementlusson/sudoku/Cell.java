package com.clementlusson.sudoku;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Pair;


public class Cell {
    Rect rectangle;
    CellNumber i ;
    Pair<Integer, Integer> pos;

    Cell(CellNumber cn, Pair<Integer, Integer> pos, int top, int left, int bottom, int right){
        this.rectangle = new Rect(top, left, bottom, right);
        this.i = cn;
        this.pos = pos;
    }

    public void draw(Canvas canvas){
        Paint paintrect = new Paint();
        paintrect.setStyle(Paint.Style.FILL);
        paintrect.setColor(Color.TRANSPARENT);
        canvas.drawRect(rectangle, paintrect);

        paintrect.setStrokeWidth(1);
        paintrect.setStyle(Paint.Style.STROKE);
        paintrect.setColor(Color.BLACK);
        canvas.drawRect(rectangle, paintrect);

        i.draw(rectangle, canvas);

    }
    //Check if key is selected in event action
    public boolean isSelected(int x, int y){
        return x > rectangle.left && x < rectangle.right && y > rectangle.top && y < rectangle.bottom;
    }

    public boolean isOnGroup(Cell c){
        if(this.pos.first == c.pos.first || this.pos.second == c.pos.second){
            return true;
        }
        if(this.pos.first / 3 == c.pos.first / 3 && this.pos.second / 3 == c.pos.second / 3){
            return true;
        }
        return false;
    }
}
