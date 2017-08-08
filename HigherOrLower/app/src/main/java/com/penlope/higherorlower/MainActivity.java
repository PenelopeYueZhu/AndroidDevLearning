package com.penlope.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final int TWENTY = 20;
    int appThink = 0;

    // OnClick event for the GUESS button
    public void guessButton( View view ){

        // Get the number user guessed
        EditText inputNumEditText = (EditText) findViewById( R.id.inputNumEditText );
        int userGuess = Integer.parseInt(inputNumEditText.getText().toString());

        // Compare the numbers and toast according to each condition
        // When user guessed bigger
        if (appThink < userGuess) {
            Toast.makeText(MainActivity.this, "Lower!", Toast.LENGTH_SHORT).show();
        }
        // When user guessed smaller
        else if (appThink > userGuess) {
            Toast.makeText(MainActivity.this, "Higher!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Good guess!", Toast.LENGTH_SHORT).show();

            // Get a new random number
            Random rand = new Random();
            appThink = rand.nextInt(TWENTY) + 1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a new random number from 1 to 20 inclusively
        Random rand = new Random();
        appThink = rand.nextInt(TWENTY) + 1;
    }
}
