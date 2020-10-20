package com.example.food_preserver;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FoodItemInstructions extends AppCompatActivity {

    ImageView foodImage;
    TextView nameTV;
    ImageButton favouriteButton;
    ArrayList<String> favourites = new ArrayList<>();
    boolean isFavourited = false;

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

        //check if item is already favourited (when loading activity) and display favourited star variant if it's favourited
        String datastring = tinydb.getString((String) nameTV.getText());
        if (datastring.equals("favourited")) {
            favouriteButton.setColorFilter(Color.parseColor("#ff9900"));
            isFavourited = true;
        }

        //when user clicks the favourites button
        favouriteButton.setOnClickListener(v -> {
            if (!isFavourited) {
                //display favourited star variant
                favouriteButton.setColorFilter(Color.parseColor("#ff9900"));
                isFavourited = true;
                Toast.makeText(getApplicationContext(), nameTV.getText() + " Favourited", Toast.LENGTH_SHORT).show();

                //save individual item as favourited and add to arraylist of favourited items
                tinydb.putString((String) nameTV.getText(), "favourited");
                favourites.add((String) nameTV.getText());
            } else {
                //display unfavourited star variant
                favouriteButton.setColorFilter(Color.parseColor("#FFAAAAAA"));
                isFavourited = false;
                Toast.makeText(getApplicationContext(), nameTV.getText() + " Unfavourited", Toast.LENGTH_SHORT).show();

                //save individual item as unfavourited and remove item from arraylist of favourited items
                tinydb.putString((String) nameTV.getText(), "unfavourited");
                String delete = (String) nameTV.getText();
                favourites.remove(delete);
            }
            //save all changes to arraylist of favourited items
            tinydb.putListString("allFavourites", favourites);
        });

/*
        try {
            InputStream inputStream = getAssets().open("vegetablesv1.xml");
            XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            parser.setInput(inputStream,null);
            String tag = "" , text = "";
            int event = parser.getEventType();
            while (event!= XmlPullParser.END_DOCUMENT){
                tag = parser.getName();
                switch (event) {
                    case XmlPullParser.START_TAG:
                        if(tag.equals("Food"))
                            foods = new Food();
                        break;
                    case XmlPullParser.TEXT:
                        text=parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        switch (tag) {
                            case "name": foods.setName(text);
                                break;
                            case "image": foods.setImageURL(text);
                                imageURI = getResources().getIdentifier(text, "drawable", getPackageName());
                                foods.setImage(imageURI);
                                break;
                            case "type": foods.setType(text);
                                if(text.equals("vegetable")) {
                                    vegetable++;
                                }
                                if(text.equals("fruit")) {
                                    fruit++;
                                }
                                if(text.equals("meat")) {
                                    meat++;
                                }
                                break;
                            case "Food":
                                if(foods!=null)
                                    foodList.add(foods);
                                break;
                        }
                        break;
                }
                event = parser.next();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int image = intent.getIntExtra("image", 0);

        foodImage = findViewById(R.id.food_image);
        nameTV = findViewById(R.id.food_name);

        nameTV.setText(name);
        foodImage.setImageResource(image);

 */
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