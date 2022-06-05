package com.example.news_projectv10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class projectDatabase extends SQLiteOpenHelper {

    public static final String databaseName = "login_dp";
    public static final int dpVersion = 2;


    /**
     * 1-
     * table users
     * contain:-
     * (username ==> (TEXT) primary key)
     * (password ==> (TEXT) )
     */

    public static final String user_table = "users";
    public static final String user_table_username = "username";
    public static final String user_table_password = "password";



    public projectDatabase(Context context) {
        super(context, databaseName, null, dpVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ user_table + " ( "+user_table_username+
                " TEXT PRIMARY KEY,"+user_table_password+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ user_table);
        onCreate(sqLiteDatabase);
    }

    /**
     * to a new user
     */

    public boolean insertNewUser(userInfo newuser) {

        SQLiteDatabase dp = getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put(user_table_username, newuser.getUsername());
        contentValues.put(user_table_password, newuser.getPassword());

        long res = dp.insert(user_table,null,contentValues);

        return res!=-1;

    }

    public boolean isUserExist(String theUser) {

        SQLiteDatabase dp = getReadableDatabase();

        //// ali; DROP TABLE IF EXISTS + user_table;

        Cursor cursor = dp.rawQuery("select * from "+user_table+" where "+
                user_table_username + " =?",new String[] {theUser});

        int res = cursor.getCount();

        return res>0;

    }

    public boolean checkIfAValidUser(userInfo loginuser) {
        SQLiteDatabase dp = getReadableDatabase();

        Cursor cursor = dp.rawQuery("select * from "+user_table+" where "+
                user_table_username + " =? and "+user_table_password +" =?",new String[] {loginuser.getUsername(),loginuser.getPassword()});

        int res = cursor.getCount();

        return res>0;
    }


    /**
     * return all register users
     */

    public ArrayList<userInfo> getAllUsers() {

        ArrayList<userInfo> persons = new ArrayList<>();

        SQLiteDatabase dp = getReadableDatabase();

        Cursor cursor = dp.rawQuery("select * from "+ user_table,null);
        /**
         * -1
         * 0
         * 1
         */

        if(cursor.moveToFirst()) {
            do{
                String username = cursor.getString(0);
                String pass = cursor.getString(1);

                persons.add(new userInfo(username,pass));

            }while (cursor.moveToNext());
        }

        return persons;
    }

}
