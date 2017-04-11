package com.anwesome.ui.collapsiblelistview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * Created by anweshmishra on 11/04/17.
 */
public class CollapsibleListView extends ViewGroup {
    private  int w,h;
    public CollapsibleListView(Context context) {
        super(context);
        initDimensions(context);
    }
    public void initDimensions(Context context) {
        DisplayManager displayManager = (DisplayManager)context.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        if(display!=null) {
            Point size = new Point();
            display.getRealSize(size);
            w = size.x;
            h = size.y;
        }
    }
    public void addCollapsibleItem(Bitmap bitmap) {
        CollapsibleItem collapsibleItem = new CollapsibleItem(getContext(),bitmap);
        addView(collapsibleItem,new ViewGroup.LayoutParams(9*w/10,9*w/10));
        requestLayout();
    }
    public void onLayout(boolean reloaded,int a,int b,int w2,int h1) {
        float y = 0;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            CollapsibleItem collapsibleItem = (CollapsibleItem)child;
            int viewH = collapsibleItem.getMeasuredHeight();
            collapsibleItem.layout(w/20,(int)y,(19*w)/20,(int)(y+viewH+(4*viewH*collapsibleItem.getScale())));
            y+=viewH/5+viewH*collapsibleItem.getScale()+h/20;
        }
    }
    public void onMeasure(int wspec,int hspec) {
        int hNew = 0;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            measureChild(child,wspec,hspec);
            hNew+=child.getMeasuredHeight();
        }
        hNew = Math.max(h,hNew);
        setMeasuredDimension(w,hNew);
    }
}
