package com.example.coderslibrary;

import static com.example.coderslibrary.ChooseActivity.Data_f;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Output_text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_text);

        Intent intent = getIntent();
        String data = intent.getStringExtra(Data_f);
        TextView txt = (TextView) findViewById(R.id.content_file);
        txt.setText(data);
    }
}