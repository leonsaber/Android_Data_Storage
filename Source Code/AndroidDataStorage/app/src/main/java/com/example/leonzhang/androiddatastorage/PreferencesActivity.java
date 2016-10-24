package com.example.leonzhang.androiddatastorage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PreferencesActivity extends AppCompatActivity {
    private int _id = 0;
    private static int counter = 0;
    private SimpleDateFormat time =new SimpleDateFormat("MM/dd/yyyy-hh:mm a");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

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
                startActivity(new Intent(PreferencesActivity.this, MainActivity.class));
            }
        });
    }

    private void save(){
        PreferenceWriter pw = new PreferenceWriter(this);
        SQLite_2 sq_2 = new SQLite_2();
        EditText editName = (EditText) findViewById(R.id.editText_1);
        sq_2.name = editName.getText().toString();
        EditText editAuthor = (EditText) findViewById(R.id.editText_2);
        sq_2.author= editAuthor.getText().toString();
        EditText editDescription = (EditText) findViewById(R.id.editText_3);
        sq_2.description = editDescription.getText().toString();
        if (_id==0){
            _id = pw.insert(sq_2);
            Toast.makeText(this, "New Message Insert", Toast.LENGTH_SHORT).show();
        }
        insertArray();
        startActivity(new Intent(PreferencesActivity.this,MainActivity.class));
    }

    public void insertArray(){
        counter +=1;
        String message ="Saved Preference "+counter+"  "+time.format(new Date());
        SQliteActivity.result.add(message);
    }

}
