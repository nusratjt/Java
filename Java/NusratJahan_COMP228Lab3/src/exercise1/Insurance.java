package exercise1;

//using JOptionPane to display multiple lines in a dialog box
import javax.swing.JOptionPane;

// abstract Insurance super class
public abstract class Insurance {

    // Instance variables
    private String name;
    private int insuranceNumber;
    protected String insuranceType;
    protected String plantype;


    // constructor
    public Insurance(String name, int insuranceNumber, String insuranceType){

        // show error message if name is empty
        if(name == "")
            throw new IllegalArgumentException("Name can not be empty");

        // show error message if insurance number is less than or equal to zero
        if(insuranceNumber <= 0)
            throw new IllegalArgumentException("Insurance number can not be less than or equal to 0");

        // show error message if insurance type is not health and life type
        if(insuranceType != "health" && insuranceType != "life")
            throw new IllegalArgumentException("Invalid type");

        this.name = name;
        this.insuranceNumber = insuranceNumber;
        this.insuranceType = insuranceType;

    }

    // method to set the name of the customer
    public void setName(String name) {
        if(name == "")
            throw new IllegalArgumentException("Name can not be empty");
        this.name = name;
    }

    //method to set the insurance number of the customer
    public void setInsuranceNumber(int insuranceNumber) {
        if(insuranceNumber <= 0)
            throw new IllegalArgumentException("Insurance number can not be less than or equal to 0");
        this.insuranceNumber = insuranceNumber;
    }


    // method to retrieve the name
    public String getName() {
        return name;
    }

    // method to retrieve the insurance number
    public int getInsuranceNumber() {
        return insuranceNumber;
    }

    // method to retrieve the type of insurance
    public String getInsuranceType() {
        return insuranceType;
    }

    // abstract method that need to be overridden by concrete subclasses
    public abstract double setInsuranceCost();

    // abstract method that need to be overridden by concrete subclasses
    public abstract String displayInfo();

}// end of Insurance super class
