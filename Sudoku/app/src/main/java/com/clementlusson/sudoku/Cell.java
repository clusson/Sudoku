package com.clementlusson.sudoku;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Pair;

/**
 * Created by Clement on 06/02/2017.
 */

public class Cell {
    Rect rectangle;
    CellNumber i ;
    Pair<Integer, Integer> position;

    Cell(CellNumber cs, Pair<Integer, Integer> position, int top, int left, int bottom, int right){
        this.rectangle = new Rect(top, left, bottom, right);
        this.i = cs;
        this.position = position;
    }

    public void draw(Canvas canvas){
        Paint paintrect = new Paint();
        paintrect.setStyle(Paint.Style.FILL);
        paintrect.setColor(Color.WHITE);
        canvas.drawRect(rectangle, paintrect);

        paintrect.setStrokeWidth(1);
        paintrect.setStyle(Paint.Style.STROKE);
        paintrect.setColor(Color.BLACK);
        canvas.drawRect(rectangle, paintrect);

        i.draw(rectangle, canvas);

    }

    public boolean isSelected(int x, int y){
        return x > rectangle.left && x < rectangle.right && y > rectangle.top && y < rectangle.bottom;
    }

    public boolean isOnGroup(Cell c){
        if(this.position.first == c.position.first || this.position.second == c.position.second){
            return true;
        }
        if(this.position.first / 3 == c.position.first / 3 && this.position.second / 3 == c.position.second / 3){
            return true;
        }
        return false;
    }
}
