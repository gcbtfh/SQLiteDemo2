package com.example.tonghung.sqlitedemo2.database;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tonghung.sqlitedemo2.object.Item;

/**
 * Created by tonghung on 22/12/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context/*, String name, SQLiteDatabase.CursorFactory factory, int version*/) {
        super(context, "SQLiteDemo2.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_thucdon(id integer primary key autoincrement, type text not " +
                "null, title text not null, description text not null, price integer not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tb_thucdon");
        onCreate(db);
    }

    public long insertItem(Item item){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", item.getType());
        contentValues.put("title", item.getTitle());
        contentValues.put("description", item.getDesc());
        contentValues.put("price", item.getPrice());

        return db.insert("tb_thucdon", null, contentValues);
    }

    public Cursor selectItem(String type){
        SQLiteDatabase db = getReadableDatabase();
        return db.query("tb_thucdon", null, "type = ?", new String[]{type}, null, null, null);
    }
}
