package com.company;

import javax.security.auth.login.AccountException;

public class Main {

    /*
     * create a new class for a bank account
     * create fields for the account number, balance, customer name, email and phone number.
     *
     * create getters and setters for each field
     * create two additional methods
     * 1. to allow the customer to deposit funds (this should increment the base balance field
     * 2. to allow the customer to withdraw funds. This should deduct from the balance field,
     * but not allow the withdrawal to complete if there are insufficient funds.
     * You will want to create various code in the main class to confirm your code is working
     * add some System.out.println in the two methods above as well
     *
     * */

    public static void main(String[] args) {
        BankAccount account = new BankAccount(
                123,
                0,
                "Alice",
                "alice@alice.com",
                "12346"

        );

        BankAccount newAccount = new BankAccount();
        System.out.println(newAccount.getCustomerName() + " balance is : " + newAccount.getBalance());

        System.out.println(account.getCustomerName() + " balance is : " + account.getBalance());


        account.depositFunds(100);
        account.depositFunds(62);
        account.withdrawFunds(33);

        System.out.println(account.getCustomerName() + " balance is : " + account.getBalance());

        VipCustomer vipCustomer = new VipCustomer();

        System.out.println("vip customer name : " + vipCustomer.getName());

        VipCustomer vipCUstomer2 = new VipCustomer("Bob", 5000.00, "testtest.com");

        System.out.println(vipCUstomer2.getName() + " " + vipCUstomer2.getCreditLimit());
    }
}
