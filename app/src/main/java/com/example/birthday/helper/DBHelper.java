package com.example.birthday.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    final String LOG_TAG = "myLogs";
    public DBHelper(Context context) {
        // конструктор суперкласса
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");
        // создаем таблицу с полями
//        surname name patronymic telephone
        db.execSQL("create table person ("
                + "id integer primary key autoincrement,"
                + "surname text not null,"
                + "name text,"
                + "patronymic text,"
                + "telephone integer" + ");");
        // data event id idPerson
        // FOREIGN KEY (auth_id) REFERENCES auth(id)
        db.execSQL("create table event ("
                + "id integer primary key autoincrement,"
                + "data text not null,"
                + "event text,"
                + "idPerson integer not null ,FOREIGN KEY (idPerson) REFERENCES person(id));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}