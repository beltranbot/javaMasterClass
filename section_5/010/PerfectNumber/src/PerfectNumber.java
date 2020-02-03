public class PerfectNumber {

    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i <= number - 1; i++) {
            sum += number % i == 0 ? i : 0;
        }

        return number == sum;
    }
}
