package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

// Student name: Alina Kazakova
// Student number: C16709219


public class MainActivity extends AppCompatActivity {

    protected static final String USER_EMAIL = "user_email";
    protected static final String USER_YEARS = "user_years";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Sign Up");
    }

    public void signUp(View view) {

        boolean valid = true;

        // get email
        EditText editEmail = (EditText) findViewById(R.id.emailInput);
        String email = editEmail.getText().toString();


        if(email.equals("")) {
            valid = false;
            Toast.makeText(this, "Email is required!",Toast.LENGTH_LONG).show();

        } // check email is valid
        else if(!isValidEmail(email)) {
            valid = false;
            Toast.makeText(this, "Email is invalid!",Toast.LENGTH_LONG).show();
        }


        // get password
        EditText editPassword = (EditText) findViewById(R.id.pwInput);
        String password = editPassword.getText().toString();

        if(password.equals("")) {
            valid = false;
            Toast.makeText(this, "Password is required!",Toast.LENGTH_LONG).show();
        }

        // check password is valid
        else if(!isValidPassword(password)) {
            valid = false;
            Toast.makeText(this, "Password is invalid!",Toast.LENGTH_LONG).show();
        }


        // get pw confirm & make sure it matches pw 1
        EditText editPassConf = (EditText) findViewById(R.id.pwConfirmInput);
        String passwordConf = editPassConf.getText().toString();

        if(passwordConf.equals("")) {
            valid = false;
            Toast.makeText(this, "Password confirmation is required!",Toast.LENGTH_LONG).show();
        } else if(!isMatchPassword(password, passwordConf)) {
            valid = false;
            Toast.makeText(this, "Passwords don't match!",Toast.LENGTH_LONG).show();
        }


        // get number of years
        EditText editYears = (EditText) findViewById(R.id.yearsInput);
        String years = editYears.getText().toString();

        if(years.equals("")) {
            valid = false;
            Toast.makeText(this, "Number of years is required!",Toast.LENGTH_LONG).show();
        } else if(Integer.parseInt(years) < 0) {
            valid = false;
            Toast.makeText(this, "Number of years can't be negative!",Toast.LENGTH_LONG).show();
        }

        if(valid) {
            Intent intent = new Intent(this, CardInfo.class);
            intent.putExtra(USER_EMAIL, email);
            intent.putExtra(USER_YEARS, Integer.parseInt(years));
            startActivity(intent);
        }
    }

    public static boolean isValidEmail(String email)
    {
        if(email.contains(" ") || !email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            return false;
        }
        return true;

    }

    public static boolean isValidPassword(String password) {

        if(password.length() >= 6 && !password.contains(" ")) {
            return true;
        }
        return false;
    }

    public static boolean isMatchPassword(String password1, String password2) {

        if(password1.equals(password2)) {
            return true;
        }
        return false;
    }

}
