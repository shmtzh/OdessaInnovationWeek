package com.mycompany.oiw;

import android.app.Activity;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.mycompany.oiw.Content.TechContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TechFragment extends ListFragment {




    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_CHECKED = "checked";
    final String ATTRIBUTE_NAME_IMAGE = "image";
    ListView lvSimple;
    String[] texts = { "03.07", "04.07", "04.07", "05.07", "sometext 5", "sometext 6" };
    String[] word = {"WebCamp: Back-end Developers Day", "WebCamp: Front-end Developers Day",
            "WebCamp: Designers Day", "WebCamp: Project Management Day",
            "Hardware Lab", "Robotics School" };
    int img[] = {R.drawable.item11,R.drawable.item11,R.drawable.item11,R.drawable.item11,R.drawable.item12,R.drawable.item13};
    String[] from = { ATTRIBUTE_NAME_TEXT,
            ATTRIBUTE_NAME_CHECKED,
                ATTRIBUTE_NAME_IMAGE };
    int[] to = { R.id.tvText,
            R.id.cbChecked,
            R.id.ivImg };


    private OnFragmentInteractionListener mListener;

    //
    // TODO: Rename and change types of parameters
    public static TechFragment newInstance(int a) {
        TechFragment fragment = new TechFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }





        public static  ArrayList <Map <String, Object>> data = new ArrayList <Map<String, Object>>(
    );
    Map<String, Object> m;




    @Override
    public void onPause(){
        super.onPause();
    data.clear();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_event, container, false);



            for (int i = 0; i < 6; i++) {
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



    public TechFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        setListAdapter(new ArrayAdapter<TechContent.TechItem>(getActivity(),
//                android.R.layout.simple_list_item_1, android.R.id.text1, TechContent.T_ITEMS));
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

        mListener.onListItemClick(TechContent.T_ITEMS.get(position).id);

    }

}
