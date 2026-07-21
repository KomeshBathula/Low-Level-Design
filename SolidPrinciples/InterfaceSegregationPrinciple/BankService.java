package SolidPrinciples.InterfaceSegregationPrinciple;

public class BankService {
    public void processDeposit(DepositAccount account, double amount) {
        account.deposit(amount);
    }

    public void processWithdrawl(WithdrawAccount account, double amount) {
        account.withdraw(amount);
    }

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount();
        CurrentAccount currentAccount = new CurrentAccount();
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount();

        BankService service = new BankService();
        service.processDeposit(savingsAccount, 500000);
        service.processDeposit(currentAccount, 500000);
        service.processDeposit(fixedDepositAccount, 500000);


        service.processWithdrawl(savingsAccount, 2000);
        service.processWithdrawl(currentAccount, 2000);

        // this is not possible because fixedDepositAccount does not implement withdraw
        
        // service.processWithdrawl(fixedDepositAccount, 2000);
    }
}
