package com.penlope.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Create a class for the number user put in
    private class number {

        // Create a variable to hold the input number
        int input;
        // Declare a nature number counter
        int natureNum = 1;
        // Initialize the flag for square number and triangular number
        boolean isSquare = false;
        boolean isTriangle = false;

        // Constructor to take the passed in number
        public number (int input) {
            this.input = input;
        }

        // Function to determine the shape of the input number
        private void getShape () {

            // square root the number to see if the root is an int
            if( (Math.sqrt( input )) == ((int)Math.sqrt( input ))) {

                // If the root is an int, set the square flag to true
               isSquare = true;
            }

            // Deduct nature numbers from the input number
            // See if the number is a sum of nature numbers
            while( input > 0 ) {

                // Minus the unput num with nature numbers
                input = input - natureNum;
                natureNum ++;
            }
            // If the result of deducting all the nature numbers is 0, set the flag
            if( input == 0) isTriangle = true;

            // Make the output depending on whether the number is a square number, triangular number
            // both or neither
            if( isTriangle && isSquare ) {
                Toast.makeText(MainActivity.this, "Both", Toast.LENGTH_SHORT).show();
            } else if (isTriangle && !isSquare ) {
                Toast.makeText(MainActivity.this, "Triangle", Toast.LENGTH_SHORT).show();
            } else if( !isTriangle && isSquare ) {
                Toast.makeText( MainActivity.this, "Square", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText( MainActivity.this, "neither", Toast.LENGTH_SHORT ).show();
            }

        }

    }

    // The method to be called when user clicks the button of "Find Out"
    public void findOutButton (View view) {



        // Get the text user puts in
        EditText userNum = (EditText) findViewById( R.id.inputNumEditText );
        // Read the input text as number
        int inputNum = Integer.parseInt( userNum.getText().toString() );

        number toGetShape = new number( inputNum );

        toGetShape.getShape();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
