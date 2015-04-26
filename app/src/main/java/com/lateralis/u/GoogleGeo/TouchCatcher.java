package com.lateralis.u.GoogleGeo;

/**
 * Created by Allan on 4/22/2015.
 */

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * An AsyncTask that will be used to interact with TemBoo.
 */

public class TouchCatcher extends AsyncTask<Void, Void, String> {


View vx;
Context c;
    public TouchCatcher(View view, Context context){
         vx = view;
        c = context;
    }

    @Override
    protected String doInBackground(Void... arg0) {
        try {

        } catch(Exception e) {
            vx.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {

                    if (event.getAction() == MotionEvent.ACTION_MOVE) {
                        Toast.makeText(c,MotionEvent.AXIS_X,Toast.LENGTH_SHORT);
                    }
                    return true;
                }
            });
            Log.e(this.getClass().toString(), e.getMessage());
        }
        return null;
    }

    protected void onPostExecute(String result) {
        try {
            //textView.setText(result);
        } catch(Exception e) {
            // if an exception occurred, show an error message
            Log.e(this.getClass().toString(), e.getMessage());
        }
    }
}