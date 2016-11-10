package com.example.sandeep.samplegreendao.result;

import com.example.sandeep.samplegreendao.db.provider.StudentProvider;

/**
 * Created by sandeep on 11/9/2016.
 */

public class ResultPresenterImpl implements ResultPresenter {
    private ResultView view;
    StudentProvider dataProvider;
    private String studentName;

    public ResultPresenterImpl(ResultView view, StudentProvider studentProvider) {
            this.view = view;
            this.dataProvider = studentProvider;
    }

    @Override
    public void onAttach() {

    }

    @Override
    public void onOneRelClicked(String name) {
        if(dataProvider!=null){
            dataProvider.getFeedbackData(name);
        }
    }
}
