public class Main {

    public static void main(String[] args) {
        int value = 1;

        if (value == 1) {
            System.out.println("Value was 1");
        } else if (value == 2) {
            System.out.println("Value was 2");
        } else {
            System.out.println("Value was not 1 or 2");
        }

        int switchValue = 4;

        switch(switchValue) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("Was a 3, or 4, or a 5");
                System.out.println("Actually it was a " + switchValue);
                break;
            default:
                System.out.println("Value was not 1, 2, 3, 4 or 5");
                break;
        }


        // Create a new switch statement using har instead of int
        // create  a new char variable
        // create a switch statement testing for
        // A, B, C, D or E
        // display a message if any of these are found and then break
        // add a default which displays a message saying not found

        char myChar = 'B';

        switch (myChar) {
            case 'A':
                System.out.println("Char 'A' found");
                break;
            case 'B':
                System.out.println("Char 'B' found");
                break;
            case 'C':
                System.out.println("Char 'C' found");
                break;
            case 'D':
                System.out.println("Char 'D' found");
                break;
            case 'E':
                System.out.println("Char 'E' found");
                break;
            default:
                System.out.println("Char not found");
        }

    }
}
