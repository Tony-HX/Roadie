package com.tony.roadie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.answersRadioGroup);
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                if(radioButton.getText().equals("A")){
                    Toast.makeText(MainActivity.this, "A: Bonne réponse!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Mauvaise réponse! C'est la A.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //answer selection test function
    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        //Toast.makeText(this, radioButton.getText(), Toast.LENGTH_SHORT).show();

    }
}
