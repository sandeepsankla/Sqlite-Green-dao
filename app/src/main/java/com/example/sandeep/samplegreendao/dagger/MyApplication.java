package com.example.sandeep.samplegreendao.dagger;

import android.app.Application;
import android.content.Context;

import com.example.sandeep.samplegreendao.db.dagger.DataBaseModule;

import dagger.internal.DaggerCollections;


/**
 * Created by sandeep on 10/27/2016.
 */

public class MyApplication extends Application {

    private MyApplication application;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        initAppComponent();
    }


    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
