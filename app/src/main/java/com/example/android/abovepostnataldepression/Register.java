package com.example.android.abovepostnataldepression;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.abovepostnataldepression.repo.UserRepo;

public class Register extends AppCompatActivity implements android.view.View.OnClickListener{


    Button register_button;
    EditText AbovePNDUsername, AbovePNDPassword, AbovePNDConfirmPassword;

    UserRepo registerHelper = new UserRepo(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


    }

    public void onClick(View v) {
        if (v.getId() == R.id.register_button) {

            AbovePNDUsername = (EditText) findViewById(R.id.AbovePNDUsername);
            AbovePNDPassword = (EditText) findViewById(R.id.AbovePNDPassword);
            AbovePNDConfirmPassword = (EditText) findViewById(R.id.AbovePNDConfirmPassword);

            register_button = (Button) findViewById(R.id.register_button);
            register_button.setOnClickListener(this);


            String username = AbovePNDUsername.getText().toString();
            String password = AbovePNDPassword.getText().toString();
            String confirmpassword = AbovePNDConfirmPassword.getText().toString();

            if (!password.equals(confirmpassword))
            {

                Toast TVpass = Toast.makeText(Register.this, "Your password don't match", Toast.LENGTH_SHORT);
                TVpass.show();


            }
            else
                {
               User registerNewUser = new User ();
                registerNewUser.setUserName(username);
                registerNewUser.setPassword(password);
                registerNewUser.setConfirmPassword(confirmpassword);


                registerHelper.insertUser(registerNewUser);

                    startActivity(new Intent(this, Login.class));


            }


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
