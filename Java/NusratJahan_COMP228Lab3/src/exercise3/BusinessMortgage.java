package exercise3;

// BusinessMortgage class that extends Mortgage
public class BusinessMortgage extends Mortgage {

    // instance variables
    private final double bussInterestRate; // interest rate over current prime rate ($4.00)
    private double monthlyInterestRate;

    //constructor
    public BusinessMortgage(int mortgageNumber, String customerName, double mortgageAmount,
                             int term, String mortgageType) {
        super(mortgageNumber, customerName, mortgageAmount, term);

        // set rate of business mortgage over prime rate 4.00
        this.bussInterestRate = 1.00;
        // set mortgage type to "Business"
        this.mortgageType = "Business";
    }

    // getter methods to retrieve the values
    public double getBussInterestRate() {
        return bussInterestRate;
    }

    public double getMonthlyInterestRate() {
        return monthlyInterestRate = ((getPrimeRate()+ getBussInterestRate())/100 )/12;
    }


    // overridden  method : implements getMonthlyPayment method that was abstract in Mortgage abstract class
    @Override
    public double getMonthlyPayment(){
        if(getTerm() == shortTermMort)
            monthlyPayment= getMortgageAmount()*(monthlyInterestRate * Math.pow((1 + monthlyInterestRate),shortTermMort));
        else if(getTerm() == mediumTermMort)
            monthlyPayment= getMortgageAmount()*(monthlyInterestRate * Math.pow((1 + monthlyInterestRate),mediumTermMort));
        else if(getTerm() == longTermMort)
            monthlyPayment= getMortgageAmount()*(monthlyInterestRate * Math.pow((1 + monthlyInterestRate),longTermMort));
        return monthlyPayment;
    }

    // overridden getMortgageInfo method : implements MortgageConstants interface
    @Override
    public String getMortgageInfo(){
        return String.format("%s%n%s:  %s%n%s:  $%.2f%n%s:  $%.3f%n%s:  $%.2f", super.getMortgageInfo(),
                "Mortgage type", getMortgageType(),
                "Bank Prime rate",getPrimeRate(),
                "Monthly Interest Rate", getMonthlyInterestRate(),
                "Monthly payment", getMonthlyPayment());
    }

}//end of BusinessMortgage subclass
