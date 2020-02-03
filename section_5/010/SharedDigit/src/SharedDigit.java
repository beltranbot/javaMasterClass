public class SharedDigit {

    public static boolean hasSharedDigit(int a, int b) {
        if (!(a >= 10 && a <= 99) || !(b >= 10 && b <= 99)) {
            return false;
        }

        do {
            int i = a % 10;
            int tempB = b;

            do {
                int j = tempB % 10;
                System.out.println(i + " " + j);
                if (i == j) {
                    return true;
                }
            } while ((tempB = tempB / 10) > 0);
        } while((a = a / 10) > 0);

        return false;
    }
}
