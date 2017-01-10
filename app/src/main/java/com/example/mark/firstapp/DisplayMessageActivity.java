package com.example.mark.firstapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mark.firstapp.tasks.AsyncResponse;
import com.example.mark.firstapp.tasks.LoadJSONTask;
import com.example.mark.firstapp.util.JSONUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DisplayMessageActivity extends AppCompatActivity implements AsyncResponse {

    private ListView listView;
    private TextView textView;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Intent.EXTRA_TEXT);

        //textView.setTextSize(40sp);
        //textView.setText(message);

        //ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        //layout.addView(textView);


        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();


         if (networkInfo != null && networkInfo.isConnected()) {
             Log.d("DEBUG","Network up, lets load some JSON");

             LoadJSONTask findWords = new LoadJSONTask("http://wordsfriend.com/lookup.json?word=" + message);
            //set delegate/listener back to this class
             findWords.delegate = this;
             findWords.execute();

        } else {
             Log.d("Error","Network not connected");
        }

    }

    //this override the implemented method from asyncTask
    @Override
    public void processFinish(Object output){
        Log.d("INFO", "Received this string: " + output);
        listView = (ListView) findViewById(R.id.lv_word_view);
        ArrayList<String> wordGroups = JSONUtil.getWordGroups(output.toString());
        listAdapter = new ArrayAdapter<>(this, R.layout.tv_word, wordGroups);
        listView.setAdapter(listAdapter);
    }

}
