package com.bernal.gilberto.len_timer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.id.list;


public class HoursReportViewFragment extends Fragment {


   private View view;
   private Context context;
   private ArrayList<String> list = new ArrayList<String>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_hours_report_view, container, false);

        //generate list

        list.add("Gilberto");
        list.add("Yolanda");
        list.add("Valeria");
        list.add("Juan G.");
        list.add("Camilo A.");

        //instantiate custom adapter
        MyCustomAdapter adapter = new MyCustomAdapter(list, getActivity().getApplicationContext());

        //handle listview and assign adapter
        ListView lView = (ListView) view.findViewById(R.id.listView);
        lView.setAdapter(adapter);

        return view;

    }


}
