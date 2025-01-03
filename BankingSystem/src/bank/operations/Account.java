package bank.operations;

public class Account implements BankOperations {
    private String accountHolder; // name of the person
    private double balance; // total money in the acct

    // Constructor to set up name & starting balance
    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        // Deposit only if amount valid
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount); // show deposit success
        } else {
            System.out.println("Invalid deposit amount."); // bad amount error
        }
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        // Check if enough money in balance
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for this withdrawal."); // Not enough cash
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount."); // Cannot withdraw zero or less
        } else {
            balance -= amount;
            System.out.println("Withdrew: " + amount); // show withdrawal success
        }
    }

    // Show current balance of acct
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}
