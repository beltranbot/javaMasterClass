import java.util.Scanner;

public class Main {

    /*
     * read 10 numbers from the console entered by the user
     * and print the sum of those numbers
     *
     * create a scanner like we did in the previous video
     *
     * use the has next int() method from the scanner
     * to check if the user has entered an input
     *
     * if hasNextInt() returns false, print the message "Invalid Number".
     * Continue reading until you have 10 numbers
     *
     * Use the nextInt() method to get the number and add it to the sum.
     *
     * before the user enters each number, print the message "Enter number #x:" where x
     * represents the count, i.e. 1, 2, 3, 4, etc.
     *
     * fore example, the first message printed to the user would be "Enter number #1:", the
     * next "Enter number #2:", and so on.
     * hint:
     * use a while loop
     * use a counter variable for counting valid numbers
     * close the scanner after you don't need it anymore
     * create a project with the name ReadingUserInputChallenge
     * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.println("Enter number #" + i + ":");
            if (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            } else {
                System.out.println("Invalid Number");
                i--;
            }

            scanner.nextLine();
        }
        scanner.close();

        System.out.println("Total = " + sum);
        
    }
}
