package com.example.food_preserver;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    //  ArrayList<Food> foodList = new ArrayList<>();
    //  Food foods;
    //  int imageURI;
    //  Activity act;

    RecyclerView recyclerView;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference FruitRef = db.collection("Fruit");
    private FoodAdapter adapter;
    private Parcelable mListState;
    private Bundle mBundleRecyclerViewState;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FirstFragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        //query the items according to the priority field from JSON
        Query query = FruitRef.orderBy("priority", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<FoodItem> options = new FirestoreRecyclerOptions.Builder<FoodItem>()
                .setQuery(query, FoodItem.class)
                .build();

        //recyclerview implementation in fragment
        recyclerView = view.findViewById(R.id.recyclerView_FirstFragment);
        adapter = new FoodAdapter(options);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //On click listener for items
        adapter.setOnItemClickListener(new FoodAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                FoodItem food = documentSnapshot.toObject(FoodItem.class);
                String id = documentSnapshot.getId();
                String path = documentSnapshot.getReference().getPath();
                Toast.makeText(getActivity(),
                        "Position: " + position + " ID: " + id, Toast.LENGTH_SHORT).show();

                // Code for implementing new activity using the document ID
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                bundle.putString("path", path);
                bundle.putParcelable("food", food);

                // sends data to the foodItemInstruction class
                Intent intent = new Intent(getContext(), FoodItemInstructions.class);
                intent.putExtra("id", id);
                intent.putExtra("food", food);
                startActivity(intent);

                // sends data to the canning fragment class
                Intent intent2 = new Intent(getContext(), canningFragment.class);
                intent2.putExtra("id", id);
                intent2.putExtra("food", food);

                // override the transition for each activity
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        return view;


        /*  XML PULLER CODE & RECYCLE VIEW

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        act = getActivity();

        try {
            InputStream inputStream = getActivity().getAssets().open("fruits.xml");
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
                                imageURI = act.getResources().getIdentifier(text, "drawable", act.getPackageName());
                                foods.setImage(imageURI);
                                break;
                            case "type": foods.setType(text);
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

        //recyclerview implementation in fragment
        recyclerView = view.findViewById(R.id.recyclerView_FirstFragment);
        MyAdapter myAdapter = new MyAdapter(getContext(), foodList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
         */
    }

    @Override  // starts listening to the database
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override   // stops listening to the database
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override  // saves the state of the fragment
    public void onPause() {
        super.onPause();
        mBundleRecyclerViewState = new Bundle();
        mListState = recyclerView.getLayoutManager().onSaveInstanceState();
      //  mBundleRecyclerViewState.putParcelable("KEY_RECYCLER_STATE", mListState);
    }

    @Override  // calls the state saved of the fragment
    public void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               // mListState = mBundleRecyclerViewState.getParcelable("KEY_RECYCLER_STATE");
                recyclerView.getLayoutManager().onRestoreInstanceState(mListState);
            }
        }, 50);
       // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
