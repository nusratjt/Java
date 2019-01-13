package exercise2;

// abstract Student super  class
public abstract class Student {

    // instance variables
    private String firstName;
    private String lastName;
    private int studentId;
    private boolean status;

    // constructor
    public Student(String firstName,String lastName,int studentId, boolean status){

        // show error message if customer name is empty
        if(firstName == "")
            throw new IllegalArgumentException("Name can not be empty");

        if(lastName == "")
            throw new IllegalArgumentException("Name can not be empty");

        // show error message if mortgage number less than or equal zero
        if(studentId <= 0)
            throw new IllegalArgumentException("Student id can not be less than or equal to zero");

        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.status = status;
    }

    // all setter methods to store the values

    public void setFirstName(String firstName) {
        // show error message if customer name is empty
        if(firstName == "")
            throw new IllegalArgumentException("Name can not be empty");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName == "")
            throw new IllegalArgumentException("Name can not be empty");
        this.lastName = lastName;
    }

    public void setStudentId(int studentId) {
        // show error message if mortgage number less than or equal zero
        if(studentId <= 0)
            throw new IllegalArgumentException("Student id can not be less than or equal to zero");
        this.studentId = studentId;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // all the getter methods to retrieve the values
    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public int getStudentId() {
        return studentId;
    }

    public Boolean getStatus() {
        return status;
    }

    // abstract method to determine tuition fee that need to implemented
    public abstract double calculateTuitionFee();

    @Override
    public String toString(){
        return String.format("%s%s, %s%n%s%n%n%s: %s %s%n%s: %s%n%s: %s",
                "Student Information of",getlastName(),
                getfirstName(),"======================================",
                "Student Name", getfirstName(),getlastName(),
                "Student Id",getStudentId(),
                "Status",(getStatus()? "Full-time" : "Part-time"));
    }
}// end of super class
