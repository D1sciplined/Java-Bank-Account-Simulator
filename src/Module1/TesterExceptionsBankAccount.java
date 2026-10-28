/**
 * 
 */
package Module1;

import java.util.Scanner;

public class TesterExceptionsBankAccount {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        BankAccount account = new BankAccount("12345", 250.0);

        boolean running = true;

        while (running) {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = keyboard.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = keyboard.nextDouble();
                        account.deposit(depositAmount);
                        System.out.println("Transaction completed.");
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = keyboard.nextDouble();
                        account.withdraw(withdrawAmount);
                        System.out.println("Transaction completed.");
                        break;

                    case 3:
                        System.out.println("Current balance: " + account.getBalance());
                        break;

                    case 4:
                        running = false;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid menu option.");
                }
            } catch (InvalidDepositException |
                     InvalidAmountException |
                     InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        keyboard.close();
    }
}
