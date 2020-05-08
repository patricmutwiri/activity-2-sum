package com.mutwiri.sectioniii2activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GetInput extends AppCompatActivity implements View.OnClickListener {
    protected EditText fnumber;
    protected EditText snumber;
    protected float number1, number2;
    protected double total;
    protected String myTag="Errors ",resultsDisplay = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_input);

        Button calc=(Button)findViewById(R.id.button2);
        calc.setOnClickListener(this);
    }
    public void onClick(View view) {
        Intent data = new Intent("com.mutwiri.sectioniii2activities.MainActivity");

        fnumber = fnumber.findViewById(R.id.entrynumber1);
        snumber = snumber.findViewById(R.id.entrynumber2);
        resultsDisplay = "Error encountered. ";

        if(fnumber != null && snumber != null) {
            try {
                number1 = Float.parseFloat(fnumber.getText().toString());
                number2 = Float.parseFloat(snumber.getText().toString());
                total = (number1*1.0)+(number2*1.0);
                resultsDisplay = String.format("\nThe sum of %.2f and %.2f is %.2f ",number1,number2,total);
            } catch (Exception e) {
                Log.v(myTag,e.getMessage());
                resultsDisplay = e.getMessage();
            }
        }

        data.setData(Uri.parse(resultsDisplay));
        setResult(RESULT_OK, data);
        finish();
    }
}
