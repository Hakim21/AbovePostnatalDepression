package com.example.android.abovepostnataldepression;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements android.view.View.OnClickListener{

    Button _login_button;
    EditText _AbovePNDUsername, _AbovePNDPassword;
    TextView _registerTextLink;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper = new DBHelper(this);
        db = openHelper.getReadableDatabase();
        _login_button = (Button) findViewById(R.id.login_button);
        _AbovePNDUsername = (EditText) findViewById(R.id.AbovePNDUsername);
        _AbovePNDPassword = (EditText) findViewById(R.id.AbovePNDPassword);
        _login_button.setOnClickListener(this);
        _registerTextLink = (TextView) findViewById(R.id.TVSignUp);
        _registerTextLink.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.login_button) {

            String username = _AbovePNDUsername.getText().toString();
            String password = _AbovePNDPassword.getText().toString();
            cursor = db.rawQuery("SELECT * FROM " + User.TABLE + " WHERE "
                    + User.KEY_UserName + " =? AND " + User.KEY_Password
                    + " =? ", new String[] {username, password});
            if(cursor != null)
            {
                if(cursor.getCount()> 0){
                    cursor.moveToNext();

                    Toast.makeText(getApplicationContext(), "login successfully", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this, view_treatment_entry.class));
                }
                else {

                    Toast.makeText(getApplicationContext(), "error in login", Toast.LENGTH_LONG).show();
                }

            }

        }

        if (v.getId() == R.id.TVSignUp) {

            startActivity(new Intent(this, Register.class));

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
