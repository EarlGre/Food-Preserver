package com.example.food_preserver;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link dryingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dryingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String ARG_TEXT = "argText";
    private static final String ARG_NUMBER = "argNumber";

    TextView dryingDetails;

    /*
    ArrayList<Food> foodList = new ArrayList<>();
    Food foods;
    int vegetable, fruit, meat;
    */

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public dryingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dryingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static dryingFragment newInstance(String param1, String param2) {
        dryingFragment fragment = new dryingFragment();
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
/*
        try {
            InputStream inputStream = getActivity().getAssets().open("vegetablesv1.xml");
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
                            case "dryingMethod": foods.setDryingMethod(text);
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

 */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_drying, container, false);

        dryingDetails = v.findViewById(R.id.drying);
        FoodItem details = getActivity().getIntent().getParcelableExtra("food");
        dryingDetails.setText(details.getDescription());



/*
        Bundle bundle = getActivity().getIntent().getExtras();

        String name = bundle.getString("name");

        int i = 0;
        int value = 0;
        while(i < foodList.size())
        {
            if(name.equals(foodList.get(i).getName())) {
                value = i;
            }
            i++;
        }

        String drying = "";

        drying = foodList.get(value).getDryingMethod();

        dryingDetails = v.findViewById(R.id.drying);

        dryingDetails.setText(drying);
*/
        return v;
    }

}