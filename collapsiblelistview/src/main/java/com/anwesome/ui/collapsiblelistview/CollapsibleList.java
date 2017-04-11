package com.anwesome.ui.collapsiblelistview;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * Created by anweshmishra on 11/04/17.
 */
public class CollapsibleList {
    private Activity activity;
    private boolean shown = false;
    private CollapsibleListView collapsibleListView;
    public CollapsibleList(Activity activity) {
        this.activity = activity;
        collapsibleListView = new CollapsibleListView(activity);
    }
    public void show() {
        if(!shown) {
            ScrollView scrollView = new ScrollView(activity);
            scrollView.addView(collapsibleListView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            activity.setContentView(scrollView);
            shown = true;
        }
    }
    public void addCollapsible(String title, Bitmap bitmap){
        collapsibleListView.addCollapsibleItem(bitmap,title);
    }
}
