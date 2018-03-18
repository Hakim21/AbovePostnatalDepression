package com.example.android.abovepostnataldepression;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.abovepostnataldepression.repo.TreatmentRepo;
import com.example.android.abovepostnataldepression.repo.UserRepo;
import com.example.android.abovepostnataldepression.repo.GoalRepo;

/**
 * Created by bolaadeyeyeomisade on 31/08/2017.
 */

public class DBHelper extends SQLiteOpenHelper {


        //version number to upgrade database version
        //each time if you Add, Edit table, you need to change the
        //version number.
        private static final int DATABASE_VERSION = 4;
    SQLiteDatabase db;

        // Database Name
        private static final String DATABASE_NAME = "AbovePostnatalDepression.db";

        public DBHelper(Context context ) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //All necessary tables you like to create will create here

            db.execSQL(TreatmentRepo.createTable());
            db.execSQL(UserRepo.createTable());
            db.execSQL(GoalRepo.createTable());

        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Drop older table if existed, all data will be gone!!!
            db.execSQL("DROP TABLE IF EXISTS " + Treatment.TABLE);

            // Create tables again
            onCreate(db);

        }


}
