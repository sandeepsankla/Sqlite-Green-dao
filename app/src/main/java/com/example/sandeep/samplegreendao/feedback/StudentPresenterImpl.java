package com.example.sandeep.samplegreendao.feedback;

import android.support.annotation.NonNull;

import com.example.sandeep.samplegreendao.R;
import com.example.sandeep.samplegreendao.db.Student;
import com.example.sandeep.samplegreendao.db.Teacher;
import com.example.sandeep.samplegreendao.db.provider.StudentProvider;
import com.example.sandeep.samplegreendao.utility.StringUtils;

/**
 * Created by sandeep on 11/3/2016.
 */

public class StudentPresenterImpl implements StudentPresenter {

    private StudentView studentView;
    private StudentProvider studentProvider;
    private Student student;
    private Teacher teacher;

    public StudentPresenterImpl(StudentView view, StudentProvider studentProvider) {
        this.studentView = view;
        this.studentProvider = studentProvider;

    }

    @Override
    public void attachPresenter() {
        studentView.initAppBarLayout();
    }

    @Override
    public void SubmitFeedBackDetails(@NonNull String name, @NonNull String fName, @NonNull String standard, @NonNull String rollNos, boolean teacherData) {
        if (!StringUtils.isNullOrEmpty(name) && !StringUtils.isNullOrEmpty(fName) && !StringUtils.isNullOrEmpty(standard) && !StringUtils.isNullOrEmpty(rollNos)) {
            if (teacherData) {
                teacher = new Teacher();
                teacher.setName(name);
                teacher.setSubject(fName);
                teacher.setRating(standard);
                teacher.setTeacher_id(rollNos);
                savedb();
            } else {
                student = new Student();
                student.setName(name);
                student.setF_name(fName);
                student.setS_class(standard);
                student.setRoll_no(rollNos);
                saveTodb();
            }


        }
    }

    private void savedb() {
        if (studentProvider != null) {
            boolean isSaved = studentProvider.addOrUpdateTeachersData(teacher);
            if (isSaved) {
                studentView.navigateToResultActivity();
            } else {
                studentView.showToast(R.string.error_message);
            }
        }
    }

    private void saveTodb() {
        if (studentProvider != null) {
            boolean isSaved = studentProvider.addOrUpdateStudentData(student);
            if (isSaved) {
                studentView.showTeacherFeedBackForm();
            } else {
                studentView.showToast(R.string.error_message);
            }
        }
    }
}
