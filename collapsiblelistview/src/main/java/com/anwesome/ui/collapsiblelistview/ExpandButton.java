package com.anwesome.ui.collapsiblelistview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by anweshmishra on 11/04/17.
 */
public class ExpandButton {
    private float x,y,size,deg = 0,dir = 0;
    public ExpandButton(float x,float y,float size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(x,y);
        canvas.rotate(deg);
        paint.setColor(Color.GRAY);
        canvas.drawCircle(0,0,size/2,paint);
        paint.setTextSize(size/20);
        paint.setColor(Color.BLACK);
        for(int i=0;i<2;i++) {
            canvas.save();
            canvas.rotate(90*i);
            canvas.drawLine(0, -size / 2, 0, size / 2, paint);
            canvas.restore();
        }
        canvas.restore();
    }
    public void move() {
        deg+=dir*9;
    }
    public float getDir() {
        return dir;
    }
    public boolean stop() {
        return dir == 0;
    }
    public boolean handleTap(float x,float y) {
        boolean condition = x>=this.x-this.size/2 && x<=this.x+this.size/2 && y>=this.y-size/2 && y<=this.y+size/2;
        if(condition) {
            dir = deg == 0?1:-1;
        }
        return condition;
    }
}
