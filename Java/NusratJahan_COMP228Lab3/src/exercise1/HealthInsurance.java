package exercise1;

//using JOptionPane to display multiple lines in a dialog box
import javax.swing.JOptionPane;

// HealthInsurance class is a subclass of Insurance class
public class HealthInsurance extends Insurance {

    // instance variables of HealthInsurance class that represents the benefits of health insurance
    private String hplantype;
    private double healthCoverage;
    private double monthlyFee;
    private double visitCost;
    private double ambulance;
    private double oxygenEquipment;
    private double privateDutyNursing;
    private double accidentalDental;
    private double hearingAids;
    private double prescriptionDrugs;
    private double hospitalRooms;

    //constructor of HealthInsurance class that takes the parameters of parent class
    public HealthInsurance(String name, int insuranceNumber, String insurancetype){
        super(name,insuranceNumber,insurancetype = "health");

        // prompt the user to enter the type of health insurance plans
        hplantype = JOptionPane.showInputDialog("What type of insurance do you want?\nenter omni, extended or basic");

        // set the benefits according to the user choice of the types of health insurance
        switch (hplantype){
            case "omni":
                this.visitCost = 30;
                this.ambulance = 3000;
                this.oxygenEquipment = 500;
                this.privateDutyNursing = 2000;
                this.accidentalDental = 10000;
                this.hearingAids = 700;
                this.prescriptionDrugs = 3500;
                this.hospitalRooms = 3500;
                this.monthlyFee = 120.25;
                this.healthCoverage = 300000;
                break;
            case "extended":
                this.visitCost = 25;
                this.ambulance = 2000;
                this.oxygenEquipment = 400;
                this.privateDutyNursing = 1500;
                this.accidentalDental = 7000;
                this.hearingAids = 500;
                this.prescriptionDrugs = 2800;
                this.hospitalRooms = 3000;
                this.monthlyFee = 103.25;
                this.healthCoverage = 200000;
                break;
            case "basic":
                this.visitCost = 15;
                this.ambulance = 1500;
                this.oxygenEquipment = 300;
                this.privateDutyNursing = 1000;
                this.accidentalDental = 5000;
                this.hearingAids = 400;
                this.prescriptionDrugs = 2000;
                this.hospitalRooms = 2000;
                this.monthlyFee = 90.25;
                this.healthCoverage = 100000;
                break;
            default:
                break;

        }

    }


    // getter methods of the instance variables to retrieve the values
    public double getMonthlyFee() {
        return monthlyFee;
    }

    public double getHealthCoverage() {
        return healthCoverage;
    }

    public double getVisitCost() {
        return visitCost;
    }

    public double getAmbulance() {
        return ambulance;
    }

    public double getOxygenEquipment() {
        return oxygenEquipment;
    }

    public double getPrivateDutyNursing() {
        return privateDutyNursing;
    }

    public double getAccidentalDental() {
        return accidentalDental;
    }

    public double getHearingAids() {
        return hearingAids;
    }

    public double getPrescriptionDrugs() {
        return prescriptionDrugs;
    }

    public double getHospitalRooms() {
        return hospitalRooms;
    }

    public String getHplantype() { return hplantype; }

    // set the types of the health insurance
    public void setHplantype(String hplantype) {
        switch (hplantype){
            case "omni":
                this.hplantype = hplantype;
                break;
            case "extended":
                this.hplantype = hplantype;
                break;
            case "basic":
                this.hplantype = hplantype;
                break;
        }

    }

    // Show the information of the benefits offered by the health insurance
    public String healthPlanInfo (){
        return String.format("%s:  $%.2f%n%s:  $%.2f%n%n%s:%n%s%n%s:  $%.2f%n%s:  $%.2f%n%s:  $%.2f  %s%n%s: %.2f  %s%n" +
                        "%s:  %s $%.2f%n%s:  $%.2f %s%n%s:  $%.2f%n%s:  $%.2f",
                "Coverage for health insurance",getHealthCoverage(),
                "Monthly payment",getMonthlyFee(),
                "Benefits covered by the insurance","-----------------------------------------------------",
                "Visit cost per person",getVisitCost(),
                "Ambulance",getAmbulance(),
                "Accidental Dental",getAccidentalDental(),"per person per year",
                "Hearing aids",getHearingAids(),"per person every 4 years",
                "Hospital rooms","45 days to",getHospitalRooms(),
                "Oxygen Equipment",getOxygenEquipment(),"/year",
                "Prescription drugs",getPrescriptionDrugs(),
                "Private Duty Nursing",getPrivateDutyNursing());
    }


    // override the setInsuranceCost() method of Insurance abstract class and
    // set the amount of money that customer get returns after 10 years of insurance
    @Override
    public double setInsuranceCost(){
        return getHealthCoverage()* .07;
        }

        // override the displayInfo() method of Insurance abstract class and show the customer information
    @Override
    public  String displayInfo(){
        return String.format("%s: %s%n%s: %d%n%s: %s%n%s: %s%n%s%n%s:  $%.2f","Name",getName(),
                "Insurance Number", getInsuranceNumber(),
                "Insurance Type",getInsuranceType(),
                "plan type", getHplantype(),healthPlanInfo(),
                "Coverage after maximum 10 years",setInsuranceCost());
    }

}//end of HealthInsurance subclass
