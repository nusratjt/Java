package exercise1;

//using JOptionPane to display multiple lines in a dialog box
import javax.swing.JOptionPane;
//program uses class SecureRandom
import java.security.SecureRandom;

// class to formulate the test
public class Test {

    // declaring static variables
     private static Question[] questionSet;
     private static final SecureRandom randomObject = new SecureRandom();
     private static int answer;
     private static final int numOfQuestions = 5;
     private static int score = 0;
     private static boolean isCorrectAnswer;


    public static void startTest(String name) {

        // Instructions for the test
        JOptionPane.showMessageDialog(null,"Instruction for the test"+
                "\n==================================="+"\nHello "+name+
                ",\nThis is a multiple choice question test.\nThere is only 5 questions.\n" +
                "You will have to type 1-4 to give your answer.\n\n " + "So, start your test....");

        // declaring question variables and assigning them to the questions

        String question1 = "Which object allows to display information in the command window?" + "\n1) System.print \n 2) System.in" +
                " \n 3) System.out\n 4) System.print.in";
        String question2 = "What is the function of System.in object?" + "\n1) to get mouse input \n 2) to get keyboard input " +
                "\n 3) to show output \n 4) to get USB files";
        String question3 = "Class System is a part of package --------------" + "\n1) javax.swing \n 2) java.security \n " +
                "3) java.util\n 4) java.lang";
        String question4 = "Which of the following is true -"+"\n1) getter method returns a value \n 2) setter method returns a value"
                + "\n 3) variables with private modifier is accessible from everywhere \n 4) instance variables are declared with static keyword";
        String question5 = "Which of the following is a wrong declaration -"+"\n1) Scanner input = new Scanner(System.in);"
                +"\n2) private int number = 10; \n3) Scanner input = new Scanner()\n4) Account myAccount = new Account();";


        // setting the questions in array
        questionSet = new Question[]{
                new Question(question1, 3),
                new Question(question2, 2),
                new Question(question3, 4),
                new Question(question4, 1),
                new Question(question5, 3)};

        // calling the simulateQuestion() method to show and start the test
            simulateQuestion(questionSet);
    }

    // for simulating questions
    public  static void simulateQuestion(Question[] questionsSet) {
        // loop to show all the questions and to answer them in each iteration
        for (int i = 0; i < questionsSet.length; i++) {
            JOptionPane.showMessageDialog(null, questionsSet[i].getQuestions());
            int answer = inputAnswer(); // calling the method to input answer
            isCorrectAnswer = checkAnswer(questionSet[i].getCorrectAns()); // calling the method to check the answer
            generateMessage(isCorrectAnswer); // calling the method to generate message according to the answer
        }

    }

    // prompting user for answer
    public  static int inputAnswer() {
        answer = Integer.parseInt(JOptionPane.showInputDialog("Enter an option from 1-4: "));
        return answer;

    }

    // for checking answer is right or wrong
    public  static boolean checkAnswer(int correctAnswer) {
        boolean isCorrect = false;
        for (int i = 0; i < questionSet.length; i++) {
            // checking the answer input by user is correct or not
            if (answer == correctAnswer) {
                score++;
                return true;
            }
            else
                return false;
        }
        return isCorrect;
    }

    // method to set grade according to the score
    public String setGrade(){
        String grade = "";
        switch (score ){
            case 1:
            case 2:
                return "F";
            case 3:
                return "B";
            case 4:
                return "A";
            case 5:
                return "A+";
        }
        return grade;
    }

    // for generating message
    public  static void generateMessage(boolean correctAnswer) {
        int randomResponse = 1 + randomObject.nextInt(4);
        if (correctAnswer) {
            // if answer is correct, generate a message randomly
            switch (randomResponse) {
                case 1:
                    JOptionPane.showMessageDialog(null,"Excellent!");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,"Very good!");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,"Nice work!");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,"Keep up!!");
                    break;
            }
        }
        else {
            // if answer is wrong, generate a message randomly
            switch (randomResponse) {
                case 1:
                    JOptionPane.showMessageDialog(null,"Wrong answer. Best of luck!");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,"Not correct answer. Hope next time!");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,"Don't give up!");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,"Wrong answer. Keep trying!!");
                    break;
            }
        }

    }

    // method to show the score
    public String showScore(){
        return "Feedback of your test"+"\n=================================="+"\nYour score is: " + score +"/"+ numOfQuestions
                + "\nYour score in percentage: " + (score * 100)/numOfQuestions +"%" +"\nYour grade is: "+ setGrade();
    }

}//end of Test class
