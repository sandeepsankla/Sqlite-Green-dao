package com.example.sandeep.samplegreendao.db.provider;

import com.example.sandeep.samplegreendao.db.Student;
import com.example.sandeep.samplegreendao.db.Teacher;
import com.example.sandeep.samplegreendao.result.FeedBackDetails;

import java.util.List;

/**
 * Created by sandeep on 11/8/2016.
 */

public interface StudentProvider {

    boolean addOrUpdateStudentData(Student student);

    List<Student> getStudentData();

    boolean addOrUpdateTeachersData(Teacher teacher);

    List<Teacher> getTeacherData();

    List<FeedBackDetails> getFeedbackData();

}
