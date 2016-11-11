package com.example.sandeep.samplegreendao.result;

import com.example.sandeep.samplegreendao.db.Teacher;
import com.example.sandeep.samplegreendao.db.provider.StudentProvider;

import java.util.List;

/**
 * Created by sandeep on 11/9/2016.
 */

public class ResultPresenterImpl implements ResultPresenter {
    private ResultView view;
    StudentProvider dataProvider;

    public ResultPresenterImpl(ResultView view, StudentProvider studentProvider) {
        this.view = view;
        this.dataProvider = studentProvider;
    }

    @Override
    public void onAttach() {

    }

    @Override
    public void onOneRelClicked() {
        if (dataProvider != null) {
            List<FeedBackDetails> data = dataProvider.getFeedbackData();
            view.showDailog(data);
        }
    }

    @Override
    public void onManyRelClicked() {
        if (dataProvider != null) {
                List<String> teacherList = dataProvider.getTeacherData();
            view.showTeacherList(teacherList);
        }
    }

    @Override
    public void setSelectedTeacher(String name) {
        List<String> data = dataProvider.getVoterList(name);
        view.showVoterList(data);
    }
}
