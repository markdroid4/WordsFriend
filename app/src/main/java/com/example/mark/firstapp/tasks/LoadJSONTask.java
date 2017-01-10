package com.example.mark.firstapp.tasks;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by mark on 10/24/16.
 */

public class LoadJSONTask extends AsyncTask {

    public AsyncResponse delegate = null;
    private String jsonURL;

    public LoadJSONTask(String jsonURL) {
        super();
        this.jsonURL=jsonURL;
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        StringBuilder result = new StringBuilder();
        HttpURLConnection urlConnection = null;
        JSONObject obj = new JSONObject();
        try {
            URL url = new URL(jsonURL);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

        }catch( Exception e) {
            e.printStackTrace();
        }
        finally {
            urlConnection.disconnect();
        }

        Log.d("INFO", "returning json: " + result.toString());

        return result.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {
        delegate.processFinish(o);
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(Object o) {
        super.onCancelled(o);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
