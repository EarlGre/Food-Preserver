package com.example.food_preserver;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MistakesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MistakesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_TEXT = "argText";
    private static final String ARG_NUMBER = "argNumber";
    /*
    ArrayList<Food> foodList = new ArrayList<>();
    Food foods;
    int vegetable, fruit, meat;
    */
    TextView mistakesDetails;
    ImageView mistakesImage;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference FruitRef = db.document("Guide/Mistakes");

    // TODO: Rename and change types of parameters
    private String text;
    private int number;

    public MistakesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param text Parameter 1.
     * @param number Parameter 2.
     * @return A new instance of fragment canningFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MistakesFragment newInstance(String text, int number) {
        MistakesFragment fragment = new MistakesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        args.putInt(ARG_NUMBER, number);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            text = getArguments().getString(ARG_TEXT);
            number = getArguments().getInt(ARG_NUMBER);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mistakes, container, false);


        // text from description field is read into the fragment
        mistakesDetails = v.findViewById(R.id.mistakes);
        mistakesImage = v.findViewById(R.id.Mistakes_Image_1);



        // get document reference and read it into the textView
        FruitRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            String title = (String) documentSnapshot.get("description");
                            String replacement = title.replaceAll("\\\\n", "\n");
                            mistakesDetails.setText(replacement);

                            String picture = (String) documentSnapshot.get("picture");
                            Picasso.get().load(picture).into(mistakesImage);

                        }
                    }
                });


 //       FoodItem details = getActivity().getIntent().getParcelableExtra("food");
//        String replacement = details.getCanningMethod().replaceAll("\\\\n", "\n");
 //       canningDetails.setText(replacement);
   //   canningDetails.setText(details.getCanningMethod());


        //have a slight delay so that the green android man doesn't show up
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        return v;
    }
}