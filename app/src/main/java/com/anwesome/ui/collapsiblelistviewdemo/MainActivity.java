package com.anwesome.ui.collapsiblelistviewdemo;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

import com.anwesome.ui.collapsiblelistview.CollapsibleList;
import com.anwesome.ui.collapsiblelistview.CollapsibleListView;

public class MainActivity extends AppCompatActivity {
    private int drawables[] = {R.drawable.back1,R.drawable.back2,R.drawable.back3,R.drawable.back4};
    private CollapsibleListView collapsibleListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CollapsibleList collapsibleList = new CollapsibleList(this);
        for(int i=0;i<drawables.length;i++) {
            collapsibleList.addCollapsible("title "+i,BitmapFactory.decodeResource(getResources(),drawables[i]));
        }
        collapsibleList.show();
    }
}
