package com.example.food_preserver;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Equipment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipment);
        //request for get intent when search button is tapped
        if (getIntent().hasExtra("com.example.test.SOMETHING2")) {
            TextView tv = findViewById(R.id.textView2);
            String text = getIntent().getExtras().getString("com.example.test.SOMETHING2");
        }
    }


}
