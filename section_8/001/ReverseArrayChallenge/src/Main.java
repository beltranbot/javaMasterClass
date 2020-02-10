import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /*
    * write a method called reverse() with an int array as parameter
    * the method should not return any value. In other words, the method is allowed to modify
    * the array parameter.
    * in main() thes the reverse method and print the array both reversed and non-reversed.
    * to reverse the array, you have to swap the elements, so that the first element is swapped
    * with the last element and so on.
    * for example, if the array is {1,2,3,4,5}, then the reversed array is {5,4,3,2,1}
    * tip:
    *   create a new console project with the name ReverseArrayChallenge
    * */

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number count:\r");
        int count = scanner.nextInt();

        int[] integers = readIntegers(count);
        System.out.println("Array: " + Arrays.toString(integers));
        reverse(integers);
        System.out.println("Reversed Array: " + Arrays.toString(integers));

    }

    private static int[] readIntegers(int count) {
        System.out.println("enter " + count + " integers:\r");
        int[] integers = new int[count];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = scanner.nextInt();
        }
        return integers;
    }

    private static void reverse(int[] array) {
        int temp = 0;
        int j = 0;
        for (int i = 0; i < (array.length / 2); i++) {
            j = array.length - 1 - i;
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
