package com.example.food_preserver;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.Arrays;

import static org.apache.commons.lang3.text.WordUtils.capitalizeFully;

public class SearchActivity extends AppCompatActivity {

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference FruitRef = db.collection("Food 2.0");
    RecyclerView recyclerView;
    private FoodAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //request for get intent when search button is tapped
        if (getIntent().hasExtra("com.example.test.SOMETHING")) {
            TextView tv = findViewById(R.id.textView);
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

        //On click listener for items
        adapter.setOnItemClickListener(new FoodAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                FoodItem food = documentSnapshot.toObject(FoodItem.class);
                String id = documentSnapshot.getId();
                String path = documentSnapshot.getReference().getPath();
                Toast.makeText(getApplicationContext(),
                        "Position: " + position + " ID: " + id, Toast.LENGTH_SHORT).show();

                // Code for implementing new activity using the document ID
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                bundle.putString("path", path);
                bundle.putParcelable("food", food);

                // sends data to the foodItemInstruction class
                Intent intent = new Intent(getApplicationContext(), FoodItemInstructions.class);
                intent.putExtra("id", id);
                intent.putExtra("food", food);
                startActivity(intent);

                // sends data to the canning fragment class
                Intent intent2 = new Intent(getApplicationContext(), canningFragment.class);
                intent2.putExtra("id", id);
                intent2.putExtra("food", food);

                // override the transition for each activity
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });


        EditText searchBox = findViewById(R.id.fireStoreSearchBox);

        //Gets the typed out text and uses a query from firestore to filter the items
        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //ignored method
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //ignored method
            }

            @Override
            public void afterTextChanged(Editable s) {
                //capitalize first letter of each word of user's input
                final char delimiter = ' ';
                String userInput = capitalizeFully(String.valueOf(s), delimiter);
                String[] input = {userInput};

                //This log is needed. Do not delete
                Log.d("TAG", "searchBox has changed to " + userInput);
                Query query;
                if (s.toString().isEmpty()) {
                    query = FruitRef
                            .orderBy("priority", Query.Direction.ASCENDING);
                } else {
                    query = FruitRef
                            .whereArrayContainsAny("search", Arrays.asList(input))
                            .orderBy("priority", Query.Direction.ASCENDING);
                    FirestoreRecyclerOptions<FoodItem> options = new FirestoreRecyclerOptions.Builder<FoodItem>()
                            .setQuery(query, FoodItem.class)
                            .build();

                    adapter.updateOptions(options);
                }
                FirestoreRecyclerOptions<FoodItem> options = new FirestoreRecyclerOptions.Builder<FoodItem>()
                        .setQuery(query, FoodItem.class)
                        .build();

                adapter.updateOptions(options);
            }
        });
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
