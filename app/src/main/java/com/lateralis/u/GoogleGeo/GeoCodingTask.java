package com.lateralis.u.GoogleGeo;

/**
 * Created by Allan on 4/22/2015.
 */

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.temboo.Library.Google.Geocoding.GeocodeByAddress;
import com.temboo.Library.Google.Geocoding.GeocodeByAddress.GeocodeByAddressInputSet;
import com.temboo.Library.Google.Geocoding.GeocodeByAddress.GeocodeByAddressResultSet;
import com.temboo.core.TembooSession;

/**
 * An AsyncTask that will be used to interact with TemBoo.
 */
public class GeoCodingTask extends AsyncTask<Void, Void, String> {

    private TextView textView;

    public GeoCodingTask(TextView textView){
        this.textView = textView;
    }

    @Override
    protected String doInBackground(Void... arg0) {
        try {

            // Instantiate the ChoReo, using a previously instantiated TemBooSession object, eg:
            TembooSession session = new TembooSession("allanrd", "myFirstApp", "a3bbe2c80e8949768906fcfb02be39d1");

            GeocodeByAddress geocodeByAddressChoreo = new GeocodeByAddress(session);

            // Get an InputSet object for the choreo
            GeocodeByAddressInputSet geocodeByAddressInputs = geocodeByAddressChoreo.newInputSet();

            // Set inputs
            geocodeByAddressInputs.set_Address("Cartago, Costa Rica");

            // Execute Choreo
            GeocodeByAddressResultSet geocodeByAddressResults = geocodeByAddressChoreo.execute(geocodeByAddressInputs);
            return geocodeByAddressResults.get_Latitude() + "/" + geocodeByAddressResults.get_Longitude();

        } catch(Exception e) {
            // if an exception occurred, log it
            Log.e(this.getClass().toString(), e.getMessage());
        }
        return null;
    }

    protected void onPostExecute(String result) {
        try {
            // Update the UI
            textView.setText(result);
        } catch(Exception e) {
            // if an exception occurred, show an error message
            Log.e(this.getClass().toString(), e.getMessage());
        }
    }
}
