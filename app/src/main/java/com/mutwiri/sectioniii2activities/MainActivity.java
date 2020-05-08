package com.mutwiri.sectioniii2activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity  extends AppCompatActivity implements View.OnClickListener {

    protected Button getInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getInput = findViewById(R.id.button);
        getInput.setOnClickListener(this);
    }

    public void onClick(View v) {
        // load input activity
        Intent getInput = new Intent("com.mutwiri.sectioniii2activities.GetInput");
        startActivityForResult(getInput,1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
