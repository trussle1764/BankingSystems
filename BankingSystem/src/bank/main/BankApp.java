package bank.main;

import bank.operations.Account;
import bank.operations.InsufficientFundsException;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account("Tanatswa Rusinga", 500.0); // Starting with 500 bucks

        System.out.println("Welcome to Tanatswa Rusinga's Banking System!");

        while (true) {
            // Menu options for user
            System.out.println("\nChoose an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt(); // Get user choice

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount); // Do deposit
                    account.displayBalance(); // Show updated balance
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    try {
                        account.withdraw(withdrawAmount); // Do withdrawal
                        account.displayBalance(); // Show updated balance
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage()); // Show error for not enough money
                    }
                    break;

                case 3:
                    account.displayBalance(); // Just show balance
                    break;

                case 4:
                    System.out.println("Exiting the Banking System. Bye!");
                    scanner.close();
                    return; // End program

                default:
                    System.out.println("Invalid choice. Try again."); // If choice not 1-4
                    break;
            }
        }
    }
}
