import java.util.Scanner;

public class InputCalculator {

    public static void inputThenPrintSumAndAverage() {
        int sum = 0;
        double avg = 0;
        int counter = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (!scanner.hasNextInt()) {
                break;
            }

            sum += scanner.nextInt();
            counter++;

            scanner.nextLine();
        }

        scanner.close();

        avg = (counter > 0) ? Math.round((double) sum / counter) : 0;

        System.out.println("SUM = " + sum + " AVG = " + (int) avg);
    }
}
