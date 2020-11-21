package com.preservenow.food_preserver;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link freezingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class freezingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String ARG_TEXT = "argText";
    private static final String ARG_NUMBER = "argNumber";


    /*
    ArrayList<Food> foodList = new ArrayList<>();
    Food foods;
    int vegetable, fruit, meat;
     */

    TextView freezingDetails;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public freezingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment freezingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static freezingFragment newInstance(String param1, String param2) {
        freezingFragment fragment = new freezingFragment();
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
        View v = inflater.inflate(R.layout.fragment_freezing, container, false);

        freezingDetails = v.findViewById(R.id.freezing);
        FoodItem details = getActivity().getIntent().getParcelableExtra("food");
        String replacement = details.getFreezingMethod().replaceAll("\\\\n", "\n");
        freezingDetails.setText(replacement);
        return v;
    }
}