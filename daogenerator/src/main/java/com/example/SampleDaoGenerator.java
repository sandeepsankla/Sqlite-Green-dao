package com.example;


import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;
import org.greenrobot.greendao.generator.ToMany;


public class SampleDaoGenerator {

    public static int DB_VERSION = 1;
    public static void main(String[] args) throws Exception {

        Schema schema  = new Schema(DB_VERSION, "com.example.sandeep.samplegreendao.db");

        addEntities(schema);

        new DaoGenerator().generateAll(schema, "./app/src/main/java/");
    }

    private static void addEntities(Schema schema) {
        Entity teacher  = schema.addEntity("Teacher");
        teacher.addIdProperty().autoincrement().primaryKey();
        teacher.addStringProperty("name");
        teacher.addStringProperty("subject");
        teacher.addStringProperty("rating");
        teacher.addStringProperty("teacher_id");



        Entity student = schema.addEntity("Student");
        student.addStringProperty("roll_no");
        student.addStringProperty("f_name");
        student.addStringProperty("s_class");
        student.addStringProperty("name");

        Property id = student.addIdProperty().autoincrement().primaryKey().getProperty();
        student.addToOne(teacher,id,"_id");

        //Property relStudentId = teacher.addStringProperty("student_id").getProperty();
        ToMany many =  teacher.addToMany(student, id);
    }
}