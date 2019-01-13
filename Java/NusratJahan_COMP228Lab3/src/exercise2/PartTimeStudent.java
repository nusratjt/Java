package exercise2;

//PartTimeStudent subclass that extends Student superclass
public class PartTimeStudent extends Student {

    // instance variable
    private final double feePerCredit;
    private double creditHour;


    // constructor
    public PartTimeStudent(String firstName,String lastName,int studentId, boolean status, double creditHour){
        super(firstName,lastName,studentId,status);

        //show error if credit hour is less than 3 or more than 15 of a part time student
        if(creditHour < 3 || creditHour > 15)
            throw new IllegalArgumentException("Credit hour for a part time student must be in between 3 to 15.");

        this.creditHour = creditHour;
        //set the fee for per credit hour as $100.00
        this.feePerCredit = 100;
    }

    //getter methods to retrieve the values

    public double getfeePerCredit() {
        return feePerCredit;
    }

    public double getCreditHour() {
        return creditHour;
    }

    // set method to store credit hour
    public void setCreditHour(double creditHour) {
        if(creditHour < 3 && creditHour > 15)
            throw new IllegalArgumentException("Credit hour for a part time student must be in between 3 to 15.");
        this.creditHour = creditHour;
    }

    // overridden calculateTuitionFee() that was abstract in super class

    @Override
    public double calculateTuitionFee(){
        return getfeePerCredit() * getCreditHour();
    }

    //return string representation of PartTimeStudent object
    @Override
    public String toString(){
        return String.format("%s%n%s: $%.2f%n%s: %.2f%n%s: $%s",
                super.toString(),
                "Tuition fee per credit hour", getfeePerCredit(),
                "Total credit hour", getCreditHour(),
                "Total Tuition fee", calculateTuitionFee());
    }
}// end of PartTimeStudent class
