package com.kseniyaa.flagapp;


import android.graphics.drawable.Drawable;

public class Item {
    private Drawable imgItem;
    private String txtItem;

    Drawable getImgItem() {
        return imgItem;
    }


    String getTxtItem() {
        return txtItem;
    }


    Item(Drawable imgItem, String txtItem) {

        this.imgItem = imgItem;
        this.txtItem = txtItem;
    }
}
