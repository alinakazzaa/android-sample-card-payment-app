package com.example.assignment1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.*;
import android.view.*;

public class CardInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_info);
        setTitle("Account Overview");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        MainActivity ma = new MainActivity();

        // get values from sign up screen
        String email = intent.getStringExtra(ma.USER_EMAIL);
        int years = intent.getIntExtra(ma.USER_YEARS, 0);

        // calculate fee
        double fee = 0;

        if(years <= 5) {
            fee = years*100;
        }
        else {
            fee = (years*100)*0.8;
        }

        // set values to be displayed

        TextView emailTxt = (TextView) findViewById(R.id.usrEmail);
        TextView feeTxt = (TextView) findViewById(R.id.usrFee);

        emailTxt.setText(email);
        feeTxt.setText(String.valueOf(fee));

    }

    public void submitPay(View v) {
        EditText cardNumEdit = (EditText) findViewById(R.id.cardNumInput);
        EditText dateEdit = (EditText) findViewById(R.id.dateInput);
        TextView confirmPay = (TextView) findViewById(R.id.confirmPayMsg);

        cardNumEdit.setText("");
        dateEdit.setText("");
        confirmPay.setText("Thank you! Your payment has been submitted!");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}


