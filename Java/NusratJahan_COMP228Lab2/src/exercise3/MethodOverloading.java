package exercise3;

//using JOptionPane to display multiple lines in a dialog box
import javax.swing.JOptionPane;

// class to implement overloaded static methods
public class MethodOverloading {

    // declaring static variables
    private static int length;
    private static int width;

    public static void main(String[] args) {

        // prompt user to enter integer values for length and width of the rectangle
        int lengthInt = Integer.parseInt(JOptionPane.showInputDialog("Enter length of the rectangle (only integers): "));
        int widthInt = Integer.parseInt(JOptionPane.showInputDialog("Enter width of the rectangle (only integers): "));
        JOptionPane.showMessageDialog(null,"\nCalled getRectangleArea() with no argument : "
                +"\nArea of the first rectangle is: " +getRectangleArea()
                +"\n\nCalled getRectangleArea() with one integer argument : "
                +"\nArea of the second rectangle is: " +getRectangleArea(lengthInt)
                +"\n\nCalled getRectangleArea() with two integer arguments : "
                +"\nArea of the third rectangle is: " +getRectangleArea(lengthInt,widthInt));

        // prompt user to enter double values for length and width of the rectangle
        double lengthDouble = Double.parseDouble(JOptionPane.showInputDialog("Enter length of the rectangle (provide decimal values): "));;
        double widthDouble = Double.parseDouble(JOptionPane.showInputDialog("Enter width of the rectangle (provide decimal values): "));;
        JOptionPane.showMessageDialog(null,String.format("\nCalled getRectangleArea() with two double arguments : " +
                "\nArea of the fourth rectangle is: %.2f" ,getRectangleArea(lengthDouble,widthDouble)));

    }

    // method without any parameter
    public static int getRectangleArea(){
        length = 50;
        width = 8;
        return  length * width;
    }

    // method overloading getRectangleArea() with an integer parameter
    public static int getRectangleArea(int length){
        width = 10;
        return  length * width;
    }

    // method overloading getRectangleArea() with two integer parameters
    public static int getRectangleArea(int length, int width){
        return  length * width;
    }

    // method overloading getRectangleArea() with two double parameters
    public static double getRectangleArea(double length, double width){
        return  length * width;
    }

}//end of MethodOverloading class
