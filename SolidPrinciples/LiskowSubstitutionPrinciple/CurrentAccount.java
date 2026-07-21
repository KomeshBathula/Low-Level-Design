package SolidPrinciples.LiskowSubstitutionPrinciple;

public class CurrentAccount implements DepositAccount, WithdrawAccount{
    public void deposit(double amount) {
        System.out.println("Deposited "+amount+" into current account");
    }

    public void withdraw(double amount) {
        System.out.println("Withdrawl is done ");
    }
}
