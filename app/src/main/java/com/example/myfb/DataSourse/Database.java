package com.example.myfb.DataSourse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "fakebook.db";
    public static final int DB_VERSION=1;
    public static final String TABLE_NAME = "studentDetails";

   public static  final  String new_id="ID";
    public static final String new_name = "Name";
    public static final String new_age= "Age";
    public static final String new_mark = "Mark";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
            new_id + " INTEGER PRIMARY KEY AUTOINCREMENT ," + new_name + " VARCHAR(50) ," +
            new_age + " INTEGER ," +
            new_mark + " INTEGER ) ; " ;
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;


    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase mydb = this.getWritableDatabase();



    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
    public boolean insertDetails(String Name,String Age,String Marks){
        try (SQLiteDatabase mydb = this.getWritableDatabase()) {
            ContentValues contentValues=new ContentValues();
            contentValues.put(new_name,Name);
            contentValues.put(new_age,Age);
            contentValues.put(new_mark,Marks);
            long result=mydb.insert(TABLE_NAME,null,contentValues);
            if (result== -1)
                return true;
        }
        return false;
    }
    public Cursor getDetails(){
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor result=mydb.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return result;
    }
    public Cursor searchData(String name){
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor result=mydb.rawQuery("SELECT * FROM " + TABLE_NAME+ " WHERE "+ new_name + " = " + name +";",null);
        return result;
    }

}
