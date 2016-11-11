package com.example.sandeep.samplegreendao.db.provider;

import com.example.sandeep.samplegreendao.db.Student;
import com.example.sandeep.samplegreendao.db.StudentDao;
import com.example.sandeep.samplegreendao.db.Teacher;
import com.example.sandeep.samplegreendao.db.TeacherDao;
import com.example.sandeep.samplegreendao.result.FeedBackDetails;

import java.util.ArrayList;
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
    public List<Student> getStudentData() {
        int count = (int) studentDao.count();
        return studentDao.queryBuilder().where(StudentDao.Properties.Id.eq(count)).list();
    }

    @Override
    public boolean addOrUpdateTeachersData(Teacher teacher) {
        return teacherDao.insertOrReplace(teacher)!=0;
    }

    @Override
    public List<String> getTeacherData() {
        List<Teacher> teacherList = teacherDao.loadAll();
        List<String> nameList = new ArrayList<>();
        for(int i=0; i<teacherList.size();i++){
            nameList.add(teacherList.get(i).getName());
        }

        return  nameList;
    }

    @Override
    public List<FeedBackDetails> getFeedbackData(){
        List<Student> studentList = getStudentData();
        List<Teacher> teacherList = new ArrayList<>();
        List<FeedBackDetails> data = new ArrayList<>();

        for(int i=0; i<studentList.size(); i++){
            teacherList.add(studentList.get(i).get_id());
            FeedBackDetails details= new FeedBackDetails(studentList.get(i).getName(),
                    teacherList.get(i).getName(),teacherList.get(i).getRating());
            data.add(details);
        }
        return data;

    }

    public List<String> getVoterList(String name){
        List<Teacher> teacherList = getTeacherData(name);
        List<Student> studentList = new ArrayList<>();
        for(int i=0; i<teacherList.size(); i++){
            studentList.addAll(teacherList.get(i).getStudentList());
        }
        List<String> voterList = new ArrayList<>();
        for(int i=0; i<studentList.size(); i++){
            voterList.add(studentList.get(i).getName());
        }
        return voterList;
    }

    private List<Teacher> getTeacherData(String name) {
        return teacherDao.queryBuilder().where(TeacherDao.Properties.Name.eq(name)).list();
    }
}
