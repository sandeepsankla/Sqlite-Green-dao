package com.example.sandeep.samplegreendao.db.dagger;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.sandeep.samplegreendao.db.DaoMaster;
import com.example.sandeep.samplegreendao.db.DaoSession;
import com.example.sandeep.samplegreendao.db.provider.StudentProvider;
import com.example.sandeep.samplegreendao.db.provider.StudentProviderImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sandeep on 11/8/2016.
 */
@Singleton
@Module
public class DataBaseModule {

    public DataBaseModule() {
    }

    @Singleton
    @Provides
    public DaoSession providesDaoSession(Application app) {
        DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(app.getApplicationContext(),
                                                                  "sample_db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        return daoMaster.newSession();
    }


    @Provides
    public StudentProvider providesStudentProvider(DaoSession daoSession) {
        return new StudentProviderImpl(daoSession.getStudentDao(),
                                       daoSession.getTeacherDao());
    }
}
