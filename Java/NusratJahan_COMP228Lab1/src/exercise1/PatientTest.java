package exercise1;

// using JOptionPane to display multiple lines in a dialog box
import javax.swing.JOptionPane;

public class PatientTest
{
    public static void main(String[] args)
    {
        // create an instance of Patient class
        Patient patient1 = new Patient();

        // Prompt the user to enter id and set the id in the object
        int patientId = Integer.parseInt(JOptionPane.showInputDialog("Enter patient Id: "));
        patient1.setPatientId(patientId);
        // Prompt the user to enter first name and set the name in the object
        String firstName = JOptionPane.showInputDialog("Patient first name: ");
        patient1.setFirstName(firstName);
        // Prompt the user to enter last name and set the name in the object
        String lastName = JOptionPane.showInputDialog("Patient last name: ");
        patient1.setFirstName(lastName);
        // Prompt the user to enter address and set it in the object
        String address = JOptionPane.showInputDialog("Patient Address: ");
        patient1.setAddress(address);
        // Prompt the user to enter city and set it in the object
        String cityName = JOptionPane.showInputDialog("Patient City: ");
        patient1.setCity(cityName);
        // Prompt the user to enter province and set it in the object
        String province = JOptionPane.showInputDialog("Province name: ");
        patient1.setProvince(province);
        // Prompt the user to enter postal code and set it in the object
        String postalCode = JOptionPane.showInputDialog("Postal Code: ");
        patient1.setPostalCode(postalCode);

        // display the patient1 information in the message dialog box
        JOptionPane.showMessageDialog(null, patient1.getPatientInfo());
        JOptionPane.showMessageDialog(null, "Thank you!!");

        // updating the information so as to using multi-parameter constructor
        // allow user to decide whether or not to update the information
        String choice = JOptionPane.showInputDialog("You want to update your information: (y/n)");

        if(choice == "y")
        {
            patientId = Integer.parseInt(JOptionPane.showInputDialog("Enter patient Id: "));
            firstName = JOptionPane.showInputDialog("Patient first name: ");
            lastName = JOptionPane.showInputDialog("Patient last name: ");
            // creating another instance of Patient class using multi-parameter constructor
            Patient patient2 = new Patient(patientId, firstName, lastName);
            patient2.setAddress(JOptionPane.showInputDialog("Patient Address: "));
            patient2.setCity(JOptionPane.showInputDialog("Patient City: "));
            patient2.setProvince(JOptionPane.showInputDialog("Province name: "));
            patient2.setPostalCode(JOptionPane.showInputDialog("Postal Code: "));
            JOptionPane.showMessageDialog(null, patient2.getPatientInfo());
            JOptionPane.showMessageDialog(null, "Thank you!! ");
        }
        // if user do not type "y", it will not allow user to update but show only thank you message and exit
        else
            JOptionPane.showMessageDialog(null, "Thank you!! ");

    }//end of main method
}//end of TestPatient class
