package exercise3;

// using JOptionPane to display multiple lines in a dialog box
import javax.swing.JOptionPane;

public class GameObjectTest
{
    public static void main(String[] args)
    {
        // prompt the user to enter center of the object
        double objXAxis = Double.parseDouble(JOptionPane.showInputDialog("Enter the x-Axis of the object : "));
        double objYAxis = Double.parseDouble(JOptionPane.showInputDialog("Enter the y-Axis of the object : "));


        // prompt the user to enter velocity of the object
        double objVelocity = Double.parseDouble(JOptionPane.showInputDialog("Enter the velocity of the object: "));

        // prompt the user to enter state of the object
        String objState = JOptionPane.showInputDialog("State of the object (alive or dead): ");

        // prompt the user to enter rotation of the object
        boolean objRotation = Boolean.parseBoolean(JOptionPane.showInputDialog("Do the object rotate? (true/false) "));

        // create an instance of GameObject class assigning it to gameObject1 and initialize the variables
        GameObject gameObject1 = new GameObject(objXAxis, objYAxis, objVelocity, objState, objRotation);

        //display the game object information in the message dialog box
        JOptionPane.showMessageDialog(null, gameObject1.getGameObjectInfo());

        // reset the variables of the object if user wants to
        String choice = JOptionPane.showInputDialog("Do you want to reset the object: (y/n)");
        if(choice == "y")
        {
            //typing "y" allows user to update the game object
            gameObject1.setxAxis(Double.parseDouble(JOptionPane.showInputDialog("Reset the x-Axis of the object : ")));
            gameObject1.setyAxis(Double.parseDouble(JOptionPane.showInputDialog("Reset the y-Axis of the object : ")));
            gameObject1.setVelocity(Double.parseDouble(JOptionPane.showInputDialog("Reset the velocity of the object: ")));
            gameObject1.setState(JOptionPane.showInputDialog("Reset the state of the object (alive or dead): "));
            gameObject1.setRotation(Boolean.parseBoolean(JOptionPane.showInputDialog("Do the object rotate? (true/false) ")));
            JOptionPane.showMessageDialog(null, gameObject1.getGameObjectInfo());
        }
        else
            // if user do not type "y", it will not allow user to update but show only thank you message and exit
            JOptionPane.showMessageDialog(null, "Thank you!!");


    }// end of main method

}// end of TestGameObject
