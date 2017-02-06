package com.clementlusson.sudoku;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class NumberSelect {

    Rect rectangle;
    Integer i;

    //create a rectangle with key given
    NumberSelect(int i, int top, int left, int bottom, int right){
        this.i = i;
        this.rectangle = new Rect(top, left, bottom, right);
    }

    public void draw(Canvas canvas){
        Paint rect = new Paint();
        rect.setStyle(Paint.Style.FILL);
        rect.setColor(Color.LTGRAY);
        canvas.drawRect(rectangle, rect);

        Paint text = new Paint();
        text.setTextSize(50);
        text.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(i.toString(), this.rectangle.left + 40, this.rectangle.top + 70, text);

    }

    //Check if key is selected in event action
    public boolean isSelected(int x, int y){
        return x > rectangle.left && x < rectangle.right && y > rectangle.top && y < rectangle.bottom;
    }

}
