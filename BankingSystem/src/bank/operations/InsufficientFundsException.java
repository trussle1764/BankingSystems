package bank.operations;

// Custom exception for when user has not enough money in acct
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
