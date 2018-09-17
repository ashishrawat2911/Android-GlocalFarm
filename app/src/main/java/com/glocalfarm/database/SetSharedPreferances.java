package com.glocalfarm.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SetSharedPreferances {

    public static void setUserProfileSharedPreferences(String key, String value, Context ctx) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor sharedPreferencesEditor;
        sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putString(key, value);
        sharedPreferencesEditor.apply();
    }

    public static void setUserProfileSharedPreferences(String key, int value, Context ctx) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor sharedPreferencesEditor;
        sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putInt(key, value);
        sharedPreferencesEditor.apply();
    }


}
