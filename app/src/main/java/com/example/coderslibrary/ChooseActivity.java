package com.example.coderslibrary;

import static com.example.coderslibrary.MainActivity.Lang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class ChooseActivity extends AppCompatActivity {
    public static final String Data_f = "com.example.coderslibrary.DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Intent intent = getIntent();
        String message = intent.getStringExtra(Lang);
        TextView title = findViewById(R.id.title_2) ;
        title.setText(message);

        Intent show_intent = new Intent(this, Output_text.class);





        try {

            //List of all files and directories
            String[] contents = getAssets().list("Notes/"+message);
            System.out.println("List of files and directories in the specified directory:");
            if (contents.length != 0){
                for (String content : contents) System.out.println(content);
                ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contents);
                ListView lv = (ListView) findViewById(R.id.filecontent);
                lv.setAdapter(adapter);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        // TODO Auto-generated method stub
                        String value= (String) adapter.getItem(position);
                        Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
                        try {

                            String string = "";

                            InputStream inputStream = getAssets().open("Notes/"+message + "/" +value);
                            int size = inputStream.available();
                            byte[] buffer = new byte[size];
                            inputStream.read(buffer);
                            string = new String(buffer);


                            show_intent.putExtra(Data_f, string);
                            startActivity(show_intent);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });

            }



        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

}
