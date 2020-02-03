public class FactorPrinter {

    public static void printFactors(int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
            return;
        }

        String output = "";

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                output += i;

                if (i != number) {
                    output += " ";
                }
            }
        }

        System.out.println(output);
    }
}
