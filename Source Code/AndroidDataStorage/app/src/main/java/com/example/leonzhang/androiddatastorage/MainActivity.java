package com.example.leonzhang.androiddatastorage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Display display;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display();
        Button btn_preferences = (Button) findViewById(R.id.button_1);
        btn_preferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PreferencesActivity.class));
            }
        });

        Button btn_sqlite = (Button) findViewById(R.id.button_2);
        btn_sqlite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SQliteActivity.class));
            }
        });

        Button btn_close = (Button) findViewById(R.id.button_3);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();
                System.exit(0);
            }
        });
    }

    private void display(){

        ListView show= (ListView)this.findViewById(R.id.listView);
        display = new Display(this,android.R.layout.simple_list_item_1,SQliteActivity.result);
        show.setAdapter(display);
    }

}
