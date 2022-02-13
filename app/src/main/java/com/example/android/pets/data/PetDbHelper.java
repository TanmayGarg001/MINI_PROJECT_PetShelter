package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.PetContract.PetEntry;

public class PetDbHelper extends SQLiteOpenHelper {
    private static final String LOG_TAG = PetDbHelper.class.getName();

    private static final String DATABASE_NAME = "pets.db";
    private static final int DATABASE_VERSION = 1;

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE pets(_ID INTEGER PRIMARY KEY,name TEXT NOT NULL,breed TEXT,gender INTEGER NOT NULL,weight INTEGER NOT NULL DEFAULT 0);
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetEntry.TABLE_NAME + "(" +
                PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL," +
                PetEntry.COLUMN_PET_BREED + " TEXT," +
                PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL," +
                PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
