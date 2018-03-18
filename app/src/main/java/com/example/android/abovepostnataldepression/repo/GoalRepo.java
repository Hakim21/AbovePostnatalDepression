package com.example.android.abovepostnataldepression.repo;

/**
 * Created by bolaadeyeyeomisade on 20/08/2017.
 */


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.example.android.abovepostnataldepression.Goal;
import com.example.android.abovepostnataldepression.DBHelper;

public class GoalRepo {
    private DBHelper dbHelper;


        private Goal goal;

        public GoalRepo(){

            goal= new Goal();

        }


        public static String createTable(){
            return "CREATE TABLE " + Goal.TABLE  + "("
                    + Goal.KEY_GoalId + " TEXT  PRIMARY KEY, "
                    + Goal.KEY_GoalName + " TEXT, "
                    + Goal.KEY_GoalDesc + " TEXT )";
        }



        public int insert(Goal goal) {
            int goalId;
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(Goal.KEY_GoalId, goal.getGoalId());
            values.put(Goal.KEY_GoalName, goal.getGoalName());
            values.put(Goal.KEY_GoalDesc, goal.getGoalDesc());

            // Inserting Row
            goalId=(int)db.insert(Goal.TABLE, null, values);
            db.close();
            return goalId;

        }



        public void delete( ) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.delete(Goal.TABLE, null,null);
            db.close();
        }






}
