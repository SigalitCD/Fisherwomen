package com.fisherwomen.fisherwomen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Katya on 8/2/15.
 */
public class NoticeDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Yad2DB";
    public static final String MAIN_TABLE = "NoticesTable";
    private static final int DB_VERSION = 1;

    private static final String CREATE_MAIN_TABLE =
            "CREATE TABLE " + MAIN_TABLE + " (" +
                    "_id INTEGER NOT NULL PRIMARY KEY, " +
                    "New INTEGER, "+
                    "Context TEXT, " +
                    "Rooms INTEGER, " +
                    "Price TEXT, " +
                    "Site TEXT, " +
                    "Date TEXT)";

    private static final String INSERT_QUERY =
            "INSERT INTO " + MAIN_TABLE + " " +
                    "(New, Context, Rooms, Price, Site, Date)" +
                    "VALUES " +
                    "(1, 'text 5', 2, 4000000, 'yad2', '07/08/15'), " +
                    "(1, 'text 2', 2, 2500000, 'yad2', '07/08/15'), " +
                    "(1, 'text 3', 3, 3000000, 'yad2', '17/12/15'), " +
                    "(0, 'text 6', 5, 4000000, 'winwin', '07/08/15'), " +
                    "(1, 'text 1', 6, 6000000, 'winwin', '07/08/15'), " +
                    "(1, 'text 4', 4, 5000000, 'yad2', '07/08/15')";


    NoticeDBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MAIN_TABLE);
        db.execSQL(INSERT_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("NoticeDBHelper", "Upgrading database from version " + oldVersion
                + " to " + newVersion + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS " + MAIN_TABLE);
        this.onCreate(db);

    }
}
