package com.example.sandeep.samplegreendao.feedback;

/**
 * Created by sandeep on 11/3/2016.
 */

public interface StudentPresenter {

    void attachPresenter();

    void SubmitFeedBackDetails(String name, String fName, String std, String roll, boolean teacherData);

}
