package exercise1;

// class to simulate the questions
public class Question {
    //declaring instance variables
    private String questions;
    private int correctAns;

    //constructor to initialize the questions and the correct answers
    public Question(String questions,  int correctAns){
        this.questions = questions;
        this.correctAns = correctAns;
    }

    // method to retrieve the questions
    public String getQuestions(){
        return this.questions;
    }

    //method to retrieve the correct answers
    public int getCorrectAns() {
        return correctAns;
    }

}//end of Question class
