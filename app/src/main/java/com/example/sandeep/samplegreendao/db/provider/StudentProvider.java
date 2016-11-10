package com.example.sandeep.samplegreendao.db.provider;

import com.example.sandeep.samplegreendao.db.Student;
import com.example.sandeep.samplegreendao.db.Teacher;

import java.util.List;

/**
 * Created by sandeep on 11/8/2016.
 */

public interface StudentProvider {

    boolean addOrUpdateStudentData(Student student);

    List<Student> loadStudentData();

    boolean addOrUpdateTeachersData(Teacher teacher);

    List<Teacher> loadTeacherData();

}
