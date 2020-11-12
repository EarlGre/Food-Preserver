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
 * Use the {@link SetupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetupFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_TEXT = "argText";
    private static final String ARG_NUMBER = "argNumber";
    /*
    ArrayList<Food> foodList = new ArrayList<>();
    Food foods;
    int vegetable, fruit, meat;
    */
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final DocumentReference FruitRef = db.document("Guide/Setup");

    TextView setupParagraph1;
    TextView setupParagraph2;
    TextView setupParagraph3;
    TextView setupParagraph4;
    ImageView setupImage1;
    ImageView setupImage2;
    ImageView setupImage3;

    // TODO: Rename and change types of parameters
    private String text;
    private int number;

    public SetupFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param text   Parameter 1.
     * @param number Parameter 2.
     * @return A new instance of fragment canningFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SetupFragment newInstance(String text, int number) {
        SetupFragment fragment = new SetupFragment();
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
        View v = inflater.inflate(R.layout.fragment_setup, container, false);

        // text from description field is read into the fragment
        setupParagraph1 = v.findViewById(R.id.Setup_Paragraph1);
        setupParagraph2 = v.findViewById(R.id.Setup_Paragraph2);
        setupParagraph3 = v.findViewById(R.id.Setup_Paragraph3);
        setupParagraph4 = v.findViewById(R.id.Setup_Paragraph4);
        setupImage1 = v.findViewById(R.id.Setup_Image1);
        setupImage2 = v.findViewById(R.id.Setup_Image2);
        setupImage3 = v.findViewById(R.id.Setup_Image3);

        // get document reference and read it into the textView
        FruitRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            String paragraph1 = (String) documentSnapshot.get("paragraph1");
                            String paragraph2 = (String) documentSnapshot.get("paragraph2");
                            String paragraph3 = (String) documentSnapshot.get("paragraph3");
                            String paragraph4 = (String) documentSnapshot.get("paragraph4");
                            String replacement1 = paragraph1.replaceAll("\\\\n", "\n");
                            String replacement2 = paragraph2.replaceAll("\\\\n", "\n");
                            String replacement3 = paragraph3.replaceAll("\\\\n", "\n");
                            String replacement4 = paragraph4.replaceAll("\\\\n", "\n");

                            setupParagraph1.setText(replacement1);
                            setupParagraph2.setText(replacement2);
                            setupParagraph3.setText(replacement3);
                            setupParagraph4.setText(replacement4);

                            String picture1 = (String) documentSnapshot.get("picture1");
                            String picture2 = (String) documentSnapshot.get("picture2");
                            String picture3 = (String) documentSnapshot.get("picture3");
                            Picasso.get().load(picture1).into(setupImage1);
                            Picasso.get().load(picture2).into(setupImage2);
                            Picasso.get().load(picture3).into(setupImage3);

                        }
                    }
                });

        //have a slight delay so that the green android man doesn't show up
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        return v;
    }
}