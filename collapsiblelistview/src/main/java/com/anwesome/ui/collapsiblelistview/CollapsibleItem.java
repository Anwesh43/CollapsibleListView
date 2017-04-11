package com.anwesome.ui.collapsiblelistview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 11/04/17.
 */
public class CollapsibleItem extends View {
    private Bitmap bitmap;
    private boolean opened = false;
    private float scale = 0,dir = 0;
    private int time =0;
    private boolean isAnimated = false;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private ExpandButton expandButton;
    public CollapsibleItem(Context context,Bitmap bitmap) {
        super(context);
        this.bitmap = bitmap;
    }
    public void onDraw(Canvas canvas) {
        int w = canvas.getWidth(),h = canvas.getHeight();
        if(time == 0) {
            bitmap = Bitmap.createScaledBitmap(bitmap,4*w/5,7*h/10,true);
            expandButton = new ExpandButton(17*w/20,h/10,h/10);
        }
        paint.setColor(Color.parseColor("#E6E6E6"));
        canvas.drawRect(new RectF(0,0,w,h/5),paint);
        expandButton.draw(canvas,paint);
        canvas.save();
        canvas.translate(0,h/5);
        canvas.scale(1,scale);
        paint.setColor(Color.parseColor("#E6E6E6"));
        canvas.drawRect(new RectF(0,0,w,h-h/5),paint);
        canvas.drawBitmap(bitmap,w/10,h/20,paint);
        canvas.restore();
        time++;
        if(isAnimated) {
            expandButton.move();
            scale+=dir*0.2f;
            if(expandButton.stop()) {
                dir = 0;
                isAnimated = false;
            }
            try {
                Thread.sleep(50);
                invalidate();
            }
            catch (Exception ex) {

            }
        }
    }
    public float getScale() {
        return scale;
    }
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX(),y = event.getY();
        if(event.getAction() == MotionEvent.ACTION_DOWN && !isAnimated && expandButton!=null) {
            if(expandButton.handleTap(x,y)) {
                dir = expandButton.getDir();
                isAnimated = true;
                postInvalidate();
            }
        }
        return true;
    }
}
