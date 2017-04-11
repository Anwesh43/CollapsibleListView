package com.anwesome.ui.collapsiblelistview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by anweshmishra on 11/04/17.
 */
public class CollapsibleListView extends LinearLayout {
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
    }
}
