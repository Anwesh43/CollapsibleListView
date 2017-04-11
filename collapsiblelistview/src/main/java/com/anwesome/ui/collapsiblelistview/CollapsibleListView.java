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
    private int viewSize;
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
            viewSize = (9*w)/10;
        }
    }
    public void addCollapsibleItem(Bitmap bitmap) {
        CollapsibleItem collapsibleItem = new CollapsibleItem(getContext(),bitmap);
        collapsibleItem.setOnUpdateListener(new CollapsibleItem.OnUpdateListener() {
            @Override
            public void onUpdate() {
                requestLayout();
            }
        });
        addView(collapsibleItem,new ViewGroup.LayoutParams(viewSize,viewSize));
        requestLayout();
    }
    public void onLayout(boolean reloaded,int a,int b,int w2,int h1) {
        int y = h/40;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            CollapsibleItem collapsibleItem = (CollapsibleItem)child;
            collapsibleItem.layout(w/20,y,(19*w)/20,(y+collapsibleItem.getMeasuredHeight()));
            y+=(collapsibleItem.getMeasuredHeight()/5+(int)((4*collapsibleItem.getMeasuredHeight()/5)*collapsibleItem.getScale()))+h/40;
        }
    }
    public void onMeasure(int wspec,int hspec) {
        int hNew = h/40;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            measureChild(child,wspec,hspec);
            CollapsibleItem collapsibleItem = (CollapsibleItem)child;
            hNew+=(collapsibleItem.getMeasuredHeight()/5+(int)((4*collapsibleItem.getMeasuredHeight()/5)*collapsibleItem.getScale()))+h/40;
        }
        hNew = Math.max(h,hNew);
        setMeasuredDimension(w,hNew);
    }
}
