package com.example.food_preserver;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
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
//                Toast.makeText(getApplicationContext(),
//                        "Position: " + position + " ID: " + id, Toast.LENGTH_SHORT).show();

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
}
