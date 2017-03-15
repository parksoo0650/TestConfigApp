package com.hanbit.testconfigapp.factory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hanbit on 2017-03-15.
 */

public abstract class QueryFactory {
    SQLiteDatabase db;
    SQLiteOpenHelper helper;
    Context context;

    public QueryFactory(Context context) {
        this.context = context;
    }

    public abstract SQLiteDatabase getDatabase();
}
