package entities;

import java.math.BigDecimal;

public class ATM {

    private long id;
    private String accountHolderName;
    private String accountNumber;
    private BigDecimal balance;
    private boolean isActive;

    public ATM(long id, String accountHolderName, String accountNumber, BigDecimal balance, boolean isActive) {

        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Initial balance cannot be negative");
        }

        this.id = id;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.isActive = isActive;
    }

    public void deposit(BigDecimal amount) {
        if (!isActive) {
            throw new RuntimeException("Account is not active");
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Deposit amount must be greater than zero");
        }

        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (!isActive) {
            throw new RuntimeException("Account is not active");
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Withdraw amount must be greater than zero");
        }

        if (balance.compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        balance = balance.subtract(amount);
    }

    public BigDecimal checkBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "id=" + id +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", isActive=" + isActive +
                '}';
    }
}
