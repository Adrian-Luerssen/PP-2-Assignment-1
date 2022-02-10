package com.example.firstclass09022022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private TextView score;

    private Button trueButton;
    private Button falseButton;

    private int scoreCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QuestionPool questionPool = new QuestionPool();
        questionPool.init();
        trueButton = (Button) findViewById(R.id.true_button);   // true button in the view
        falseButton = (Button) findViewById(R.id.false_button); // false button in the view
        question = (TextView) findViewById(R.id.question); // text box displaying the question in the view
        score = (TextView) findViewById(R.id.score);
        question.setText(questionPool.getQuestionString());
        // setting the initial question on start up
        // creating the toast for a correct answer
        Toast correctToast= Toast.makeText(getApplicationContext(), R.string.toast_correct, Toast.LENGTH_SHORT);
        correctToast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 250);
        // creating the toast for an incorrect answer
        Toast incorrectToast= Toast.makeText(getApplicationContext(), R.string.toast_incorrect, Toast.LENGTH_SHORT);
        incorrectToast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 250);


        trueButton.setOnClickListener(view -> {
            if (!questionPool.isEmpty()){

                // the user presses true, display the corresponding toast if the answer is correct or not
                if (questionPool.answerIsCorrect(true)) {
                    correctToast.show();
                    scoreCounter += 1;
                } else {
                    incorrectToast.show();
                }

                questionPool.popCurrentQuestion(); // removes the current question from the list
                questionPool.nextQuestion(); // moves onto the next question
                question.setText(questionPool.getQuestionString()); // changes the display question
                score.setText(String.format(Locale.getDefault(), "Score: %d", scoreCounter));

            } else{
                question.setText(questionPool.getQuestionString()); // changes the display question
            }

        });

        falseButton.setOnClickListener(view -> {
            if (!questionPool.isEmpty()){

                // the user presses true, display the corresponding toast if the answer is correct or not
                if (questionPool.answerIsCorrect(false)) {
                    correctToast.show();
                    scoreCounter += 1;
                } else {
                    incorrectToast.show();
                }

                questionPool.popCurrentQuestion(); // removes the current question from the list
                questionPool.nextQuestion(); // moves onto the next question
                question.setText(questionPool.getQuestionString()); // changes the display question
                score.setText(String.format(Locale.getDefault(), "Score: %d", scoreCounter));

            } else {
                question.setText(questionPool.getQuestionString()); // changes the display question
            }
        });

    }


}