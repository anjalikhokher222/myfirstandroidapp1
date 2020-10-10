package com.example.foodsafetyappl;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import  android.widget.TextView;
import java.util.zip.Inflater;


public class customadaptor extends BaseAdapter {
    Context context;
    String[] uploads;
    LayoutInflater inflter;
    public customadaptor(Context applicationContext, String[] uploads){
        this.context=context;
        this.uploads=uploads;
        inflter=(LayoutInflater.from(applicationContext));


    }


    @Override
    public int getCount() {
        return uploads.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView , ViewGroup container) {
        if (convertView == null){
            convertView = inflter.inflate(R.layout.activity_listviewactivity,container,false);}
            (( TextView) convertView.findViewById(android.R.id.text1))
        .setText(position);
        return convertView;




    }







}
