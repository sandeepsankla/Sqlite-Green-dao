package com.example.sandeep.samplegreendao.feedback.dagger;


import com.example.sandeep.samplegreendao.dagger.AppComponent;
import com.example.sandeep.samplegreendao.feedback.StudentActivity;
import com.example.sandeep.samplegreendao.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by sandeep on 11/3/2016.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {FeedBackModule.class})
public interface FeedBackComponent {
    void inject(StudentActivity view);
}
