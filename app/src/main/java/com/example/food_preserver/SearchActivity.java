package com.example.food_preserver;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.common.api.Api;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SearchView searchView;
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference FruitRef = db.collection("Food 2.0");
    private FoodAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //request for get intent when search button is tapped
        if (getIntent().hasExtra("com.example.test.SOMETHING")) {
            TextView tv =  (TextView) findViewById(R.id.textView);
            String text = getIntent().getExtras().getString("com.example.test.SOMETHING");
        }

        Query query = FruitRef.orderBy("priority", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<FoodItem> options = new FirestoreRecyclerOptions.Builder<FoodItem>()
                .setQuery(query, FoodItem.class)
                .build();


        recyclerView = findViewById(R.id.recycler_search);
        adapter = new FoodAdapter(options);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    // override the transition going back in an activity
    @Override
    public void finish() {
        super.finish();

        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }




    //private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    //CollectionReference FoodRef = db.collection("Food");

    //global variables for recyclerview
    /*
    RecyclerView recyclerView;
    SearchView searchView;
    //List<Food> foodList;
    ArrayList<FoodItem> list;
    DatabaseReference ref;
    private static final String TAG = "FireStoreSearchActivity";
    private static final String FOOD = "birds";
    private SearchAdapter searchAdapter;

*/

//    Food foods;
//    int imageURI;
//    int vegetable, fruit, meat;
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ref = FirebaseDatabase.getInstance().getReference().child(FOOD);
        recyclerView = findViewById(R.id.recycler_search);
        searchView = findViewById(R.id.food_name);

 */

//        RecyclerView recyclerView = findViewById(R.id.recycler_search);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//
//        Query query = db.collection(FOOD)
//                .orderBy("priority", Query.Direction.ASCENDING);
//        FirestoreRecyclerOptions<FoodItem> options = new FirestoreRecyclerOptions.Builder<FoodItem>()
//                .setQuery(query, FoodItem.class)
//                .build();
//
//        mAdapter = new FoodAdapter(options);
//        recyclerView.setAdapter(mAdapter);
//
//        EditText editText = findViewById(R.id.food_name);
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                Log.d(TAG, "Searchbox has changed to" + s.toString());
//            }
//        });

                //to import the data from josn to firestore
//        try {
//            // get JSONObject from JSON file
//            JSONObject obj = new JSONObject(loadJSONFromAsset());
//            // fetch JSONArray named users
//            JSONArray foodArray = obj.getJSONArray("users");
//            // implement for loop for getting users list data
//            for (int i = 0; i < foodArray.length(); i++) {
//                // create a JSONObject for fetching single user data
//                JSONObject userDetail = foodArray.getJSONObject(i);
//                // fetch email and name and store it in arraylist
//                personNames.add(userDetail.getString("name"));
//                emailIds.add(userDetail.getString("email"));
//                // create a object for getting contact data from JSONObject
//                JSONObject contact = userDetail.getJSONObject("contact");
//                // fetch mobile number and store it in arraylist
//                mobileNumbers.add(contact.getString("mobile"));
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

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
    /*
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(ref != null) {
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()) {
                        list = new ArrayList<>();
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            list.add(ds.getValue(FoodItem.class));
                        }

                        searchAdapter = new SearchAdapter(list);
                        recyclerView.setAdapter(searchAdapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if(searchView != null) {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    search(newText);
                    return false;
                }
            });
        }

    }

    private void search(String str) {
        ArrayList<FoodItem> myFoods = new ArrayList<>();
        for(FoodItem obj : list) {
            if (obj.getTitle().toLowerCase().contains(str.toLowerCase())) {
                myFoods.add(obj);
            }
            SearchAdapter searchList = new SearchAdapter(myFoods);
            recyclerView.setAdapter(searchList);
        }
    }

    //    public String loadJSONFromAsset() {
//        String json = null;
//        try {
//            InputStream is = getAssets().open("vegetablesv1.json");
//            int size = is.available();
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//            json = new String(buffer, "UTF-8");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//        return json;
//    }
*/
}
