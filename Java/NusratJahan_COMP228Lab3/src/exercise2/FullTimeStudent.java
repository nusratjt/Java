package exercise2;

//PartTimeStudent subclass that extends Student superclass
public class FullTimeStudent extends Student{

    // instance variable
    private final double flatFee;
    private double totalCreditHour;

    // constructor
    public FullTimeStudent(String firstName,String lastName,int studentId, boolean status, double totalCreditHour){
        super(firstName,lastName,studentId,status);

        //show error if credit hour is less than 16 or more than 24 of a Full time student
        if(totalCreditHour < 16.00 || totalCreditHour > 24.00)
            throw new IllegalArgumentException("Credit hour for a full-time student must be in between 16.00 and 24.00");
        this.totalCreditHour = totalCreditHour;
        // set the fee for full time student as $2000
        this.flatFee = 2000;
    }

    //method to retrieve the value flatFee
    public double getFlatFee() {
        return flatFee;
    }

    // set method to store credit hour of a full time student
    public void setTotalCreditHour(double totalCreditHour) {

        if(totalCreditHour < 16.00 && totalCreditHour > 24.00)
            throw new IllegalArgumentException("Credit hour for a fulltime student must be in between 16.00 and 24.00");
        this.totalCreditHour = totalCreditHour;
    }

    public double getTotalCreditHour() {
        return totalCreditHour;
    }

    // overridden calculateTuitionFee() that was abstract in super class
    @Override
    public double calculateTuitionFee(){
        return getFlatFee();
    }

    //return string representation of FullTimeStudent object
    @Override
    public String toString(){
        return String.format("%s%n%s: %s%n%s: $%.2f", super.toString(),
                "Total credit hour",getTotalCreditHour(),
                "Tuition fee", getFlatFee());
    }
}//end of FullTimeStudent subclass
