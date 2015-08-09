package com.fisherwomen.fisherwomen;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jebia on 7/10/2015.
 */
public class SearchModel {

    private Context activity;

    private static NoticeDBHelper noticeDBHelper = null;
    private static SQLiteDatabase noticeDB = null;
    private static Cursor cursor = null;
    private static SimpleCursorAdapter cursorAdapter = null;

    public SearchModel(Context activity) {
        this.activity = activity;

        noticeDBHelper = new NoticeDBHelper(activity);
        noticeDB = noticeDBHelper.getWritableDatabase();
        setCursorAdapter();

//        data = new ArrayList<>();
    }



    public void sortByButton(String sortedColumn){
        cursor = noticeDB.rawQuery("SELECT * from " + noticeDBHelper.MAIN_TABLE + " ORDER BY " + sortedColumn, null);
        String[] from = {
                cursor.getColumnName(1),
                cursor.getColumnName(2),
                cursor.getColumnName(3),
                cursor.getColumnName(4),
                cursor.getColumnName(5),
                cursor.getColumnName(6)
        };
        int[] to = {
                R.id.tbl_c1,
                R.id.tbl_c2,
                R.id.tbl_c3,
                R.id.tbl_c4,
                R.id.tbl_c5,
                R.id.tbl_c10
        };
        cursorAdapter.changeCursor(cursor);
    }

    public SimpleCursorAdapter getCursorAdapter() {
        return cursorAdapter;
    }

    private void setCursorAdapter(){
        cursor = noticeDB.rawQuery("SELECT * from " + noticeDBHelper.MAIN_TABLE, null);

        String[] from = {   cursor.getColumnName(1),
                cursor.getColumnName(2),
                cursor.getColumnName(3),
                cursor.getColumnName(4),
                cursor.getColumnName(5),
                cursor.getColumnName(6)
        };
        int[] to = {    R.id.tbl_c1,
                R.id.tbl_c2,
                R.id.tbl_c3,
                R.id.tbl_c4,
                R.id.tbl_c5,
                R.id.tbl_c10
        };
        cursorAdapter = new SimpleCursorAdapter(activity, R.layout.notice_layout, cursor, from, to, 0);
    }
}

