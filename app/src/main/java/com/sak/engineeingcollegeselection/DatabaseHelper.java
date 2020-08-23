package com.sak.engineeingcollegeselection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME="contacts";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_USERNAME="username";
    private static final String COLUMN_EMAIL="email_id";
    private static final String COLUMN_PASSWORD="password";
    private SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts(id integer primary key not null ," + "name text not null, username text not null , email_id text not null , password text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertContact(Contacts c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "SELECT * from contacts";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();
        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_USERNAME,c.getUsername());
        values.put(COLUMN_EMAIL,c.getEmail_id());
        values.put(COLUMN_PASSWORD,c.getPassword());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public String searchPassword(String uname){
        db = this.getReadableDatabase();
        String query = "Select username,password from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b="not found";
        if (cursor.moveToFirst()){
            do {
                a=cursor.getString(0);
                if (a.equals(uname)){
                    b = cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return b;
    }

    public Cursor selectAll(){
        db=this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updatePassword(String password,String name){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "SELECT * from contacts";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();
        values.put(COLUMN_ID,count);
        values.put(COLUMN_PASSWORD,password);
        db.update(TABLE_NAME,values,"name= ?",new String[]{name});
        db.close();
        return true;
    }

    public boolean resetPassword(String password,String email){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "SELECT * from contacts";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();
        values.put(COLUMN_ID,count);
        values.put(COLUMN_PASSWORD,password);
        db.update(TABLE_NAME,values,"email_id= ?",new String[]{email});
        db.close();
        return true;
    }

    public String searchEmail(String email){
        db = this.getReadableDatabase();
        String query = "Select email_id from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a;
        a="not found";
        if (cursor.moveToFirst()){
            do {
                a=cursor.getString(0);
                if (a.equals(email)){
                    break;
                }
            }while (cursor.moveToNext());
        }
        return a;
    }

    public String searchName(String name){
        db = this.getReadableDatabase();
        String query = "Select name from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a;
        a="not found";
        if (cursor.moveToFirst()){
            do {
                a=cursor.getString(0);
                if (a.equals(name)){
                    break;
                }
            }while (cursor.moveToNext());
        }
        return a;
    }
}
