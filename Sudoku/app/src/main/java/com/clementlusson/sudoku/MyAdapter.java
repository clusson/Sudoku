package com.clementlusson.sudoku;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import java.util.ArrayList;

class MyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<vGrid> items;

    public MyAdapter(Context context, ArrayList<vGrid> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TwoLineListItem twoLineListItem;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            twoLineListItem = (TwoLineListItem) inflater.inflate(
                    android.R.layout.simple_list_item_2, null);
        } else {
            twoLineListItem = (TwoLineListItem) convertView;
        }

        TextView text1 = twoLineListItem.getText1();
        TextView text2 = twoLineListItem.getText2();

        text1.setText(items.get(position).num + "   niveau:" + (int) items.get(position).lvl);
        text2.setText(items.get(position).done+" %");
        text2.setTextSize(22);
        if (items.get(position).done < 40)
            text2.setTextColor(Color.RED);
        else
            text2.setTextColor(Color.GREEN);

        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Munro.ttf");
        text2.setTypeface(typeface);

        return twoLineListItem;
    }
}