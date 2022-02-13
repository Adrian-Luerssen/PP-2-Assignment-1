package com.example.assignment1;

public class Question {
    private String question;
    private boolean answer;
    private String explanation;

    public String getQuestion() {
        return question;
    }
    public String getExplanation(){return explanation;}

    public boolean isCorrect(boolean answer) {
        return this.answer == answer;
    }

    public Question(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
        this.explanation = "";
    }
    public Question(String question, boolean answer, String explanation) {
        this.question = question;
        this.answer = answer;
        this.explanation = explanation;
    }
}
