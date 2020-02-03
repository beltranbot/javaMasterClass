public class Main {

    public static void main(String[] args) {
        // create a statement using a range of numbers from 1 to 1000
        // sum all the numbers that can be divided with both 3 and also with 5
        // for those number that met the above conditions, print out the number
        // break out of the loop once you find 5 numbers that met the above conditions
        // after breaking out of the loop print the sum of the numbers that met the above conditions.
        // Note: type all code in main method

        int sum = 0;
        int fizzbuzzCount = 0;
        int limit = 5;
        for (int i = 1; i <= 1000; i++) {
            if (i % 15 == 0) {
                sum += i;
                System.out.println(i + " is divisible by 3 and 5");
                fizzbuzzCount++;
                if(fizzbuzzCount == limit) {
                    break;
                }
            }
        }

        System.out.println("The total is: " + sum);
    }
}
