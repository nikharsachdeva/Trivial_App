package com.nikharsachdeva.triviaapp.History;

import android.content.ContentValues;
import android.content.Intent;

import com.nikharsachdeva.triviaapp.Database.QuizTable;

// Model class

public class AnswersModel {
    public String DateTime;
    public String GameNumber;
    public String Name;
    public String Cricketer;
    public String Colors;

    public AnswersModel(String dateTime, String gameNumber, String name, String cricketer, String colors) {
        DateTime = dateTime;
        GameNumber = gameNumber;
        Name = name;
        Cricketer = cricketer;
        Colors = colors;
    }

    public ContentValues getContentValues() {
        //Number of columns = 5, ID will auto increment , hence i/p 4
        ContentValues contentValues = new ContentValues(4);
        contentValues.put(QuizTable.COLUMN_DATETIME, this.DateTime);
        contentValues.put(QuizTable.COLUMN_NAME, this.Name);
        contentValues.put(QuizTable.COLUMN_CRICKETER, this.Cricketer);
        contentValues.put(QuizTable.COLUMN_COLORS, this.Colors);

        return contentValues;

    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String getGameNumber() {
        return GameNumber;
    }

    public void setGameNumber(String gameNumber) {
        GameNumber = gameNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCricketer() {
        return Cricketer;
    }

    public void setCricketer(String cricketer) {
        Cricketer = cricketer;
    }

    public String getColors() {
        return Colors;
    }

    public void setColors(String colors) {
        Colors = colors;
    }
}
