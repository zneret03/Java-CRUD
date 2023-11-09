// CurrentAccount class implementing BankAccount interface
public class CurrentAccount implements BankAccount {

    private String accountHolder;
    private double balance;

    public CurrentAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    @Override
    public String getAccountHolder() {
        return accountHolder;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount. Amount must be greater than 0.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    // Additional method specific to CurrentAccount
    public void issueOverdraft() {
        // Logic to issue overdraft for current account
        System.out.println("Overdraft issued. New balance: " + balance + 1000.0);
    }
}
