package com.nikharsachdeva.triviaapp.Database;


// Simple class to hold constant fields related to Database
public class QuizTable {


    public static final String TABLE_QUIZ = "quizTable";

    public static final String COLUMN_ID = "gameId";
    public static final String COLUMN_DATETIME = "dateTime";
    public static final String COLUMN_NAME = "userName";
    public static final String COLUMN_CRICKETER = "userCricketer";
    public static final String COLUMN_COLORS = "userColors";

    //Data will be retrieved in this order
    public static final String[] ALL_COLUMNS =
            new String[]{COLUMN_ID, COLUMN_DATETIME, COLUMN_NAME, COLUMN_CRICKETER, COLUMN_COLORS};

    //Query for creating Table
    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_QUIZ + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DATETIME + " TEXT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_CRICKETER + " TEXT, " +
                    COLUMN_COLORS + " TEXT);";


}
