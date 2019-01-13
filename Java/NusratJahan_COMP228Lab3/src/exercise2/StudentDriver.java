package exercise2;

//using JOptionPane to display multiple lines in a dialog box
import javax.swing.JOptionPane;

//Driver class of Student class
public class StudentDriver {

    // main method
    public static void main(String[] args) {

        // prompt the user to enter first name, last name, student id and status
        String firstName = JOptionPane.showInputDialog("Enter first name: ");
        String lastName = JOptionPane.showInputDialog("Enter last name: ");
        int studentId = Integer.parseInt(JOptionPane.showInputDialog("Enter the student id: "));
        boolean status = Boolean.parseBoolean(JOptionPane.showInputDialog("Are you a full-time student?\nType true/false"));

        //check if the student is full time student : show the information of students according to the status
        if(status == true){
            double creditHour = Double.parseDouble(JOptionPane.showInputDialog("Enter your credit hour: "));
            Student fullTimeStudent = new FullTimeStudent(firstName, lastName, studentId, status, creditHour);
            JOptionPane.showMessageDialog(null,fullTimeStudent.toString());
        }
        else {
            double creditHour = Double.parseDouble(JOptionPane.showInputDialog("Enter your required credit hour: "));
            Student partTimeStudent = new PartTimeStudent(firstName, lastName, studentId, status, creditHour);
            JOptionPane.showMessageDialog(null,partTimeStudent.toString());
        }

    }//end of main method
}//end of Driver class
