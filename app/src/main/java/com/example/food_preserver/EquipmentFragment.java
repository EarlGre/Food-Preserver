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
 * Use the {@link EquipmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EquipmentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_TEXT = "argText";
    private static final String ARG_NUMBER = "argNumber";
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final DocumentReference FruitRef = db.document("Guide/Equipment");
    /*
    ArrayList<Food> foodList = new ArrayList<>();
    Food foods;
    int vegetable, fruit, meat;
    */
    TextView equipmentParagraph1;
    TextView equipmentParagraph2;
    TextView equipmentParagraph3;
    TextView equipmentParagraph4;
    ImageView equipmentImage1;
    ImageView equipmentImage2;
    ImageView equipmentImage3;
    // TODO: Rename and change types of parameters
    private String text;
    private int number;

    public EquipmentFragment() {
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
    public static EquipmentFragment newInstance(String text, int number) {
        EquipmentFragment fragment = new EquipmentFragment();
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
        View v = inflater.inflate(R.layout.fragment_equipment, container, false);

        // text from description field is read into the fragment
        equipmentParagraph1 = v.findViewById(R.id.Equipment_Paragraph1);
        equipmentParagraph2 = v.findViewById(R.id.Equipment_Paragraph2);
        equipmentParagraph3 = v.findViewById(R.id.Equipment_Paragraph3);
        equipmentParagraph4 = v.findViewById(R.id.Equipment_Paragraph4);
        equipmentImage1 = v.findViewById(R.id.Equipment_Image1);
        equipmentImage2 = v.findViewById(R.id.Equipment_Image2);
        equipmentImage3 = v.findViewById(R.id.Equipment_Image3);

        // get document reference and read it into the textView & imageView
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

                            equipmentParagraph1.setText(replacement1);
                            equipmentParagraph2.setText(replacement2);
                            equipmentParagraph3.setText(replacement3);
                            equipmentParagraph4.setText(replacement4);

                            String picture1 = (String) documentSnapshot.get("picture1");
                            String picture2 = (String) documentSnapshot.get("picture2");
                            String picture3 = (String) documentSnapshot.get("picture3");
                            Picasso.get().load(picture1).into(equipmentImage1);
                            Picasso.get().load(picture2).into(equipmentImage2);
                            Picasso.get().load(picture3).into(equipmentImage3);
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