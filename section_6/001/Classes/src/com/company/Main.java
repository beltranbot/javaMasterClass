package com.company;

public class Main {

    public static void main(String[] args) {
        Car porsch = new Car();
        Car holden = new Car();

        porsch.setModel("Ferrari");
        System.out.println("Model is: " + porsch.getModel());
    }
}
