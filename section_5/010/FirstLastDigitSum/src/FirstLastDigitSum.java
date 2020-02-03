public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }

        int last = number % 10;
        int first = 0;

        do {
            first = number % 10;
        } while ((number = number / 10) > 0);

        return first + last;
    }
}
