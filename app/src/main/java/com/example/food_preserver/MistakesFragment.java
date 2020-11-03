package com.example.food_preserver;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
    TextView canningDetails;

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
                            case "canningMethod": foods.setCanningMethod(text);
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mistakes, container, false);


        // text from description field is read into the fragment
        canningDetails = v.findViewById(R.id.mistakes);
        FoodItem details = getActivity().getIntent().getParcelableExtra("food");
//        String replacement = details.getCanningMethod().replaceAll("\\\\n", "\n");
 //       canningDetails.setText(replacement);
   //   canningDetails.setText(details.getCanningMethod());


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

       String canning = foodList.get(value).getCanningMethod();

       canningDetails = v.findViewById(R.id.canning);

       canningDetails.setText(canning);

 */
        return v;
    }
}