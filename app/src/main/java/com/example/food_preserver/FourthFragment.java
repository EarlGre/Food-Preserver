package com.example.food_preserver;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FourthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FourthFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<String> favourites = new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference FruitRef = db.collection("Food 2.0");
    RecyclerView recyclerView;
    private FoodAdapter adapter;

    public FourthFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fourthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FourthFragment newInstance(String param1, String param2) {
        FourthFragment fragment = new FourthFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        //load in TinyDB (The sharedPreferences life saver of the gods)
        final TinyDB tinydb = new TinyDB(getActivity());
        favourites = tinydb.getListString("allFavourites");

        //printing out list of favourited items in Debug Logcat under tag "myTag"
        Log.d("myTag", Arrays.toString(favourites.toArray())); //line to be remove later lollollololol
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_first, container, false);

        //create query and succ out favourites from favourites arraylist brought to you by tinyDB
        if(!favourites.isEmpty()) {
            Query query = FruitRef.whereIn("title", favourites).orderBy("priority", Query.Direction.ASCENDING);

            //display all the goodness into the favourites tab
            FirestoreRecyclerOptions<FoodItem> options = new FirestoreRecyclerOptions.Builder<FoodItem>()
                    .setQuery(query, FoodItem.class)
                    .build();

            recyclerView = view.findViewById(R.id.recyclerView_FirstFragment);
            adapter = new FoodAdapter(options);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if(!favourites.isEmpty()) {
            adapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(!favourites.isEmpty()) {
        adapter.stopListening();
        }
    }


}
