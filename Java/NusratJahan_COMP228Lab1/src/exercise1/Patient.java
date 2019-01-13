package exercise1;

// Patient class that contains instance variables and methods to get its values
public class Patient
{
    // Private instance variables
    private int patientId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String province;
    private String postalCode;

    // declaring a default constructor
    public Patient()
    {

    }

    // declaring a multiple argument constructor
    public Patient(int patientId, String firstName, String lastName)
    {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    // Allow user to set patient ID to something else
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    // Allow user to set patient first name to something else
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Allow user to set patient last name to something else
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Allow user to set patient address to something else
    public void setAddress(String address) {
        this.address = address;
    }

    // Allow user to set patient city to something else
    public void setCity(String city) {
        this.city = city;
    }

    // Allow user to set patient province to something else
    public void setProvince(String province) {
        this.province = province;
    }

    // Allow user to set patient postal code to something else
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    // Allow user to get patient Id
    public int getPatientId() {
        return patientId;
    }

    // Allow user to get patient first name
    public String getFirstName() {
        return firstName;
    }

    // Allow user to get patient last name
    public String getLastName() {
        return lastName;
    }

    // Allow user to get patient address
    public String getAddress() {
        return address;
    }

    // Allow user to get patient city
    public String getCity() {
        return city;
    }

    // Allow user to get patient province
    public String getProvince() {
        return province;
    }

    // Allow user to get patient postal code
    public String getPostalCode() {
        return postalCode;
    }

    // method to return patient data in a formatted string
    public String getPatientInfo()
    {
        return "Patient Information in details: "+"\n-----------------------------------------"+
                "\nPatient Id: " + getPatientId()+ "\nFirst Name: " + getFirstName()+ "\nLast Name: "+getLastName()
                + "\nAddress: "+ getAddress()+ "\nCity: "+ getCity()+
                "\nProvince: "+getProvince()+"\nPostal Code: " +getPostalCode();
    }

}//End of Patient class
