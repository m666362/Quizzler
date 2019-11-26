package com.example.quizzler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declare number variable here
    Button matruebutton;
    Button mafalsebutton;
    TextView mScoreTextView;
    TextView mQuestiontextview;
    ProgressBar mProgressBar;
    int mIndex;
    int mScore;
    int mQuestion;

    //create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    //declare constant here
    final int progressbar_bar_increment = (int) Math.ceil(100.0/mQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){

            mScore = savedInstanceState.getInt("Scorekey");
            mIndex = savedInstanceState.getInt("Indexkey");
            mScoreTextView.setText("Score "+mScore + "/" + mQuestionBank);

        }else{

            mScore = 0;
            mIndex = 0;
        }

        matruebutton = findViewById(R.id.true_button);
        mafalsebutton = findViewById(R.id.false_button);
        mQuestiontextview = findViewById(R.id.question_text_view);
        mScoreTextView = findViewById(R.id.score);
        mProgressBar = findViewById(R.id.progress_bar);

        mQuestiontextview.setText(R.string.question_1);

        matruebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(true);
                updateQuestion();
            }
        });

        mafalsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(false);
                updateQuestion();
            }
        });
    }

    private void updateQuestion(){
        mIndex = (mIndex+1)% mQuestionBank.length;
        if(mIndex==0)
        {
            mScore = 0;
            mProgressBar.setProgress(0);
        }

        mQuestion = mQuestionBank[mIndex].getmQuestionid();
        mQuestiontextview.setText(mQuestion);
        mScoreTextView.setText("Score "+mScore + "/" + mQuestionBank.length);
        //progressbar_bar_increment;

    }
    private void checkAnswer(boolean userSelection){

        boolean correctAnswer = mQuestionBank[mIndex].ismAnswer();

        if(userSelection == correctAnswer) {
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
            mScore = mScore + 1;
            mProgressBar.incrementProgressBy(progressbar_bar_increment);
        }else{
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();

        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("ScoreKey", mScore);
        outState.putInt("Indexkey", mIndex);
    }
}
