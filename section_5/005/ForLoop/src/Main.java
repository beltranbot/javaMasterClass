public class Main {

    public static void main(String[] args) {

        for(int i = 2; i <= 8; i++) {
            System.out.println(
                    "10,000 at " + i + "% interest = " +
                            String.format("%.2f", calculateInteger(10000.0, i))
            );
        }

        System.out.println("****************");

        for(int i = 8; i >= 1; i--) {
            System.out.println(
                    "10,000 at " + i + "% interest = " +
                            String.format("%.2f", calculateInteger(10000.0, i))
            );
        }

//        Create a for statement using any range of numbers
//        Determine if the number is a prime number using the isPrime method
//        if it is a prime number, print out and increment a count of the
//        number of prime numbers found
//        if that count is 3 exit the for loop
//        hint: use the break; statement to exit
        int primeCounter = 0;
        for (int i = 2; i <= 100; i++) {

            if (isPrime(i)) {
                System.out.println(i + " is prime.");
                primeCounter++;

                if (primeCounter == 3) {
                    break;
                }
            }
        }

    }

    public static double calculateInteger(double amount, double interstRate) {
        return (amount * (interstRate / 100));
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
