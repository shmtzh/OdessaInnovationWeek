package com.mycompany.oiw;

import android.app.Activity;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import com.mycompany.oiw.Content.BusContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class BusFragment extends ListFragment {


    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_CHECKED = "checked";
    final String ATTRIBUTE_NAME_IMAGE = "image";
    ListView lvSimple;
    String[] texts = { "04.06.2014", "06.06.2014", "03-08.06.2014" };
    String[] word = {"SalesLab: Outsource", "SalesLab: Product", "BizDevCamp" };
    int img[] = {R.drawable.item32,R.drawable.item32,R.drawable.item31};
    String[] from = { ATTRIBUTE_NAME_TEXT,
            ATTRIBUTE_NAME_CHECKED,
            ATTRIBUTE_NAME_IMAGE };
    int[] to = { R.id.tvText,
            R.id.cbChecked,
            R.id.ivImg };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types of parameters
    public static BusFragment newInstance(int a) {
        BusFragment fragment = new BusFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    public static ArrayList<Map<String, Object>> data = new ArrayList <Map<String, Object>>(
    );
    Map<String, Object> m;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_event, container, false);



        for (int i = 0; i < 3; i++) {
            m = new HashMap<>();
            m.put(ATTRIBUTE_NAME_TEXT, texts[i]);
            m.put(ATTRIBUTE_NAME_CHECKED, word[i]);
            m.put(ATTRIBUTE_NAME_IMAGE, img[i]);
            data.add(m);
        }

        SimpleAdapter sAdapter = new SimpleAdapter(getActivity(), data, R.layout.item, from, to);
        lvSimple = (ListView) rootView.findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapter);

        return rootView;


    }

    @Override
    public void onPause(){
        super.onPause();
        data.clear();
    }



    public BusFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

//        setListAdapter(new ArrayAdapter<BusContent.BusItem>(getActivity(),
//                android.R.layout.simple_list_item_1, android.R.id.text1, BusContent.B_ITEMS));
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);


            super.onListItemClick(l, v, position, id);

            mListener.onListItemClick(BusContent.B_ITEMS.get(position).id);

    }



}
