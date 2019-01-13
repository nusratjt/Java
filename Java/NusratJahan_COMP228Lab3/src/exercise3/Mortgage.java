package exercise3;

// Mortgage super class that implements interface MortgageConstants
public abstract class Mortgage implements MortgageConstants{

    // instance variables
    private int mortgageNumber;
    private String customerName;
    protected double mortgageAmount;
    private final double primeRate;
    private int term;
    protected double monthlyPayment;
    protected  String mortgageType;

    // variable that holds the value of maximum loan amount for short term mortgage
    private final double maxShortTermAmount = 50000;

    // constructor
    public Mortgage(int mortgageNumber, String customerName, double mortgageAmount,int term) {

        // show error message if mortgage number less than or equal zero
        if(mortgageNumber <= 0)
            throw new IllegalArgumentException("Insurance number can not be less than or equal to zero");

        // show error message if customer name is empty
        if(customerName == "")
            throw new IllegalArgumentException("Name can not be empty");

        // show error message if amount of mortgage is less than $3,000 or more than maxMortgageAmount = $300,000
        if(mortgageAmount < 3000.0 || mortgageAmount > maxMortgageAmount)
            throw new IllegalArgumentException("Amount of mortgage must be in between $3,000 and $300,000");

        // show error message if mortgage term is not shortTermMort, mediumTermMort or longTermMort
        if(!(term == shortTermMort || term == mediumTermMort || term == longTermMort))
            throw new IllegalArgumentException("Invalid term");

        // show error message if shortTermMort is less than $3000 or more than maxShortTermAmount = $50000
        if(term == shortTermMort && (mortgageAmount <= 3000.0 || mortgageAmount > maxShortTermAmount))
            throw new IllegalArgumentException("Amount of mortgage for short term can not be less than 0.0 or more than 50000");


        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.mortgageAmount = mortgageAmount;
        this.primeRate = 4.00;
        this.term = term;
    }


    // all setter to set and store values in the variables

    public void setMortgageNumber(int mortgageNumber) {
        // show error message if mortgage number less than or equal zero
        if(mortgageNumber <= 0)
            throw new IllegalArgumentException("Insurance number can not be less than or equal to zero");
        this.mortgageNumber = mortgageNumber;
    }

    public void setCustomerName(String customerName) {
        // show error message if customer name is empty
        if(customerName == "")
            throw new IllegalArgumentException("Name can not be empty");
        this.customerName = customerName;
    }

    public void setMortgageAmount(double mortgageAmount) {
        // show error message if amount of mortgage is less than $3,000 or more than maxMortgageAmount = $300,000
        if(mortgageAmount < 3000.0 || mortgageAmount > maxMortgageAmount)
            throw new IllegalArgumentException("Amount of mortgage must be in between $3,000 and $300,000");

        // show error message if shortTermMort is less than $3000 or more than maxShortTermAmount = $50000
        if(term == shortTermMort && (mortgageAmount <= 3000.0 || mortgageAmount > maxShortTermAmount))
            throw new IllegalArgumentException("Amount of mortgage for short term can not be less than 0.0 or more than 50000");
        this.mortgageAmount = mortgageAmount;
    }

    public void setTerm(int term) {
        // show error message if mortgage term is not shortTermMort, mediumTermMort or longTermMort
        if(!(term == shortTermMort || term == mediumTermMort || term == longTermMort))
            throw new IllegalArgumentException("Invalid term");
        this.term = term;
    }


    public void setMortgageType(String mortgageType) {
        this.mortgageType = mortgageType;
    }

    public int getMortgageNumber() {
        return mortgageNumber;
    }

    //all getter methods to retrieve the values

    public String getCustomerName() {
        return customerName;
    }

    public double getMortgageAmount() {
        return mortgageAmount;
    }

    public double getPrimeRate() {
        return primeRate;
    }

    public int getTerm() { return term; }

    public String getMortgageType() { return mortgageType; }

    public double getMaxShortTermAmount() { return maxShortTermAmount; }

    public double getMonthlyPayment() { return monthlyPayment; }


    // overridden method to display mortgage data
    @Override
    public String getMortgageInfo(){
        return String.format("%n%n%s%n%s%n%s:  %s%n%s:  %d%n%s:  $%.2f%n%s:  %s year",
                bankName,"==========================\n",
                "Customer name", getCustomerName(),
                "Mortgage number", getMortgageNumber(),
                "Amount of mortgage",getMortgageAmount(),
                "Mortgage term", getTerm());
    }
}//end of Mortgage abstract super class
