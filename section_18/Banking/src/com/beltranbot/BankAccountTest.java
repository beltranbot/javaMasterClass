package com.beltranbot;

import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount account;
    private static int count = 0;

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any of the test cases. Count = " + count++);
    }

    @org.junit.Before
    public void setup() {
        account = new BankAccount("Time", "Buchalka", 1000.0, BankAccount.CHECKING);
        System.out.println("Running a test...");
        System.out.println("Count = " + count++);
    }

    @org.junit.Test
    public void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200, balance, 0);
    }

    @org.junit.Test
    public void withdraw_branch() {
        double balance = account.withdraw(600.0, true);
        assertEquals(400.0, balance, 0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() {
        double balance = account.withdraw(600.0, false);
        assertEquals(400.0, balance, 0);
    }

    @org.junit.Test
    public void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true() {
        assertTrue("The account is NOT a checking account", account.isChecking());
    }

    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @org.junit.After
    public void teardown() {
        System.out.println("Count = " + count++);
    }
}
