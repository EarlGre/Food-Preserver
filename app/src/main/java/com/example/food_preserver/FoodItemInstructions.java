package com.example.food_preserver;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.prefs.Preferences;

public class FoodItemInstructions extends AppCompatActivity {

    ImageView foodImage;
    TextView nameTV;
    ImageButton favouriteButton;
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
        String datastring = tinydb.getString((String) nameTV.getText());
        if(datastring == "favourited") {
            favouriteButton.setColorFilter(Color.parseColor("#ff9900"));
            isFavourited = true;
        }

        //when user clicks the favourites button
        favouriteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!isFavourited) {
                    favouriteButton.setColorFilter(Color.parseColor("#ff9900"));
                    isFavourited = true;
                    Toast.makeText(getApplicationContext(), nameTV.getText() + " Favourited", Toast.LENGTH_SHORT).show();
                    tinydb.putString((String) nameTV.getText(), "favourited");
                } else {
                    favouriteButton.setColorFilter(Color.GRAY);
                    isFavourited = false;
                    Toast.makeText(getApplicationContext(), nameTV.getText() + " Unfavourited", Toast.LENGTH_SHORT).show();
                    tinydb.putString((String) nameTV.getText(), "unfavourited");
                }
            }
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
}