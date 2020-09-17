package com.nikharsachdeva.triviaapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nikharsachdeva.triviaapp.History.AnswersModel;

import java.util.ArrayList;
import java.util.List;

/*
 * This class provides an abstraction layer.
 * All the communication part with the database will be done via this class only
 * */
public class QuizDataSource {

    /* MVC Architecture Pattern
Provides Abstraction Layer */


    private Context context;
    private MyDBOpenHelper myDBOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public QuizDataSource(Context context) {
        this.context = context;
        this.myDBOpenHelper = new MyDBOpenHelper(context);
        sqLiteDatabase = myDBOpenHelper.getWritableDatabase();
    }

    /* These 2 functions are created because at time of orientation changes,
     * our database reference might get destroyed, hence it will help survive configuration changes
     * yes it increases code redundancy, but it is controlled . */

    public void open() {

        sqLiteDatabase = myDBOpenHelper.getWritableDatabase();
    }

    /* close will close all connections. only 1 time call can close all connection.
    prevents memory leaks */

    public void close() {
        sqLiteDatabase.close();
    }

    // For inserting into database
    public void insertItem(AnswersModel answersModel) {
        ContentValues values = answersModel.getContentValues();
        sqLiteDatabase.insert(QuizTable.TABLE_QUIZ, null, values);
    }

    // To retrieve data from database.
    public List<AnswersModel> getAllItems() {
        List<AnswersModel> answersModelList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(QuizTable.TABLE_QUIZ, QuizTable.ALL_COLUMNS, null, null, null, null, null);
        while (cursor.moveToNext()) {

            AnswersModel answersModel = new AnswersModel(
                    cursor.getString(cursor.getColumnIndex(QuizTable.COLUMN_DATETIME)),
                    cursor.getString(cursor.getColumnIndex(QuizTable.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(QuizTable.COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndex(QuizTable.COLUMN_CRICKETER)),
                    cursor.getString(cursor.getColumnIndex(QuizTable.COLUMN_COLORS))

            );

            answersModelList.add(answersModel);
        }
        cursor.close();

        return answersModelList;
    }
}
