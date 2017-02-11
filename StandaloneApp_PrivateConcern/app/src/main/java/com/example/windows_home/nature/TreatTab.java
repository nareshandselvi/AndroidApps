package com.example.windows_home.nature;

/**
 * Created by windows-home on 03-05-2015.
 */

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Intent;
import android.widget.Toast;

public class TreatTab extends Fragment implements OnItemClickListener {

    public static final String[] titles = new String[] { "Memory Enhancement Therapy",
            "Stress Buster Treatment", "Fertility Therapy", "Respiratory Therapy","Behavioral disorders in children" };



    public static final Integer[] images = { R.drawable.mem,
            R.drawable.stress, R.drawable.fertility, R.drawable.resp,R.drawable.behave };
    ListView listView;
    List<RowItem> rowItems;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.treatment, container, false);
        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem(images[i], titles[i]);
            rowItems.add(item);
        }




        listView = (ListView) rootview.findViewById(R.id.list);
        MyBaseAdapter customAdapter = new MyBaseAdapter(getActivity(),rowItems);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(this);
        return rootview;

    }

        @Override
        public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
            // TODO Auto-generated method stub
            String item = adapter.getItemAtPosition(position).toString();
            //Toast.makeText(getActivity(), "CLICK: " + item, Toast.LENGTH_SHORT).show();
            TextView c = (TextView) v.findViewById(R.id.title);
            String treatment = c.getText().toString();
            if(treatment.equals("Memory Enhancement Therapy")) {
                Intent myIntent = new Intent(getActivity(), MainActivity2Activity.class);
                myIntent.putExtra("test", "hello");
                startActivity(myIntent);
            }
            if(treatment.equals("Stress Buster Treatment")) {
                Intent myIntent = new Intent(getActivity(), MainActivity22Activity.class);
                myIntent.putExtra("test", "hello");
                startActivity(myIntent);
            }
            if(treatment.equals("Fertility Therapy")) {
                Intent myIntent = new Intent(getActivity(), MainActivity23Activity.class);
                myIntent.putExtra("test", "hello");
                startActivity(myIntent);
            }
            if(treatment.equals("Respiratory Therapy")) {
                Intent myIntent = new Intent(getActivity(), MainActivity24Activity.class);
                myIntent.putExtra("test", "hello");
                startActivity(myIntent);
            }

            if(treatment.equals("Behavioral disorders in children")) {
                Intent myIntent = new Intent(getActivity(), MainActivity25Activity.class);
                myIntent.putExtra("test", "hello");
                startActivity(myIntent);
            }


        }
          //Intent intent = new Intent(getActivity(),
                   //MainActivity2Activity.class);






}
