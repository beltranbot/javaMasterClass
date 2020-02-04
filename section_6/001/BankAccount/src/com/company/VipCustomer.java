package com.company;

/*
* Create a new class VipCustomer
* it should have 3 fields name, credit limit, and email address
* create 3 constructors
* 1st constructor empty should call the constructor with 3 parameters with default values
* 2nd constructor should pass on the 2 values it receives and add a default value for the 3rd
* 3rd constructor should save all fields
* create getters and setter for this using code generation of intellij as setter wont be needed
* test and confirm it works
*
* */

public class VipCustomer {

    private String name;
    private double creditLimit;
    private String emailAddress;

    public VipCustomer() {
        this(
                "Default user",
                1000.0,
                "example@example.com"
        );
    }

    public VipCustomer(String name, String emailAddress) {
        this(name, 5000.0, emailAddress);
    }

    public VipCustomer(String name, double creditLimit, String emailAddress) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
