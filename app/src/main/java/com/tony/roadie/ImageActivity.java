package com.tony.roadie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        //receives the current image from MainActivity
        Intent srcIntent = getIntent();

        //if it doesn't work, default image is the launcher foreground
        int imageId = srcIntent.getIntExtra("imageId", R.drawable.ic_launcher_foreground);
        ImageView largerImageView = findViewById(R.id.largerImageView);
        largerImageView.setImageResource(imageId);
    }
}
