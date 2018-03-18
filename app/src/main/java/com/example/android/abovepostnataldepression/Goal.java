package com.example.android.abovepostnataldepression;

/**
 * Created by bolaadeyeyeomisade on 20/08/2017.
 */

public class Goal {

        public static final String TAG = Goal.class.getSimpleName();
        public static final String TABLE = "Goal";
        // Labels Table Columns names
        public static final String KEY_GoalId = "GoalId";
        public static final String KEY_GoalName = "GoalName";
        public static final String KEY_GoalDesc = "GoalDesc";

        private String goalId;
        private String goalName;
        private String goalDesc;

        public String getGoalName() {
            return goalName;
        }

        public void setGoalName(String goalName) {
            this.goalName = goalName;
        }

        public String getGoalId() {
            return goalId;
        }

        public void setGoalId(String ref) {

            this.goalId = ref;
        }

        public String getGoalDesc() {
            return goalDesc;
        }

        public void setGoalDesc(String goalDesc) {

            this.goalDesc = goalDesc;
        }

}
