package com.company;

public class SpeedConverter {
    public long toMilesPerHour (double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1;
        }
        double milesPerHour = kilometersPerHour / 1.609;
        return Math.round(milesPerHour);
    }

    public void printConversion (double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            long milesPerHour = toMilesPerHour(kilometersPerHour);
            System.out.println(
                    kilometersPerHour +
                            " km/h = " +
                            milesPerHour +
                            " mi/h"
            );
        }
    }
}
