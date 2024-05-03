package se.lexicon;

import se.lexicon.exception.InsufficientFoundsException;

public class BankAccount {
    private static int nextAccountNumber = 1000; // Starting account number
    private final int accountNumber;
    private double balance;

    public BankAccount(double initialBalance) {
        this.accountNumber = nextAccountNumber++;
        this.balance = initialBalance;
    }


    /**
     * add description about the method as text
     * @param amount add description about amount
     * @throws IllegalArgumentException add description about the exception
     *
     */


    public void deposit(double amount) {
        if(amount < 0){
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
        System.out.println("Deposit successful. New Balance: " + balance);
    }

    public void withdraw(double amount) throws InsufficientFoundsException{
        if (amount < 0){
            throw new IllegalArgumentException("Withdraw must be positive");
        }
        if (amount > balance){
            throw new InsufficientFoundsException("Balance is insufficient.");
        }

        balance -= amount;
        System.out.println("Withdrawal successful. New Balance: " + balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}