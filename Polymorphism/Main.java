// MainApp class to test polymorphism
public class Main {

    public static void main(String[] args) {
        // Creating SavingsAccount and CurrentAccount objects
        BankAccount savingsAccount = new SavingsAccount("John Doe", 1000.0);
        BankAccount currentAccount = new CurrentAccount("Jane Smith", 1500.0);

        // Accessing common methods through the BankAccount interface
        System.out.println("Savings Account Holder: " + savingsAccount.getAccountHolder());
        savingsAccount.deposit(500.0);
        savingsAccount.withdraw(200.0);

        System.out.println("\nCurrent Account Holder: " + currentAccount.getAccountHolder());
        currentAccount.deposit(800.0);
        currentAccount.withdraw(300.0);

        // Applying polymorphism: calling specific methods for each account type
        if (savingsAccount instanceof SavingsAccount) {
            ((SavingsAccount) savingsAccount).applyInterest();
        }

        if (currentAccount instanceof CurrentAccount) {
            ((CurrentAccount) currentAccount).issueOverdraft();
        }
    }
}