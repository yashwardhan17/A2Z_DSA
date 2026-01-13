package Math;

public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 212;
        System.out.println(isPalindrome(x));
    }

    static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }

        // Check for even and odd digit numbers
        return (x == reversed || x == reversed / 10);
    }
}
