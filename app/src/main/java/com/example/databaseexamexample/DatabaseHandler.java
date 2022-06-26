package com.example.databaseexamexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static String DB_NAME = "myexamdb";
    private static int VERSION = 1;
    private static String TABLE_NAME = "contacts";
    private static String CID = "cid";
    private static String CNAME = "cname";
    private static String CNUMBER = "cnumber";
    public DatabaseHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+TABLE_NAME+"("+CID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CNAME+" TEXT,"+CNUMBER+" TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public boolean addcontact(String name,String number){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CNAME,name);
        values.put(CNUMBER,number);
        long ans = database.insert(TABLE_NAME,null,values);
        if (ans <= 0){
            return false;
        }else {
            return true;
        }
    }
}
