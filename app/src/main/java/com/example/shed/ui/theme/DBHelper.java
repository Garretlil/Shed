package com.example.shed.ui.theme;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
   private static final int  DATABASE_VERSION=1;
    private static final String  DATABASE_NAME="CalcDB";
    private static final String  TABLE_CONTACTS="contacts";
    //---------------
    private static final String  KEY_ID="id";
    private static final String  KEY_EXPRESSION="expression";
   public DBHelper(Context context){
       super(context, DATABASE_NAME,null,DATABASE_VERSION);
   }
    @Override
    public void onCreate(SQLiteDatabase db) {
           db.execSQL(" CREATE table " + TABLE_CONTACTS+ "(" + KEY_ID + "integer primary key," + KEY_EXPRESSION + "text"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("drop table if exists " + TABLE_CONTACTS);
         onCreate(db);
    }
}
