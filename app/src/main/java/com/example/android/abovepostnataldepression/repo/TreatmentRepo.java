package com.example.android.abovepostnataldepression.repo;

/**
 * Created by bolaadeyeyeomisade on 31/08/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import com.example.android.abovepostnataldepression.DBHelper;
import com.example.android.abovepostnataldepression.Treatment;
import com.example.android.abovepostnataldepression.User;

public class TreatmentRepo {

        private DBHelper dbHelper;

        public TreatmentRepo(Context context) {
            dbHelper = new DBHelper(context);
        }

    public static String createTable(){
        return "CREATE TABLE " + Treatment.TABLE  + "("
                + Treatment.KEY_TreatmentID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Treatment.KEY_TreatmentName + " TEXT, "
                + Treatment.KEY_TreatmentNumber + " INTEGER, "
                + Treatment.KEY_TreatmentType + " TEXT )";
    }


        public void deleteID(int treatment_ID) {

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            // It's a good practice to use parameter ?, instead of concatenate string
            db.delete(Treatment.TABLE, Treatment.KEY_TreatmentID + "= ?", new String[] { String.valueOf(treatment_ID) });
            db.close(); // Closing database connection
        }

        public void update(Treatment treatment) {

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(Treatment.KEY_TreatmentNumber, treatment.editTextTreatmentNumber);
            values.put(Treatment.KEY_TreatmentType,treatment.editTextTreatmentType);
            values.put(Treatment.KEY_TreatmentName, treatment.editTextTreatmentName);

            // It's a good practice to use parameter ?, instead of concatenate string
            db.update(Treatment.TABLE, values, Treatment.KEY_TreatmentID + "= ?", new String[] { String.valueOf(treatment.treatment_ID) });
            db.close(); // Closing database connection
        }


    public int insert(Treatment treatment) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from Treatment";
        Cursor cursor = db.rawQuery(query, null);

        int  count = cursor.getCount();

        values.put(Treatment.KEY_TreatmentID, count);
        values.put(Treatment.KEY_TreatmentNumber, treatment.getEditTextTreatmentNumber());
        values.put(Treatment.KEY_TreatmentType, treatment.getEditTextTreatmentType());
        values.put(Treatment.KEY_TreatmentName, treatment.getEditTextTreatmentName());

//        long treatment_Id = db.insert(Treatment.TABLE, null, values);
        long treatment_Id = db.insert(Treatment.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) treatment_Id;


    }


        public ArrayList<HashMap<String, String>>  getTreatmentList() {
            //Open connection to read only
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            String selectQuery =  "SELECT  " +
                    Treatment.KEY_TreatmentID + "," +
                    Treatment.KEY_TreatmentName + "," +
                    Treatment.KEY_TreatmentType + "," +
                    Treatment.KEY_TreatmentNumber +
                    " FROM " + Treatment.TABLE;

            ArrayList<HashMap<String, String>> treatmentList = new ArrayList<HashMap<String, String>>();

            Cursor cursor = db.rawQuery(selectQuery, null);
            // looping through all rows and adding to list

            if (cursor.moveToFirst()) {
                do {
                    HashMap<String, String> treatment = new HashMap<String, String>();
                    treatment.put("TreatmentId", cursor.getString(cursor.getColumnIndex(Treatment.KEY_TreatmentID)));
                    treatment.put("TreatmentName", cursor.getString(cursor.getColumnIndex(Treatment.KEY_TreatmentName)));
                    treatment.put("TreatmentType", cursor.getString(cursor.getColumnIndex(Treatment.KEY_TreatmentType)));
                    treatmentList.add(treatment);

                } while (cursor.moveToNext());
            }

            cursor.close();
            db.close();
            return treatmentList;

        }

        public Treatment getTreatmentById(int Id){
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            String selectQuery =  "SELECT  " +
                    Treatment.KEY_TreatmentID + "," +
                    Treatment.KEY_TreatmentName + "," +
                    Treatment.KEY_TreatmentType + "," +
                    Treatment.KEY_TreatmentNumber +
                    " FROM " + Treatment.TABLE
                    + " WHERE " +
                    Treatment.KEY_TreatmentID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

            int iCount =0;
            Treatment treatment = new Treatment();

            Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

            if (cursor.moveToFirst()) {
                do {

                    treatment.treatment_ID =cursor.getInt(cursor.getColumnIndex(Treatment.KEY_TreatmentID));
                    treatment.editTextTreatmentName =cursor.getString(cursor.getColumnIndex(Treatment.KEY_TreatmentName));
                    treatment.editTextTreatmentType  =cursor.getString(cursor.getColumnIndex(Treatment.KEY_TreatmentType));
                    treatment.editTextTreatmentNumber =cursor.getInt(cursor.getColumnIndex(Treatment.KEY_TreatmentNumber));


                } while (cursor.moveToNext());
            }

            cursor.close();
            db.close();
            return treatment;
        }




    public void delete(int treatment_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Treatment.TABLE, Treatment.KEY_TreatmentID + "= ?", new String[] { String.valueOf(treatment_Id) });
        db.close(); // Closing database connection
    }


}
