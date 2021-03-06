package com.example.sandeep.samplegreendao.db;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "STUDENT".
*/
public class StudentDao extends AbstractDao<Student, Long> {

    public static final String TABLENAME = "STUDENT";

    /**
     * Properties of entity Student.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Roll_no = new Property(0, String.class, "roll_no", false, "ROLL_NO");
        public final static Property F_name = new Property(1, String.class, "f_name", false, "F_NAME");
        public final static Property S_class = new Property(2, String.class, "s_class", false, "S_CLASS");
        public final static Property Name = new Property(3, String.class, "name", false, "NAME");
        public final static Property Id = new Property(4, Long.class, "id", true, "_id");
    }

    private DaoSession daoSession;

    private Query<Student> teacher_StudentListQuery;

    public StudentDao(DaoConfig config) {
        super(config);
    }
    
    public StudentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"STUDENT\" (" + //
                "\"ROLL_NO\" TEXT," + // 0: roll_no
                "\"F_NAME\" TEXT," + // 1: f_name
                "\"S_CLASS\" TEXT," + // 2: s_class
                "\"NAME\" TEXT," + // 3: name
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT );"); // 4: id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"STUDENT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Student entity) {
        stmt.clearBindings();
 
        String roll_no = entity.getRoll_no();
        if (roll_no != null) {
            stmt.bindString(1, roll_no);
        }
 
        String f_name = entity.getF_name();
        if (f_name != null) {
            stmt.bindString(2, f_name);
        }
 
        String s_class = entity.getS_class();
        if (s_class != null) {
            stmt.bindString(3, s_class);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(5, id);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Student entity) {
        stmt.clearBindings();
 
        String roll_no = entity.getRoll_no();
        if (roll_no != null) {
            stmt.bindString(1, roll_no);
        }
 
        String f_name = entity.getF_name();
        if (f_name != null) {
            stmt.bindString(2, f_name);
        }
 
        String s_class = entity.getS_class();
        if (s_class != null) {
            stmt.bindString(3, s_class);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(5, id);
        }
    }

    @Override
    protected final void attachEntity(Student entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4);
    }    

    @Override
    public Student readEntity(Cursor cursor, int offset) {
        Student entity = new Student( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // roll_no
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // f_name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // s_class
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // name
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4) // id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Student entity, int offset) {
        entity.setRoll_no(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setF_name(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setS_class(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Student entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Student entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Student entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "studentList" to-many relationship of Teacher. */
    public List<Student> _queryTeacher_StudentList(Long id) {
        synchronized (this) {
            if (teacher_StudentListQuery == null) {
                QueryBuilder<Student> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Id.eq(null));
                teacher_StudentListQuery = queryBuilder.build();
            }
        }
        Query<Student> query = teacher_StudentListQuery.forCurrentThread();
        query.setParameter(0, id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getTeacherDao().getAllColumns());
            builder.append(" FROM STUDENT T");
            builder.append(" LEFT JOIN TEACHER T0 ON T.\"_id\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Student loadCurrentDeep(Cursor cursor, boolean lock) {
        Student entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Teacher _id = loadCurrentOther(daoSession.getTeacherDao(), cursor, offset);
        entity.set_id(_id);

        return entity;    
    }

    public Student loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Student> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Student> list = new ArrayList<Student>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Student> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Student> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
