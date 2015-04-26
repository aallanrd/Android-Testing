package com.lateralis.u.Test_Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lateralis.u.R;


/**
 * Created by Allan on 19/03/2015.
 */


public class test extends Fragment {


    View rootView;
    Context context;
    Fragment fragment;
    FragmentManager fM;
    public static  final int select = 0;


    TextView textView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate del Fragment - Init Sys And Data
        rootView = inflater.inflate(R.layout.fragment_test, container, false);
        fragment = this;
        context = getActivity();

        super.onCreate(savedInstanceState);

        textView = (TextView) rootView.findViewById(R.id.text1);
        textView.setText("Aqui voy");
        //new GmailTask().execute();
        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                textView.setText("Touch coordinates : "
                        + String.valueOf(event.getX()) + "x"
                        + String.valueOf(event.getY()));
                return true;
            }
        });
        return rootView;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //getImage(requestCode,resultCode,data);
    }



}


