package com.example;


import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;


public class SampleDaoGenerator {

    public static int DB_VERSION = 1;
    public static void main(String[] args) throws Exception {

        Schema schema  = new Schema(DB_VERSION, "com.example.sandeep.samplegreendao.db");

        addEntities(schema);

        new DaoGenerator().generateAll(schema, "./app/src/main/java/");
    }

    private static void addEntities(Schema schema) {

        Entity student = schema.addEntity("Student");
        student.addStringProperty("name");
        student.addStringProperty("f_name");
        student.addStringProperty("s_class");
        student.addStringProperty("roll_no").primaryKey();

        Entity teacher  = schema.addEntity("Teacher");
        teacher.addStringProperty("name");
        teacher.addStringProperty("subject");
        teacher.addStringProperty("rating");
        teacher.addStringProperty("teacher_id").primaryKey();
    }
}