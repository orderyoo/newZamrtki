package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Adapter extends ArrayAdapter<List> {

    private final Context context;
    private  final List<String> itemName;


    public Adapter(Context context, int resource, List<Zametka> itemName) {

        super(context, resource);
        this.context = context;
        Function<Zametka, String> a = Zametka::getTitle;
        this.itemName = (ArrayList<String>) itemName.stream().map(a);
    }
    @Override
    public int getCount() {
        return itemName.size();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View view = inflater.inflate(android.R.layout.simple_expandable_list_item_1, parent, false);
        TextView textView = view.findViewById(android.R.id.text1);
        textView.setTextSize(20);
        textView.setText(itemName.get(position));
        return view;
    }

    @Override
    public List<String> getItem(int position) {
        return Collections.singletonList(itemName.get(position));
    }

}
