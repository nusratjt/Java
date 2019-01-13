package exercise2;

// using JOptionPane to display multiple lines in a dialog box
import javax.swing.JOptionPane;

// BankAccount class that contains instance variables and methods to get its values
public class BankAccount
{
    // declaring instance variables
    private int accountNumber;
    private String ownerName;
    private double balance;
    private double balAfterDepo;
    private double balAfterWith;

    // declaring a constructor with multiple parameters to initialize the variables
    public BankAccount(int accountNumber, String ownerName)
    {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        //validate that the balance is greater than 0.0; if it's not
        // instance variable balance keeps its default initial value of 0.0

        this.balance = 500.00;
    }



    // method to retrieve the accountNumber from the user
    public int getAccountNumber()
    {
        return accountNumber;
    }


    //method to retrieve the owner name from the user
    public String getOwnerName()
    {
        return ownerName;
    }

    // method returns the account balance
    public double getBalance()
    {
        return balance;
    }

    // method to deposit money in the account
    public void depositMoney(double depositAmount)
    {
        if(depositAmount > 0.0)
            this.balance += depositAmount;
        balAfterDepo = this.balance;//rename the balance after 1st deposit
    }


    // method to withdraw money
    public void withdrawMoney(double withdrawAmount)
    {
        // check if account have appropriate amount of money to withdraw
        if(withdrawAmount > 0.0) {
            this.balance -= withdrawAmount;
            balAfterWith = this.balance; // rename the balance after 1st withdraw
            if(this.balance < 500.0) {
                JOptionPane.showMessageDialog(null, "Your account does not have enough money to withdraw.");
                // if after withdrawing money balance become less than $500, balance reset to previous amount after deposit
                this.balance = balAfterDepo;
            }
        }
    }

    // method to withdraw money again in the second chance if user decide to withdraw again
    public void rewithdrawMoney(double withdrawAmount)
    {
        // condition when user fail to withdraw money 1st time due to balance less than 500.00 and
        //again try to withdraw
        if(this.balance == balAfterDepo)
        {
            if(withdrawAmount > 0.0) {
                this.balance = balAfterDepo - withdrawAmount;
                // if user fail to withdraw money again due to balance less than 500.00
                if(this.balance < 500.0) {
                    JOptionPane.showMessageDialog(null, "Your account does not have enough money to withdraw.");
                    //balance reset to amount after 1st deposit as user fail to withdraw money again
                    this.balance = balAfterDepo;
                }
            }

        }
        // condition when user withdraw money 1st time and try to withdraw again
        else if (this.balance == balAfterWith)
        {
            if(withdrawAmount > 0.0){
                this.balance = balAfterWith - withdrawAmount;
                //if user fail to withdraw money due to balance less than 500.00
                if(this.balance < 500.0) {
                    JOptionPane.showMessageDialog(null, "Your account does not have enough money to withdraw.");
                    // if after withdrawing money second time balance become less than $500,
                    // balance reset to amount after 1st withdraw
                    this.balance = balAfterWith;
                }
            }
        }

    }


    // method to return account information in a formatted string
    public String getAccountInfo()
    {
        return "Your Account Information"+"\n================================"+"\n\tAccount Number: "+getAccountNumber()
                +"\n\tAccount Name: "+getOwnerName()+"\n\tCurrent Balance: $"+ getBalance();
    }


}// end class BankAccount

