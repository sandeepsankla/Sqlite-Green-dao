package com.example.sandeep.samplegreendao.result.dagger;

import com.example.sandeep.samplegreendao.db.provider.StudentProvider;
import com.example.sandeep.samplegreendao.result.ResultPresenter;
import com.example.sandeep.samplegreendao.result.ResultPresenterImpl;
import com.example.sandeep.samplegreendao.result.ResultView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sandeep on 11/9/2016.
 */
@Module
public class ResultModule {
    private ResultView view;

    public ResultModule(ResultView view){this.view = view;}

    @Provides
    public ResultPresenter provideResultPresenter(StudentProvider studentProvider){
        return new ResultPresenterImpl(view,studentProvider);
    }

}
