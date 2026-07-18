package SolidPrinciples.ISP;

public class SavingsAccount implements DepositAccount, WithdrawAccount{
    public void deposit(double amount) {
        System.out.println("Deposited "+amount+" into savings account");
    }

    public void withdraw(double amount) {
        System.out.println("Money withdraw successfully");
    }
}
