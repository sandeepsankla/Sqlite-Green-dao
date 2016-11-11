package com.example.sandeep.samplegreendao.result;


import java.util.List;

/**
 * Created by sandeep on 11/9/2016.
 */

public interface ResultView {

    void showDailog(List<FeedBackDetails> list);

    void showTeacherList(List<String> list);

    void showVoterList(List<String> list);
}
