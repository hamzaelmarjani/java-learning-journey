package cc.hamzaelmarjani.account;

import java.util.Date;

public class Account extends AccountCredentials {
    private String accountNumber;
    private String holderName;
    private Date createdAt;
    private double balance;

    public Account(String accountNumber, String holderName, Date createdAt, double balance, String password) {
        super(password);
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.createdAt = createdAt;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return super.password;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
