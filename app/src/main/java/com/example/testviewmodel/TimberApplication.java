package com.example.testviewmodel;

import android.app.Application;

import timber.log.Timber;

public class TimberApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
    }
}
