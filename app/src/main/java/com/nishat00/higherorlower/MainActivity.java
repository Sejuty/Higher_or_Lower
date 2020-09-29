package com.nishat00.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void generateRandomNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(20) + 1;
    }

    public void onClick(View view) {
        Log.i("Random Number", Integer.toString(randomNumber));
        EditText num = (EditText) findViewById(R.id.editTextNumber);
        Log.i("Guessed: ",num.getText().toString());
        String value = num.getText().toString();
        int finalValue = Integer.parseInt(value);
        String message;
        if (finalValue == randomNumber) {
            message = "you got it!!";
            generateRandomNumber();
        } else if (finalValue < randomNumber)
            message = "higher!!";
        else
            message = "lower!!";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumber();
    }
}