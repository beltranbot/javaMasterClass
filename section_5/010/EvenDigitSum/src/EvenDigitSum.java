public class EvenDigitSum {

    public static int getEvenDigitSum(int number) {
        if (number < 0) {
            return -1;
        }
        int evenSum = 0;
        do {
            int n = number % 10;
            evenSum += (n % 2 == 0) ? n : 0;
        } while ((number = number / 10) > 0);

        return evenSum;
    }
}
