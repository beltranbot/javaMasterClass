import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        * Create a program using arrays that sorts a list of integers in descending order.
        * Descending order is highest value to lowest.
        * In other words if the array had the values in it 106, 26, 81, 15 and 5 your program should
        * ultimately have an array with 106,81,26,15,5 in it.
        * Set up the program so that the numbers to sort are read in from the keyboard.
        * Implement the following methods - getIntegers, printArray, and sortIntegers
        * getIntegers returns an array of entered integers from keyboard
        * printArray prints out the contents of the array
        * and sortIntegers should sort the array and return a new array containing the sorted numbers
        * you will have to figure out how to copy the array elements from the passed array into a new
        * array and sort them and return the new sorted array
        * */

        int[] intArray = getIntegers(10);
        printArray(intArray);
        int[] sortedArray = sortIntegers(intArray);
        printArray(sortedArray);
    }

    public static int[] getIntegers(int n) {
        int[] integers = new int[n];
        System.out.println("Enter the integer values:\r");
        for (int i = 0; i < n; i++) {
            integers[i] = scanner.nextInt();
        }

        return integers;
    }

    public static void printArray(int[] array) {
        String output = "Array: ";
        for (int i = 0; i < array.length; i++) {
            output += array[i] + " ";
        }
        System.out.println(output);
    }
    public static int[] sortIntegers(int[] intArray) {
        int[] sortedArray = Arrays.copyOf(intArray, intArray.length);
        int i = 0;
        while (i < sortedArray.length - 1) {
            if (sortedArray[i + 1] > sortedArray[i]) {
                int temp = sortedArray[i];
                sortedArray[i] = sortedArray[i + 1];
                sortedArray[i + 1] = temp;
                i = -1;
            }
            i++;
        }

        return sortedArray;
    }
}
