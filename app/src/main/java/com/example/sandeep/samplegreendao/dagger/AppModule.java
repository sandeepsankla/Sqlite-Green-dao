package com.example.sandeep.samplegreendao.dagger;

import android.app.Application;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sandeep on 10/28/2016.
 */
@Module
public class AppModule {

    MyApplication application;

    public AppModule(MyApplication app) {
        this.application = app;
    }

    @Provides
    public Application getApplication() {
        return application;
    }

}
