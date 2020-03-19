package com.tony.roadie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
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

        final Question q = new Question("Comment s'appelle le batteur des Beatles?", R.drawable.the_beatles, "Ringo Starr", "John Frusciante", "Les Paul", "George Michael");
        final Question q2 = new Question("Comment s'appelle le batteur de Nirvana?", R.drawable.nirvana, "Dave Grohl", "Krist Novoselic", "Steve Shelley", "Jack Irons");
        final TextView questionTextView = findViewById(R.id.questionTextView);
        final String question = q.getQuestion();
        questionTextView.setText(question);

        final ImageView questionImageView = findViewById(R.id.questionImageView);
        final int image = q.getImage();
        questionImageView.setImageResource(image);

        //links the ImageView to ImageActivity
        questionImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);

                //sends current image (launcher background) to ImageActivity
                intent.putExtra("imageId", image);

                startActivity(intent);
            }
        });

        //adds RadioButtons to the RadioGroup on Create then shuffles their order randomly
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
        answerRadioButton1.setText(q.getItem1());
        answerRadioButton2.setText(q.getItem2());
        answerRadioButton3.setText(q.getItem3());
        answerRadioButton4.setText(q.getItem4());
        Collections.shuffle(answers);
        for(RadioButton answerRadioButton:
                answers){
            radioGroup.addView(answerRadioButton, new RadioGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        final Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                String rightAnswer = q.getItem1();

                //shows a Toast saying whether the answer is correct or not, transforms the submitButton
                if(radioButton.getText().equals(rightAnswer)){
                    Toast.makeText(MainActivity.this, "A: Bonne réponse!", Toast.LENGTH_LONG).show();
                    submitButton.setText("Question suivante");
                    submitButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, MainActivity.class);

                            startActivity(intent);

                        }
                    });
                }else{
                    Toast.makeText(MainActivity.this, "Mauvaise réponse! C'est " + rightAnswer + ".", Toast.LENGTH_SHORT).show();
                }
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
