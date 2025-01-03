package bank.operations;

// Basic interface for bank acct operations
public interface BankOperations {
    void deposit(double amount); // Adds cash to balance
    void withdraw(double amount) throws InsufficientFundsException; // Takes cash out, errors if balance too low
}
