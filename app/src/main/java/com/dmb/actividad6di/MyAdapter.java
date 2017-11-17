package com.dmb.actividad6di;

import android.support.v7.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by davidmari on 16/11/17.
 */

public class MyAdapter extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<RecyclerItems> items;

    public MyAdapter (Activity activity, ArrayList<RecyclerItems> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public RecyclerItems getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.items_listview, null);
        }

        RecyclerItems dir = items.get(position);

        TextView title = (TextView) v.findViewById(R.id.category);
        title.setText(dir.getTitle());

        return v;
    }

}