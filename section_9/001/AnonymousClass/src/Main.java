import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Button button = new Button("print");

    public static void main(String[] args) {
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });

        listen();
    }

    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    button.onClick();
            }
        }
    }

}
