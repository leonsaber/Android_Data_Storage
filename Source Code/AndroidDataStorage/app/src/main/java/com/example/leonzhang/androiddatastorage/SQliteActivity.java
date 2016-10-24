package com.example.leonzhang.androiddatastorage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SQliteActivity extends AppCompatActivity {
    private int _id = 0;
    private static int counter = 0;
    static List<String> result = new ArrayList<>();
    private SimpleDateFormat time=new SimpleDateFormat("MM/dd/yyyy-hh:mm a");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        Button btn_save = (Button) findViewById(R.id.button_1);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        Button btn_close = (Button) findViewById(R.id.button_2);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SQliteActivity.this,MainActivity.class));
            }
        });

    }

    private void save(){
        SQLiteWriter sqw = new SQLiteWriter(this);
        SQLite sq = new SQLite();
        EditText editMessage = (EditText) findViewById(R.id.editText_1);
        sq.message = editMessage.getText().toString();
        sq.id = _id;
        if (_id==0){
            _id = sqw.insert(sq);
            Toast.makeText(this, "New Message Insert", Toast.LENGTH_SHORT).show();
        }
        insertArray();
        startActivity(new Intent(SQliteActivity.this, MainActivity.class));
    }
    public void insertArray(){
        counter +=1;
        String message ="SQLite "+counter+"  "+time.format(new Date());
        result.add(message);
    }
}
