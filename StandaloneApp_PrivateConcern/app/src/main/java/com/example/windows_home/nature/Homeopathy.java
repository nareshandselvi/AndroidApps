package com.example.windows_home.nature;

/**
 * Created by windows-home on 11-05-2015.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Intent;
import android.widget.ImageView;

public class Homeopathy extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.homeopathye, container, false);
        ImageView iview = (ImageView) rootView .findViewById(R.id.imageView4);


        iview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), MainActivity26Activity.class);
                myIntent.putExtra("test", "hello");
                startActivity(myIntent);
            }
        });

        return rootView;
    }


}
