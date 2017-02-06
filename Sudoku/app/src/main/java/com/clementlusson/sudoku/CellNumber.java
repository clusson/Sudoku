package com.clementlusson.sudoku;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class CellNumber {
    Integer nb;
    boolean change;

    public CellNumber(int nb) {
        this.nb = nb;
        if (nb == 0) {
            this.change = true;
        } else {
            this.change = false;
        }


    }

    public void draw(Rect rect, Canvas canvas) {
        if (!(nb == 0)) {
            Paint paint = new Paint();
            paint.setTextSize(40);
            if (!change) {
                paint.setFakeBoldText(true);
            }
            canvas.drawText(nb.toString(), rect.left + 40, rect.top + 60, paint);
        }
    }

    public void setNumber(int nb) {
        if (change) {
            this.nb = nb;
        }

    }
}
