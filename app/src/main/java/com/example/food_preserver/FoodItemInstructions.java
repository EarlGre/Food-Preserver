package com.example.food_preserver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FoodItemInstructions extends AppCompatActivity{

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
        NavigationUI.setupWithNavController(nav,navHostFragment.getNavController());

        // the sent data will be displayed here depending on which item was clicked
        nameTV = findViewById(R.id.food_name);
        foodImage = findViewById(R.id.food_image);
        favouriteButton = findViewById(R.id.favouriteButton);
        nameTV.setText(getIntent().getStringExtra("id"));
        FoodItem foodPicture = getIntent().getParcelableExtra("food");
        assert foodPicture != null;
        Picasso.get().load(foodPicture.getPicture()).into(foodImage);

        //when user clicks the favourites button
        favouriteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!isFavourited) {
                    favouriteButton.setColorFilter(Color.parseColor("#ff9900"));
                    isFavourited = true;
//                    Toast.makeText(this, "Position: " + position + " ID: " + id, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Item Favourited", Toast.LENGTH_SHORT).show();
                } else {
                    favouriteButton.setColorFilter(Color.GRAY);
                    isFavourited = false;
                    Toast.makeText(getApplicationContext(), "Item Unfavourited", Toast.LENGTH_SHORT).show();
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