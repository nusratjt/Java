package exercise2;

//program uses class SecureRandom
import java.security.SecureRandom;
//using JOptionPane to display multiple lines in a dialog box
import javax.swing.JOptionPane;

public class Lotto {

    //create secure random number generator for use in method public
    private static final SecureRandom randomNumbers = new SecureRandom();

    // enum type with constants that represent the game status
    private enum Status { WON, LOST};
    Status gameStatus; // can contain WON, LOST

    // declaring array instance variable to hold three random integers
    private int[] intValues = new int[3];

    // constructor to populate the array for the lotto object
    public Lotto(){
            this.intValues = intValues;
    }

    // method to retrieve the array
    public int[] getIntValues() {
        return intValues;
    }

    // method to simulate lotto game
    public void lottoGame(int userNumber){
        int lotto;
        int sum = 0;
        int noOfTurn = 1;

        // loop to carry the game max 5 times until sum matches the userNumber
            while (noOfTurn <= 5){
                lotto = 1 + randomNumbers.nextInt(9);
                sum += lotto;// add the random number lotto to the sum
                JOptionPane.showMessageDialog(null,"Your point is now: "+ sum);

                // when sum becomes equal to userNumber, loop terminates
                if(sum >= userNumber )
                    break;
                // if sum does not become equal to userNumber, loop continues up to 5 times
                else
                    noOfTurn++;
            }

            // check if game status of the user is WON or LOST
            if(sum == userNumber)
                gameStatus = Status.WON;
            else
                gameStatus = Status.LOST;

            // display won or lost message
            if(gameStatus == Status.WON)
                JOptionPane.showMessageDialog(null,"Congratulation!! \nYou won the game");
            else
                JOptionPane.showMessageDialog(null,"GAME OVER!!\nComputer wins!!");

    }//end of lottoGame method
}// end of Lotto class
