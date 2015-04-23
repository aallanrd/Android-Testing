package com.lateralis.u.GoogleGeo;

/**
 * Created by Allan on 4/22/2015.
 */

import android.os.AsyncTask;
import android.util.Log;

import com.temboo.Library.Google.Gmail.SendEmail;
import com.temboo.Library.Google.Gmail.SendEmail.SendEmailInputSet;
import com.temboo.Library.Google.Gmail.SendEmail.SendEmailResultSet;
import com.temboo.core.TembooSession;

/**
 * An AsyncTask that will be used to interact with TemBoo.
 */

public class GmailTask extends AsyncTask<Void, Void, String> {



    public GmailTask(){

    }

    @Override
    protected String doInBackground(Void... arg0) {
        try {
            // Create a new Temboo session.
            TembooSession session = new TembooSession("aallanrd", "myFirstApp", "a3bbe2c80e8949768906fcfb02be39d1");

            // Instantiate the Google.Gmail.SendEmail Choreo, using the session object.
            SendEmail sendEmailChoreo = new SendEmail(session);

            // Get an InputSet object for Google.Gmail.SendEmail Choreo.
            SendEmailInputSet sendEmailInputs = sendEmailChoreo.newInputSet();

            // Set Profile to use for execution. Note this value should be the name of the Profile that you created earlier.
            sendEmailInputs.setCredential("AllanP");

            // Set inputs for Google.Gmail.SendEmail Choreo.
            sendEmailInputs.set_MessageBody("Test from App Temboo");
            sendEmailInputs.set_Subject("Test from Temboo");
            sendEmailInputs.set_FromAddress("allanjose91@gmail.com");
            sendEmailInputs.set_ToAddress("allanjose91@gmail.com");

            // Execute Google.Gmail.SendEmail Choreo
            SendEmailResultSet sendEmailResults = sendEmailChoreo.execute(sendEmailInputs);

            return "SendEmail succeeded? " + sendEmailResults.get_Success();
        } catch(Exception e) {
            // if an exception occurred, log it
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