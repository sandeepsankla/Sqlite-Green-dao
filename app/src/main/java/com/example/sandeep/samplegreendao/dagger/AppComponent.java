package com.example.sandeep.samplegreendao.dagger;

import android.app.Application;

import com.example.sandeep.samplegreendao.db.dagger.DataBaseModule;
import com.example.sandeep.samplegreendao.db.provider.StudentProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sandeep on 10/28/2016.
 */
@Singleton
@Component(modules = {AppModule.class,
        DataBaseModule.class
})

public interface AppComponent {
    Application application();
    StudentProvider studentprovider();
}
