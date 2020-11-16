package com.example.food_preserver;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FoodItemInstructions extends AppCompatActivity {

    ImageView foodImage;
    TextView nameTV;
    ImageButton favouriteButton;
    ArrayList<String> favourites = new ArrayList<>();
    boolean isFavourited = false;
    boolean isCannedImage = false;

    /*
        String foodName;
        ArrayList<Food> foodList = new ArrayList<>();
        Food foods;
        int imageURI;
        int vegetable, fruit, meat;
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_instructions);

        BottomNavigationView nav = findViewById(R.id.methods);
        NavHostFragment navHostFragment = (NavHostFragment) this.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        NavigationUI.setupWithNavController(nav, navHostFragment.getNavController());

        // the sent data will be displayed here depending on which item was clicked
        nameTV = findViewById(R.id.food_name);
        foodImage = findViewById(R.id.food_image);
        favouriteButton = findViewById(R.id.favouriteButton);
        nameTV.setText(getIntent().getStringExtra("id"));
        FoodItem foodPicture = getIntent().getParcelableExtra("food");
        assert foodPicture != null;
        Picasso.get().load(foodPicture.getPicture()).into(foodImage);

        //load in TinyDB (The sharedPreferences life saver of the gods)
        final TinyDB tinydb = new TinyDB(getApplicationContext());
        favourites = tinydb.getListString("allFavourites");

        //initialize shimmer effect
        ShimmerFrameLayout star = findViewById(R.id.shimmer_view_container);

        //check if item is already favourited (when loading activity) and display favourited star variant if it's favourited
        String datastring = tinydb.getString((String) nameTV.getText());
        if (datastring.equals("favourited")) {
            favouriteButton.setColorFilter(Color.parseColor("#ff9900"));
            isFavourited = true;
            star.startShimmer();
            star.showShimmer(true);
        }

        //when user clicks the favourites button
        favouriteButton.setOnClickListener(v -> {
            if (!isFavourited) {
                //display favourited star variant
                favouriteButton.setColorFilter(Color.parseColor("#ff9900"));
                isFavourited = true;
                Toast.makeText(getApplicationContext(), nameTV.getText() + " Favourited", Toast.LENGTH_SHORT).show();
                star.startShimmer();
                star.showShimmer(true);

                //save individual item as favourited and add to arraylist of favourited items
                tinydb.putString((String) nameTV.getText(), "favourited");
                favourites.add((String) nameTV.getText());
            } else {
                //display unfavourited star variant
                favouriteButton.setColorFilter(Color.parseColor("#FFAAAAAA"));
                isFavourited = false;
                Toast.makeText(getApplicationContext(), nameTV.getText() + " Unfavourited", Toast.LENGTH_SHORT).show();
                star.stopShimmer();
                star.hideShimmer();

                //save individual item as unfavourited and remove item from arraylist of favourited items
                tinydb.putString((String) nameTV.getText(), "unfavourited");
                String delete = (String) nameTV.getText();
                favourites.remove(delete);
            }
            //save all changes to arraylist of favourited items
            tinydb.putListString("allFavourites", favourites);
        });

        //swap the image to the canned variant
        foodImage.setOnClickListener(v -> {
            if(foodPicture.getCanPicture() != null) {
                if (!isCannedImage) {
                    Picasso.get().load(foodPicture.getCanPicture()).into(foodImage);
                    isCannedImage = true;
                } else {
                    Picasso.get().load(foodPicture.getPicture()).into(foodImage);
                    isCannedImage = false;
                }
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    //following functions are required to make the sharedPreferences data persistent
    @Override
    public void onResume() {
        super.onResume();
        final TinyDB tinydb = new TinyDB(getApplicationContext());
        String datastring = tinydb.getString((String) nameTV.getText());
        ArrayList<String> dataarray = new ArrayList<>();
        dataarray = tinydb.getListString("allFavourites");
    }

    @Override
    protected void onStart() {
        super.onStart();
        final TinyDB tinydb = new TinyDB(getApplicationContext());
        String datastring = tinydb.getString((String) nameTV.getText());
        ArrayList<String> dataarray = new ArrayList<>();
        dataarray = tinydb.getListString("allFavourites");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        final TinyDB tinydb = new TinyDB(getApplicationContext());
        String datastring = tinydb.getString((String) nameTV.getText());
        ArrayList<String> dataarray = new ArrayList<>();
        dataarray = tinydb.getListString("allFavourites");
    }

    @Override
    protected void onPause() {
        super.onPause();
        final TinyDB tinydb = new TinyDB(getApplicationContext());
        String datastring = tinydb.getString((String) nameTV.getText());
        ArrayList<String> dataarray = new ArrayList<>();
        dataarray = tinydb.getListString("allFavourites");
    }

    @Override
    protected void onStop() {
        super.onStop();
        final TinyDB tinydb = new TinyDB(getApplicationContext());
        String datastring = tinydb.getString((String) nameTV.getText());
        ArrayList<String> dataarray = new ArrayList<>();
        dataarray = tinydb.getListString("allFavourites");
    }
}