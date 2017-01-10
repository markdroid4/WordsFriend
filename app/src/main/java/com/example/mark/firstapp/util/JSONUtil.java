package com.example.mark.firstapp.util;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by mark on 1/9/17.
 */

public class JSONUtil {


    public static ArrayList<String> getWordGroups(String JSONString) {
//        JSONObject obj = new JSONObject(JSONString);
//        JSONObject weather = obj.getJSONObject("weather");
//        return weather.getString("condition");

//        JSONArray jsonArray = null;
//        try {
//            jsonArray = new JSONArray(output);
//            Log.d("INFO", "jsonArray length " + jsonArray.length());
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONArray subArray = new JSONArray(jsonArray.getJSONObject(i));
//                Log.d("INFO", "MY ARRAY: " + subArray.toString());
//            }
//        } catch (JSONException e)
//        {
//            Log.d("INFO", "EXCEPTION " + e.toString());
//            e.printStackTrace();
//        }

        //TODO: replace this dummy data
        ArrayList<String> wordGroups = new ArrayList<>();
        wordGroups.add(JSONString);
        //wordGroups.add("group 4");
        //wordGroups.add("group 3");
        return wordGroups;

    }

}
