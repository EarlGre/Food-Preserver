package com.example.food_preserver;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        //request for get intent when search button is tapped
        if (getIntent().hasExtra("com.example.test.SOMETHING2")) {
            TextView tv = findViewById(R.id.textView2);
            String text = getIntent().getExtras().getString("com.example.test.SOMETHING2");
        }

        BottomNavigationView nav = findViewById(R.id.equipment_nav);
        NavHostFragment navHostFragment = (NavHostFragment) this.getSupportFragmentManager().findFragmentById(R.id.fragment_container_equipment);
        NavigationUI.setupWithNavController(nav, navHostFragment.getNavController());


    }


    // override the transition going back in an activity
    @Override
    public void finish() {
        super.finish();

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}
