package Strings;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
        System.out.println(isClean(s));
    }

    static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    // Using recursion
    // cleaning string in another method, then passing it to the recursive fn
    static boolean isClean(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindromeRec(cleaned, 0);
    }

    static boolean isPalindromeRec(String s, int i) {
        if (i >= s.length() / 2) return true;

        if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;

        return isPalindromeRec(s, i + 1);
    }
}

    // char[] arr = s.toCharArray();
    // System.out.println(arr[0]); // ✅
    // But, You lose immutability
    // You create extra memory
