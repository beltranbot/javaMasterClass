public class Main {

    public static void main(String[] args) {
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(-3.1756, -3.175)); // → should return true since numbers are equal up to 3 decimal places.
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(3.175, 3.176)); // → should return false since numbers are not equal up to 3 decimal places
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(3.0, 3.0)); // → should return true since numbers are equal up to 3 decimal places.
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(-3.123, 3.123)); // → should return false since numbers are not equal up to 3 decimal places.
    }
}
