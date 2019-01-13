package exercise3;

// MortgageConstants interface declaration
public interface MortgageConstants {

    // final static constants
    final static  String bankName = "City Toronto Bank";
    final static int shortTermMort = 1;
    final static int mediumTermMort = 3;
    final static int longTermMort = 5;
    final static double maxMortgageAmount = 300000;

    // method to display mortgage information, no implementation
    String getMortgageInfo();

}//end of MortgageConstants interface
