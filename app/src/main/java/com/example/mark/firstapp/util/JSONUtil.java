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

        //TODO: replace this dummy data
        ArrayList<String> wordGroups = new ArrayList<String>();
        wordGroups.add("group 5");
        wordGroups.add("group 4");
        wordGroups.add("group 3");
        return wordGroups;

    }

}
