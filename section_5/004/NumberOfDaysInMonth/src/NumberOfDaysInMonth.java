public class NumberOfDaysInMonth {

    public static boolean isLeapYear(int year) {
        if (!(year >= 1 && year <= 9999)) {
            return false;
        }
        boolean check1 = year % 4 == 0;
        boolean check2 = year % 100 == 0;
        boolean check3 = year % 400 == 0;

        return (check1 && !check2) || check3;
    }

    public static int getDaysInMonth(int month, int year) {

        if (!(year >= 1 && year <= 9999)) {
            return -1;
        }

        switch(month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return -1;
        }
    }
}
