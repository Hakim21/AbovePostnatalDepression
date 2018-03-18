package com.example.android.abovepostnataldepression;

/**
 * Created by bolaadeyeyeomisade on 20/08/2017.
 */

public class User {

    public static final String TAG = User.class.getSimpleName();
    public static final String TABLE = "User";
    // Labels Table Columns names
    public static final String KEY_UserID = "UserId";
    public static final String KEY_UserName = "UserName";
    public static final String KEY_Password = "Password";
    public static final String KEY_ConfirmPassword = "ConfirmPassword";
    public static final String KEY_GoalId = "GoalId";



    private String userId;
    private String userName;
    private String password;
    private String confirmPassword;
    private String goalId;



    public String getUserId() {

        return userId;
    }
    public void setUserId(String userId) {

        this.userId = userId;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getUserName() {

        return userName;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getPassword() {

        return password;
    }

    public void setConfirmPassword(String confirmPassword) {

        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public String getGoal() {
        return goalId;
    }

    public void setGoal(String goalId) {
        this.goalId = goalId;
    }

}
