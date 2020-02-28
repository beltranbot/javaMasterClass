import java.util.Scanner;

public class Main {

    /*
     * Write a small program to read an integer from the keyboard
     * (using Scanner) and print out the times table for that number.
     * the table should run from 1 to 12.
     *
     * You are allowed to use one variable called scanner for your
     * Scanner instance. You can use as many other variables as you
     * need, but they must all be called x. That includes any
     * class instances and loop control variables that you may decide
     * to use.
     *
     * if you use a class, the class can be called X (capital), but
     * any instances of it must be called x (lower case).
     *
     * Optional Extra:
     *
     * Change your program so that ALL variables (including the scanner instance)
     * are called x.
     *
     * */

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter a number: ");
        X x = new X(scanner.nextInt());
    }


}
