public class Main {

    public static void main(String[] args) {

        System.out.println(isPrime(45));
        System.out.println(isPrime(9));

        System.out.println(LargestPrime.getLargestPrime(45));

    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int j = 2; j <= Math.sqrt(n); j++) {
            if (n % j == 0) {
                return false;
            }
        }

        return true;

    }
}
