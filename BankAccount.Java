// public class BankAccount {
//     Private final String accountHolderName = "default";
//     Private String accountNumber;
//     Private float accountBalance;
//     Private List<String> transactions;
//     Private boolean closed;
//     Private String accountCreatingDate;
//     Private String accountClosingDate;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BankAccount {
    // Private members
    private final String accountHolderName;
    private final String accountNumber;
    private float balance;
    private List<String> transactions;
    private boolean isClosed;
    private Date accountCreationDate;
    private Date accountClosingDate;

    // Constructor (with initial balance)
    public BankAccount(String accountHolderName, float initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        this.closed = false;
        this.accountCreationDate = new Date();
        logTransaction("Account created with balance: $" + initialBalance);
    }

    // Constructor (without initial balance)
    public BankAccount(String accountHolderName) {
        this(accountHolderName, 0);
    }

    // Getter for account holder's name
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for balance
    public float getBalance() {
        return balance;
    }

    // Getter for transactions
    public List<String> getTransactions() {
        return transactions;
    }

    // Getter for closed status
    public boolean isClosed() {
        return closed;
    }

    // Deposit method
    public void deposit(float amount) {
        if (closed) {
            throw new IllegalArgumentException("Account is closed.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        logTransaction("Deposit $" + amount + " at " + new Date());
    }

    // Withdraw method
    public void withdraw(float amount) {
        if (closed) {
            throw new IllegalArgumentException("Account is closed.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
        logTransaction("Withdraw $" + amount + " at " + new Date());
    }

    // Method to close account
    public void closeAccount() {
        if (!closed) {
            closed = true;
            accountClosingDate = new Date();
            logTransaction("Account closed on " + accountClosingDate);
        }
    }

    // Generate a random account number
    private String generateAccountNumber() {
        Random random = new Random();
        int number = 10000000 + random.nextInt(90000000);
        return String.valueOf(number);
    }

    // Log transactions
    private void logTransaction(String transaction) {
        transactions.add(transaction);
    }
}




}



