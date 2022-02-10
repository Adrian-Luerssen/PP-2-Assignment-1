package com.example.firstclass09022022;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class QuestionPool {
    private ArrayList<Question> questions;
    private int index;

    public void init(){

        index = 0;

        questions = new ArrayList<>();

        questions.add(new Question("Is paris the capital city of france?", true));
        questions.add(new Question("Is a conventional tennis set 6 games?", true));
        questions.add(new Question("Is the UK part of the EU?", false));
        questions.add(new Question("Is the Dunkleosteus a type of reptile?", false));

    }
    public boolean isEmpty(){
        return questions.size() == 0;
    }
    public boolean answerIsCorrect(boolean answer) {

        return questions.get(index).isCorrect(answer);

    }
    public void nextQuestion() {
        if (!isEmpty()){
            Random rd = new Random();

            index = rd.nextInt(questions.size());
        }


    }

    public String getQuestionString() {
        return (isEmpty())?"There are no questions left.":questions.get(index).getQuestion();
    }

    public void popCurrentQuestion(){
        questions.remove(index);
    }


}
