package com.example.mihaelasolomon.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyDB.db";
    public static final int DATABASE_VERSION =1;
    public static final String TABLE_NAME="users_table";
    public static final String ID="ID";
    public static final String USERNAME="USERNAME";
    public static final String PASSWORD="PASSWORD";
    public static final String EMAIL ="EMAIL";

    private static final String CREATE_SQL = "create table " + TABLE_NAME + "(ID integer primary key autoincrement, USERNAME TEXT, PASSWORD TEXT, EMAIL TEXT)";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean createUser(String user, String pass, String mail, DBHelper context, Context DBHelper) {
        SQLiteDatabase database=context.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("USERNAME", user);
        values.put("PASSWORD", pass);
        values.put("EMAIL", mail);
        try {
            database.insert(TABLE_NAME, null, values);
            return true;
        }
        catch(Exception e)
        {
            Toast.makeText(DBHelper, "Eroare la insertie.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
