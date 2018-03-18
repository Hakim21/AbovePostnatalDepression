package com.example.android.abovepostnataldepression.repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.android.abovepostnataldepression.User;
import com.example.android.abovepostnataldepression.DBHelper;

/**
 * Created by bolaadeyeyeomisade on 04/09/2017.
 */

public class UserRepo {

    private DBHelper dbHelper;

    private User user;

    public UserRepo(Context context){
        dbHelper = new DBHelper(context);

        user= new User();

    }


    public static String createTable(){
        return "CREATE TABLE " + User.TABLE  + "("
                + User.KEY_UserID  + " TEXT PRIMARY KEY  , "
                + User.KEY_UserName + " TEXT, "
                + User.KEY_Password + " TEXT, "
                + User.KEY_ConfirmPassword + " TEXT, "
                + User.KEY_GoalId  + " TEXT )";
    }



    public void insertUser(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from user";
        Cursor cursor = db.rawQuery(query, null);

        int  count = cursor.getCount();

        values.put(User.KEY_UserID, count);
        values.put(User.KEY_UserName, user.getUserName());
        values.put(User.KEY_GoalId, user.getGoal());
        values.put(User.KEY_Password, user.getPassword());
        values.put(User.KEY_ConfirmPassword, user.getConfirmPassword());

        // Inserting Row
        db.insert(User.TABLE, null, values);
        db.close();
    }

    public void delete( ) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(User.TABLE, null,null);
        db.close();
    }


}
