package com.tony.roadie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adds RadioButtons to the RadioGroup on Create then shuffles the order randomly
        radioGroup = findViewById(R.id.answersRadioGroup);
        List<RadioButton> answers = new ArrayList<>();
        RadioButton answerRadioButton1 = new RadioButton(this);
        RadioButton answerRadioButton2 = new RadioButton(this);
        RadioButton answerRadioButton3 = new RadioButton(this);
        RadioButton answerRadioButton4 = new RadioButton(this);
        answers.add(answerRadioButton1);
        answers.add(answerRadioButton2);
        answers.add(answerRadioButton3);
        answers.add(answerRadioButton4);
        answerRadioButton1.setText("A");
        answerRadioButton2.setText("B");
        answerRadioButton3.setText("C");
        answerRadioButton4.setText("D");
        Collections.shuffle(answers);
        for(RadioButton answerRadioButton:
                answers){
            radioGroup.addView(answerRadioButton, new RadioGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                //shows a Toast saying whether the answer is correct or not
                if(radioButton.getText().equals("A")){
                    Toast.makeText(MainActivity.this, "A: Bonne réponse!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Mauvaise réponse! C'est la A.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //links the ImageView to ImageActivity
        ImageView questionImageView = findViewById(R.id.questionImageView);
        questionImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);

                //sends current image (launcher background) to ImageActivity
                intent.putExtra("imageId", R.drawable.ic_launcher_background);

                startActivity(intent);
            }
        });

    }

    //tests the answer selection with a Toast (off)
    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        //Toast.makeText(this, radioButton.getText(), Toast.LENGTH_SHORT).show();

    }



}
