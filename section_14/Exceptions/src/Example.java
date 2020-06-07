import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        int result = divide();

        System.out.println(result);
    }

    private static int divide() {
        int x;
        int y;
        try {
            x = getInt();
            y = getInt();
        } catch (NoSuchElementException noSuchElementException) {
            throw new ArithmeticException("no suitable input");
        }

        System.out.println("x is: " + x + " y is" + ": " + y);

        try {
            return x / y;
        } catch(ArithmeticException arithmeticException) {
            throw new ArithmeticException("attempt to divide by zero");
        }
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                // go round again. Read past the end of line in the input first
                scanner.nextLine();
                System.out.println("Please enter a number using only the digits 0 to 9");
            }
        }

    }
}
