package com.kseniyaa.flagapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_show;
    EditText et_country;
    ImageView img_flag;
    int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_show = findViewById(R.id.btn_show);
        et_country = findViewById(R.id.et_country);
        img_flag = findViewById(R.id.img_flag);


        et_country.addTextChangedListener(watcher);
        et_country.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});

        if (savedInstanceState != null) {
            img = savedInstanceState.getInt("img"); //т.к. при разрушении мы сохраняем значение img, а вот втрой раз его нет
            if (img == 0) {
                img = R.drawable.flag_gray;
            }
            img_flag.setImageResource(img);
            img_flag.setOnClickListener(imgListener);
//            img_flag.setImageResource(savedInstanceState.getInt("img"));
        }

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_country.getText().toString().equals("Россия") | et_country.getText().toString().equals("Аргентина") | et_country.getText().toString().equals("Ямайка")) {

                    switch (et_country.getText().toString()) {
                        case "Россия":
                            img = R.drawable.rf;
                            break;
                        case "Аргентина":
                            img = R.drawable.arg;
                            break;
                        case "Ямайка":
                            img = R.drawable.jamaica;
                            break;
                        default:
                            break;
                    }
                    img_flag.setOnClickListener(imgListener);

                } else {
                    Toast.makeText(MainActivity.this, "Такой страны нет, попробуй ещё", Toast.LENGTH_SHORT).show();
                    img_flag.setOnClickListener(null);
                    img = R.drawable.flag_gray;
                }
                img_flag.setImageResource(img);
            }
        });

//        btn_show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (et_country.getText().toString().equals("Россия")) {
//                    img = R.drawable.rf;
//                    img_flag.setImageResource(img);
//                } else if (et_country.getText().toString().equals("Аргентина")) {
//                    img = R.drawable.arg;
//                    img_flag.setImageResource(img);
//                } else if (et_country.getText().toString().equals("Ямайка")) {
//                    img = R.drawable.jamaica;
//                    img_flag.setImageResource(img);
//                } else {
//                    Toast.makeText(MainActivity.this, "Такой страны нет, попробуй ещё", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("img", img);
        super.onSaveInstanceState(outState);
    }

    View.OnClickListener imgListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, InfoActivity.class);
            intent.putExtra("country", et_country.getText().toString());
            startActivity(intent);
        }
    };

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            btn_show.setEnabled(!TextUtils.isEmpty(et_country.getText()));

            //второй вариант кнопки
           // btn_show.setBackgroundResource(R.drawable.bg_btn_start);
        }
    };
}
