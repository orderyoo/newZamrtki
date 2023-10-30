package com.example.myapplication;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class DataBase {
    static DataBase instance;
    SharedPreferences sharedPref;
    private DataBase(Activity t){
        sharedPref = t.getPreferences(Context.MODE_PRIVATE);
    }

    void addItem(Zametka item){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(item.getTitle(), item.getTxt());
        editor.apply();
    }

    Zametka getItem(String name){
        return new Zametka(name, sharedPref.getString(name, "THIS IS DOES NOT EXIST"));
    }

    static DataBase createInstance(Activity t){
        if(instance == null){
            instance = new DataBase(t);
        }
        return instance;
    }
    static DataBase getInstance(){
        return instance;
    }

}
