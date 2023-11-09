// MainApp class
public class Main {

    public static void main(String[] args) {
        // Creating a BankAccount object
        BankAccount myAccount = new BankAccount("John Doe", 1000.0);

        // Accessing the encapsulated data through getter methods
        System.out.println("Account Holder: " + myAccount.getAccountHolder());
        System.out.println("Initial Balance: " + myAccount.getBalance());

        // Performing encapsulated operations
        myAccount.deposit(500.0);
        myAccount.withdraw(200.0);
    }
}