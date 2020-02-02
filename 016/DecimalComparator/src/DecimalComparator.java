public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(double one, double two) {
        one *= 1000;
        two *= 1000;

        return (int) one == (int) two;
    }
}
