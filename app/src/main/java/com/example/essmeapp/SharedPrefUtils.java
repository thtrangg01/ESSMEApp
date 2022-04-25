package com.example.essmeapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtils {
    public static String getAuthToken(Activity activity) {
        SharedPreferences sharedPref = activity.getSharedPreferences(activity.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String authToken = sharedPref.getString(activity.getString(R.string.auth_token), "");
        return authToken;
    }

    public static String getId(Activity activity) {
        SharedPreferences sharedPref = activity.getSharedPreferences(activity.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String id = sharedPref.getString("id", "");
        return id;
    }
}
