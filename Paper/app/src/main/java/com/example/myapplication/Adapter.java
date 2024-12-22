package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Adapter extends BaseAdapter {
    Context c;
    ArrayList<Product>productNames;
    LayoutInflater inflater;
    Adapter(Context c, ArrayList<Product>productNames)
    {
        this.c=c;
        this.productNames=productNames;
        this.inflater= LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return productNames.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.custom,null);
        TextView pname=convertView.findViewById(R.id.productName);
        TextView pprice=convertView.findViewById(R.id.productPrice);
        TextView pavail=convertView.findViewById(R.id.productAvailable);
        pname.setText((String)productNames.get(position).name);
        pprice.setText(String.valueOf((double)productNames.get(position).price));
        boolean flag=(boolean)productNames.get(position).stock;
        if(flag)
            pavail.setText("Available");
        else pavail.setText("Not Available");
        ImageView pimg=convertView.findViewById(R.id.productImage);
        pimg.setImageResource(productNames.get(position).imageUrl);
        return convertView;
    }
}
