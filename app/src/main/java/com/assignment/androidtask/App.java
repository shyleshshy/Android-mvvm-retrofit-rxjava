package com.assignment.androidtask;

import android.app.Application;

import com.assignment.androidtask.api.ApiClient;
import com.assignment.androidtask.api.ApiService;
import com.assignment.androidtask.data.AppPreferencesHelper;
import com.assignment.androidtask.data.PreferencesHelper;

public class App extends Application {

    private static PreferencesHelper mPreferencesHelper;
    private static ApiService mApiService;

    @Override
    public void onCreate() {
        super.onCreate();

        mPreferencesHelper = new AppPreferencesHelper(this);
        mApiService = ApiClient.getClient(this).create(ApiService.class);
    }

    public static PreferencesHelper getPref() {
        return mPreferencesHelper;
    }

    public static ApiService getApiService() {
        return mApiService;
    }
}
