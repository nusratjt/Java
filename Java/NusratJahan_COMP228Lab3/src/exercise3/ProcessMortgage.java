package exercise3;

//using JOptionPane to display multiple lines in a dialog box
import javax.swing.JOptionPane;

//Driver class of Mortgage class
public class ProcessMortgage {

    public static void main(String[] args) {

       // prompt the user to enter name, mortgage number, mortgage amount, type of mortgage and mortgage term
       String customerName = JOptionPane.showInputDialog("Enter your name: ");
       int mortgageNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter your mortgage Number: "));
       double mortgageAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter the mortgage amount:\n" +
            "Valid amount for short-term mortgage is $3,000 - $ 50,000 and\n for other type $3,000 - $300,000 "));
       String mortgageType = JOptionPane.showInputDialog("What type of mortgage do you want? \n" +
            "enter \"b\" for business type\n \"p\" for personal for mortgage");
       int mortgageTerm = Integer.parseInt(JOptionPane.showInputDialog("How many years do you want this mortgage for? " +
            "(your mortgage term) : " + "type\n 1 for short-term\n3 for medium-term\n5 for long-term)"));


       //ceate objects of either BusinessMortgage or PersonalMortgage classes referring
       // to the Mortgage class according to the user choice
       switch (mortgageType){

            //if user types b create BusinessMortgage object referring to the Mortgage class
            case "b":
                  Mortgage customer1 = new BusinessMortgage(mortgageNumber, customerName,
                            mortgageAmount, mortgageTerm, mortgageType);
                  JOptionPane.showMessageDialog(null,"Mortgage Info of "+ customerName
                            +"\n===================================\n"+customer1.getMortgageInfo());
                  break;

                  //if user types p create PersonalMortgage object referring to the Mortgage class
            case "p":
                  Mortgage customer2 = new PersonalMortgage(mortgageNumber,customerName,
                            mortgageAmount, mortgageTerm, mortgageType);
                  JOptionPane.showMessageDialog(null,"Mortgage Info of "+ customerName
                            +"\n===================================\n"+customer2.getMortgageInfo());
                  break;
            default:
                  JOptionPane.showMessageDialog(null,"Invalid choice");
                  break;
            }


       // creating each mortgage objects referring to the Mortgage class by using Polymorphic screen manager

       JOptionPane.showMessageDialog(null,"Mortgage processed Polymorphically"
             +"\n===============================\n");


       //creating more objects of each Mortgage type
       Mortgage customer3 = new BusinessMortgage(mortgageNumber, customerName,
             mortgageAmount, mortgageTerm, mortgageType);
       Mortgage customer4 = new PersonalMortgage(mortgageNumber,customerName,
             mortgageAmount, mortgageTerm, mortgageType);

       // creating two-element MortgageConstants array
       MortgageConstants[] mortgageObjects = new MortgageConstants[2];

       //generically process each element in array MortgageConstants
       mortgageObjects[0] = customer3;
       mortgageObjects[1] = customer4;

       for(MortgageConstants mortgageConstants : mortgageObjects){
             JOptionPane.showMessageDialog(null, mortgageConstants.getMortgageInfo());
       }

    }//end of main method
}//end of ProcessMortgage (Driver) class
