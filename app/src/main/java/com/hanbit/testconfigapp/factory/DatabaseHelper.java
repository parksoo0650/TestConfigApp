package com.hanbit.testconfigapp.factory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hanbit on 2017-03-15.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "hanbit.db";
    final static Integer DATABASE_VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="CREATE TABLE IF NOT EXISTS Member(_id integer primary key autoincrement, name TEXT, phone TEXT, age TEXT, address TEXT, salary TEXT);" +
                "CREATE TABLE IF NOT EXISTS Message(_id integer primary key autoincrement, title TEXT,content TEXT, write_date TEXT, sender TEXT, receiver TEXT, FOREIGN KEY(sender) REFERENCES Member(_id), FOREIGN KEY(receiver) REFERENCES Member(_id));";
        db.execSQL(sql);
        for (int i = 0; i < 10; i++) {
            db.execSQL(String.format("INSERT INTO Member(name,phone,age,address,salary) VALUES ('%s','%s','%s','%s','%s'); \n",
                    "홍길동" + i, "010-0000-000" + i, "2", "서울", (i + 1) + "00"));
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Member");
        onCreate(db);
    }

}
