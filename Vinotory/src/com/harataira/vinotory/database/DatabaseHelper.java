package com.harataira.vinotory.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database
    // version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    // Table names
    public static final String TABLE_WINE_BOTTLE = "WINE_BOTTLE";

    // Wine Bottle Table Columns
    public static final String KEY_WINE_BOTTLE_ID = "ID";
    public static final String KEY_WINE_BOTTLE_VINEYARD = "VINEYARD";
    public static final String KEY_WINE_BOTTLE_YEAR = "YEAR";
    public static final String KEY_WINE_BOTTLE_TYPE = "TYPE";
    public static final String KEY_WINE_BOTTLE_QUANTITY = "QUANTITY";
    public static final String KEY_WINE_BOTTLE_COMMENT = "COMMENT";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_WINE_BOTTLE_TABLE = "CREATE TABLE " + TABLE_WINE_BOTTLE
                + "(" + KEY_WINE_BOTTLE_ID + " INTEGER PRIMARY KEY,"
                + KEY_WINE_BOTTLE_VINEYARD + " TEXT," 
                + KEY_WINE_BOTTLE_YEAR + " INTEGER," 
                + KEY_WINE_BOTTLE_TYPE + " TEXT,"
                + KEY_WINE_BOTTLE_QUANTITY + " INTEGER,"
                + KEY_WINE_BOTTLE_COMMENT + " TEXT" + ")";
        db.execSQL(CREATE_WINE_BOTTLE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WINE_BOTTLE);

        // Create tables again
        onCreate(db);
    }
}
