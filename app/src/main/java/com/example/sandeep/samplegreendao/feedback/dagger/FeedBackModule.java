package com.example.sandeep.samplegreendao.feedback.dagger;

import com.example.sandeep.samplegreendao.db.provider.StudentProvider;
import com.example.sandeep.samplegreendao.feedback.StudentPresenter;
import com.example.sandeep.samplegreendao.feedback.StudentPresenterImpl;
import com.example.sandeep.samplegreendao.feedback.StudentView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sandeep on 11/3/2016.
 */
@Module
public class FeedBackModule {

    private StudentView view;

    public FeedBackModule(StudentView view){
        this.view = view;
    }

    @Provides
    public StudentPresenter providesStudentPresenter(StudentProvider studentProvider){
        return new StudentPresenterImpl(view,studentProvider);
    }

}
