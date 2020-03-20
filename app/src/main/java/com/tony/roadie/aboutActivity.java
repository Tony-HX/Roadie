package com.tony.roadie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class aboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //version name is dynamically added
        TextView versionTextView = findViewById(R.id.versionTextView);
        versionTextView.setText("Version " + BuildConfig.VERSION_NAME);
    }
}
