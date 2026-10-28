/**
 * 
 */
package Module1;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) throws InvalidDepositException {
        if (amount <= 0) {
            throw new InvalidDepositException("Deposit amount must be greater than zero.");
        }
        balance += amount;
    }

    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientFundsException {

        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new InsufficientFundsException(
                "Insufficient funds. Current balance: " + balance
            );
        }

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
