package com.example.deathnum.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class StatsDatabaseManager {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public StatsDatabaseManager(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void incrementModeCount(String gameMode) {
        ContentValues values = new ContentValues();
        values.put(DatabaseConstants.COLUMN_COUNT, getModeCount(gameMode) + 1);

        database.update(DatabaseConstants.TABLE_STATS,
                values,
                DatabaseConstants.COLUMN_MODE + " = ?",
                new String[]{gameMode});
    }

    public int getModeCount(String gameMode) {
        int count = 0;
        Cursor cursor = database.query(
                DatabaseConstants.TABLE_STATS,
                new String[]{DatabaseConstants.COLUMN_COUNT},
                DatabaseConstants.COLUMN_MODE + " = ?",
                new String[]{gameMode},
                null, null, null
        );

        if (cursor != null && cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseConstants.COLUMN_COUNT));
            cursor.close();
        }

        return count;
    }

    public Cursor getAllStats() {
        return database.query(
                DatabaseConstants.TABLE_STATS,
                new String[]{DatabaseConstants.COLUMN_MODE, DatabaseConstants.COLUMN_COUNT},
                null, null, null, null, null
        );
    }
    public void saveGameScore(String gameMode, int score) {
        ContentValues values = new ContentValues();
        values.put(DatabaseConstants.COLUMN_MODE, gameMode);
        values.put(DatabaseConstants.COLUMN_SCORE, score);

        database.insert(DatabaseConstants.TABLE_SCORES, null, values);
    }
    public int getLastScore(String gameMode) {
        int lastScore = 0;
        Cursor cursor = database.query(
                DatabaseConstants.TABLE_SCORES,
                new String[]{DatabaseConstants.COLUMN_SCORE},
                DatabaseConstants.COLUMN_MODE + " = ?",
                new String[]{gameMode},
                null, null,
                DatabaseConstants.COLUMN_TIMESTAMP + " DESC",
                "1"
        );

        if (cursor != null && cursor.moveToFirst()) {
            lastScore = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseConstants.COLUMN_SCORE));
            cursor.close();
        }

        return lastScore;
    }

    public int getBestScore(String gameMode) {
        int bestScore = 0;
        Cursor cursor = database.query(
                DatabaseConstants.TABLE_SCORES,
                new String[]{"MAX(" + DatabaseConstants.COLUMN_SCORE + ") as max_score"},
                DatabaseConstants.COLUMN_MODE + " = ?",
                new String[]{gameMode},
                null, null, null
        );

        if (cursor != null && cursor.moveToFirst()) {
            bestScore = cursor.getInt(0);
            cursor.close();
        }

        return bestScore;
    }
}
