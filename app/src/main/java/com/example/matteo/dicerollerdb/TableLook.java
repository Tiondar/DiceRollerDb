package com.example.matteo.dicerollerdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;


public final class TableLook {
    // To prevent someone from accidentally instantiating the TableLook class,
    // give it an empty constructor.
    public TableLook() {}

    /* Inner class that defines the table contents */
    public static abstract class TableLooker implements BaseColumns {

        public static final String TABLE_NAME = "entry";
        public static final String _ID = " id";
        public static final String PLAYERNAME = "player";
        public static final String D4NUMBER = "d4numb";
        public static final String D6NUMBER = "d6numb";
        public static final String D8NUMBER = "d8numb";
        public static final String D10NUMBER = "d10numb";
        public static final String D12NUMBER = "d12numb";
        public static final String D20NUMBER = "d20numb";
        public static final String D100NUMBER = "d100numb";
        public static final String MODIFIER = "modifier";

    }

    public static final String TEXT_TYPE = " INTEGER";
    public static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TableLooker.TABLE_NAME + " (" +
                    TableLooker._ID + " integer primary key autoincrement, "+
                    TableLooker.PLAYERNAME + " TEXT" + COMMA_SEP +
                    TableLooker.D4NUMBER + TEXT_TYPE + COMMA_SEP +
                    TableLooker.D6NUMBER + TEXT_TYPE + COMMA_SEP +
                    TableLooker.D8NUMBER + TEXT_TYPE + COMMA_SEP +
                    TableLooker.D10NUMBER + TEXT_TYPE + COMMA_SEP +
                    TableLooker.D12NUMBER + TEXT_TYPE + COMMA_SEP +
                    TableLooker.D20NUMBER + TEXT_TYPE + COMMA_SEP +
                    TableLooker.D100NUMBER + TEXT_TYPE + COMMA_SEP +
                    TableLooker.MODIFIER + TEXT_TYPE + " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TableLooker.TABLE_NAME;

    public static void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXIST " + TableLooker.TABLE_NAME);
    }
}