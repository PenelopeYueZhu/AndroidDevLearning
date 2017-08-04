package com.penlope.currencyconverter;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // The current exchange rate
    public static final double EXCHANGE_RATE = 6.73;

    // Function for the button CONVERT, convert the currency
    public void convertButton( View view ){
        // Get the editText field where user input the amount of dollars
        EditText amountEditText = (EditText) findViewById( R.id.amountEditText );

        double amountInDollar = 0.0;
        // Get the amount of dollars in int, throw an exception if string is not an into
        try {
            amountInDollar = Double.parseDouble( amountEditText.getText().toString());
        }
        catch(NumberFormatException nfe ){
            System.out.println("Could not parse " + nfe);
        }

        // Calculate the amount in RMB
        double amountInRMB = amountInDollar * EXCHANGE_RATE;

        Toast.makeText( MainActivity.this, "￥" + String.format( "%.2f", amountInRMB),
                            Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
