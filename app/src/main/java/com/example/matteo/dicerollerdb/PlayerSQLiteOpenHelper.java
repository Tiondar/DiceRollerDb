package com.example.matteo.dicerollerdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class PlayerSQLiteOpenHelper extends SQLiteOpenHelper{

    PlayerSQLiteOpenHelper(Context context){
        super(context,"player", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        TableLook.onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
