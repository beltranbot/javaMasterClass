public class NumberPalindrome {

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            number *= -1;
        }
        if (number < 10) {
            return true;
        }

        int palindrome = 0;
        int n = number;
        do {
            palindrome *= 10;
            palindrome += (n % 10);
        } while((n = n / 10) > 0);

        return number == palindrome;
    }
}
