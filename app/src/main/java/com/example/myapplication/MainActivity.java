package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ArrayList<Zametka> itemName = new ArrayList<Zametka>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listItem);
        adapter = new Adapter(this, android.R.layout.simple_expandable_list_item_1, itemName);

        DataBase.createInstance(this);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, v, position, id) -> {
            Intent intent = new Intent(MainActivity.this, NoteActivity.class);
            startActivity(intent);
        });
    }
    public void onClickButtonAdd(View view){
        Zametka a = new Zametka("new", "bts");
        itemName.add(a);
        DataBase.getInstance().addItem(a);
        adapter.notifyDataSetChanged();
    }

}