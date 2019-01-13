package exercise1;

//using JOptionPane to display multiple lines in a dialog box
import javax.swing.JOptionPane;

//Driver class of Insurance class
public class InsuranceTest {
    public static void main(String[] args) {

        // prompt the user to enter name, insurance number and type of insurance
        String customerName = JOptionPane.showInputDialog("Enter customer name: ");
        int insuranceNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter customer insurance number"));
        String insuranceType = JOptionPane.showInputDialog("What type of insurance do you want?" +
                "\ntype h for \"health\" insurance \nand l for \"life\" insurance");

        //ceate objects of either HealthInsurance or LifeInsurance classes referring
        // to the Insurance class according to the user choice
        switch (insuranceType){

            //if user types h create HealthInsurance object referring to the Insurance class
            case "h":
                Insurance customer1 = new HealthInsurance(customerName,insuranceNumber,insuranceType);
                JOptionPane.showMessageDialog(null,"Insurance Information of "+ customerName
                        +"\n===================================\n"+customer1.displayInfo());
                break;

            //if user types l create LifeInsurance object referring to the Insurance class
            case "l" :
                Insurance customer2 = new LifeInsurance(customerName,insuranceNumber,insuranceType);
                JOptionPane.showMessageDialog(null,"Insurance Information of "+ customerName
                        +"\n===================================\n"+customer2.displayInfo());
                break;

        }


        // creating each insurance objects referring to the Insurance class by using Polymorphic screen manager

        JOptionPane.showMessageDialog(null,"Insurance processed Polymorphically"
                +"\n===============================\n");

        //creating more objects of each insurance type
        Insurance customer3 = new HealthInsurance(customerName,insuranceNumber,insuranceType);
        Insurance customer4 = new LifeInsurance(customerName,insuranceNumber,insuranceType);

        // creating two-element Insurance array
        Insurance[] insuranceObjects = new Insurance[2];

        //initialize array with Insurance
        insuranceObjects[0] = customer3;
        insuranceObjects[1] = customer4;

        //generically process each element in array insurances
        for(Insurance customers : insuranceObjects) {
            JOptionPane.showMessageDialog(null, customers.displayInfo());
        }

    }//End of main method
}//end of Driver class of Insurance
