import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /*
     * Write a method called readIntegers() with a parameter called count that represents
     * how many integers the user need to enter
     * The method needs to read from the console until all the numbers are entered, and
     * then return an array containing the numbers entered.
     * write a method findMin() with the array as a parameter. The method needs to return
     * the minimum value in the array.
     * In the main() method read the count from the console and call the method
     * readIntegers() with the count parameter
     * Then call the findMin() method passing the array returned from the call to the
     * readIntegers() method.
     * Finally, print the minimum element in the array.
     * tips:
     *   assume that the user will only enter numbers, never letters.
     *   for simplicity, create a Scanner as a static field to help with data input.
     *   create a new console project with the name MinElementChallenge
     * */

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number of integers to enter: ");
        int count = scanner.nextInt();
        int[] integers = readIntegers(count);
        System.out.println("Array: " + Arrays.toString(integers));
        System.out.println("findMin(): " + findMin(integers));
    }

    private static int[] readIntegers(int count) {
        System.out.println("Enter " + count + " integers:\r");
        int[] integers = new int[count];
        for (int i = 0; i < count; i++) {
            integers[i] = scanner.nextInt();
        }

        return integers;
    }

    private static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            min = array[i] < min ? array[i] : min;
        }
        return min;
    }


}
