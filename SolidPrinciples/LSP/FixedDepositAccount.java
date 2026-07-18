package SolidPrinciples.LSP;

public class FixedDepositAccount implements DepositAccount{
    public void deposit(double amount) {
        System.out.println("Deposited "+amount+" into fixed account");
    }
}
