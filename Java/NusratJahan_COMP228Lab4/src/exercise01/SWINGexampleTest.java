package exercise01;

import javax.swing.JFrame;

// driver class for StudentSWINGexample class
public class SWINGexampleTest {
    // main method
    public static void main(String[] args) {
        // create object for StudentSWINGexample class
        StudentSWINGexample student_swing = new StudentSWINGexample();
        //call the method to terminate the program when window is closed by the user
        student_swing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // specify the size  of the window in pixels
        student_swing.setSize(800, 700);
        // method with the argument true to display the window on the screen
        student_swing.setVisible(true);
    }//main method ends

}//SWINGexampleTest class ends
