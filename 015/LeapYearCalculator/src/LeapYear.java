public class LeapYear {

    public static boolean isLeapYear (int year) {
        if (!(year >= 1 && year <= 9999)) {
            return false;
        }

        boolean check1 = year % 4 == 0;
        boolean check2 = year % 100 == 0;
        boolean check3 = year % 400 == 0;

        return (check1 && !check2) || (check1 && check2 && check3);
    }
}

