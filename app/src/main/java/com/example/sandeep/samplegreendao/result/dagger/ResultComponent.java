package com.example.sandeep.samplegreendao.result.dagger;

import com.example.sandeep.samplegreendao.dagger.AppComponent;
import com.example.sandeep.samplegreendao.result.ResultActivity;
import com.example.sandeep.samplegreendao.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by sandeep on 11/9/2016.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ResultModule.class})
public interface ResultComponent {
    void inject(ResultActivity view);
}
