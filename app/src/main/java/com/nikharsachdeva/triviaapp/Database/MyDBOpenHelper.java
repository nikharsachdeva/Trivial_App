package com.nikharsachdeva.triviaapp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

/*
* Open helper class for Database Basic Operations
* */
public class MyDBOpenHelper extends SQLiteOpenHelper {


    public static final String TAG = "myTag";
    public static final String DATABASE_NAME = "quizInfo.db";
    public static final int DATABASE_VERSION = 1;

    public MyDBOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QuizTable.SQL_CREATE);
        Log.d(TAG, "onCreate: db created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
