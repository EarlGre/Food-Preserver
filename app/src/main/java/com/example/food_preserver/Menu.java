package com.example.food_preserver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button settings;
    Button profile;
    Button about;
    Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        settings = findViewById(R.id.settings);
        profile = findViewById(R.id.profile);
        about = findViewById(R.id.about);
        help = findViewById(R.id.help);

    }


}
