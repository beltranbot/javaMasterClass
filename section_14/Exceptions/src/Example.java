import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        } catch (NoSuchElementException | ArithmeticException exception) {
            System.out.println(exception.toString());
            System.out.println("Unable to perform division, autopilot shitting down");
        }
    }

    private static int divide() {
        int x = getInt();
        int y = getInt();
        System.out.println("x is: " + x + " y is" + ": " + y);
        return x / y;
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
