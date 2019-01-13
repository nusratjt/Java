package exercise2;

// using JOptionPane to display multiple lines in a dialog box
import javax.swing.JOptionPane;

public class BankAccountTest
{
    public static void main(String[] args)
    {
        // prompt the user to enter account number
        int accountNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your account number: "));

        // prompt the user to enter account name
        String accountName = JOptionPane.showInputDialog("Enter your name: ");

        // create a BankAccount object and assign it to account1 and initialize the accountNumber and accountName variables
        BankAccount account1 = new BankAccount(accountNo, accountName);

        // display the account information in the message dialog box
        JOptionPane.showMessageDialog(null,account1.getAccountInfo());

        //prompt the user to deposit money
        double depositAmount = Double.parseDouble(JOptionPane.showInputDialog("How much money you want to deposit? "));
        account1.depositMoney(depositAmount);

        // display the account information in the dialog box after depositing money
        JOptionPane.showMessageDialog(null,account1.getAccountInfo());

        //prompt the user to withdraw money
        double withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog("How much money you want to withdraw? "));
        account1.withdrawMoney(withdrawAmount);

        // display the account information in the dialog box after withdrawing money
        JOptionPane.showMessageDialog(null,account1.getAccountInfo());

        // Allow the user to decide whether or not deposit or withdraw money again
        String choice = JOptionPane.showInputDialog("Do you want to deposit/withdraw more money? (y/n)");
        if(choice == "y") {
            int depoOrWithdraw = Integer.parseInt(JOptionPane.showInputDialog("Do you want to"));
            //typing "y" allows user to deposit/withdraw money again
            switch (depoOrWithdraw) {
                case 1:
                    //typing 1 allow the user to deposit money again
                    depositAmount = Double.parseDouble(JOptionPane.showInputDialog("How much money you want to deposit? "));
                    account1.depositMoney(depositAmount);
                    JOptionPane.showMessageDialog(null, account1.getAccountInfo());
                    break;
                case 2:
                    // typing 2 allow the user to withdraw money again
                    withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog("How much money you want to withdraw? "));
                    account1.rewithdrawMoney(withdrawAmount);
                    JOptionPane.showMessageDialog(null, account1.getAccountInfo());
                    break;
            }
        }
        else
            // if user decide not to deposit or withdraw money again
            JOptionPane.showMessageDialog(null,"Thank you!!");

    }//End of main method
}// end of TestBankAccount class
