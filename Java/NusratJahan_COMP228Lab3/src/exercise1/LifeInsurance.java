package exercise1;

// using JOptionPane to display multiple lines in a dialog box
import javax.swing.JOptionPane;

// LifeInsurance class is a subclass of Insurance class
public class LifeInsurance extends Insurance {

    // instance variables of LifeInsurance class that represents the benefits of Life insurance
    private String lplantype;
    private double totalCoverage;
    private double monthlyFee;
    private double familySecurity;
    private double funeralExpense;
    private double debtLoanCoverage;
    private double criticalIllnessCoverage;
    private double accidentalDeath;
    private double childEducationExpense;
    private double otherExpense;

    //constructor of LifeInsurance class that takes the parameters of parent class
    public LifeInsurance(String name, int insuranceNumber, String insuranceType){
        super(name,insuranceNumber, insuranceType = "life");

        // prompt the user to enter the type of Life insurance plans
        lplantype = JOptionPane.showInputDialog("What type of insurance do you want?" +
                "\nenter t for \"term\" Life Insurance, \np for \"permanant\" Life Insurance and\n g for \"guaranteed\" Life Insurance");

        // set the benefits according to the user choice of the types of Life insurance
        switch (lplantype){
            case "term":
                this.familySecurity = 9000;
                this.funeralExpense = 3000;
                this.debtLoanCoverage = 12000;
                this.criticalIllnessCoverage = 8000;
                this.accidentalDeath = 5000;
                this.childEducationExpense = 500;
                this.otherExpense = 2000;
                this.monthlyFee = 90.25;
                this.totalCoverage = 100000;
                break;
            case "permanant":
                this.familySecurity = 12000;
                this.funeralExpense = 3500;
                this.debtLoanCoverage = 1000;
                this.criticalIllnessCoverage = 9000;
                this.accidentalDeath = 6000;
                this.childEducationExpense = 700;
                this.otherExpense = 3500;
                this.monthlyFee = 110.25;
                this.totalCoverage = 200000;
                break;
            case "guaranteed":
                this.familySecurity = 15000;
                this.funeralExpense = 4000;
                this.debtLoanCoverage = 15000;
                this.criticalIllnessCoverage = 10000;
                this.accidentalDeath = 7000;
                this.childEducationExpense = 700;
                this.otherExpense = 4000;
                this.monthlyFee = 120.25;
                this.totalCoverage = 300000;
                break;
            default:
                break;

        }

    }

    // getter methods of the instance variables to retrieve the values
    public String getPlantype() {
        return plantype;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public double getTotalCoverage() {
        return totalCoverage;
    }

    public double getFamilySecurity() {
        return familySecurity;
    }

    public double getFuneralExpense() {
        return funeralExpense;
    }

    public double getDebtLoanCoverage() {
        return debtLoanCoverage;
    }

    public double getCriticalIllnessCoverage() {
        return criticalIllnessCoverage;
    }

    public double getAccidentalDeath() {
        return accidentalDeath;
    }

    public double getChildEducationExpense() {
        return childEducationExpense;
    }

    public double getOtherExpense() {
        return otherExpense;
    }

    public String getLplantype() {
        return lplantype;
    }


    // set the types of the Life insurance
    public void setLplantype(String lplantype) {
        switch (lplantype){
            case "term":
                this.lplantype = lplantype;
                break;
            case "permanant":
                this.lplantype = lplantype;
                break;
            case "guaranteed":
                this.lplantype = lplantype;
                break;
        }    }

    // Show the information of the benefits offered by the Life insurance
    public String lifePlanInfo (){
        return String.format("%s:  $%.2f%n%s:  $%.2f%n%n%s%n%s%n%s:  $%.2f%n%s:  $%.2f%n%s:  $%.2f%n%s:  $%.2f%n%s:  $%.2f%n%s:  $%.2f%n%s:  $%.2f",
                "Coverage for life insurance",getTotalCoverage(),
                "Monthly Payment",getMonthlyFee(),
                "Benefits covered by the insurance","---------------------------------------------------------",
                "Coverage for family protection or security",getFamilySecurity(),
                "Funeral expenses",getFuneralExpense(),
                "Coverage for debts and loans",getDebtLoanCoverage(),
                "Coverage for critical illness",getCriticalIllnessCoverage(),
                "Coverage for Accidental Death",getAccidentalDeath(),
                "Child Education Expenses",getChildEducationExpense(),
                "Coverage Other Expenses",getOtherExpense());
    }

    // override the setInsuranceCost() method of Insurance abstract class
    @Override
    public double setInsuranceCost(){
        return getTotalCoverage();
    }

    // override the displayInfo() method of Insurance abstract class and show the customer information
    @Override
    public  String displayInfo(){
        return String.format("%s: %s%n%s: %d%n%s: %s%n%s: %s%n%s","Name",getName(),
                "Insurance Number", getInsuranceNumber(),
                "Insurance Type",getInsuranceType(),
                "plan type", getLplantype(),lifePlanInfo());
    }
}//end of LifeInsurance subclass
