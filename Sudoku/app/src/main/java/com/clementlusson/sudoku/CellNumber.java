package com.clementlusson.sudoku;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Clement on 06/02/2017.
 */

public class CellNumber {
    Integer content;
    boolean editable;

    public CellNumber(int content) {
        this.content = content;
        if (content == 0) {
            this.editable = true;
        } else {
            this.editable = false;
        }


    }

    public void draw(Rect rectangle, Canvas canvas) {
        if (!(content == 0)) {
            Paint paint = new Paint();
            paint.setTextSize(40);
            if (!editable) {
                paint.setFakeBoldText(true);
            }
            canvas.drawText(content.toString(), rectangle.left + 40, rectangle.top + 60, paint);
        }
    }

    public void setNumber(int content) {
        if (editable) {
            this.content = content;
        }

    }
}
