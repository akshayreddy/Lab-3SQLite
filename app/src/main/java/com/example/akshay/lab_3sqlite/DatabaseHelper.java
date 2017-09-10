package com.example.akshay.lab_3sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by akshay on 9/10/17.
 */


/*Extend the subclass SQLiteOpenHelper and click on the red pop up to implement the onCreate and onUpgrade methods
Also create a constructor*/

/*make changes to the constructor */






public class DatabaseHelper extends SQLiteOpenHelper{

    /* create default variale DATABASE_NAME and TABLE_NAME */

    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = " student_table ";

    /* Create table variable*/
    public static final String COL_1 ="id ";
    public static final String COL_2 = "name";
    public static final String COL_3 = "surname";
    public static final String COL_4 = "cgpa";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
       // SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "create table " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, surname TEXT, cgpa FLOAT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists" + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String name,String surname,String cgpa) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,cgpa);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}
