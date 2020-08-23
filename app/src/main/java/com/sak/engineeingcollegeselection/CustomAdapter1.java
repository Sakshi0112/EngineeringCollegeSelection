package com.sak.engineeingcollegeselection;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter1 extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] collegename1;
    private final Integer[] imgid1;

    public CustomAdapter1(Activity context, String[] collegename1, Integer[] imgid1) {
        super(context, R.layout.mylist1, collegename1);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.collegename1 = collegename1;
        this.imgid1 = imgid1;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist1, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item1);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon1);

        txtTitle.setText(collegename1[position]);
        imageView.setImageResource(imgid1[position]);
        return rowView;
    };
}