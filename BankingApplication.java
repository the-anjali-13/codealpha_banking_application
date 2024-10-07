import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        System.out.println("--- WELCOME TO BANKING SERVICE--");
        account.showMenu();
    }
}



 class BankAccount {
    private double balance = 0; // store balance

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Enter a valid amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    // Method to show menu and interact with user
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        char option;
        do {
            System.out.println("Menu: ");
            System.out.println("A: Check Balance");
            System.out.println("B: Deposit");
            System.out.println("C: Withdraw");
            System.out.println("D: Exit");
            System.out.print("Enter an option: ");
            option = scanner.next().charAt(0);

            switch (option) {
                case 'A':
                    checkBalance();
                    break;
                case 'B':
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 'C':
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 'D':
                    System.out.println("--- Thank you for visiting us ---");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 'D');
        scanner.close();
    }
}
