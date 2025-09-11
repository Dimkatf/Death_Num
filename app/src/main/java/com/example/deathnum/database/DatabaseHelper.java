package com.example.deathnum.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, DatabaseConstants.DATABASE_NAME, null, DatabaseConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + DatabaseConstants.TABLE_STATS + " (" +
                DatabaseConstants.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DatabaseConstants.COLUMN_MODE + " TEXT UNIQUE NOT NULL, " +
                DatabaseConstants.COLUMN_COUNT + " INTEGER DEFAULT 0)";

        db.execSQL(createTable);

        initializeGameModes(db);

        String createScoresTable = "CREATE TABLE " + DatabaseConstants.TABLE_SCORES + " (" +
                DatabaseConstants.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DatabaseConstants.COLUMN_MODE + " TEXT NOT NULL, " +
                DatabaseConstants.COLUMN_SCORE + " INTEGER NOT NULL, " +
                DatabaseConstants.COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP)";

        db.execSQL(createScoresTable);
    }

    private void initializeGameModes(SQLiteDatabase db) {
        String[] modes = {
                DatabaseConstants.MODE_ONE_PLAYER,
                DatabaseConstants.MODE_TWO_PLAYERS,
                DatabaseConstants.MODE_SUPER_GAME,
                DatabaseConstants.MODE_FIFTY_FIFTY
        };

        for (String mode : modes) {
            String insert = "INSERT INTO " + DatabaseConstants.TABLE_STATS +
                    " (" + DatabaseConstants.COLUMN_MODE + ", " + DatabaseConstants.COLUMN_COUNT + ") " +
                    "VALUES ('" + mode + "', 0)";
            db.execSQL(insert);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_STATS);
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseConstants.TABLE_SCORES);
        onCreate(db);
    }
}