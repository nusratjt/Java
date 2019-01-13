package exercise2;

//using JOptionPane to display multiple lines in a dialog box
import javax.swing.JOptionPane;

public class LottoDriver {
    public static void main(String[] args) {

        // welcome message and rules of the game for the user
        JOptionPane.showMessageDialog(null,"WELCOME to the LOTTO game!" +
                "\n==============================\n\nRules of the game--\nTo conduct the game you need to choose a number from 3 to 27." +
                "\nTo win the game, run the lotto maximum 5 times to match with \nthe number you have choosen." +
                "\nIf it's matched you win, otherwise computer wins.\n\nSTART THE GAME..... ");

        // prompt user to enter a number that to match with the sum
        int userInput = Integer.parseInt(JOptionPane.showInputDialog("Enter a number from 3 to 27: "));
        // create an object of Lotto class
        Lotto lottoObj1 = new Lotto();
        // call the method to start the game
        lottoObj1.lottoGame(userInput);

    }// end of main class
}//end of LottoDriver class
