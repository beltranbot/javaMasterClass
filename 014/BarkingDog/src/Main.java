public class Main {

    public static void main(String[] args) {

        boolean shouldWakeUp = BarkingDog.shouldWakeUp(true, 1); // should return true
        System.out.println(shouldWakeUp);
        shouldWakeUp = BarkingDog.shouldWakeUp(false, 2); // should return false since the dog is not barking.
        System.out.println(shouldWakeUp);
        shouldWakeUp = BarkingDog.shouldWakeUp(true, 8); // should return false, since it's not before 8.
        System.out.println(shouldWakeUp);
        shouldWakeUp = BarkingDog.shouldWakeUp(true, -1); // should return false since the hourOfDay parameter needs to be in a range 0-23.
        System.out.println(shouldWakeUp);
    }
}
