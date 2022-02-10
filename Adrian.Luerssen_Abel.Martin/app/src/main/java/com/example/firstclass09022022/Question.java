package com.example.firstclass09022022;

public class Question {
    private String question;
    private boolean answer;

    public String getQuestion() {
        return question;
    }

    public boolean isCorrect(boolean answer) {
        return this.answer == answer;
    }

    public Question(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }
}
