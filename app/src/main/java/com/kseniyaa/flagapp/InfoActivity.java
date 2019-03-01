package com.kseniyaa.flagapp;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InfoActivity extends AppCompatActivity {

    RecyclerView recycler;
    ItemsAdapter adapter;
    List<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        String country = Objects.requireNonNull(getIntent().getExtras()).getString("country");

        String[] stringArray = {};
        TypedArray imgArray = null;

        assert country != null;
//
//        if (country.equals("Россия")) {
//            stringArray = getResources().getStringArray(R.array.ru_txt_items);
//            imgArray = getResources().obtainTypedArray(R.array.ru_drawables);
//
//        } else if (country.equals("Ямайка")) {
//            stringArray = getResources().getStringArray(R.array.ja_txt_items);
//            imgArray = getResources().obtainTypedArray(R.array.ja_drawables);
//
//        } else if (country.equals("Аргентина")) {
//            stringArray = getResources().getStringArray(R.array.ar_txt_items);
//            imgArray = getResources().obtainTypedArray(R.array.ar_drawables);
//        }
        switch (country) {
            case "Россия":
                stringArray = getResources().getStringArray(R.array.ru_txt_items);
                imgArray = getResources().obtainTypedArray(R.array.ru_drawables);

                break;
            case "Ямайка":
                stringArray = getResources().getStringArray(R.array.ja_txt_items);
                imgArray = getResources().obtainTypedArray(R.array.ja_drawables);

                break;
            case "Аргентина":
                stringArray = getResources().getStringArray(R.array.ar_txt_items);
                imgArray = getResources().obtainTypedArray(R.array.ar_drawables);
                break;
        }

        add_items(imgArray, stringArray);

        recycler = findViewById(R.id.recycler);

        adapter = new ItemsAdapter();
        adapter.setItems(items);


        recycler.setAdapter(adapter);
        //recycler.setLayoutManager(new LinearLayoutManager(this));

// это вторым этапом, когда покажу поворот
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        } else {
            linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
        }
        recycler.setLayoutManager(linearLayoutManager);
    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
//
//
//            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        }
//    }

    private void add_items(TypedArray imgArray, String[] stringArray) {


// сперва делам так, потом for
//        items.add(new Item(imgArray[0], stringArray[0]));
//        items.add(new Item(imgArray[1], stringArray[1]));
//        items.add(new Item(imgArray[2], stringArray[2]));
//        items.add(new Item(imgArray[3], stringArray[3]));

        for (int i = 0; i < stringArray.length; i++) {
            items.add(new Item(imgArray.getDrawable(i), stringArray[i]));
        }
    }


}
