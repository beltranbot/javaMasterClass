public class Main {

    /*
    * write a method with the name sumDigits that has one int parameter called number
    * if parameter >= 10 the method should process the number and return sum of all digits,
    * otherwise return -1 to indicate an invalid value
    * the numbers from 0-9 have 1 digit so we don't want to process them, also we don't
    * want to process negative numbers, so also return -1 for negative numbers.
    * for example calling the method sumDigits(125) should return 8 since 1 + 2 + 5 = 8
    * calling the method sumDigits(1) should return -1 as per requirements described above
    *
    * add some code to the main method to test out the sumDigits method to determine
    * that is working correctly for valid and invalid values passed as arguments
    *
    * hint:
    * use n % 10 to extract the least significant digit
    * use n = n /10 to discard the least-significant digit
    * the method needs to be static like other methods so far in the course
    * */


    public static void main(String[] args) {
        System.out.println(sumDigits(1990));
        System.out.println(digitalRoot(1990));
    }

    public static int sumDigits(int n) {
        if (n < 10) {
            return -1;
        }

        int sum = 0;

        do {
            sum += n % 10;
        } while((n = n / 10) > 0);

        return sum;
    }

    public static int digitalRoot(int n) {
        if (n < 0) {
            return -1;
        }
        if (n < 10) {
            return n;
        }

        int sum = 0;
        do {
            sum += n % 10;
        } while((n = n / 10) > 0);

        return digitalRoot(sum);
    }
}
