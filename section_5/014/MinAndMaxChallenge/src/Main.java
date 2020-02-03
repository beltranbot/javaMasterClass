import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a number:");
            if (!scanner.hasNextInt()) {
                break;
            }

            int number = scanner.nextInt();

            min = number < min ? number : min;
            max = number > max ? number : max;

            scanner.nextLine();
        }

        System.out.println("Minimum number: " + min);
        System.out.println("Maximum number: " + max);

        scanner.close();
    }
}
