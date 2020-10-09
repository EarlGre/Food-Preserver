package com.example.food_preserver;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
                            case "freezingMethod": foods.setFreezingMethod(text);
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
        View v = inflater.inflate(R.layout.fragment_freezing, container, false);

        freezingDetails = v.findViewById(R.id.freezing);
        FoodItem details = getActivity().getIntent().getParcelableExtra("food");
        freezingDetails.setText(details.getFreezingMethod());






/*
        Bundle bundle = getActivity().getIntent().getExtras();

        Intent intent = getActivity().getIntent();

        String type = bundle.getString("type");

        String name = bundle.getString("name");

        int position = intent.getIntExtra("position", 0);

        int i = 0;
        int value = 0;
        while(i < foodList.size())
        {
            if(name.equals(foodList.get(i).getName())) {
                value = i;
            }
            i++;
        }

        String freezing = foodList.get(value).getFreezingMethod();

        freezingDetails = v.findViewById(R.id.freezing);

        freezingDetails.setText(freezing);
*/
        return v;
    }

}