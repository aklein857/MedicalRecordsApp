package com.adamklein.android.medicalrecordsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;


/**
 * Created by aklein on 6/20/2015.
 */

//SQLiteOpenHelper is a helper class to manage database creation and management
public class DatabaseOperations extends SQLiteOpenHelper implements BaseColumns {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "basic_info.db";
    public static final String TABLE_NAME = "register_info_table";
    public static final String FIRST_NAME = "first_name";
    public static final String MIDDLE_NAME = "middle_name";
    public static final String LAST_NAME = "last_name";


    public final String CREATE_QUERY = "CREATE TABLE " + TABLE_NAME +
            " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + FIRST_NAME + " TEXT, " + MIDDLE_NAME + " TEXT, " + LAST_NAME + " TEXT);";

    //used for logcat purposes
    private static final String TAG = "DatabaseOperations";


    //default constructor required
    public DatabaseOperations(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG, "Database created");
    }



    @Override
    public void onCreate(SQLiteDatabase sdb){

        sdb.execSQL(CREATE_QUERY);
        Log.d(TAG, "Table (register_info_table) created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

    //custom method to put information into the database
    public boolean putInformation(DatabaseOperations dbOps, String firstName, String middleName,
                               String lastName){

        // SQLiteDatabase object instantiated to write data into database
        SQLiteDatabase sq = dbOps.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(FIRST_NAME, firstName);
        cv.put(MIDDLE_NAME, middleName);
        cv.put(LAST_NAME, lastName);


        //method returns a long value but it is not necessary to store the value
        long result = sq.insert(TABLE_NAME, null, cv);

        Log.d(TAG, "One row inserted");

        if(result == -1){

            return false;
        }else{
            return true;
        }
    }

    public Cursor getAllData(){

        SQLiteDatabase sq = this.getWritableDatabase();
        Cursor res = sq.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }


}
