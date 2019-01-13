package exercise3;

// PersonalMortgage class that extends Mortgage
public class PersonalMortgage extends Mortgage{

    // instance variables
    private final double personalInterestRate; // interest rate over current prime rate ($4.00)
    private double monthlyInterestRate;

    //constructor
    public PersonalMortgage(int mortgageNumber, String customerName, double mortgageAmount,
                            int term,String mortgageType) {
        super(mortgageNumber, customerName, mortgageAmount, term);

        // set rate of personal mortgage over prime rate 4.00
        this.personalInterestRate = 2.00;
        // set mortgage type to "Personal"
        this.mortgageType = "Personal";
    }

    // getter methods to retrieve the values
    public double getpersonalInterestRate() {
        return personalInterestRate;
    }

    public double getMonthlyInterestRate() {
        return monthlyInterestRate = ((getPrimeRate()+ getpersonalInterestRate())/100 )/12;
    }


    // overridden  method : implements getMonthlyPayment method that was abstract in Mortgage abstract class
    @Override
    public double getMonthlyPayment(){

        if(getTerm() == shortTermMort)
            monthlyPayment = getMortgageAmount() * (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), (shortTermMort * 12)));
        else if(getTerm() == mediumTermMort)
            monthlyPayment= getMortgageAmount()*(monthlyInterestRate * Math.pow((1 + monthlyInterestRate),(mediumTermMort * 12)));
        else if(getTerm() == longTermMort)
            monthlyPayment= getMortgageAmount()*(monthlyInterestRate * Math.pow((1 + monthlyInterestRate),(longTermMort * 12)));
        return monthlyPayment;
    }

    // overridden getMortgageInfo method : implements MortgageConstants interface
    @Override
    public String getMortgageInfo(){
        return String.format("%s%n%s:  %s%n%s:  $%.2f%n%s:  $%.3f%n%s:  $%.2f ", super.getMortgageInfo(),
                "Mortgage type", getMortgageType(),
                "Bank Prime rate",getPrimeRate(),
                "Monthly Interest Rate", getMonthlyInterestRate(),
                "Monthly payment", getMonthlyPayment());
    }
}//end of PersonalMortgage subclass
