package com.huruwo.hposed.utils;

import android.app.AndroidAppHelper;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class XSharePrefeUtil {


    public static String getDeviceId() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(AndroidAppHelper.currentApplication().getApplicationContext());
        return prefs.getString("DeviceId", "");
    }

    public static void setDeviceId(String deviceId) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(AndroidAppHelper.currentApplication().getApplicationContext());
        prefs.edit().putString("DeviceId", deviceId).apply();
    }

    public static String getDataHost() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(AndroidAppHelper.currentApplication().getApplicationContext());
        return prefs.getString("DataHost", "192.168.100.100");
    }

    public static void setDataHost(String host) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(AndroidAppHelper.currentApplication().getApplicationContext());
        prefs.edit().putString("DataHost", host).apply();
    }

    public static String getDataPort() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(AndroidAppHelper.currentApplication().getApplicationContext());
        return prefs.getString("DataPort", "5620");
    }

    public static void setDataPort(String host) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(AndroidAppHelper.currentApplication().getApplicationContext());
        prefs.edit().putString("DataPort", host).apply();
    }

}

