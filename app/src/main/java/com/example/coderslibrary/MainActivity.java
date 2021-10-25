package com.example.coderslibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    public static final String Lang = "com.example.coderslibrary.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cppbtn, pythonbtn, htmlbtn, javabtn;
        cppbtn = findViewById(R.id.cpp);
        pythonbtn = findViewById(R.id.python);
        htmlbtn = findViewById(R.id.html);
        javabtn = findViewById(R.id.java);
        Intent intent = new Intent(this, ChooseActivity.class);



        cppbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(Lang, "C++");
                startActivity(intent);

            }
        });

        pythonbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(Lang, "Python");
                startActivity(intent);

            }
        });

        javabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(Lang, "Java");
                startActivity(intent);

            }
        });

        htmlbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(Lang, "HTML");
                startActivity(intent);

            }
        });

    }







}