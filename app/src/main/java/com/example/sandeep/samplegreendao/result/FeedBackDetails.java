package com.example.sandeep.samplegreendao.result;

/**
 * Created by sandeep on 11/10/2016.
 */

public class FeedBackDetails {
    private String studentName;
    private String teachersName;
    private String teachersRating;

    public FeedBackDetails(String studentName, String teachersName, String teachersRating) {
        this.studentName = studentName;
        this.teachersName = teachersName;
        this.teachersRating = teachersRating;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTeachersRating() {
        return teachersRating;
    }

    public void setTeachersRating(String teachersRating) {
        this.teachersRating = teachersRating;
    }

    public String getTeachersName() {
        return teachersName;
    }

    public void setTeachersName(String teachersName) {
        this.teachersName = teachersName;
    }
}
