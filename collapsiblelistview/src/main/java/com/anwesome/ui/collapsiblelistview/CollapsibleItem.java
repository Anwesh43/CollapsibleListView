package com.anwesome.ui.collapsiblelistview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 11/04/17.
 */
public class CollapsibleItem extends View {
    public CollapsibleItem(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {
        
    }
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
