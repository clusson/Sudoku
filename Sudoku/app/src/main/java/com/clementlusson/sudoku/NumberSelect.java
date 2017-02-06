package com.clementlusson.sudoku;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class NumberSelect {

    Rect rectangle;
    Integer i;

    NumberSelect(int i, int top, int left, int bottom, int right){
        this.i = i;
        this.rectangle = new Rect(top, left, bottom, right);
    }

    public void draw(Canvas canvas){
        Paint paintrect = new Paint();
        paintrect.setStyle(Paint.Style.FILL);
        paintrect.setColor(Color.LTGRAY);
        canvas.drawRect(rectangle, paintrect);

        Paint paint = new Paint();
        paint.setTextSize(40);
        canvas.drawText(i.toString(), this.rectangle.left + 10, this.rectangle.top + 60, paint);

    }
    public boolean isSelected(int x, int y){
        return x > rectangle.left && x < rectangle.right && y > rectangle.top && y < rectangle.bottom;
    }

}
