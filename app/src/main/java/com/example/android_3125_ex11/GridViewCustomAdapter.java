package com.example.android_3125_ex11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class GridViewCustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<ImageObj> images;
    LayoutInflater inflter;

    public GridViewCustomAdapter(Context applicationContext, ArrayList<ImageObj> images) {
        this.context = applicationContext;
        this.images = images;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return images.size();
    }
    @Override
    public Object getItem(int i) {
        return images.get(i);
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.grid_view_custom, null); // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.icon); // get the reference of ImageView
        ImageObj object = images.get(i);
        icon.setImageResource(object.getImageID()); // set logo images
        return view;
    }
}
