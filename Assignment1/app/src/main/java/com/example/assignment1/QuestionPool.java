package com.example.assignment1;

import java.util.ArrayList;
import java.util.Random;

public class QuestionPool {
    private ArrayList<Question> questions;
    private int index;

    public void init(){

        index = 0;

        questions = new ArrayList<>();

        questions.add(new Question("Paris the capital city of france.", true, "Paris has been the capital of France since 987 A.D"));
        questions.add(new Question("A conventional tennis set 6 games.", true,"Tennis sets consist of 6 games, if both players are tied at 5 it is the first player to 7 games"));
        questions.add(new Question("The UK part of the EU.", false,"After Brexit, the Uk is no longer considered part of the EU"));
        questions.add(new Question("The Dunkleosteus a type of reptile.", false, "The Dunkleosteus belongs to the Placodermi class"));
        questions.add(new Question("Peanuts are nuts.", false, "Peanuts are a type of legume"));
        questions.add(new Question("Light travels in a straight line.", true,"Contrary to popular belief, light does travel in straight lines."));
        questions.add(new Question("The Mona Liza was stolen from the Louvre in 1911.", true));
        questions.add(new Question("Ayrton Senna is the only brazilian driver to win a grand prix.", false,"Among others, Felipe Massa has won 11"));
        questions.add(new Question("Martin Brundle raced against both Ayrton Senna and Micheal Schumacher.", true, "In the 1992 season he was teammate to Michael, and Senna was racing for mclaren"));
        questions.add(new Question("There are a total of 38 pokemon games.", false, "Including side games, there have been a total of 122 pokemon games"));

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
    public String getQuestionExplanation(){
        return questions.get(index).getExplanation();
    }

    public void popCurrentQuestion(){
        questions.remove(index);
    }

    public void resetQuestions (){
        init();
        if (!isEmpty()){
            Random rd = new Random();

            index = rd.nextInt(questions.size());
        }

    }

}
