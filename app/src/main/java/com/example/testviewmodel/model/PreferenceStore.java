package com.example.testviewmodel.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.testviewmodel.view.MainActivity;

public class PreferenceStore {

    public static void setStringPreference(Context context, String name, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }



}
