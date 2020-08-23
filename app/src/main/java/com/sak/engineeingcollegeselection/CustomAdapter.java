package com.sak.engineeingcollegeselection;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] collegename;
    private final Integer[] imgid;

    public CustomAdapter(Activity context, String[] collegename, Integer[] imgid) {
        super(context,R.layout.mylist, collegename);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.collegename = collegename;
        this.imgid=imgid;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        txtTitle.setText(collegename[position]);
        imageView.setImageResource(imgid[position]);
        return rowView;

    };
}
