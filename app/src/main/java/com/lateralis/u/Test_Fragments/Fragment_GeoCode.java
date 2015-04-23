package com.lateralis.u.Test_Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.lateralis.u.GoogleGeo.*;
import com.lateralis.u.R;


/**
 * Created by Allan on 19/03/2015.
 */


public class Fragment_GeoCode extends Fragment  {


    View rootView;
    Context context;
    Fragment fragment;
    FragmentManager fM;
    public static  final int select = 0;

    Button mButton;
    Button mButton1;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate del Fragment - Init Sys And Data
        rootView = inflater.inflate(R.layout.fragment_geo_code, container, false);
        fragment = this;
        context = getActivity();

        super.onCreate(savedInstanceState);

        TextView textView = (TextView) rootView.findViewById(R.id.result);
        new GeoCodingTask(textView).execute();

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //getImage(requestCode,resultCode,data);
    }



}







