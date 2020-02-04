package com.company;

public class BankAccount {

    private int number;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount() {
        this(
                123,
                0.0,
                "Default name",
                "default email",
                "default phone"
        );
    }

    public BankAccount(int number, double balance, String customerName, String email, String phoneNumber) {
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public BankAccount(int number, String customerName) {
        this.number = number;
        this.customerName = customerName;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNUmber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumber() {
        return this.number;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPHoneNumber() {
        return this.phoneNumber;
    }

    // methods
    public void depositFunds(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit: amount is invalid");
            return;
        }

        this.balance += amount;
        System.out.println("Current funds: " + this.balance);
    }

    public void withdrawFunds(double amount) {
        if (amount < 0) {
            System.out.println("Withdraw: amount is invalid");
            return;
        }
        if (amount > this.balance) {
            System.out.println("Withdraw: amount to withdraw surpasses the account's balance");
            return;
        }

        this.balance -= amount;
        System.out.println("Current balance: " + this.balance);
    }

}
