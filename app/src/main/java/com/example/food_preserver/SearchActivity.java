package com.example.food_preserver;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    //global variables for recyclerview
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<Food> foodList;

    Food foods;
    int imageURI;
    int vegetable, fruit, meat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
/*
        foodList = new ArrayList<>();

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

        recyclerView = findViewById(R.id.recycler_search);
        myAdapter = new MyAdapter(this, foodList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        //request for get intent when search button is tapped
        if (getIntent().hasExtra("com.example.test.SOMETHING")) {
            TextView tv =  (TextView) findViewById(R.id.textView);
            String text = getIntent().getExtras().getString("com.example.test.SOMETHING");

        }
    }

    // search function
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                    myAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    // override the transition going back in an activity
    @Override
    public void finish() {
        super.finish();

        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);


 */
    }

}
