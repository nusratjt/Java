package exercise1;

//using JOptionPane to display multiple lines in a dialog box
import javax.swing.JOptionPane;

// class to conduct the test
public class ConductTest {
    public static void main(String[] args) {
        Test test = new Test();
        String name = JOptionPane.showInputDialog("Enter your name: ");
        // calling the method to start the test after entering the name
        test.startTest(name);
        // after the test calling the method to show the score
        JOptionPane.showMessageDialog(null,test.showScore());

    }//end of main method
}//end of ConductTest class
