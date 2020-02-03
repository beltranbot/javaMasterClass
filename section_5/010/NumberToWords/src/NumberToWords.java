public class NumberToWords {

    public static int getDigitCount(int n) {
        if (n < 0) {
            return -1;
        }

        int digitCount = 0;
        do {
            digitCount++;
        } while ((n = n / 10) > 0);

        return digitCount;
    }

    public static int reverse(int n) {
        boolean isNegative = false;
        if (n < 0) {
            n *= -1;
            isNegative = true;
        }

        int reversed = 0;
        int i = 0;
        do {
            reversed *= 10;
            reversed += (n % 10);
        } while ((n = n / 10) > 0);

        return isNegative ? -1 * reversed : reversed;
    }

    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
            return;
        }

        String output = "";
        do {
            switch (number % 10) {
                case 0:
                    output = "Zero " + output;
                    break;
                case 1:
                    output = "One " + output;
                    break;
                case 2:
                    output = "Two " + output;
                    break;
                case 3:
                    output = "Three " + output;
                    break;
                case 4:
                    output = "Four " + output;
                    break;
                case 5:
                    output = "Five " + output;
                    break;
                case 6:
                    output = "Six " + output;
                    break;
                case 7:
                    output = "Seven " + output;
                    break;
                case 8:
                    output = "Eight " + output;
                    break;
                case 9:
                    output = "Nine " + output;
                    break;
                default:
                    System.out.println("Invalid Value");
                    return;
            }
        } while ((number = number / 10) > 0);

        System.out.println(output);
    }
}
