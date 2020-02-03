public class Main {

    public static void main(String[] args) {
//        int count = 0;
//        while (count != 6) {
//            System.out.println("Count value is " + count);
//            count++;
//        }
//
//        count = 1;
//        while (true) {
//            if (count == 6) {
//                break;
//            }
//            System.out.println("Count value is " + count);
//            count++;
//        }
//
//        count = 5;
//        do {
//            System.out.println("Count value was " + count);
//            count++;
//        } while (count != 6);

//        Create a method called isEvenNumber that takes a parameter of type int
//        its purpose is to determine if the argument passed to the method
//        is an even number or not
//        return true if an even number otherwise return false
        int number = 4;
        int finishNumber = 20;
        int evenCount = 0;

        while(number <= finishNumber) {
            number++;

            if (!isEvenNumber(number)) {
                continue;
            }

            evenCount++;
            if (evenCount == 5) {
                break;
            }

            System.out.println("event number " + number);
        }

        System.out.println("Even numbers found: " + evenCount);

        /*
        * modify the while code above
        * make it also record the total number of even numbers it has found
        * and break once 5 are found
        * and at the end, display the total number of even numbers found
        * */
    }

    public static boolean isEvenNumber(int n) {
        return n % 2 == 0;
    }
}
