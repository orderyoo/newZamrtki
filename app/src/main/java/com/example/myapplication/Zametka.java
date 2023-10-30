package com.example.myapplication;

public class Zametka {
    private String title;
    private String txt;
    Zametka(String title, String txt){
        this.title = title;
        this.txt = txt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
