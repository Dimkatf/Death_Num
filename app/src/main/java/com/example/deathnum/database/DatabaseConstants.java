package com.example.deathnum.database;

public class DatabaseConstants {
    public static final String DATABASE_NAME = "game_stats.db";
    public static final int DATABASE_VERSION = 2;

    public static final String TABLE_STATS = "statistics";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_MODE = "game_mode";
    public static final String COLUMN_COUNT = "visit_count";

    public static final String MODE_ONE_PLAYER = "one_player";
    public static final String MODE_TWO_PLAYERS = "two_players";
    public static final String MODE_SUPER_GAME = "super_game";
    public static final String MODE_FIFTY_FIFTY = "fifty_fifty";

    public static final String TABLE_SCORES = "scores";
    public static final String COLUMN_SCORE = "score";
    public static final String COLUMN_TIMESTAMP = "timestamp";
}
