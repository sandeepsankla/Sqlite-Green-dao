package com.example.sandeep.samplegreendao.db.provider;

import com.example.sandeep.samplegreendao.db.Student;
import com.example.sandeep.samplegreendao.db.StudentDao;
import com.example.sandeep.samplegreendao.db.Teacher;
import com.example.sandeep.samplegreendao.db.TeacherDao;

import java.util.List;

/**
 * Created by sandeep on 11/8/2016.
 */

public class StudentProviderImpl implements StudentProvider {

    private StudentDao studentDao;
    private TeacherDao teacherDao;

    public StudentProviderImpl(StudentDao studentDao, TeacherDao teacherDao) {
        this.studentDao = studentDao;
        this.teacherDao = teacherDao;
    }

    @Override
    public boolean addOrUpdateStudentData(Student student) {
        return studentDao.insertOrReplace(student)!=0;
    }

    @Override
    public List<Student> loadStudentData() {
        return studentDao.loadAll();
    }

    @Override
    public boolean addOrUpdateTeachersData(Teacher teacher) {
        return teacherDao.insertOrReplace(teacher)!=0;
    }

    @Override
    public List<Teacher> loadTeacherData() {
        return teacherDao.loadAll();
    }
}
